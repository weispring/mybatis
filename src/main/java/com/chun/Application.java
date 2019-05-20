package com.chun;

import org.apache.ibatis.builder.annotation.MapperAnnotationBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by lixianchun on 2018/7/11.
 **/
@MapperScan("com.chun.proxy.mapper.**")
//@ImportResource("mybatis-config.xml")
//@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
//@ImportResource("applicationContext-spring.xml")
@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
public class Application {

        public static void main(String[] args) throws Exception {

            //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("conf/mybatis-config.xml"));
            SpringApplication.run(Application.class, args);
        }

     //            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("conf/mybatis-config.xml"));
    //tk.mybatis.spring.mapper.MapperFactoryBean
    //MapperHelper
   // MapperAnnotationBuilder
}
