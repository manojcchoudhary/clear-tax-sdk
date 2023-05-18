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
public enum IgstOnIntra {
    @JsonProperty("IgstOnIntra")
	Y("Y"),
	N("N");

	private String text;

	@JsonCreator
	@Length(min = 1, max = 1, message = "RegRev should be \"Y\", \"N\"")
	@NotBlank
	private IgstOnIntra(String text) {
		this.text = text;
	}

	@JsonValue
	public String getText() {
		return this.text;
	}

	public static Optional<IgstOnIntra> fromText(String text) {
		return Arrays.stream(values()).filter(bl -> bl.text.equalsIgnoreCase(text)).findFirst();
	}

}
