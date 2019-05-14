package com.chun.proxy;

import com.chun.proxy.entity.SubjectUserType;
import com.chun.proxy.mapper.SubjectUserTypeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.Reader;
import java.util.Random;

/**
 * @Auther: lixianchun
 * @Date: 2019/4/25 11:16
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Reader reader = Resources.getResourceAsReader("conf/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SubjectUserTypeMapper subjectUserTypeMapper = sqlSession.getMapper(SubjectUserTypeMapper.class);

        SubjectUserType userType = new SubjectUserType();
        userType.setId(new Random(100).nextLong());
        userType.setAppId(12345L);
        userType.setId(System.currentTimeMillis());
        userType.setUserTypeId(1L);
        userType.setSubjectId(1L);
        Integer integer = subjectUserTypeMapper.save(userType);
        System.out.print(integer);
    }
}
