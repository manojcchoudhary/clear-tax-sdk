package dev.manojc.cleartaxsdk.models.transaction.sellerdetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import dev.manojc.cleartaxsdk.models.transaction.addressdetails.AddressDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Getter
@NoArgsConstructor
public class SellerDetails extends AddressDetails {

}
