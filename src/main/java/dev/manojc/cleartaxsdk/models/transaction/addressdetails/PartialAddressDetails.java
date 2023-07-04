package dev.manojc.cleartaxsdk.models.transaction.addressdetails;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PartialAddressDetails {

    @JsonProperty("Addr1")
	@Length(max = 100, min = 1, message = "Addr1 should be greater than 3 and lesser than 100 characters")
	@Pattern(regexp = "^([^\\\\\\\"])*$")
	@NotBlank(message = "Addr1 (Building/Flat no, Road/Street) is required.")
	private String address1;

	@JsonProperty("Addr2")
	@Length(max = 100, min = 3, message = "Addr2 should be greater than 3 and lesser than 100 characters")
	@Pattern(regexp = "^([^\\\\\\\"])*$")
	@Nullable
	private String address2;

	@JsonProperty("Loc")
	@Length(max = 50, min = 3, message = "Loc should be greater than 3 and lesser than 50 characters")
	@Pattern(regexp = "^([^\\\\\\\"])*$")
	@NotBlank(message = "Loc is required.")
	private String location;

	@JsonProperty("Pin")
	@Length(min = 100000, max = 999999, message = "Pin should be equal or greater than 100000 and less than or equal to 999999 digits")
	@Min(value = 100000, message = "Pin must be at least 100000")
    @Max(value = 999999, message = "Pin must be at most 999999")
	@NotNull(message = "Pin is required.")
	@NotBlank
	private Integer pin;

    /**
     * Go to below link for clear tax state codes
     * {@link https://cleartax.gitbook.io/cleartax-for-developers/e-invoicing-api/e-invoicing-api-reference/resources-and-master/state-master}
     */
    @JsonProperty("Stcd")
    @Length(min = 1, max = 2, message = "Stcd should be equal or greater than 1 and less than or equal to 2 characters")
	@NotBlank(message = "Stcd is required.")
    private StateCode stateCode;

}
