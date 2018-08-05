package com.chun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by lixianchun on 2018/7/11.
 **/
@MapperScan("com.chun.proxy.mapper.**")
//@ImportResource("mybatis-config.xml")
@SpringBootApplication
public class Application {

        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }

}
