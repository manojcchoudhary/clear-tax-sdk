package dev.manojc.cleartaxsdk.utils;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClearTaxValidationUtils {


	private ClearTaxValidationUtils() { 
		log.debug("ClearTaxValidationUtils initialized");
	}
	
	public static Validator getValidator() {
		ValidatorFactory validatorFactory = Validation.byDefaultProvider().configure()
				.messageInterpolator(new ParameterMessageInterpolator()).buildValidatorFactory();
		return validatorFactory.getValidator();
	}
	
}
