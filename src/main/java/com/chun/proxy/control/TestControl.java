package com.chun.proxy.control;

import com.chun.proxy.entity.SubjectUserType;
import com.chun.proxy.service.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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



    @PostMapping(value = "/testdocker")
    public String  test(HttpServletRequest request){
        log.info("入參：{}",request);
        return "测试docker";
    }
}
