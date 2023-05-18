package dev.manojc.cleartaxsdk.models.transaction.transactiondetails;

import javax.validation.constraints.NotBlank;
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
public class TransactionDetails {

	@JsonProperty("TaxSch")
	@Length(max = 10, min = 3, message = "TaxSch should be 'GST'")
	@Builder.Default
	@NotBlank
	private TaxSchema taxSch = TaxSchema.GST;

	@JsonProperty("SupTyp")
	@Length(max = 10, min = 3, message = "SupTyp should be \"B2B\", \"SEZWP\", \"SEZWOP\", \"EXPWP\", \"EXPWOP\", \"DEXP\"")
	@Builder.Default
	@NotBlank
	private SupplyType supTyp = SupplyType.B2B;

	@JsonProperty("RegRev")
	@Length(min = 1, max = 1, message = "RegRev should be \"Y\", \"N\"")
	@Builder.Default
	@NotBlank
	private RegistrationReverseCharge regRev = RegistrationReverseCharge.N;

	/**
	 * GSTIN of e-Commerce operator
	 */
	@JsonProperty("EcmGstin")
	@Length(min = 15, max = 15)
	@Pattern(regexp = "^([0-9]{2}[0-9A-Z]{13})$")
	@Nullable
	private String ecmGstin;

	@JsonProperty("IgstOnIntra")
	@Length(min = 1, max = 1, message = "IgstOnIntra should be \"Y\", \"N\"")
	@Builder.Default
	@NotBlank
	private IgstOnIntra igstOnIntra = IgstOnIntra.N;

}
