package dev.manojc.cleartaxsdk.models.transaction.referencedetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

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
public class DocumentPeriodDetails {

    @JsonProperty("InvStDt")
    @Length(min = 10, max = 10, message = "InvStDt (Invoice Period Start Date) should be at least 10 and at most 10 characters")
    @NotNull
    @Pattern(regexp = "^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$", message = "InvStDt should be of pattern dd/mm/yyyy")
    private String invoicePeriodStartDate;

    @JsonProperty("InvEndDt")
    @Length(min = 10, max = 10, message = "InvEndDt (Invoice Period End Date) should be at least 10 and at most 10 characters")
    @NotNull
    @Pattern(regexp = "^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$", message = "InvEndDt should be of pattern dd/mm/yyyy")
    private String invoicePeriodEndDate;

}
