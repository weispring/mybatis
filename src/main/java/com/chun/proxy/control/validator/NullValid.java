package com.chun.proxy.control.validator;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author lixianchun
 * @Description
 * @date 2019/5/18 18:20
 */
@Slf4j
public class NullValid implements ConstraintValidator<NotNull,Object> {

    @Override
    public void initialize(NotNull constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        log.info("validtor----------");
        return false;
    }
}
