package com.cafe24.shopping.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.shopping.validator.constraint.ValidId;

public class IdValidator implements ConstraintValidator<ValidId, String> {
	private Pattern pattern = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9_]{2,14}$"); 
	


	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || "".contentEquals(value)) {
			return false;
		}
		return pattern.matcher( value ).matches();
		
	}


	public void initialize(ValidId constraintAnnotation) {
		
	}


}
