package com.chun.proxy.control.interfaceControl;

import com.chun.proxy.control.request.Req;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//@RestController
public interface ControlInterface {

    @PostMapping(value = "/rpc/test/interface")
    String test(@RequestBody Req req);

}