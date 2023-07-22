package de.zeus.covid19.api.country.history.deaths;

import com.google.gson.annotations.SerializedName;

public class HistoryDeathResponse {

    @SerializedName("deaths")
    public String deaths;

    @SerializedName("date")
    public String date;
}