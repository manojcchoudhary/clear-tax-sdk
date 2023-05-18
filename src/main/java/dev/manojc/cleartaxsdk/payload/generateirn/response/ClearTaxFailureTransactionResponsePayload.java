package dev.manojc.cleartaxsdk.payload.generateirn.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.manojc.cleartaxsdk.payload.generateirn.response.government.TransactionFailureGovernmentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=true)
public class ClearTaxFailureTransactionResponsePayload<T> extends ClearTaxTransactionResponse<T>{

    @JsonProperty("govt_response")
    private TransactionFailureGovernmentResponse govtResponse;

}
