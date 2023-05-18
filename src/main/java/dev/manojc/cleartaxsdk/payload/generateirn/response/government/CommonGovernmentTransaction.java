package dev.manojc.cleartaxsdk.payload.generateirn.response.government;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
public abstract class CommonGovernmentTransaction {

    @JsonProperty("Success")
    @NotBlank
    @Length(max = 1, min = 1, message = "Success should be \"Y\" or \"N\"")
    private SuccessType successType;

}
