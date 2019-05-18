package com.chun.proxy.control.interfaceControl;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lixianchun
 * @Description
 * @date 2019/5/18 16:53
 */
@Slf4j
public class AbstractTest {


    public void print(){
        log.info("0000");
        printLine();
    }


    public void printLine(){
        log.info("------------");
    }

}
