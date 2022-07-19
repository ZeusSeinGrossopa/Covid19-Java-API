package de.zeus.covid19.api.country.data;

import com.google.gson.annotations.SerializedName;

public class HospitalizationResponse {

    @SerializedName("cases7Days")
    public String cases7Days;
    @SerializedName("incidence7Days")
    public String incidence7Days;
    @SerializedName("date")
    public String date;
    @SerializedName("lastUpdate")
    public String lastUpdate;
}