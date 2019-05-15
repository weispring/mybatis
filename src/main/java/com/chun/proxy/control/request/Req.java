package com.chun.proxy.control.request;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Getter
@Setter
public class Req implements Serializable {
    private Long serialVersionUID = 123456789099L;

    private Object object;
}
