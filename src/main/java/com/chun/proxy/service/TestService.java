package com.chun.proxy.service;

import com.chun.proxy.entity.SubjectUserType;
import com.chun.proxy.mapper.SubjectUserTypeMapper;
import jdk.nashorn.internal.ir.ReturnNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.lang.reflect.InvocationHandler;

/**
 * Created by lixianchun on 2018/7/11.
 **/
@Service
@Slf4j
public class TestService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private SubjectUserTypeMapper mapper;

    @Autowired
    private Environment environment;

    public int testXml(SubjectUserType userType){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int result = sqlSession.insert("com.chun.proxy.mapper.SubjectUserTypeMapper.saveXml",userType);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    @Transactional
    public void test(SubjectUserType userType){

       // mapper.selectOne(userType);

        environment.getProperty("spring.datasource.name");

      Integer a = mapper.save(userType);
      System.out.println("返回结果： "+a);
    }

    public int testInterface(SubjectUserType userType){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SubjectUserTypeMapper mapper = sqlSession.getMapper(SubjectUserTypeMapper.class);
        mapper.saveInterface(userType);
        sqlSession.commit();
        sqlSession.close();
        return 1;
    }
}
