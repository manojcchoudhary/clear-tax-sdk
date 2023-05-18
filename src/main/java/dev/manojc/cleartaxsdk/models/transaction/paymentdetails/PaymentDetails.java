package dev.manojc.cleartaxsdk.models.transaction.paymentdetails;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class PaymentDetails {

    @JsonProperty("Nm")
    @Length(min = 1, max = 100, message = "Nm (Payee Name) should be at least 1 and at most 100 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$")
    private String payeeName;

    @JsonProperty("AccDet")
    @Length(min = 1, max = 18, message = "AccDet (Bank Account number of payee) should be at least 1 and at most 18 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$")
    private String accountDetails;

    @JsonProperty("Mode")
    @Length(min = 1, max = 18, message = "Mode (Mode of Payment: Cash, Credit, Direct Transfer) should be at least 1 and at most 18 characters")
    @Pattern(regexp = "^([^\\\"])*$")
    @Nullable
    private String mode;

    @JsonProperty("FinInsBr")
    @Length(min = 1, max = 11, message = "FinInsBr (Branch or IFSC code) should be at least 1 and at most 11 characters")
    @Pattern(regexp = "^([^\\\"])*$")
    @Nullable
    private String branchOrIfscCode;

    @JsonProperty("PayTerm")
    @Length(min = 1, max = 100, message = "PayTerm (Terms of Payment) should be at least 1 and at most 100 characters")
    @Pattern(regexp = "^([^\\\"])*$")
    @Nullable
    private String paymentTerms;

    @JsonProperty("PayInstr")
    @Length(min = 1, max = 100, message = "PayInstr (Payment Instruction) should be at least 1 and at most 100 characters")
    @Pattern(regexp = "^([^\\\"])*$")
    @Nullable
    private String paymentInstruction;

    @JsonProperty("CrTrn")
    @Length(min = 1, max = 100, message = "CrTrn (Credit Transfer) should be at least 1 and at most 100 characters")
    @Nullable
    private String creditTransfer;

    @JsonProperty("DirDr")
    @Length(min = 1, max = 100, message = "DirDr (Direct Debit) should be at least 1 and at most 100 characters")
    @Pattern(regexp = "^([^\\\"])*$")
    @Nullable
    private String directDebit;

    @JsonProperty("CrDay")
    @Min(value = 0, message = "CrDay (Credit Days) should be at least 0")
    @Max(value = 9999, message = "CrDay (Credit Days) should be at least 9999")
    @Nullable
    private Integer creditDays;

    @JsonProperty("PaidAmt")
    @DecimalMin(value = "0", message = "PaidAmt (The sum of amount which have been paid in advance) should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "PaidAmt (The sum of amount which have been paid in advance) should be at least 99999999999999.99")
    @Nullable
    private BigDecimal paidAmount;

    @JsonProperty("PaymtDue")
    @DecimalMin(value = "0", message = "PaymtDue (Outstanding amount that is required to be paid.) should be at least 0")
    @DecimalMax(value = "99999999999999.99", message = "PaymtDue (Outstanding amount that is required to be paid.) should be at least 99999999999999.99")
    @Nullable
    private BigDecimal paymentDue;

}
