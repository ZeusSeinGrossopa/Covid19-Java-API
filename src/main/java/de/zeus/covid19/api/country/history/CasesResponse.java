package de.zeus.covid19.api.country.history;

import com.google.gson.annotations.SerializedName;

public class CasesResponse {
    @SerializedName("cases")
    public String cases;
    @SerializedName("date")
    public String date;
}