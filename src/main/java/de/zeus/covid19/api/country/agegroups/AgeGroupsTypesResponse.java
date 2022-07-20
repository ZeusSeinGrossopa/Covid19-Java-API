package de.zeus.covid19.api.country.agegroups;

import com.google.gson.annotations.SerializedName;

public class AgeGroupsTypesResponse {

    @SerializedName("A00-A04")
    public AgeGroupDataResponse A00A04;

    @SerializedName("A05-A14")
    public AgeGroupDataResponse A05A14;

    @SerializedName("A15-A34")
    public AgeGroupDataResponse A15A34;

    @SerializedName("A35-A59")
    public AgeGroupDataResponse A35A59;

    @SerializedName("A60-A79")
    public AgeGroupDataResponse A60A79;

    @SerializedName("A80+")
    public AgeGroupDataResponse A80Plus;
}