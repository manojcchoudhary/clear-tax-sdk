package dev.manojc.cleartaxsdk.models.transaction.additionaldetails;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@Builder
public class AdditionalDetails {

    @JsonProperty("Url")
    @Length(min = 3, max = 100, message = "Url (Supporting document URL) should be at least 3 and at most 100 characters")
    @Pattern(regexp = "^([^\\\"])*$")
    @Nullable
    private String url;

    @JsonProperty("Docs")
    @Length(min = 3, max = 1000, message = "Docs (Supporting document in Base64 format) should be at least 3 and at most 1000 characters")
    @Pattern(regexp = "^([^\\\"])*$")
    @Nullable
    private String docs;

    @JsonProperty("Info")
    @Length(min = 3, max = 1000, message = "Info (Any additional information) should be at least 3 and at most 1000 characters")
    @Pattern(regexp = "^([^\\\"])*$")
    @Nullable
    private String info;
}
