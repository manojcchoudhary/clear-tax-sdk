package dev.manojc.cleartaxsdk.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.manojc.cleartaxsdk.initializer.ClearTaxConfigurationInitializer;
import dev.manojc.cleartaxsdk.payload.downloadinvoice.ClearTaxDownloadInvoiceRequestPayload;
import dev.manojc.cleartaxsdk.payload.generateirn.ClearTaxTransactionRequestPayload;
import dev.manojc.cleartaxsdk.payload.generateirn.response.ClearTaxTransactionResponse;
import dev.manojc.cleartaxsdk.utils.ClearTaxRequestUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClearInvoiceApi {

	private ClearInvoiceApi() {
		log.debug("ClearInvoiceApi initialized");
	}

	private static final String GENERATE_IRN_URL = "/einv/v2/eInvoice/generate";
	private static final String DOWNLOAD_INVOICE = "/einv/v2/eInvoice/download";
	private static ClearTaxConfigurationInitializer configProvider = ClearTaxConfigurationInitializer.getInstance();
	
	public static <E> ResponseEntity<Collection<ClearTaxTransactionResponse<E>>> generateIrn(
			final Collection<ClearTaxTransactionRequestPayload<E>> payload) throws JsonProcessingException {
		final HttpHeaders headers = ClearTaxRequestUtils.getClearTaxHeaders();
		return generateIrnInternal(payload, headers);
	}
	
	public static <E> ResponseEntity<Collection<ClearTaxTransactionResponse<E>>> generateIrn(
			final Collection<ClearTaxTransactionRequestPayload<E>> payload, String gstin) throws JsonProcessingException {
		final HttpHeaders headers = ClearTaxRequestUtils.getClearTaxHeadersCustomGstin(gstin, configProvider.getOwnerId());
		return generateIrnInternal(payload, headers);
	}
	
	public static <E> ResponseEntity<Collection<ClearTaxTransactionResponse<E>>> generateIrn(
			final Collection<ClearTaxTransactionRequestPayload<E>> payload, String gstin, String ownerId) throws JsonProcessingException {
		final HttpHeaders headers = ClearTaxRequestUtils.getClearTaxHeadersCustomGstin(gstin, ownerId);
		return generateIrnInternal(payload, headers);
	}
	
	public static <E> ResponseEntity<Collection<ClearTaxTransactionResponse<E>>> generateIrn(
			final Collection<ClearTaxTransactionRequestPayload<E>> payload, String gstin, String ownerId, String authToken) throws JsonProcessingException {
		final HttpHeaders headers = ClearTaxRequestUtils.getClearTaxHeadersCustom(gstin, ownerId, authToken);
		return generateIrnInternal(payload, headers);
	}

	public static <E> ResponseEntity<Collection<ClearTaxTransactionResponse<E>>> generateIrnInternal(
			final Collection<ClearTaxTransactionRequestPayload<E>> payload, final HttpHeaders headers)
			throws JsonProcessingException {
		final String URL = ClearTaxRequestUtils.appendHost(GENERATE_IRN_URL);
		log.info("Clear Tax API - generate IRN initialized {}", URL);
		final RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		String requestJson = mapper.writeValueAsString(payload);
		final HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);		
		return restTemplate.exchange(URL, HttpMethod.PUT, entity,
				new ParameterizedTypeReference<Collection<ClearTaxTransactionResponse<E>>>() {
				});
	}

	public static Optional<ResponseEntity<byte[]>> downloadEInvoice(
			final ClearTaxDownloadInvoiceRequestPayload payload, String gstin) {
		final HttpHeaders headers = ClearTaxRequestUtils.getClearTaxHeadersCustomGstin(gstin, configProvider.getOwnerId());
		return downloadEInvoice(payload, headers);
	}
	
	public static Optional<ResponseEntity<byte[]>> downloadEInvoice(
			final ClearTaxDownloadInvoiceRequestPayload payload, String gstin, String ownerId) {
		final HttpHeaders headers = ClearTaxRequestUtils.getClearTaxHeadersCustomGstin(gstin, ownerId);
		return downloadEInvoice(payload, headers);
	}
	
	public static Optional<ResponseEntity<byte[]>> downloadEInvoice(
			final ClearTaxDownloadInvoiceRequestPayload payload, String gstin, String ownerId, String authToken) {
		final HttpHeaders headers = ClearTaxRequestUtils.getClearTaxHeadersCustom(gstin, ownerId, authToken);
		return downloadEInvoice(payload, headers);
	}
	
	public static Optional<ResponseEntity<byte[]>> downloadEInvoice(
			final ClearTaxDownloadInvoiceRequestPayload payload) {
		final HttpHeaders headers = ClearTaxRequestUtils.getClearTaxHeaders();	
		return downloadEInvoice(payload, headers);
	}

	private static Optional<ResponseEntity<byte[]>> downloadEInvoice(
			final ClearTaxDownloadInvoiceRequestPayload payload, final HttpHeaders headers) {
		final String URL = ClearTaxRequestUtils.appendHost(DOWNLOAD_INVOICE);
		log.info("Clear Tax API - e-invoice download initialized {}", URL);
		final RestTemplate restTemplate = new RestTemplate();		
		final HttpEntity<ClearTaxDownloadInvoiceRequestPayload> entity = new HttpEntity<>(payload, headers);
		return Optional.of(restTemplate.exchange(URL, HttpMethod.GET, entity, byte[].class));
	}
	
	
}
