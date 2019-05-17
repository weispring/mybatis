package com.chun.proxy.control.interfaceControl;

import com.chun.proxy.control.request.Body;
import com.chun.proxy.control.request.Req;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 接口control测试类
 */
@RestController
public class TestInterfaceControl implements ControlInterface {
    @Override
    public String test(@RequestBody Body req) {
        if ("1".equals(req.getId())){
            throw new RuntimeException("runtime");
        }else if ("2".equals(req.getId())){
            new File("./334.txt");
        }else if ("3".equals(req.getId())) {
            throw new NullPointerException("null point");
        }

        return "uuuuuuuuuuuu";
    }




    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Object handleException(Exception exp, HttpServletRequest request, HttpServletResponse response) {
        if (exp.getMessage() != null){
            return exp.getMessage();
        }

      /*  @RestControllerAdvice与@ExceptionHandler注解是sprngmvc中与异常捕获与处理相关的注解，它的入口也是DispatcherServlet中的doDispatcher()方法中，如下：
        this.processDispatchResult(processedRequest, response, mappedHandler, mv, (Exception)dispatchException);

        org.springframework.web.servlet.DispatcherServlet#processHandlerException
        org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver#resolveException,实例HandlerExceptionResolverComposite
       */

        return exp.getMessage();
    }



    @ExceptionHandler(IOException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Object handleExceptionWithIo(Exception exp, HttpServletRequest request, HttpServletResponse response) {
        if (exp.getMessage() != null){
            return exp.getMessage();
        }
      return exp.getMessage();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Object handleExceptionWithRun(Exception exp, HttpServletRequest request, HttpServletResponse response) {
        if (exp.getMessage() != null){
            return exp.getMessage();
        }
        return exp.getMessage();
    }



}
