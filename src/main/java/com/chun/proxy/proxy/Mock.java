package com.chun.proxy.proxy;


import com.chun.proxy.util.ApplicationContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: lixianchun
 * @Date: 2018/10/22 12:58
 * @Description:
 */
public class Mock {

    private static final Logger log = LoggerFactory.getLogger(Mock.class);

    private static LinkedList<Object> list = new LinkedList();

    public Mock() {
    }

    public static void push(Object resp) {
        list.add(resp);
    }

    public static void clear() {
        list.clear();
    }


    public static <T> T wrapper(T t) {
        if (t.getClass().getInterfaces() != null && t.getClass().getInterfaces().length > 0) {
            DynamicProxyHandlerJavaProxy dynamicProxyHandler = new DynamicProxyHandlerJavaProxy();
            return (T) Proxy.newProxyInstance(dynamicProxyHandler.getClass().getClassLoader(), t.getClass().getInterfaces(), dynamicProxyHandler);
        } else {
            DynamicProxyHandlerCglib handler = new DynamicProxyHandlerCglib();
            return (T) handler.getProxy(t);
        }
    }


    /**
     * 重写实现代理
     */
    static class DynamicProxyHandlerCglib implements MethodInterceptor {
        private Enhancer enhancer;

        private DynamicProxyHandlerCglib() {
            this.enhancer = new Enhancer();
        }

        public Object getProxy(Object c) {
            this.enhancer.setSuperclass(c.getClass());
            this.enhancer.setCallback(this);
            return this.enhancer.create();//nextInstance 将自己放到threadLocal
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
            log.info("invoke{}-{},", proxy.getClass(), method.getName());
            //一直执行代理办法，死递归
            // Object object1 = method.invoke(obj,arg);
            // Object object2 = proxy.invoke(obj,arg);
            // list.poll();
            //获取真实值
            Object object = proxy.invokeSuper(obj, arg);

            log.info("object=", object.toString());
            return object;
        }
    }


    /**
     * 重写
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T interfaceWrapper(Class<T> t) {
        HttpDynamicProxyHandlerCglib handler = new HttpDynamicProxyHandlerCglib();
        return (T) handler.getProxy(t);
    }


    /**
     * 实现接口
     */
    private static class DynamicProxyHandlerJavaProxy implements InvocationHandler {
        private Object t;

        DynamicProxyHandlerJavaProxy() {
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) {
            if (customMethod(method)){
                return null;
            }
            log.info("interace invoke{}-{},", proxy.getClass(), method.getName());
            Object object = list.poll();
            try {
                //会导致递归调用
                //Object realVale = method.invoke(proxy,args);
                //调用真实方法
                Object target = ApplicationContextUtil.getBean(proxy.getClass().getInterfaces()[0]);
                Object realVale = method.invoke(target,args);
                log.info("realValue : {}",realVale);
            }catch (Exception e){

            }

            log.info("interace object=", object.toString());
            return object;
        }
    }


    /**
     * 避免触发 toString()，equals(),hashCode()方法等object方法，非自定义的
     * @param args
     */
    public static void main(String[] args) {
        //cglib
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\test00");
        //jdk 代理 位置 ./com/sun
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        Mock.push(new Integer(123456));

        TestCglib testCglib = new TestCglib();



       /* Object thanks = Mock.wrapper(testCglib).thanks();
        log.info("testCglib : {}",thanks);
        Object introduceMySelf = Mock.wrapper(testCglib).introduceMySelf();
        log.info("testCglib : {}",introduceMySelf);*/

        ITestInterfaceProxy testInterfaceProxy = new TestInterfaceProxy();
        Object ithanks = wrapper(testInterfaceProxy).thanks();
        log.info("ithanks：{}", ithanks);
        Object iintroduceMySelf = wrapper(testInterfaceProxy).introduceMySelf();
        log.info("iintroduceMySelf：{}", iintroduceMySelf);
    }


    /**
     * 重写
     */
    static class HttpDynamicProxyHandlerCglib implements MethodInterceptor {
        private Enhancer enhancer;

        private HttpDynamicProxyHandlerCglib() {
            this.enhancer = new Enhancer();
        }

        public Object getProxy(Class<?> c) {
            this.enhancer.setSuperclass(c);
            this.enhancer.setCallback(this);
            return this.enhancer.create();
        }


        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) {
            return list.poll();
        }
    }


    /**
     * 避免触发 toString()，equals(),hashCode()方法等object方法，非自定义的
     */
    private static boolean customMethod(Method method){
        List<String> objectMethods = Arrays.asList("toString","equals","hashCode");
        return objectMethods.contains(method.getName());
    }
}