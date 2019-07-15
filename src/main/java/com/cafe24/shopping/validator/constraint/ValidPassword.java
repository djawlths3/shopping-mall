package com.cafe24.shopping.validator.constraint;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cafe24.shopping.validator.PasswordValidator;
import com.cafe24.shopping.validator.PhoneNumberValidator;

@Retention(RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy=PasswordValidator.class)
public @interface ValidPassword {
	String message() default "비밀번호는 8자 이상 20자 이하의 알파벳, 숫자, 특수문자를 조합하여 작성해야 합니다.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
