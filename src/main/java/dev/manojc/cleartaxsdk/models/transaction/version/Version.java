package dev.manojc.cleartaxsdk.models.transaction.version;

import java.util.Arrays;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Version {


	@JsonProperty("Version")
	VERSION_1_1("1.1");

	private String text;

	@JsonCreator
	@NotBlank
	private Version(String text) {
		this.text = text;
	}

	@JsonValue
	public String getText() {
		return this.text;
	}

	public static Optional<Version> fromText(String text) {
		return Arrays.stream(values()).filter(bl -> bl.text.equalsIgnoreCase(text)).findFirst();
	}

}
