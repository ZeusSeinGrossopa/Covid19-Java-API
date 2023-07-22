package de.zeus.covid19.api.country.data;

import com.google.gson.annotations.SerializedName;

public class RValueResponse {

    @SerializedName("value")
    public String value;

    @SerializedName("rValue4Days")
    public RValueResponse rValue4DaysResponse;

    @SerializedName("rValue7Days")
    public RValueResponse rValue7DaysResponse;

    @SerializedName("lastUpdate")
    public String lastUpdate;
}