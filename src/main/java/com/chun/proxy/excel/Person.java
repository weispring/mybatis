package com.chun.proxy.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Excel(name = "姓名", orderNum = "0")
    private String name;

    @Excel(name = "图片",type = 2,orderNum = "1",imageType = 1)
    private byte[] fis;

    @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "2")
    private String sex;

    public Person(String name,String sex){
        this.name = name;
        this.sex = sex;
    }
  /*  @Excel(name = "生日", exportFormat = "yyyy-MM-dd", orderNum = "2")
    private Date birthday;*/


}
