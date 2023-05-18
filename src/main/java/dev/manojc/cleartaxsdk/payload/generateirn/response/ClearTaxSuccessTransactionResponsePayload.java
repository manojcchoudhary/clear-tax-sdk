package dev.manojc.cleartaxsdk.payload.generateirn.response;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.manojc.cleartaxsdk.payload.generateirn.response.government.SuccessType;
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
public class ClearTaxSuccessTransactionResponsePayload<T> extends ClearTaxTransactionResponse<T> {

    @JsonProperty("Success")
    @NotBlank
    @Length(max = 1, min = 1, message = "Success should be \"Y\" or \"N\"")
    private SuccessType successType;

    @JsonProperty("AckNo")
    private Long acknowledgmentNumber;

    @JsonProperty("AckDt")
    private String acknowledgmentDate;

    @JsonProperty("Irn")
    @NotBlank
    private String irn;

    @JsonProperty("SignedInvoice")
    private String signedInvoice;

    @JsonProperty("SignedQRCode")
    private String signedQrCode;

    @JsonProperty("Status")
    private String status;


    @JsonProperty("EwbNo")
    private Long eWayBillNumber;

    @JsonProperty("EwbDt")
    private String eWayBillDate;

    @JsonProperty("EwbValidTill")
    private String ewbValidTill;

}
