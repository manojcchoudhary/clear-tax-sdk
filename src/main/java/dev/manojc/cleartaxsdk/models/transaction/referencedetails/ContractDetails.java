package dev.manojc.cleartaxsdk.models.transaction.referencedetails;

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
public class ContractDetails {

    @JsonProperty("RecAdvRef")
    @Length(min = 1, max = 20, message = "RecAdvRef (Receipt Advice Number) should be at least 1 and at most 20 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$", message = "RecAdvRef (Receipt Advice Number) should be of pattern ^([^\\\"])*$")
    private String receiptAdviceNumber;

    @JsonProperty("RecAdvDt")
    @Length(min = 10, max = 10, message = "RecAdvRef Optional. Date of Receipt Advice")
    @Nullable
    @Pattern(regexp = "^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$", message = "RecAdvRef (Receipt Advice Number) should be of pattern ^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$")
    private String dateOfReceiptAdvice;

    @JsonProperty("TendRefr")
    @Length(min = 1, max = 20, message = "TendRefr (Lot/Batch Reference No) should be at least 1 and at most 20 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$", message = "TendRefr (Lot/Batch Reference No) should be of pattern ^([^\\\"])*$")
    private String tenderOrReferenceNumber;

    @JsonProperty("ContrRefr")
    @Length(min = 1, max = 20, message = "ContrRefr (Contract Reference Number) should be at least 1 and at most 20 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$", message = "ContrRefr (Contract Reference Number) should be of pattern ^([^\\\"])*$")
    private String contractReferenceNumber;

    @JsonProperty("ExtRefr")
    @Length(min = 1, max = 20, message = "ExtRefr (Any other reference) should be at least 1 and at most 20 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$", message = "ExtRefr (Any other reference) should be of pattern ^([^\\\"])*$")
    private String extraReference;

    @JsonProperty("ProjRefr")
    @Length(min = 1, max = 20, message = "ProjRefr (Project Reference Number) should be at least 1 and at most 20 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$", message = "ProjRefr (Project Reference Number) should be of pattern ^([^\\\"])*$")
    private String projectReference;

    @JsonProperty("PORefr")
    @Length(min = 1, max = 16, message = "PORefr (PO Reference Number) should be at least 1 and at most 16 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$", message = "PORefr (PO Reference Number) should be of pattern ^([^\\\"])*$")
    private String poReferenceNumber;

    @JsonProperty("PORefDt")
    @Length(min = 10, max = 10, message = "PORefDt (PO Reference Date) should be at least 10 and at most 10 characters")
    @Nullable
    @Pattern(regexp = "^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$", message = "PORefDt (PO Reference Date) should be of pattern ^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$")
    private String poReferenceDate;

}
