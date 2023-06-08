package dev.manojc.cleartaxsdk.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

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

	public static HttpHeaders getClearTaxHeaders() {
		final HttpHeaders headers = getClearTaxAuthHeader();
		headers.setContentType(MediaType.APPLICATION_JSON);
				
		if (configProvider.hasOwnerId())
			headers.set(OWNER_ID, configProvider.getOwnerId());
		if (configProvider.hasGstin())
			headers.set(GSTIN_HEADER, configProvider.getGstin());
		return headers;
	}

	public static String appendHost(final String url) {
		return new StringBuilder(configProvider.getHost()).append(url).toString();
	}

}
