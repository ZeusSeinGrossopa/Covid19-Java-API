package de.zeus.covid19.api.country.data;

import com.google.gson.annotations.SerializedName;

public class DeltaResponse {

    @SerializedName("cases")
    public String cases;

    @SerializedName("deaths")
    public String deaths;

    @SerializedName("recovered")
    public String recovered;
}