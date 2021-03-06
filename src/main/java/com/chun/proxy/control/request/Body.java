package com.chun.proxy.control.request;

import com.chun.proxy.control.validator.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author lixianchun
 * @Description
 * @date 2019/5/17 20:54
 */

@Slf4j
@Getter
@Setter
public class Body implements Serializable {

    @NotNull
    private String id;

}
