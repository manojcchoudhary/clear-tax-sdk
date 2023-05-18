package dev.manojc.cleartaxsdk.models.transaction.addressdetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
@Getter
public abstract class AddressDetails extends PartialAddressDetails {

    @JsonProperty("Gstin")
	@Length(max = 15, min = 15, message = "Gstin should be of length 15")
	@Pattern(regexp = "([0-9]{2}[0-9A-Z]{13})")
	@NotBlank(message = "Gstin is required")
	private String gstin;

	@JsonProperty("LglNm")
	@Length(max = 100, min = 3, message = "LglNm should be greater than 3 and lesser than 100")
	@Pattern(regexp = "^([^\\\\\\\"])*$")
	@NotBlank(message = "LglNm is required")
	private String legalName;

	@JsonProperty("TrdNm")
	@Length(max = 100, min = 3, message = "TrdNm should be greater than 3 and lesser than 100 characters")
	@Pattern(regexp = "^([^\\\\\\\"])*$")
	@NotBlank(message = "Trade Name is required")
	private String tradeName;

    @JsonProperty("Ph")
    @Length(min = 6, max = 12, message = "Ph should be equal or greater than 6 and less than or equal to 12 digits")
    @Pattern(regexp = "^([0-9]{6,12})$")
	@Nullable
    private String phoneNumber;

    @JsonProperty("Em")
    @Length(min = 6, max = 12, message = "Em should be equal or greater than 6 and less than or equal to 12 digits")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	@Nullable
    private String emailId;

}
