package com.chun.proxy.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author lixianchun
 * @Description
 * @date 2019/5/20 11:24
 */
@Slf4j
@Component
public class AopService {


    @Async
    public void test(){
        log.info("threadId:{}",Thread.currentThread().getId());
        log.info("测试AopContext.currentProxy();");
    }
}
