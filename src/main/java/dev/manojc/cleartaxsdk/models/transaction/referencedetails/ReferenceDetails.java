package dev.manojc.cleartaxsdk.models.transaction.referencedetails;

import java.util.Collection;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
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
public class ReferenceDetails {

    @JsonProperty("InvRm")
    @Length(min = 3, max = 100, message = "InvRm (Invoice Remark) should be at least 3 and at most 100 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$")
    private String invoiceRemark;

    @JsonProperty("DocPerdDtls")
    @Nullable
    private DocumentPeriodDetails documentPeriodDetails;

    /**
     * List of one or more Preceding Document Details objects.
     */
    @JsonProperty("PrecDocDtls")
    @Nullable
    private Collection<PrecedingDocumentDetails> precedingDocumentDetails;

    /**
     *  List of one or more Contract Details objects.
     */
    @JsonProperty("ContrDtls")
    @Nullable
    private Collection<ContractDetails> contractDetails;
}
