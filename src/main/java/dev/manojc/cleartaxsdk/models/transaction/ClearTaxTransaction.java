package dev.manojc.cleartaxsdk.models.transaction;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.manojc.cleartaxsdk.models.transaction.additionaldetails.AdditionalDetails;
import dev.manojc.cleartaxsdk.models.transaction.buyerdetails.BuyerDetails;
import dev.manojc.cleartaxsdk.models.transaction.dispatchdetails.DispatchDetails;
import dev.manojc.cleartaxsdk.models.transaction.documentdetails.DocumentDetails;
import dev.manojc.cleartaxsdk.models.transaction.ewaydetails.EwayBillDetails;
import dev.manojc.cleartaxsdk.models.transaction.exportdetails.ExportDetails;
import dev.manojc.cleartaxsdk.models.transaction.itemlist.TransactionItem;
import dev.manojc.cleartaxsdk.models.transaction.paymentdetails.PaymentDetails;
import dev.manojc.cleartaxsdk.models.transaction.referencedetails.ReferenceDetails;
import dev.manojc.cleartaxsdk.models.transaction.sellerdetails.SellerDetails;
import dev.manojc.cleartaxsdk.models.transaction.shipdetails.ShippingDetails;
import dev.manojc.cleartaxsdk.models.transaction.transactiondetails.TransactionDetails;
import dev.manojc.cleartaxsdk.models.transaction.valuedetails.ValueDetails;
import dev.manojc.cleartaxsdk.models.transaction.version.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ClearTaxTransaction {

	@JsonProperty("Version")
	@Builder.Default
	private final Version version = Version.VERSION_1_1;

	@JsonProperty("TranDtls")
	@NotNull(message = "TranDtls is required")
	private TransactionDetails transactionDetails;

	@JsonProperty("DocDtls")
	@NotNull(message = "DocDtls is required")
	private DocumentDetails documentDetails;

	@JsonProperty("SellerDtls")
	@NotNull(message = "SellerDtls is required")
	private SellerDetails sellerDetails;

	@JsonProperty("BuyerDtls")
	@NotNull(message = "BuyerDtls is required")
	private BuyerDetails buyerDetails;

	/*
	 * Conditional. Dispatch From details object. Required only if the Dispatch From
	 * address is different from Seller Details address.
	 */
	@JsonProperty("DispDtls")
	@Nullable
	private DispatchDetails dispatchDetails;

	/**
	 * Conditional. Ship To details object. Required only if the Ship To address is
	 * different from Buyer Details address.
	 */
	@JsonProperty("ShipDtls")
	@Nullable
	private ShippingDetails shippingDetails;

	/**
	 * Mandatory. List of one or more Item objects. Maximum 1000 line items are
	 * supported per document. This limit can be extended to 5000 line items by
	 * requesting the same from the NIC (Government) support
	 */
	@JsonProperty("ItemList")
	@Size(min = 1, message = "ItemList should at least be of 1 item")
	@NotNull
	@Builder.Default
	private Collection<TransactionItem> transactionItems = new ArrayList<>();

	/**
	 * Mandatory. Value details object.
	 */
	@JsonProperty("ValDtls")
	@NotNull
	private ValueDetails valueDetails;

	/**
	 * Optional. Payment details object.
	 */
	@JsonProperty("PayDtls")
	@Nullable
	private PaymentDetails paymentDetails;

	/**
	 * Optional. Reference details object.
	 */
	@JsonProperty("RefDtls")
	@Nullable
	private ReferenceDetails referenceDetails;

	/**
	 * Optional. Additional Document details object.
	 */
	@JsonProperty("AddlDocDtls")
	@Nullable
	private Collection<AdditionalDetails> additionalDetails;

	/**
	 * Conditional. Export details object. Required only if the document type is
	 * Export.
	 */
	@JsonProperty("ExpDtls")
	@Nullable
	private ExportDetails exportDetails;

	@JsonProperty("EwbDtls")
	@Nullable
	private EwayBillDetails ewayBillDetails;
}
