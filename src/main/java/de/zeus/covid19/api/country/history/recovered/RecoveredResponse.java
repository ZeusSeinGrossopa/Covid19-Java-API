package de.zeus.covid19.api.country.history.recovered;

import com.google.gson.annotations.SerializedName;
import de.zeus.covid19.api.MetaResponse;

public class RecoveredResponse {

    @SerializedName("data")
    public HistoryRecoveredResponse[] recovered;

    @SerializedName("meta")
    public MetaResponse meta;
}