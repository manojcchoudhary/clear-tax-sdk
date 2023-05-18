package dev.manojc.cleartaxsdk.payload.generateirn.response.government;

import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.manojc.cleartaxsdk.payload.generateirn.response.government.error.GovernmentTransactionErrorDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
public class TransactionFailureGovernmentResponse extends CommonGovernmentTransaction {

    @JsonProperty("ErrorDetails")
    @Builder.Default
    private Collection<GovernmentTransactionErrorDetails> errorDetails = Collections.emptyList();

}
