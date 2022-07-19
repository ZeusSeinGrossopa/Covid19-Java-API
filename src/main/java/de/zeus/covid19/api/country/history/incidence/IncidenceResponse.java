package de.zeus.covid19.api.country.history.incidence;

import com.google.gson.annotations.SerializedName;
import de.zeus.covid19.api.MetaResponse;

public class IncidenceResponse {

    @SerializedName("data")
    public HistoryIncidenceResponse[] incidences;

    @SerializedName("meta")
    public MetaResponse meta;
}