package com.cafe24.shopping.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.shopping.validator.constraint.ValidPhoneNumber;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
	private Pattern pattern = Pattern.compile("[0-9]{10,11}"); 
	
	public void initialize(ValidPhoneNumber constraintAnnotation) {

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value == null || "".contentEquals(value)) {
			return true;
		}
		return pattern.matcher( value ).matches();
	}

}
