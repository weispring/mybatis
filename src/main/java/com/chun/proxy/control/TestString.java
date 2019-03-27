package com.chun.proxy.control;

/**
 * Author: lixianchun
 * Date: 2018/10/14
 * Description:
 */
public class TestString {

    public static final String s1="Hello";
    public static final String s2="World";
    public static void main(String[] args){
        String s3="HelloWorld";
        String s4=s1+s2;
        System.out.println(s3==s4);      //true
    }



}
