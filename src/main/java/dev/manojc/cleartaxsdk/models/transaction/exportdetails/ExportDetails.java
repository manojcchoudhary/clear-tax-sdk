package dev.manojc.cleartaxsdk.models.transaction.exportdetails;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
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
public class ExportDetails {

    @JsonProperty("ShipBNo")
    @Length(min = 1, max = 20, message = "ShipBNo (Shipping Bill No.) should be at least 1 and at most 20 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$")
    private String shippingBillNumber;

    @JsonProperty("ShipBDt")
    @Length(min = 10, max = 10, message = "ShipBDt (Shipping Bill Date.) should be at least 10 and at most 10 characters")
    @Nullable
    @Pattern(regexp = "^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$")
    private String shippingBillDate;

    @JsonProperty("Port")
    @Length(min = 10, max = 10, message = "Port (Port Code) should be https://docs.cleartax.in/cleartax-docs/e-invoicing-api/e-invoicing-api-reference/resources-and-master/port-code-master")
    @Nullable
    @Pattern(regexp = "^[0-9|A-Z|a-z]{2,10}$")
    private PortCode portCode;

    @JsonProperty("RefClm")
	@Length(min = 1, max = 1, message = "RefClm should be \"Y\", \"N\"")
    @Nullable
    private ClaimingRefund claimRefund;

    @JsonProperty("ForCur")
	@Length(min = 3, max = 16, message = "ForCur should be at one of https://docs.cleartax.in/cleartax-docs/e-invoicing-api/e-invoicing-api-reference/resources-and-master/currency-code-master")
    @Pattern(regexp = "^[A-Z|a-z]{3,16}$", message = "ForCur should be at one of https://docs.cleartax.in/cleartax-docs/e-invoicing-api/e-invoicing-api-reference/resources-and-master/currency-code-master")
    @Nullable
    private CurrencyCode currencyCode;

    @JsonProperty("CntCode")
	@Length(min = 2, max = 2, message = "CntCode should be at one of https://docs.cleartax.in/cleartax-docs/e-invoicing-api/e-invoicing-api-reference/resources-and-master/country-code-master")
    @Pattern(regexp = "^([A-Z]{2})$", message = "CntCode should be at one of https://docs.cleartax.in/cleartax-docs/e-invoicing-api/e-invoicing-api-reference/resources-and-master/country-code-master")
    @Nullable
    private CountryCode countryCode;

    @JsonProperty("ExpDuty")
    @DecimalMin(value = "0", message = "ExpDuty should be at least 0")
    @DecimalMax(value = "999999999999.99", message = "ExpDuty should be at most be 999999999999.99")
    @Nullable
    @Builder.Default
    private BigDecimal quantity = new BigDecimal("0");
}
