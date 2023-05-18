package dev.manojc.cleartaxsdk.models.transaction.itemlist;

import java.math.BigDecimal;
import java.util.Collection;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@Builder
public class TransactionItem {

    @JsonProperty("SlNo")
    @Length(min = 1, max = 6, message = "SlNo should be at least 1 and at most 6 characters")
    @NotBlank(message = "SlNo (Serial Number) is required")
    @Pattern(regexp = "^([0-9]{1,6})$")
    private String serialNumber;

    @JsonProperty("PrdDesc")
    @Length(min = 3, max = 300, message = "PrdDesc should be at least 3 and at most 300 characters")
    @Pattern(regexp = "^([^\\\"])*$")
    @Nullable
    private String productDescription;

    @JsonProperty("IsServc")
    @Length(min = 1, max = 1, message = "IsServc should be 'Y' or 'N'")
    @Pattern(regexp = "^[YN]$")
    @NotBlank
    private ServiceType isService;

    @JsonProperty("HsnCd")
    @Length(min = 6, max = 8, message = "HsnCd should be at least 6 and at most 8 characters")
    @Pattern(regexp = "^(?!0+$)([0-9]{4}|[0-9]{6}|[0-9]{8})$")
    @NotBlank
    private String hsnCode;

    @JsonProperty("Barcde")
    @Length(min = 3, max = 30, message = "Barcde should be at least 3 and at most 30 characters")
    @Pattern(regexp = "^([^\\\"])*$")
    @Nullable
    private String barCode;

    @JsonProperty("Qty")
    @DecimalMin(value = "0", message = "Qty should be at least 0")
    @DecimalMax(value = "9999999999.999", message = "Qty should be at most be 9999999999.999")
    @Nullable
    @Builder.Default
    private BigDecimal quantity = new BigDecimal("0");

    @JsonProperty("FreeQty")
    @DecimalMin(value = "0", message = "FreeQty should be at least 0")
    @DecimalMax(value = "9999999999.999", message = "FreeQty should be at most be 9999999999.999")
    @Nullable
    @Builder.Default
    private BigDecimal freeQuantity = new BigDecimal("0");

    @JsonProperty("Unit")
    @Length(max = 8, min = 3, message = "Unit in itemList should be any of https://docs.cleartax.in/cleartax-docs/e-invoicing-api/e-invoicing-api-reference/resources-and-master/unit-master")
    @Nullable
    private UnitType unit;

    @JsonProperty("UnitPrice")
    @DecimalMin(value = "0", message = "UnitPrice should be at least 0")
    @DecimalMax(value = "9999999999.999", message = "UnitPrice should be at most be 9999999999.999")
    @NotBlank
    @Builder.Default
    private BigDecimal unitPrice = new BigDecimal("0");

