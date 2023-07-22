package de.zeus.covid19.api.country.data;

import com.google.gson.annotations.SerializedName;

public class RValueDaysResponse {

    @SerializedName("value")
    public String value;

    @SerializedName("date")
    public String date;
}