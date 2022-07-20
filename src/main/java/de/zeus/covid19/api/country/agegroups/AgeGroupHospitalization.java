package de.zeus.covid19.api.country.agegroups;

import com.google.gson.annotations.SerializedName;

public class AgeGroupHospitalization {

    @SerializedName("cases7Days")
    public String cases7Days;

    @SerializedName("incidence7Days")
    public String incidence7Days;

    @SerializedName("date")
    public String date;

}