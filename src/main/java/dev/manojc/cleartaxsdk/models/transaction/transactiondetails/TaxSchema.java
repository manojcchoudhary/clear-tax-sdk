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
public enum TaxSchema {

	@JsonProperty("TaxSch")
	GST("GST");

	private String text;

	@JsonCreator
	@Length(max = 10, min = 3, message = "TaxSch should be 'GST'")
	@NotBlank
	private TaxSchema(String text) {
		this.text = text;
	}

	@JsonValue
	public String getText() {
		return this.text;
	}

	public static Optional<TaxSchema> fromText(String text) {
		return Arrays.stream(values()).filter(bl -> bl.text.equalsIgnoreCase(text)).findFirst();
	}

}
