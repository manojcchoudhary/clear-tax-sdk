package dev.manojc.cleartaxsdk.models.transaction.valuedetails;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class ValueDetails {

    /*
     * Mandatory. Total Assessable value of all items
     */
    @JsonProperty("AssVal")
    @DecimalMin(value = "0", message = "AssVal should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "AssVal should be at most be 99999999999999.99")
    @NotNull
    @Builder.Default
    private BigDecimal assessableValue = new BigDecimal("0");

    /**
     * Conditional. Total CGST value of all items
     */
    @JsonProperty("CgstVal")
    @DecimalMin(value = "0", message = "CgstVal should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "CgstVal should be at most be 99999999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal cgstValue = new BigDecimal("0");

    /**
     * Conditional. Total SGST value of all items
     */
    @JsonProperty("SgstVal")
    @DecimalMin(value = "0", message = "SgstVal should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "SgstVal should be at most be 99999999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal sgstValue = new BigDecimal("0");

    /**
     * Conditional. Total IGST value of all items
     */
    @JsonProperty("IgstVal")
    @DecimalMin(value = "0", message = "IgstVal should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "IgstVal should be at most be 99999999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal igstValue = new BigDecimal("0");

    /**
     * Conditional. Total CESS value of all items
     */
    @JsonProperty("CesVal")
    @DecimalMin(value = "0", message = "CesVal should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "CesVal should be at most be 99999999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal cesValue = new BigDecimal("0");

    /**
     * Conditional. Total State CESS value of all items
     */
    @JsonProperty("StCesVal")
    @DecimalMin(value = "0", message = "StCesVal should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "StCesVal should be at most be 99999999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal stateCesValue = new BigDecimal("0");

    /**
     * Conditional. Total invoice discount
     */
    @JsonProperty("Discount")
    @DecimalMin(value = "0", message = "Discount should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "Discount should be at most be 99999999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal invoiceDiscount = new BigDecimal("0");

    /**
     * Conditional. Other Charges
     */
    @JsonProperty("OthChrg")
    @DecimalMin(value = "0", message = "OthChrg should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "OthChrg should be at most be 99999999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal otherCharges = new BigDecimal("0");

    /**
     * Conditional. Rounding off amount
     */
    @JsonProperty("RndOffAmt")
    @DecimalMin(value = "-99.99", message = "RndOffAmt should be at least -99.99")
    @DecimalMax(value = "99.99", message = "RndOffAmt should be at most be 99.99")
    @Nullable
    @Builder.Default
    private BigDecimal roundOffAmount = new BigDecimal("0");

    /**
     * Mandatory.  Final Invoice value
     */
    @JsonProperty("TotInvVal")
    @DecimalMin(value = "0", message = "TotInvVal should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "TotInvVal should be at most be 99999999999999.99")
    @NotNull
    @Builder.Default
    private BigDecimal totalInvoiceValue = new BigDecimal("0");

    /**
     * Optional. Final Invoice value in Additional Currency
     */
    @JsonProperty("TotInvValFc")
    @DecimalMin(value = "0", message = "TotInvValFc should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "TotInvValFc should be at most be 99999999999999.99")
    @NotNull
    @Builder.Default
    private BigDecimal finalInvoiceValueInAdditionalCurrency = new BigDecimal("0");

}
