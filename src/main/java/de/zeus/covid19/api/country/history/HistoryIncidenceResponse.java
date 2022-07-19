package de.zeus.covid19.api.country.history;

import com.google.gson.annotations.SerializedName;

public class HistoryIncidenceResponse {

    @SerializedName("weekIncidence")
    public String weekIncidence;

    @SerializedName("date")
    public String date;

}