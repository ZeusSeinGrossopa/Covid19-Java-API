package de.zeus.covid19.api.country.agegroups;

import com.google.gson.annotations.SerializedName;
import de.zeus.covid19.api.MetaResponse;

public class AgeGroupsDataResponse {

    @SerializedName("data")
    public AgeGroupsTypesResponse data;

    @SerializedName("meta")
    public MetaResponse meta;
}