package com.chun.proxy.control;

import com.chun.proxy.entity.SubjectUserType;
import com.chun.proxy.proxy.ITestInterfaceProxy;
import com.chun.proxy.proxy.Mock;
import com.chun.proxy.service.TestService;
import com.chun.proxy.util.WebUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Random;

/**
 * Created by lixianchun on 2018/7/11.
 **/
@RestController
@Slf4j
@AllArgsConstructor
public class TestControl {

    @Autowired
    private TestService service;

    @Autowired
    ITestInterfaceProxy testInterfaceProxy;

    @PostMapping(value = "/test")
    public void  proxy(HttpServletRequest request){

        log.info("IP地址 ：{}",request.getHeader("x-forwarded-for"));
        log.info("IP地址 ：{}",request.getRemoteAddr());
        HttpHeaders httpHeaders = null;

        SubjectUserType userType = new SubjectUserType();
        userType.setId(new Random(100).nextLong());
        userType.setAppId(12345L);
        userType.setId(System.currentTimeMillis());
        userType.setUserTypeId(1L);
        userType.setSubjectId(1L);
        service.test(userType);
        service.testXml(userType);
        service.testInterface(userType);
    }


    //

    @PostMapping(value = "/testdocker")
    public String  test(HttpServletRequest request){
        log.info("入參：{}",request);
        return "测试docker";
    }

    @GetMapping(value = "/teststart")
    public String  start(HttpServletRequest request){
        Thread.currentThread();
        log.info("入參：{}",request);
        if ("true".equals(request.getParameter("ex"))){
            throw new NullPointerException("测试异常");
        }
        return "测试docker";
    }

    public static void main(String[] args) {

        String a = "1";
        String b = "3";
        String c = "4";

        System.out.println(a+b==c);
        a.equals("");


        System.out.println(c=="4");



    }


    /**
     * 获取图片
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/api/open/terminal/self/img")
    public void img(HttpServletRequest request, HttpServletResponse response) throws Exception{
        File file = new File("C:\\Users\\lixia\\Desktop\\mryjywhh\\天安门.jpg");
        FileInputStream fis = new FileInputStream(file);

        //http头部属性设置
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("utf-8");

        byte[] bytes = new byte[1024];
        int r;
        while ((r=fis.read(bytes)) > -1){
            response.getOutputStream().write(bytes,0,r);
        }
        response.getOutputStream().flush();
    }


    /**
     * 获取请求参数
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/testHttp")
    public String  testHttp() throws Exception{
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info("request method: {}, content-type: {}",request.getMethod(), request.getContentType());
        String bodyParam = WebUtil.getRequestBodyStr(request);
        Map<String,String> param = WebUtil.getRequestParams(request);
        return "测试docker";
    }


    /**
     * 测试 jdk 代理
     * @throws Exception
     */
    @RequestMapping(value = "/testJdkProxy")
    public String  testJdkProxy() throws Exception{
        Mock.wrapper(testInterfaceProxy).thanks();
        return "测试docker";
    }



}
