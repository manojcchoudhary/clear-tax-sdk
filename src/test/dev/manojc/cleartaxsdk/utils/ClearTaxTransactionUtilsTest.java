package dev.manojc.cleartaxsdk.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.manojc.cleartaxsdk.models.transaction.itemlist.TransactionItem;
import dev.manojc.cleartaxsdk.models.transaction.valuedetails.ValueDetails;

class ClearTaxTransactionUtilsTest {

	@Test
	public void testCalculateTotalItemValue() {
		TransactionItem item = TransactionItem.builder().assessableAmount(new BigDecimal("100"))
				.igstAmount(new BigDecimal("18")).cgstAmount(new BigDecimal("9")).sgstAmount(new BigDecimal("9"))
				.cesAmount(new BigDecimal("0")).cesNonAdvlAmount(new BigDecimal("0"))
				.stateCesAmount(new BigDecimal("0")).stateCesNonAdvlAmount(new BigDecimal("0"))
				.otherCharge(new BigDecimal("0")).build();
		BigDecimal expectedValue = new BigDecimal("136");
		BigDecimal actualValue = ClearTaxTransactionUtils.calculateTotalItemValue(item);
		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testAddBigDecimal() {
		BigDecimal value1 = new BigDecimal("100.00");
		BigDecimal value2 = new BigDecimal("200.00");
		BigDecimal expected = new BigDecimal("300.00");

		BigDecimal actual = ClearTaxTransactionUtils.addBigDecimal(value1, value2);

		assertEquals(expected, actual);
	}

	@Test
	public void testAddValueDetails() {
		ValueDetails value1 = ValueDetails.builder().assessableValue(new BigDecimal("100.00"))
				.cgstValue(new BigDecimal("10.00")).sgstValue(new BigDecimal("10.00")).igstValue(new BigDecimal("0.00"))
				.cesValue(new BigDecimal("5.00")).stateCesValue(new BigDecimal("5.00"))
				.invoiceDiscount(new BigDecimal("0.00")).otherCharges(new BigDecimal("0.00"))
				.totalInvoiceValue(new BigDecimal("130.00")).build();

		ValueDetails value2 = ValueDetails.builder().assessableValue(new BigDecimal("200.00"))
				.cgstValue(new BigDecimal("20.00")).sgstValue(new BigDecimal("20.00")).igstValue(new BigDecimal("0.00"))
				.cesValue(new BigDecimal("10.00")).stateCesValue(new BigDecimal("10.00"))
				.invoiceDiscount(new BigDecimal("0.00")).otherCharges(new BigDecimal("0.00"))
				.totalInvoiceValue(new BigDecimal("260.00")).build();

		ValueDetails expected = ValueDetails.builder().assessableValue(new BigDecimal("300.00"))
				.cgstValue(new BigDecimal("30.00")).sgstValue(new BigDecimal("30.00")).igstValue(new BigDecimal("0.00"))
				.cesValue(new BigDecimal("15.00")).stateCesValue(new BigDecimal("15.00"))
				.invoiceDiscount(new BigDecimal("0.00")).otherCharges(new BigDecimal("0.00"))
				.totalInvoiceValue(new BigDecimal("390.00")).build();

		ValueDetails actual = ClearTaxTransactionUtils.addValueDetails(value1, value2);

		assertEquals(expected, actual);
	}

	@Test
	void testCalculateTransactions() {
		// Create TransactionItem objects using builder pattern
		TransactionItem item1 = TransactionItem.builder().assessableAmount(new BigDecimal("100"))
				.cgstAmount(new BigDecimal("5")).sgstAmount(new BigDecimal("5")).igstAmount(BigDecimal.ZERO)
				.cesAmount(BigDecimal.ZERO).stateCesAmount(BigDecimal.ZERO).cesNonAdvlAmount(BigDecimal.ZERO)
				.stateCesNonAdvlAmount(BigDecimal.ZERO).discount(BigDecimal.ZERO).otherCharge(BigDecimal.ZERO)
				.totalAmount(new BigDecimal("110")).build();
		TransactionItem item2 = TransactionItem.builder().assessableAmount(new BigDecimal("200"))
				.cgstAmount(new BigDecimal("10")).sgstAmount(new BigDecimal("10")).igstAmount(BigDecimal.ZERO)
				.cesAmount(BigDecimal.ZERO).stateCesAmount(BigDecimal.ZERO).cesNonAdvlAmount(BigDecimal.ZERO)
				.stateCesNonAdvlAmount(BigDecimal.ZERO).discount(BigDecimal.ZERO).otherCharge(BigDecimal.ZERO)
				.totalAmount(new BigDecimal("220")).build();

		// Create a collection of TransactionItem objects
		Collection<TransactionItem> items = Arrays.asList(item1, item2);

		// Calculate the total transaction value
		ValueDetails result = ClearTaxTransactionUtils.calculateValueDetailsFromTransactionItems(items);

		// Assert that the total transaction value is correct
		Assertions.assertEquals(new BigDecimal("330"), result.getTotalInvoiceValue(),
				"Total transaction value should be 330");
		Assertions.assertEquals(new BigDecimal("300"), result.getAssessableValue(),
				"Total assessable value should be 300");
		Assertions.assertEquals(new BigDecimal("15"), result.getCgstValue(), "Total CGST value should be 15");
		Assertions.assertEquals(new BigDecimal("15"), result.getSgstValue(), "Total SGST value should be 15");
		Assertions.assertEquals(BigDecimal.ZERO, result.getIgstValue(), "Total IGST value should be 0");
		Assertions.assertEquals(BigDecimal.ZERO, result.getCesValue(), "Total CES value should be 0");
		Assertions.assertEquals(BigDecimal.ZERO, result.getStateCesValue(), "Total state CES value should be 0");
		Assertions.assertEquals(BigDecimal.ZERO, result.getInvoiceDiscount(), "Total invoice discount should be 0");
		Assertions.assertEquals(BigDecimal.ZERO, result.getOtherCharges(), "Total other charges should be 0");
	}
}
