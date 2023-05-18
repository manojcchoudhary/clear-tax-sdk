package dev.manojc.cleartaxsdk.models.transaction.referencedetails;

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
public class PrecedingDocumentDetails {

    /**
     * Reference of original invoice, if any
     */
    @JsonProperty("InvNo")
    @Length(min = 1, max = 16, message = "InvNo (Reference of original invoice, if any) should be at least 1 and at most 16 characters")
    @NotNull
    @Pattern(regexp = "^[1-9a-zA-Z]{1}[0-9a-zA-Z\\/-]{1,15}$", message = "InvNo (Reference of original invoice, if any) should be of pattern ^[1-9a-zA-Z]{1}[0-9a-zA-Z\\/-]{1,15}$")
    private String invoiceNumber;

    @JsonProperty("InvDt")
    @Length(min = 10, max = 10, message = "InvDt (Date of preceding invoice) should be at least 10 and at most 10 characters")
    @NotNull
    @Pattern(regexp = "^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$", message = "InvDt (Date of preceding invoice) should be of pattern dd/mm/yyyy")
    private String invoicePeriodStartDate;

    /**
     * Other Reference
     */
    @JsonProperty("OthRefNo")
    @Length(min = 1, max = 20, message = "OthRefNo (Other Reference) should be at least 1 and at most 20 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$", message = "OthRefNo should be of pattern ^([^\\\"])*$")
    private String otherReferenceNumber;

}
