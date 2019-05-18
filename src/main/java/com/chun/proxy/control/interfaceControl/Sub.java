package com.chun.proxy.control.interfaceControl;

import lombok.extern.slf4j.Slf4j;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

/**
 * @author lixianchun
 * @Description
 * @date 2019/5/18 16:54
 */
@Slf4j
public class Sub  extends AbstractTest{
/*    @Override
    public void print() {
      log.info("sub-print");
    }*/

    @Override
    public void printLine() {
        log.info("sub-printLine");
    }


    public static void main(String[] args) {
        new Sub().print();
    }
}
