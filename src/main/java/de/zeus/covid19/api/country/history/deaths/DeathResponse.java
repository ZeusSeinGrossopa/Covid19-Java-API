package de.zeus.covid19.api.country.history.deaths;

import com.google.gson.annotations.SerializedName;
import de.zeus.covid19.api.MetaResponse;

public class DeathResponse {

    @SerializedName("data")
    public HistoryDeathResponse[] deaths;

    @SerializedName("meta")
    public MetaResponse meta;
}