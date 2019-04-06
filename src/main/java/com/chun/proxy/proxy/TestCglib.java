package com.chun.proxy.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestCglib {

    public Object introduceMySelf() {
        log.info("interface I an lixianchun , i'm from china ! ");
        return "I an lixianchun , i'm from china ! ";
    }


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
