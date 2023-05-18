package dev.manojc.cleartaxsdk.payload.generateirn.response;

import java.util.Map;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

import dev.manojc.cleartaxsdk.models.transaction.transactiondetails.TransactionDetails;
import lombok.Data;

@Data
public class ClearTaxTransactionResponse<E> implements ClearTaxTransactionResponseMarker {

    @JsonProperty("custom_fields")
    @Size(min = 0, max = 10, message = "custom_fields should be at most 10 key value pairs")
    @Nullable
    private Map<?, E> customFields;

    @JsonProperty("deleted")
    private boolean deleted;

    @JsonProperty("document_status")
    @Length(min = 11, max = 13, message = "document_status should be \"IRN_GENERATED\", \"NOT_CREATED\"")
    @NotBlank
    private DocumentStatus documentStatus;

    @JsonProperty("error_response")
    private Optional<String> errorResponse;

    @JsonProperty("errors")
    private Optional<String> errors;

    @JsonProperty("group_id")
    private Optional<String> groupId;

    @JsonProperty("gstin")
    private String gstin;

    @JsonProperty("is_deleted")
    private boolean isDeleted;

    @JsonProperty("owner_id")
    private Optional<String> ownerId;

    @JsonProperty("tag_identifier")
    private Optional<String> tagIdentifier;

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("transaction_metadata")
    private Optional<String> transactionMetadata;

    @JsonProperty("transaction")
    private Optional<TransactionDetails> transaction;

    public boolean isSuccess() {
        return DocumentStatus.IRN_GENERATED.equals(documentStatus);
    }
}
