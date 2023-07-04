package dev.manojc.cleartaxsdk.models.transaction.itemlist;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AttributeDetails {

    /**
     * Optional. Attribute details of the item
     */
    @JsonProperty("Nm")
    @Length(min = 1, max = 100, message = "Nm should be at least 1 and at most 100 characters")
    @Pattern(regexp = "^([^\\\"])*$", message = "Nm is invalid")
    @Nullable
    private String batchNumber;

    /**
     * Optional. Attribute details of the item
     */
    @JsonProperty("Val")
    @Length(min = 10, max = 10, message = "Val should be at least 10 and at most 10 characters")
    @Pattern(regexp = "^([^\\\"])*$", message = "Val is invalid")
    @Nullable
    private String expiryDate;

}
