package com.ali.springsecurity.annotations;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>{
	
	private String firstFieldName;
	private String secondFieldName;
	private String message;
	
	@Override
	public void initialize(final FieldMatch constraintAnnotation) {
		
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		message = constraintAnnotation.message();
		
	}
	
	@Override
	public boolean isValid(final Object value, ConstraintValidatorContext context) {
		
		boolean valid = true;
		
		try {
			final Object firstObj = new BeanWrapperImpl().getPropertyValue(firstFieldName);
			final Object secondObj = new BeanWrapperImpl().getPropertyValue(secondFieldName);
			
			valid = (firstObj == null && secondObj == null || 
					firstObj != null && firstObj.equals(secondObj));
			
		}catch (final Exception e) {
			e.printStackTrace();
		}
		
		if (!valid) {
			context.buildConstraintViolationWithTemplate(message)
				.addPropertyNode(firstFieldName)
				.addConstraintViolation()
				.disableDefaultConstraintViolation();
		}
		
		return valid;
	}

}
