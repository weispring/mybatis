package com.chun.proxy.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@Slf4j
public class Control {

    @RequestMapping("export")
    public void export(HttpServletResponse response){

        //模拟从数据库获取需要导出的数据
        List<Object> personList = new ArrayList<>();
        Person person1 = new Person("路飞","1");
        Person person2 = new Person("娜美","2");
        Person person3 = new Person("索隆","1");
        Person person4 = new Person("小狸猫","1");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        //导出操作
        ExcelUtil.exportExcel(personList,"花名册","草帽一伙",Person.class,"海贼王.xls",response);
    }

    @RequestMapping("importExcel")
    public void importExcel(){
        String filePath = "C:\\Users\\Dell\\Desktop\\test.xlsx";
        if (new File(filePath).exists()){
            log.info("---------");
        }
        //解析excel，
        List<Person> personList = ExcelUtil.importExcel(filePath,1,1,Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");

        Person testModel =(Person) personList.get(0);
        File img = new File("./img.png");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(img);
           // outputStream.write(testModel.getFis());
            outputStream.flush();
            log.info("");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        new Control().importExcel();
    }
}
