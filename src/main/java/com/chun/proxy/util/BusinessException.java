package com.chun.proxy.util;

import lombok.AllArgsConstructor;

/**
 * Author: lixianchun
 * Date: 2019/3/31
 * Description:
 */
@AllArgsConstructor
public class BusinessException extends RuntimeException{

    public BusinessException(){

    }

    public BusinessException(String error){
        super(error);
    }

    private IReturnCode returnCode;


    public String getCode() {
        return returnCode.getCode();
    }

    public String getMsg() {
        return returnCode.getMsg();
    }


}
