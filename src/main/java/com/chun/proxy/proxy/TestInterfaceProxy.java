package com.chun.proxy.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Author: lixianchun
 * Date: 2019/3/31
 * Description:
 */
@Slf4j
@Component
public class TestInterfaceProxy implements ITestInterfaceProxy {
    @Override
    public Object introduceMySelf() {
        log.info("interface I an lixianchun , i'm from china ! ");
        return "I an lixianchun , i'm from china ! ";
    }

    @Override
    public Object thanks() {
        introduceMySelf();
        log.info("interface thanks all");
        return "thanks all";
    }

    @Override
    public String toString() {
        //thanks();
        return super.toString();
    }
}
