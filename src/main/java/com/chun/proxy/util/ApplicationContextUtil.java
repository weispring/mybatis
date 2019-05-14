package com.chun.proxy.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lixianchun on 2018/7/26.
 **/
@Component
@Slf4j
public class ApplicationContextUtil implements ApplicationContextAware {

    public static ApplicationContext context;

    /**
     * 设置上下文
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }


    /**
     * 获取bean
     */
    public static  <T> T getBean(Class<T> tClass){
        return context.getBean(tClass);
    }


    public static  <T> String[]  getBeanNames(Class<T> tClass){
        return context.getBeanNamesForType(tClass);
    }


    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("00");
        System.out.println(set.iterator().next());
    }
}