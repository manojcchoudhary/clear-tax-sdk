package dev.manojc.cleartaxsdk.models.transaction.itemlist;

import java.util.Arrays;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum ServiceType {

    @JsonProperty("IsServc")
	Y("Y"), // Yes
	N("N"); // No

	private String text;

	@JsonCreator
	@NotBlank
	@Length(max = 1, min = 1, message = "IsServc in itemList should be \"Y\" or \"N\"")
	private ServiceType(String text) {
		this.text = text;
	}

	@JsonValue
	public String getText() {
		return this.text;
	}

	public static Optional<ServiceType> fromText(String text) {
		return Arrays.stream(values()).filter(bl -> bl.text.equalsIgnoreCase(text)).findFirst();
	}
}
