package dev.manojc.cleartaxsdk.utils;

import java.util.Objects;

import dev.manojc.cleartaxsdk.models.transaction.buyerdetails.BuyerDetails;
import dev.manojc.cleartaxsdk.models.transaction.sellerdetails.SellerDetails;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClearTaxAddressUtils {

	private ClearTaxAddressUtils() {
		log.debug("ClearTaxAddressUtils initialized");
	}

	public static boolean isInterstate(BuyerDetails buyerDetails, SellerDetails sellerDetails) {
		return !Objects.equals(sellerDetails.getStateCode(), buyerDetails.getStateCode());
	}
	
}
