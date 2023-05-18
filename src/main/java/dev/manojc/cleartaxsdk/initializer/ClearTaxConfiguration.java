package dev.manojc.cleartaxsdk.initializer;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClearTaxConfiguration {

	@URL(message = "Clear Tax target host is required")
	private String host;

	@NotBlank(message = "Clear Tax auth token is required")
	private String authToken;

	@NotBlank(message = "Clear Tax owner id is required")
	private String ownerId;

	@NotBlank(message = "Clear Tax gstin is required ")
	private String gstin;

}
