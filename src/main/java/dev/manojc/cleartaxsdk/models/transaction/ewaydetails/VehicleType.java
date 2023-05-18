package dev.manojc.cleartaxsdk.models.transaction.ewaydetails;

import java.util.Arrays;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum VehicleType {
    @JsonProperty("VehType")
	ODC("O"), // ODC
	REGULAR("R"); // Regular

	private String text;

	@JsonCreator
	@Length(max = 1, min = 1, message = "VehType should be 'O' or 'R'")
	@NotBlank
	private VehicleType(String text) {
		this.text = text;
	}

	@JsonValue
	public String getText() {
		return this.text;
	}

	public static Optional<VehicleType> fromText(String text) {
		return Arrays.stream(values()).filter(bl -> bl.text.equalsIgnoreCase(text)).findFirst();
	}
}
