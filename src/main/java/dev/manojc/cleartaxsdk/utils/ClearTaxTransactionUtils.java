package dev.manojc.cleartaxsdk.utils;

import java.math.BigDecimal;
import java.util.Collection;

import dev.manojc.cleartaxsdk.models.transaction.itemlist.TransactionItem;
import dev.manojc.cleartaxsdk.models.transaction.valuedetails.ValueDetails;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClearTaxTransactionUtils {

	private ClearTaxTransactionUtils() {
		log.debug("ClearTaxTransactionUtils initialized");
	}

	public static BigDecimal calculateTotalItemValue(TransactionItem item) {
		return new BigDecimal("0").add(item.getAssessableAmount()).add(item.getIgstAmount()).add(item.getCgstAmount())
				.add(item.getSgstAmount()).add(item.getCesAmount()).add(item.getCesNonAdvlAmount())
				.add(item.getStateCesAmount()).add(item.getStateCesNonAdvlAmount()).add(item.getOtherCharge());
	}

	public static ValueDetails calculateTransaction(TransactionItem item) {
		BigDecimal itemAssessableValue = item.getAssessableAmount();
		BigDecimal itemCgstValue = item.getCgstAmount();
		BigDecimal itemSgstValue = item.getSgstAmount();
		BigDecimal itemIgstValue = item.getIgstAmount();
		BigDecimal itemCesValue = item.getCesAmount();
		BigDecimal itemStateCesValue = item.getStateCesAmount();
		BigDecimal itemInvoiceDiscount = item.getDiscount();
		BigDecimal itemOtherCharges = item.getOtherCharge();
		BigDecimal itemTotal = item.getTotalAmount();
		return ValueDetails.builder().assessableValue(itemAssessableValue).cgstValue(itemCgstValue)
				.sgstValue(itemSgstValue).igstValue(itemIgstValue).cesValue(itemCesValue)
				.stateCesValue(itemStateCesValue).invoiceDiscount(itemInvoiceDiscount).otherCharges(itemOtherCharges)
				.totalInvoiceValue(itemTotal).build();
	}

	public static BigDecimal addBigDecimal(BigDecimal value1, BigDecimal value2) {
		return new BigDecimal(0).add(value1).add(value2);
	}

	public static ValueDetails addValueDetails(ValueDetails value1, ValueDetails value2) {
		BigDecimal totalAssessableValue = addBigDecimal(value1.getAssessableValue(), value2.getAssessableValue());
		BigDecimal totalCgstValue = addBigDecimal(value1.getCgstValue(), value2.getCgstValue());
		BigDecimal totalSgstValue = addBigDecimal(value1.getSgstValue(), value2.getSgstValue());
		BigDecimal totalIgstValue = addBigDecimal(value1.getIgstValue(), value2.getIgstValue());
		BigDecimal totalCesValue = addBigDecimal(value1.getCesValue(), value2.getCesValue());
		BigDecimal totalStateCesValue = addBigDecimal(value1.getStateCesValue(), value2.getStateCesValue());
		BigDecimal totalInvoiceDiscount = addBigDecimal(value1.getInvoiceDiscount(), value2.getInvoiceDiscount());
		BigDecimal totalOtherCharges = addBigDecimal(value1.getOtherCharges(), value2.getOtherCharges());
		BigDecimal totalInvoiceValue = addBigDecimal(value1.getTotalInvoiceValue(), value2.getTotalInvoiceValue());
		return ValueDetails.builder().assessableValue(totalAssessableValue).cgstValue(totalCgstValue)
				.sgstValue(totalSgstValue).igstValue(totalIgstValue).cesValue(totalCesValue)
				.stateCesValue(totalStateCesValue).invoiceDiscount(totalInvoiceDiscount).otherCharges(totalOtherCharges)
				.totalInvoiceValue(totalInvoiceValue).build();
	}

	public static ValueDetails calculateValueDetailsFromTransactionItems(Collection<TransactionItem> items) {
		return items.stream().map(ClearTaxTransactionUtils::calculateTransaction).reduce(ValueDetails.builder().build(),
				ClearTaxTransactionUtils::addValueDetails);
	}

}
