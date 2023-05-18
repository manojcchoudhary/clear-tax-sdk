package dev.manojc.cleartaxsdk.models.transaction.documentdetails;

import java.util.Arrays;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum DocumentType {
    @JsonProperty("Typ")
	INV("INV"), // INVOICE
	CRN("CRN"), // CREDIT NOTE
	DBN("DBN"); // DEBIT NOTE

	private String text;

	@JsonCreator
	@NotBlank
	@Length(max = 3, min = 3, message = "Typ in Invoice Document Type should be \"INV\", \"CRN\", \"DBN\"")
	private DocumentType(String text) {
		this.text = text;
	}

	@JsonValue
	public String getText() {
		return this.text;
	}

	public static Optional<DocumentType> fromText(String text) {
		return Arrays.stream(values()).filter(bl -> bl.text.equalsIgnoreCase(text)).findFirst();
	}

}
