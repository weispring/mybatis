package com.chun.proxy.control.interfaceControl;

import com.chun.proxy.control.request.Body;
import com.chun.proxy.control.request.Req;
import org.springframework.web.bind.annotation.*;


//@RestController
public interface ControlInterface {

    @PostMapping(value = "/rpc/test/interface")
    String test(@RequestBody Body req);

    @RequestMapping(value = "/rpc/test/interfaceException",method = {RequestMethod.GET,RequestMethod.POST})
    String test(@RequestParam("type") String type);

}