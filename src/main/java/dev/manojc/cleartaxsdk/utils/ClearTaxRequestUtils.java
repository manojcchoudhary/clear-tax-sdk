package dev.manojc.cleartaxsdk.utils;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import dev.manojc.cleartaxsdk.initializer.ClearTaxConfigurationInitializer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClearTaxRequestUtils {

	private ClearTaxRequestUtils() {
		log.debug("ClearTaxRequestUtils initialized");
	}

	private static final String GSTIN_HEADER = "gstin";

	private static final String OWNER_ID = "owner_id";	

	private static final String X_CLEARTAX_PRODUCT = "x-cleartax-product";

	private static final String X_CLEARTAX_AUTH_TOKEN = "x-cleartax-auth-token";

	private static ClearTaxConfigurationInitializer configProvider = ClearTaxConfigurationInitializer.getInstance();

	public static HttpHeaders getClearTaxAuthHeader() {
		final HttpHeaders headers = new HttpHeaders();
		if (configProvider.hasAuthToken())
			headers.set(X_CLEARTAX_AUTH_TOKEN, configProvider.getAuthToken());
		return headers;
	}
	
	public static HttpHeaders getClearTaxAuthHeader(String authToken) {
		final HttpHeaders headers = new HttpHeaders();
		if (StringUtils.hasText(authToken))
			headers.set(X_CLEARTAX_AUTH_TOKEN, authToken);
		return headers;
	}

	public static HttpHeaders getClearTaxHeaders() {
		final HttpHeaders headers = getClearTaxAuthHeader();
		headers.setContentType(MediaType.APPLICATION_JSON);
				
		if (configProvider.hasOwnerId())
			headers.set(OWNER_ID, configProvider.getOwnerId());
		if (configProvider.hasGstin())
			headers.set(GSTIN_HEADER, configProvider.getGstin());
		return headers;
	}
	
	public static HttpHeaders getClearTaxHeadersCustomGstin(String gstin, String ownerId) {
		final HttpHeaders headers = getClearTaxAuthHeader();
		headers.setContentType(MediaType.APPLICATION_JSON);				
		if (StringUtils.hasText(ownerId))
			headers.set(OWNER_ID, configProvider.getOwnerId());
		if (StringUtils.hasText(gstin))
			headers.set(GSTIN_HEADER, gstin);
		return headers;
	}
	
	public static void setClearTaxHeader(final HttpHeaders headers) {
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_PDF));
	}
	
	public static HttpHeaders getClearTaxHeadersCustom(String gstin, String ownerId, String authToken) {
		final HttpHeaders headers = getClearTaxAuthHeader(authToken);
		headers.setContentType(MediaType.APPLICATION_JSON);				
		if (StringUtils.hasText(ownerId))
			headers.set(OWNER_ID, configProvider.getOwnerId());
		if (StringUtils.hasText(gstin))
			headers.set(GSTIN_HEADER, gstin);
		return headers;
	}

	public static String appendHost(final String url) {
		return new StringBuilder(configProvider.getHost()).append(url).toString();
	}

}
