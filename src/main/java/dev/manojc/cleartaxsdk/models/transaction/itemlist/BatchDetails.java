package dev.manojc.cleartaxsdk.models.transaction.itemlist;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@Builder
public class BatchDetails {

    /**
     * Batch Number
     */
    @JsonProperty("Nm")
    @Length(min = 3, max = 20, message = "Nm should be at least 3 and at most 20 characters")
    @Pattern(regexp = "^([^\\\"])*$", message = "Nm is invalid")
    @NonNull
    private String batchNumber;

    /**
     * Optional. Batch Expiry Date
     */
    @JsonProperty("ExpDt")
    @Length(min = 10, max = 10, message = "ExpDt should be at least 10 and at most 10 characters")
    @Pattern(regexp = "^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$", message = "ExpDt is invalid")
    @Nullable
    private String expiryDate;

    /**
     * Optional. Warranty Date
     */
    @JsonProperty("WrDt")
    @Length(min = 10, max = 10, message = "WrDt should be at least 10 and at most 10 characters")
    @Pattern(regexp = "^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$", message = "WrDt is invalid")
    @Nullable
    private String warrantyDate;

}
