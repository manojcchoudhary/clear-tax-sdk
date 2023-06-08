package dev.manojc.cleartaxsdk.models.transaction.addressdetails;

import java.util.Arrays;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum StateCode {

	  JAMMU_AND_KASHMIR("1"), // JAMMU AND KASHMIR
	  HIMACHAL_PRADESH("2"), // HIMACHAL PRADESH
	  PUNJAB("3"), // PUNJAB
	  CHANDIGARH("4"), // CHANDIGARH
	  UTTARAKHAND("5"), // UTTARAKHAND
	  HARYANA("6"), // HARYANA
	  DELHI("7"), // DELHI
	  RAJASTHAN("8"), // RAJASTHAN
	  UTTAR_PRADESH("9"), // UTTAR PRADESH
	  BIHAR("10"), // BIHAR
	  SIKKIM("11"), // SIKKIM
	  ARUNACHAL_PRADESH("12"), // ARUNACHAL PRADESH
	  NAGALAND("13"), // NAGALAND
	  MANIPUR("14"), // MANIPUR
	  MIZORAM("15"), // MIZORAM
	  TRIPURA("16"), // TRIPURA
	  MEGHALAYA("17"), // MEGHALAYA
	  ASSAM("18"), // ASSAM
	  WEST_BENGAL("19"), // WEST BENGAL
	  JHARKHAND("20"), // JHARKHAND
	  ORISSA("21"), // ORISSA
	  CHHATTISGARH("22"), // CHHATTISGARH
	  MADHYA_PRADESH("23"), // MADHYA PRADESH
	  GUJARAT("24"), // GUJARAT
	  DAMAN_AND_DIU("25"), // DAMAN AND DIU
	  DADRA_AND_NAGAR_HAVELI("26"), // DADRA AND NAGAR HAVELI
	  MAHARASHTRA("27"), // MAHARASHTRA
	  KARNATAKA("29"), // KARNATAKA
	  GOA("30"), // GOA
	  LAKSHADWEEP("31"), // LAKSHADWEEP
	  KERALA("32"), // KERALA
	  TAMIL_NADU("33"), // TAMIL NADU
	  PUDUCHERRY("34"), // PUDUCHERRY
	  ANDAMAN_AND_NICOBAR("35"), // ANDAMAN AND NICOBAR
	  TELANGANA("36"), // TELANGANA
	  ANDHRA_PRADESH("37"), // ANDHRA PRADESH
	  Ladakh("38"), // Ladakh
	  OTHER_TERRITORY("97"), // OTHER TERRITORY
	  OTHER_COUNTRY("96"); // OTHER COUNTRY


		private String text;

		@JsonCreator
		@Length(max = 10, min = 3, message = "StateCode should be https://docs.cleartax.in/cleartax-docs/e-invoicing-api/e-invoicing-api-reference/resources-and-master/state-master")
		@NotBlank
		private StateCode(String text) {
			this.text = text;
		}

		@JsonValue
		public String getText() {
			return this.text;
		}

		public static Optional<StateCode> fromText(String text) {
			return Arrays.stream(values()).filter(bl -> bl.text.equalsIgnoreCase(text)).findFirst();
		}
}
