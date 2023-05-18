package dev.manojc.cleartaxsdk.payload.generateirn.response.government;

import java.util.Arrays;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum SuccessType {

    @JsonProperty("Success")
    Y("Y"), // Yes
    N("N"); // No

    private String text;

    @JsonCreator
    @NotBlank
    @Length(max = 1, min = 1, message = "Success should be \"Y\" or \"N\"")
    private SuccessType(String text) {
        this.text = text;
    }

    @JsonValue
    public String getText() {
        return this.text;
    }

    public static Optional<SuccessType> fromText(String text) {
        return Arrays.stream(values()).filter(bl -> bl.text.equalsIgnoreCase(text)).findFirst();
    }
}
