package dev.manojc.cleartaxsdk.initializer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.Validator;

import org.junit.jupiter.api.Test;

import dev.manojc.cleartaxsdk.utils.ClearTaxValidationUtils;

class ClearTaxConfigurationTest {

	private final Validator validator = ClearTaxValidationUtils.getValidator();

	@Test
	public void testValidClearTaxConfiguration() {
		ClearTaxConfiguration config = ClearTaxConfiguration.builder().host("https://cleartax.com").authToken("abc123")
				.ownerId("owner123").gstin("GSTIN123").build();
		assertTrue(validator.validate(config).isEmpty());
	}

	@Test
	public void testInvalidClearTaxConfiguration() {
		ClearTaxConfiguration config = ClearTaxConfiguration.builder().host("").authToken("").ownerId("").gstin("")
				.build();
		assertFalse(validator.validate(config).isEmpty());
	}

	@Test
	public void testInvalidHost() {
		ClearTaxConfiguration config = ClearTaxConfiguration.builder().host("not a valid url").authToken("abc123")
				.ownerId("owner123").gstin("GSTIN123").build();
		assertFalse(validator.validate(config).isEmpty());
	}

	@Test
	public void testMissingAuthToken() {
		ClearTaxConfiguration config = ClearTaxConfiguration.builder().host("https://cleartax.com").ownerId("owner123")
				.gstin("GSTIN123").build();
		assertFalse(validator.validate(config).isEmpty());
	}

	@Test
	public void testMissingOwnerId() {
		ClearTaxConfiguration config = ClearTaxConfiguration.builder().host("https://cleartax.com").authToken("abc123")
				.gstin("GSTIN123").build();
		assertFalse(validator.validate(config).isEmpty());
	}

	@Test
	public void testMissingGstin() {
		ClearTaxConfiguration config = ClearTaxConfiguration.builder().host("https://cleartax.com").authToken("abc123")
				.ownerId("owner123").build();
		assertFalse(validator.validate(config).isEmpty());
	}

}
