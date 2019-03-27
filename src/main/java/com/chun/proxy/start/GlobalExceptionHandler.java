package com.chun.proxy.start;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: lixianchun
 * Date: 2018/9/9
 * Description:
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    public GlobalExceptionHandler() {
    }


    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object exceptionHandler(Exception e) {
        log.debug("统一异常处理:{}",e);
        return "异常";
    }
}

