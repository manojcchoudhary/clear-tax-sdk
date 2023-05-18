package dev.manojc.cleartaxsdk.models.transaction.documentdetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@Builder
public class DocumentDetails {

    @JsonProperty("Typ")
	@Length(max = 3, min = 3, message = "Typ in Invoice Document Type should be \"INV\", \"CRN\", \"DBN\"")
	@Builder.Default
	@NotBlank
	private DocumentType typ = DocumentType.INV;

	@JsonProperty("No")
	@Length(max = 16, min = 1, message = "Invoice number should greater than 1 and less than 16")
	@Pattern(regexp = "^([a-zA-Z1-9]{1}[a-zA-Z0-9\\/-]{0,15})$")
	@NotBlank(message = "No (invoice number) is required")
	private String number;

	@JsonProperty("Dt")
	@Length(max = 10, min = 10, message = "Invoice date should be DD/MM/YYYY")
	@Pattern(regexp = "^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$")
	@NotBlank
	private String date;
}
