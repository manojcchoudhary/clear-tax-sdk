package dev.manojc.cleartaxsdk.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;

import dev.manojc.cleartaxsdk.initializer.ClearTaxConfiguration;
import dev.manojc.cleartaxsdk.initializer.ClearTaxConfigurationInitializer;

class ClearTaxRequestUtilsTest {

	private ClearTaxConfigurationInitializer configurationProvider = ClearTaxConfigurationInitializer.getInstance();
	private String host = "https://your-cleartax-endpoint.com";
	private String authToken = "your-auth-token";
	private String ownerId = "your-owner-id";
	private String gstin = "your-gstin";

	@BeforeEach
	void setUp() {
		configurationProvider.initialize(
				ClearTaxConfiguration.builder().host(host).authToken(authToken).ownerId(ownerId).gstin(gstin).build());
	}

	@Test
	public void testGetClearTaxAuthHeader() {
		HttpHeaders headers = ClearTaxRequestUtils.getClearTaxAuthHeader();
		assertNotNull(headers);
		assertTrue(headers.containsKey("x-cleartax-auth-token"));
		// Replace the expected token with your own authentication token
		assertEquals("your-auth-token", headers.getFirst("x-cleartax-auth-token"));
	}

	@Test
	public void testGetClearTaxHeaders() {
		HttpHeaders headers = ClearTaxRequestUtils.getClearTaxHeaders();
		assertNotNull(headers);
		assertTrue(headers.containsKey("x-cleartax-auth-token"));
		assertTrue(headers.containsKey("x-cleartax-product"));
		assertTrue(headers.containsKey("gstin"));
		assertTrue(headers.containsKey("owner_id"));
		// Replace the expected values with your own configuration values
		assertEquals("your-auth-token", headers.getFirst("x-cleartax-auth-token"));
		assertEquals("EInvoice", headers.getFirst("x-cleartax-product"));
		assertEquals("your-gstin", headers.getFirst("gstin"));
		assertEquals("your-owner-id", headers.getFirst("owner_id"));
	}

	@Test
	public void testAppendHost() {
		String url = "/invoices";
		String fullUrl = ClearTaxRequestUtils.appendHost(url);
		assertNotNull(fullUrl);
		assertTrue(fullUrl.startsWith("https://"));
		assertTrue(fullUrl.endsWith(url));
		// Replace the expected value with your own ClearTax API endpoint URL
		assertEquals("https://your-cleartax-endpoint.com", fullUrl.substring(0, fullUrl.length() - url.length()));
	}

}
