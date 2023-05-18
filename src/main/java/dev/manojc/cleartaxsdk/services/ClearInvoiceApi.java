package dev.manojc.cleartaxsdk.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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

	public static <E> ResponseEntity<ClearTaxTransactionResponse<E>> generateIrn(
			final Collection<ClearTaxTransactionRequestPayload<E>> payload) {
		final String URL = ClearTaxRequestUtils.appendHost(GENERATE_IRN_URL);
		log.info("Clear Tax API - generate IRN initialized {}", URL);
		final RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = ClearTaxRequestUtils.getClearTaxHeaders();
		final HttpEntity<Collection<ClearTaxTransactionRequestPayload<E>>> entity = new HttpEntity<>(payload, headers);
		try {
			return restTemplate.exchange(URL, HttpMethod.PUT, entity,
					new ParameterizedTypeReference<ClearTaxTransactionResponse<E>>() {
					});
		} catch (Exception e) {
			log.error("Something went wrong", e);
		}
		return null;
	}

	public static Optional<ResponseEntity<byte[]>> downloadEInvoice(
			final ClearTaxDownloadInvoiceRequestPayload payload) {
		final String URL = ClearTaxRequestUtils.appendHost(DOWNLOAD_INVOICE);
		log.info("Clear Tax API - e-invoice download initialized {}", URL);
		final RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = ClearTaxRequestUtils.getClearTaxHeaders();
		final HttpEntity<ClearTaxDownloadInvoiceRequestPayload> entity = new HttpEntity<>(payload, headers);
		return Optional.of(restTemplate.exchange(URL, HttpMethod.GET, entity, byte[].class));
	}
}