    /**
     * Total Amount (Unit Price * Quantity)
     */
    @JsonProperty("TotAmt")
    @DecimalMin(value = "0", message = "TotAmt should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "TotAmt should be at most be 9999999999.99")
    @NotBlank
    @NotNull
    @Builder.Default
    private BigDecimal totalAmount = new BigDecimal("0");

    @JsonProperty("Discount")
    @DecimalMin(value = "0", message = "Discount should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "Discount should be at most be 9999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal discount = new BigDecimal("0");

    @JsonProperty("PreTaxVal")
    @DecimalMin(value = "0", message = "PreTaxVal should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "PreTaxVal should be at most be 9999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal preTaxValue = new BigDecimal("0");

    /**
     * Assessable Amount (Total Amount - Discount)
     */
    @JsonProperty("AssAmt")
    @DecimalMin(value = "0", message = "AssAmt should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "AssAmt should be at most be 9999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal assessableAmount = new BigDecimal("0");

    /**
     * The GST rate, represented as percentage that applies to the invoiced item.
     * It will be IGST rate (OR sum of CGST and SGST rates)
     */
    @JsonProperty("GstRt")
    @DecimalMin(value = "0", message = "GstRt should be at least 0")
    @DecimalMax(value = "999.999", message = "GstRt should be at most be 999.999")
    @NotBlank
    @Builder.Default
    private BigDecimal gstRate = new BigDecimal("0");

    /**
     * Conditional. Amount of IGST payable
     */
    @JsonProperty("IgstAmt")
    @DecimalMin(value = "0", message = "IgstAmt should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "IgstAmt should be at most be 9999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal igstAmount = new BigDecimal("0");

    /**
     * Conditional. Amount of CGST payable
     */
    @JsonProperty("CgstAmt")
    @DecimalMin(value = "0", message = "CgstAmt should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "CgstAmt should be at most be 9999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal cgstAmount = new BigDecimal("0");

    /**
     * Conditional. Amount of SGST payable
     */
    @JsonProperty("SgstAmt")
    @DecimalMin(value = "0", message = "SgstAmt should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "SgstAmt should be at most be 9999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal sgstAmount = new BigDecimal("0");

    /**
     * Optional. Cess Rate
     */
    @JsonProperty("CesRt")
    @DecimalMin(value = "0", message = "CesRt should be at least 0")
    @DecimalMax(value = "999.999", message = "CesRt should be at most be 999.999")
    @NotBlank
    @Builder.Default
    private BigDecimal cesRate = new BigDecimal("0");

    /**
     * Optional. Cess Amount(advolorem) on basis of rate and quantity of item
     */
    @JsonProperty("CesAmt")
    @DecimalMin(value = "0", message = "CesAmt should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "CesAmt should be at most be 9999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal cesAmount = new BigDecimal("0");

    /**
     * Optional. Cess Non-Advol Amount
     */
    @JsonProperty("CesNonAdvlAmt")
    @DecimalMin(value = "0", message = "CesNonAdvlAmt should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "CesNonAdvlAmt should be at most be 9999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal cesNonAdvlAmount = new BigDecimal("0");

    /**
     * Optional. State Cess Rate
     */
    @JsonProperty("StateCesRt")
    @DecimalMin(value = "0", message = "StateCesRt should be at least 0")
    @DecimalMax(value = "999.999", message = "StateCesRt should be at most be 999.999")
    @NotBlank
    @Builder.Default
    private BigDecimal stateCesRate = new BigDecimal("0");

    /**
     * Optional. State Cess Amount
     */
    @JsonProperty("StateCesAmt")
    @DecimalMin(value = "0", message = "StateCesAmt should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "StateCesAmt should be at most be 9999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal stateCesAmount = new BigDecimal("0");

    /**
     * Optional. State Cess Non-Advol Amount
     */
    @JsonProperty("StateCesNonAdvlAmt")
    @DecimalMin(value = "0", message = "StateCesNonAdvlAmt should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "StateCesNonAdvlAmt should be at most be 9999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal stateCesNonAdvlAmount = new BigDecimal("0");

    /**
     * Optional. Other Charges on line item
     */
    @JsonProperty("OthChrg")
    @DecimalMin(value = "0", message = "OthChrg should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "OthChrg should be at most be 9999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal otherCharge = new BigDecimal("0");

    /**
     * Mandatory. Total Item Value =
     * AssAmt + IgstAmt + CgstAmt + SgstAmt + CesAmt + CesNonAdvlAmt + StateCesAmt +
     * StateCesNonAdvlAmt + OthChrg
     */
    @JsonProperty("TotItemVal")
    @DecimalMin(value = "0", message = "TotItemVal should be at least 0")
    @DecimalMax(value = "9999999999.99", message = "TotItemVal should be at most be 9999999999.99")
    @NotBlank
    @Builder.Default
    private BigDecimal totalItemValue = new BigDecimal("0");

    /**
     * Optional. Order line reference
     */
    @JsonProperty("OrdLineRef")
    @Length(min = 1, max = 50, message = "OrdLineRef should be at least 1 and at most 50 characters")
    @Pattern(regexp = "^([^\\\"])*$")
    @Nullable
    private String orderLineReference;

    /**
     * Optional. Origin Country Code.
     */
    @JsonProperty("OrgCntry")
    @Length(max = 2, min = 2, message = "OrgCntry in Invoice Document Type should be of https://docs.cleartax.in/cleartax-docs/e-invoicing-api/e-invoicing-api-reference/resources-and-master/country-code-master")
    @Pattern(regexp = "^([A-Z|a-z]{2})$", message = "OrgCntry is invalid")
    @Nullable
    private String originalCountryCode;

    /**
     * Optional. Serial number in case of each item having a unique number.
     */
    @JsonProperty("PrdSlNo")
    @Length(max = 20, min = 1, message = "PrdSlNo should be at least 1 and at most 20 characters")
    @Pattern(regexp = "^([^\\\"])*$", message = "PrdSlNo is invalid")
    @Nullable
    private String productSerialNumber;

    /**
     * Optional. Batch details object.
     */
    @JsonProperty("BchDtls")
    @Nullable
    private Collection<BatchDetails> batchDetails;

    /**
     * Optional. List of one or more Attribute Details object.
     */
    @JsonProperty("AttribDtls")
    @Nullable
    private Collection<AttributeDetails> attributeDetails;
    
}
