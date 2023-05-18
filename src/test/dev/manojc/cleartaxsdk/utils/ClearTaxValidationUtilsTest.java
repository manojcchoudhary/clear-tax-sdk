package dev.manojc.cleartaxsdk.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.validation.Validator;

import org.junit.jupiter.api.Test;

class ClearTaxValidationUtilsTest {

	@Test
	public void testGetValidator() {
		Validator validator = ClearTaxValidationUtils.getValidator();
		assertNotNull(validator);
	}

}
