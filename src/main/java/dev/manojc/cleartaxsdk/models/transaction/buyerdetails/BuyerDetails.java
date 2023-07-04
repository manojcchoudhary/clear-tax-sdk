package dev.manojc.cleartaxsdk.models.transaction.buyerdetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.manojc.cleartaxsdk.models.transaction.addressdetails.AddressDetails;
import dev.manojc.cleartaxsdk.models.transaction.addressdetails.StateCode;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BuyerDetails extends AddressDetails {

    /**
     * State code of Place of supply. If POS lies outside the country then POS should be 96
     * {@link https://cleartax.gitbook.io/cleartax-for-developers/e-invoicing-api/e-invoicing-api-reference/resources-and-master/state-master}
     */
    @JsonProperty("Pos")
    @Length(min = 1, max = 2, message = "Pos (place of supply) should be equal or greater than 1 and less than or equal to 2 digits")
    @NotBlank(message = "Pos (place of supply) is required")
    @Pattern(regexp = "^(?!0+$)([0-9]{1,2})$")
    private StateCode placeOfSupply;

}
