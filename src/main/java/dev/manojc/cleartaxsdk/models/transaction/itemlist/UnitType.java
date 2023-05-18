package dev.manojc.cleartaxsdk.models.transaction.itemlist;

import java.util.Arrays;
import java.util.Optional;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum UnitType {

    @JsonProperty("Unit")
    BAG("BAG"), // BAGS
    BAL("BAL"), // BALE
    BDL("BDL"), // BUNDLES
    BKL("BKL"), // BUCKLES
    BOU("BOU"), // BILLION OF UNITS
    BOX("BOX"), // BOX
    BTL("BTL"), // BOTTLES
    BUN("BUN"), // BUNCHES
    CAN("CAN"), // CANS
    CCM("CCM"), // CUBIC CENTIMETERS
    CMS("CMS"), // CENTIMETERS
    CBM("CBM"), // CUBIC METERS
    CTN("CTN"), // CARTONS
    DOZ("DOZ"), // DOZENS
    DRM("DRM"), // DRUMS
    GGK("GGK"), // GREAT GROSS
    GMS("GMS"), // GRAMMES
    GRS("GRS"), // GROSS
    GYD("GYD"), // GROSS YARDS
    KGS("KGS"), // KILOGRAMS
    KLR("KLR"), // KILOLITRE
    KME("KME"), // KILOMETRE
    LTR("LTR"), // LITRES
    MLS("MLS"), // MILLI LITRES
    MLT("MLT"), // MILILITRE
    MTR("MTR"), // METERS
    MTS("MTS"), // METRIC TON
    NOS("NOS"), // NUMBERS
    OTH("OTH"), // OTHERS
    PAC("PAC"), // PACKS
    PCS("PCS"), // PIECES
    PRS("PRS"), // PAIRS
    QTL("QTL"), // QUINTAL
    ROL("ROL"), // ROLLS
    SET("SET"), // SETS
    SQF("SQF"); // SQUARE FEET

    private String text;

    @JsonCreator
    @Length(max = 8, min = 3, message = "Unit in itemList should be any of https://docs.cleartax.in/cleartax-docs/e-invoicing-api/e-invoicing-api-reference/resources-and-master/unit-master")
    private UnitType(String text) {
        this.text = text;
    }

    @JsonValue
    public String getText() {
        return this.text;
    }

    public static Optional<UnitType> fromText(String text) {
        return Arrays.stream(values()).filter(bl -> bl.text.equalsIgnoreCase(text)).findFirst();
    }
}
