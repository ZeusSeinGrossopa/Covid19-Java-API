package de.zeus.covid19.api.country.history.deaths;

import com.google.gson.annotations.SerializedName;
import de.zeus.covid19.api.MetaResponse;
import de.zeus.covid19.api.country.history.cases.CasesResponse;

public class DeathResponse {

    @SerializedName("data")
    public CasesResponse[] deaths;

    @SerializedName("meta")
    public MetaResponse meta;
}