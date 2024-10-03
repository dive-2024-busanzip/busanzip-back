package com.example.busanzipback.domain.residency.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.busanzipback.domain.residency.entity.Distance;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

public class DistanceValidation {

	@Target({ElementType.FIELD, ElementType.PARAMETER})
	@Retention(RetentionPolicy.RUNTIME)
	@Constraint(validatedBy = DistanceValidator.class)
	public @interface ValidDistance {
		String message() default "거리는 near, mid, far 중 하나여야 합니다.";
		Class<?>[] groups() default {};
		Class<? extends Payload>[] payload() default {};
	}

	public static class DistanceValidator implements ConstraintValidator<ValidDistance, Distance>{
		@Override
		public boolean isValid(Distance value, ConstraintValidatorContext context){
			if(value == null){
				return false;
			}
			return value == Distance.NEAR || value == Distance.MID || value == Distance.FAR;
		}
	}
}
