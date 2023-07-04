package dev.manojc.cleartaxsdk.models.transaction.dispatchdetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.manojc.cleartaxsdk.models.transaction.addressdetails.PartialAddressDetails;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DispatchDetails extends PartialAddressDetails {

	@JsonProperty("Nm")
	@Length(max = 100, min = 3, message = "Nm should be greater than 3 and lesser than 100")
	@Pattern(regexp = "^([^\\\\\\\"])*$")
	@NotBlank(message = "Nm (name of company from which goods are dispatched) is required")
	private String name;
}
