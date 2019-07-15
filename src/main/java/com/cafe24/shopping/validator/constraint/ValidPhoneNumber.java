package com.cafe24.shopping.validator.constraint;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cafe24.shopping.validator.PhoneNumberValidator;

@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy=PhoneNumberValidator.class)
public @interface ValidPhoneNumber {
	String message() default "잘못된 번호 입니다.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
