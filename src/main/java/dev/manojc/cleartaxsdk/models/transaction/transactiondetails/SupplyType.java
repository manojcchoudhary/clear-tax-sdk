package dev.manojc.cleartaxsdk.models.transaction.transactiondetails;

import java.util.Arrays;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum SupplyType {
    @JsonProperty("SupTyp")
	B2B("B2B"), //Business to Business
	SEZWP("SEZWP"), //SEZ with payment
	SEZWOP("SEZWOP"), // SEZ without payment
	EXPWP("EXPWP"), // Export with Payment
	EXPWOP("EXPWOP"), // Export without payment
	DEXP("DEXP"); // Deemed Export

	private String text;

	@JsonCreator
	@Length(max = 10, min = 3, message = "SupTyp should be \"B2B\", \"SEZWP\", \"SEZWOP\", \"EXPWP\", \"EXPWOP\", \"DEXP\"")
	@NotBlank
	private SupplyType(String text) {
		this.text = text;
	}

	@JsonValue
	public String getText() {
		return this.text;
	}

	public static Optional<SupplyType> fromText(String text) {
		return Arrays.stream(values()).filter(bl -> bl.text.equalsIgnoreCase(text)).findFirst();
	}
}
