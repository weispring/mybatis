package com.chun.proxy;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.io.File;


/**
 * Created by lixianchun on 2018/7/11.
 **/

public class Config {

    /**
    @Autowired
    private DataSource source;
    @Bean
    public SqlSessionFactoryBean initSqlSessionFactory(){
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(source);
        return sqlSessionFactory;
    }
}*/

    public static void main(String[] args) {// classpath:/,classpath:/config/,file:./,file:./config/
        File file = new File("file:./");


        System.out.println(file.getAbsolutePath() +":" +file.getPath()+":"+file.getParent());
    }
}
