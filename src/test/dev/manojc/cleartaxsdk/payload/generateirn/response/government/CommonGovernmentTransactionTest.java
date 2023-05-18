package dev.manojc.cleartaxsdk.payload.generateirn.response.government;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommonGovernmentTransactionTest {

	@Test
	public void testSuccessTypeGetterSetter() {
		CommonGovernmentTransaction transaction = new ConcreteTransaction();
		transaction.setSuccessType(SuccessType.Y);
		Assertions.assertEquals(SuccessType.Y, transaction.getSuccessType());
	}

	@Test
	public void testSuccessTypeMaxValue() {
		CommonGovernmentTransaction transaction = new ConcreteTransaction();
		transaction.setSuccessType(SuccessType.Y);
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			transaction.setSuccessType(SuccessType.fromText("YY").get());
		});
	}

	@Test
	public void testSuccessTypeMinValue() {
		CommonGovernmentTransaction transaction = new ConcreteTransaction();
		transaction.setSuccessType(SuccessType.Y);
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			transaction.setSuccessType(SuccessType.fromText("NN").get());
		});
	}

	@Test
	public void testSuccessTypeNotBlank() {
		CommonGovernmentTransaction transaction = new ConcreteTransaction();
		transaction.setSuccessType(null);
		Assertions.assertNull(transaction.getSuccessType());		
	}

	private static class ConcreteTransaction extends CommonGovernmentTransaction {
	}

}
