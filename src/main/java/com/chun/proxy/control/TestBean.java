package com.chun.proxy.control;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.print.DocFlavor;

/**
 * @Auther: lixianchun
 * @Date: 2019/4/23 22:19
 * @Description:
 */
@Data
public class TestBean {

    private String aaa ;

    @Bean
    public Xbean pageHelper() {
        System.out.print("88888888888888");
        return new Xbean();
    }
}
