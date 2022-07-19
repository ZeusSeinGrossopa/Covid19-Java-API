package de.zeus.covid19.api.country.history.recovered;

import com.google.gson.annotations.SerializedName;

public class HistoryRecoveredResponse {

    @SerializedName("recovered")
    public String recovered;

    @SerializedName("date")
    public String date;

}