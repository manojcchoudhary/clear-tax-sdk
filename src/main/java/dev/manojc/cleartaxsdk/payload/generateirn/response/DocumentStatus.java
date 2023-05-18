package dev.manojc.cleartaxsdk.payload.generateirn.response;

import java.util.Arrays;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum DocumentStatus {
    @JsonProperty("document_status")
	IRN_GENERATED("IRN_GENERATED"),
	NOT_CREATED("NOT_CREATED");

	private String text;

	@JsonCreator
	@Length(min = 11, max = 13, message = "document_status should be \"IRN_GENERATED\", \"NOT_CREATED\"")
    @NotBlank
	private DocumentStatus(String text) {
		this.text = text;
	}

	@JsonValue
	public String getText() {
		return this.text;
	}

	public static Optional<DocumentStatus> fromText(String text) {
		return Arrays.stream(values()).filter(bl -> bl.text.equalsIgnoreCase(text)).findFirst();
	}
}
