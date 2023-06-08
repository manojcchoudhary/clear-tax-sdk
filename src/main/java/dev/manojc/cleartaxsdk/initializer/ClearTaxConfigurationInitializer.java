package dev.manojc.cleartaxsdk.initializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClearTaxConfigurationInitializer {

	private static ClearTaxConfigurationInitializer instance;

	private static final String SETTING_USER_DEFINED_CLEAR_TAX_CONFIGURATION = "Setting user defined ClearTaxConfiguration";

	private ClearTaxConfiguration config;

	private int isInitialLoaded = 0;

	public static synchronized ClearTaxConfigurationInitializer getInstance() {
		if (null == instance) {
			instance = new ClearTaxConfigurationInitializer();
		}
		return instance;
	}

	public void initialize(final ClearTaxConfiguration config) {
		if (this.isInitialLoaded == 1) {
			log.debug("ClearTaxConfigurationInitializer already initialized");
			return;
		}
		this.isInitialLoaded += 1;
		log.info(SETTING_USER_DEFINED_CLEAR_TAX_CONFIGURATION);
		this.config = config;
	}

	public boolean hasHost() {
		return this.config.hasHost();
	}

	public boolean hasAuthToken() {
		return this.config.hasAuthToken();
	}

	public boolean hasOwnerId() {
		return this.config.hasOwnerId();
	}

	public boolean hasGstin() {
		return this.config.hasGstin();
	}

	public String getAuthToken() {
		return this.config.getAuthToken();
	}

	public String getHost() {
		return this.config.getHost();
	}

	public String getOwnerId() {
		return this.config.getOwnerId();
	}

	public String getGstin() {
		return this.config.getGstin();
	}

}
