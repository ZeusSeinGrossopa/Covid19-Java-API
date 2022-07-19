package de.zeus.covid19.api.country.history;

import com.google.gson.annotations.SerializedName;
import de.zeus.covid19.api.MetaResponse;

public class CountryHistoryCasesResponse {

    @SerializedName("data")
    public CasesResponse[] cases;

    @SerializedName("meta")
    public MetaResponse meta;
}