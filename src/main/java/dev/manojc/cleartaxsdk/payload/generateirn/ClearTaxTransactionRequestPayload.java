package dev.manojc.cleartaxsdk.payload.generateirn;

import java.util.Map;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.manojc.cleartaxsdk.models.transaction.ClearTaxTransaction;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class ClearTaxTransactionRequestPayload<T> {

	@JsonProperty("transaction")
	@NotNull(message = "transaction is required")
	private ClearTaxTransaction transaction;

	@JsonProperty("custom_fields")
	private Map<?, T> customFields;
}
