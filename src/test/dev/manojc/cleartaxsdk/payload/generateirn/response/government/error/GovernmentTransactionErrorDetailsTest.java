package dev.manojc.cleartaxsdk.payload.generateirn.response.government.error;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GovernmentTransactionErrorDetailsTest {

	@Test
	public void testBuilder() {
		GovernmentTransactionErrorDetails details = GovernmentTransactionErrorDetails.builder().errorCode("ERR001")
				.errorMessage("Invalid input parameter").errorSource("Government transaction service").build();

		assertNotNull(details);
		assertEquals("ERR001", details.getErrorCode());
		assertEquals("Invalid input parameter", details.getErrorMessage());
		assertEquals("Government transaction service", details.getErrorSource());
	}

	@Test
	public void testSetterGetter() {
		GovernmentTransactionErrorDetails details = GovernmentTransactionErrorDetails.builder().errorCode("ERR001")
				.errorMessage("Invalid input parameter").errorSource("Government transaction service").build();

		assertEquals("ERR001", details.getErrorCode());
		assertEquals("Invalid input parameter", details.getErrorMessage());
		assertEquals("Government transaction service", details.getErrorSource());
	}

	@Test
	public void testToString() {
		GovernmentTransactionErrorDetails details = GovernmentTransactionErrorDetails.builder().errorCode("ERR001")
				.errorMessage("Invalid input parameter").errorSource("Government transaction service").build();

		String expected = "GovernmentTransactionErrorDetails(errorCode=ERR001, errorMessage=Invalid input parameter, errorSource=Government transaction service)";
		assertEquals(expected, details.toString());
	}

	@Test
	public void testEqualsAndHashCode() {
		GovernmentTransactionErrorDetails details1 = GovernmentTransactionErrorDetails.builder().errorCode("ERR001")
				.errorMessage("Invalid input parameter").errorSource("Government transaction service").build();

		GovernmentTransactionErrorDetails details2 = GovernmentTransactionErrorDetails.builder().errorCode("ERR001")
				.errorMessage("Invalid input parameter").errorSource("Government transaction service").build();

		GovernmentTransactionErrorDetails details3 = GovernmentTransactionErrorDetails.builder().errorCode("ERR002")
				.errorMessage("Invalid input parameter").errorSource("Government transaction service").build();

		assertEquals(details1, details2);
		assertNotEquals(details1, details3);

		assertEquals(details1.hashCode(), details2.hashCode());
		assertNotEquals(details1.hashCode(), details3.hashCode());
	}
}
