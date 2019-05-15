package com.chun.proxy.control.interfaceControl;

import com.chun.proxy.control.request.Req;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口control测试类
 */
@RestController
public class TestInterfaceControl implements ControlInterface {
    @Override
    public String test(Req req) {
        return "uuuuuuuuuuuu";
    }
}
