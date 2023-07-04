package dev.manojc.cleartaxsdk.models.transaction.ewaydetails;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EwayBillDetails {

    @JsonProperty("TransId")
    @Length(min = 15, max = 15, message = "TransId (Transin/GSTIN) should be at least 15 and at most 15 characters")
    @Nullable
    @Pattern(regexp = "^([0-9]{2}[0-9A-Z]{13})$", message = "TransId should be of pattern ^([0-9]{2}[0-9A-Z]{13})$")
    private String shippingBillNumber;

    @JsonProperty("TransName")
    @Length(min = 3, max = 100, message = "TransName (Name of the transporter) should be at least 3 and at most 100 characters")
    @Nullable
    @Pattern(regexp = "^([^\\\"])*$", message = "TransName should be of pattern ^([^\\\"])*$")
    private String transportName;

    @JsonProperty("TransMode")
    @Length(min = 1, max = 1, message = "TransMode (Mode of transport (Road-1, Rail-2, Air-3, Ship-4)) should be at least 1 and at most 1 characters")
    @Nullable
    private TransportMode transportMode;

    /**
     * Distance between source and destination PIN codes.If the value is "0" then the distance will be auto-computed by NIC based on the availability of pin-codes in NIC database.
     */
    @JsonProperty("Distance")
    @Min(value = 1, message = "Distance should be at least 1 and at most 1 characters. Distance between source and destination PIN codes.If the value is \"0\" then the distance will be auto-computed by NIC based on the availability of pin-codes in NIC database")
    @Max(value = 4000, message = "Distance should be at least 1 and at most 1 characters. Distance between source and destination PIN codes.If the value is \"0\" then the distance will be auto-computed by NIC based on the availability of pin-codes in NIC database")
    @NotBlank
    private Integer distance;

    @JsonProperty("TransDocNo")
    @Length(min = 1, max = 15, message = "TransDocNo (Transport Document Number) should be at least 1 and at most 15 characters")
    @Nullable
    @Pattern(regexp = "^([a-zA-Z0-9\\/-]{1,15})$", message = "TransDocNo (Transport Document Number) should be of pattern ^([0-9]{2}[0-9A-Z]{13})$")
    private String transportDocumentNumber;

    @JsonProperty("TransDocDt")
    @Length(min = 10, max = 10, message = "TransDocDt (Transport Document Date.) should be at least 10 and at most 10 characters")
    @Nullable
    @Pattern(regexp = "^[0-3][0-9]\\/[0-1][0-9]\\/[2][0][1-2][0-9]$")
    private String transportDocumentDate;

    @JsonProperty("VehNo")
    @Length(min = 4, max = 20, message = "VehNo (Vehicle Number) should be at least 4 and at most 20 characters")
    @Nullable
    @Pattern(regexp = "^([A-Z|a-z|0-9]{4,20})$")
    private String vehicleNumber;

    @JsonProperty("VehType")
    @Length(min = 1, max = 1, message = "VehType should be 'O' for ODC or 'R' for Regular")
    @Nullable
    private VehicleType vehicleType;

}
