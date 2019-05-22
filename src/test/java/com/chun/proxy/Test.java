package com.chun.proxy;

import com.chun.proxy.control.interfaceControl.TestInterfaceControl;
import com.chun.proxy.entity.SubjectUserType;
import com.chun.proxy.mapper.SubjectUserTypeMapper;
import com.chun.proxy.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Created by lixianchun on 2018/12/25.
 **/
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles({""})
public class Test {

    @Autowired
    private TestInterfaceControl testInterfaceControl;
    @Autowired
    private SubjectUserTypeMapper subjectUserTypeMapper;

    @Autowired
    private TestService testService;
    @org.junit.Test
    public void testCreate(){
        SubjectUserType userType = new SubjectUserType();
        userType.setId(new Random(100).nextLong());
        userType.setAppId(12345L);
        userType.setId(System.currentTimeMillis());
        userType.setUserTypeId(1L);
        userType.setSubjectId(1L);
        //subjectUserTypeMapper.list(userType);
        testService.test(userType);
        Integer result = subjectUserTypeMapper.save(userType);
        log.info("result: {}",result);
        //testInterfaceControl.test("1");
        log.info("000000000000000");
    }



}
