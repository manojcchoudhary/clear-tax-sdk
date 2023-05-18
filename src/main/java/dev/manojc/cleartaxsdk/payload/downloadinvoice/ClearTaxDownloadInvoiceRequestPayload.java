package dev.manojc.cleartaxsdk.payload.downloadinvoice;

import java.util.Collection;
import java.util.Collections;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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
public class ClearTaxDownloadInvoiceRequestPayload {

    @JsonProperty("irns")
    @Builder.Default
    @NotEmpty(message = "irns is required")
    @Length(min = 1, max = 10, message = "irns should be at least 1 and at most 10")
    private Collection<String> irns = Collections.emptyList();

}
