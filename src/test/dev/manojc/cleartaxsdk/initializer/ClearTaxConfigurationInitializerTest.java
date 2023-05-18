package dev.manojc.cleartaxsdk.initializer;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Field;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClearTaxConfigurationInitializerTest {

	@Test
	public void testInitializeAndGetters() {
		// Arrange
		ClearTaxConfiguration config = ClearTaxConfiguration.builder().authToken("myAuthToken").gstin("myGstin")
				.host("http://localhost").ownerId("myOwnerId").build();
		ClearTaxConfigurationInitializer instance = ClearTaxConfigurationInitializer.getInstance();

		// Act
		instance.initialize(config);

		// Assert
		assertEquals("myAuthToken", instance.getAuthToken());
		assertEquals("http://localhost", instance.getHost());
		assertEquals("myOwnerId", instance.getOwnerId());
		assertEquals("myGstin", instance.getGstin());
	}

	@Test
	public void testGetInstanceReturnsSameInstance() {
		// Arrange
		ClearTaxConfigurationInitializer instance1 = ClearTaxConfigurationInitializer.getInstance();
		ClearTaxConfigurationInitializer instance2 = ClearTaxConfigurationInitializer.getInstance();

		// Assert
		assertSame(instance1, instance2);
	}

	@Test
	public void testGetInstanceReturnsNonNull() {
		// Arrange
		ClearTaxConfigurationInitializer instance = ClearTaxConfigurationInitializer.getInstance();

		// Assert
		assertNotNull(instance);
	}

	@Test
	public void testInitializeTwiceOnlyUsesFirstConfig() {
		// Arrange
		ClearTaxConfiguration config1 = ClearTaxConfiguration.builder().authToken("myAuthToken1").gstin("myGstin1")
				.host("http://localhost").ownerId("myOwnerId1").build();
		ClearTaxConfiguration config2 = ClearTaxConfiguration.builder().authToken("myAuthToken2").gstin("myGstin2")
				.host("http://localhost").ownerId("myOwnerId2").build();
		ClearTaxConfigurationInitializer instance = ClearTaxConfigurationInitializer.getInstance();

		// Act
		instance.initialize(config1);
		instance.initialize(config2);

		// Assert
		assertEquals("myAuthToken1", instance.getAuthToken());
		assertEquals("myGstin1", instance.getGstin());
		assertEquals("myOwnerId1", instance.getOwnerId());
		assertEquals("http://localhost", instance.getHost());
	}

	@BeforeEach
	@AfterEach
	public void resetInstance() throws Exception {
		// Reset the static instance of the ClearTaxConfigurationInitializer class
		Field instance = ClearTaxConfigurationInitializer.class.getDeclaredField("instance");
		instance.setAccessible(true);
		instance.set(null, null);
	}

}
