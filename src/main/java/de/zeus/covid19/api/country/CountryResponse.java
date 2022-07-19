package de.zeus.covid19.api.country;

import com.google.gson.annotations.SerializedName;
import de.zeus.covid19.api.MetaResponse;
import de.zeus.covid19.api.country.data.DeltaResponse;
import de.zeus.covid19.api.country.data.HospitalizationResponse;
import de.zeus.covid19.api.country.data.RValueResponse;

public class CountryResponse {

    @SerializedName("cases")
    public String cases;
    @SerializedName("deaths")
    public String deaths;
    @SerializedName("recovered")
    public String recovered;
    @SerializedName("weekIncidence")
    public String weekIncidence;
    @SerializedName("casesPer100k")
    public String casesPer100k;
    @SerializedName("casesPerWeek")
    public String casesPerWeek;

    @SerializedName("deltaResponse")
    public DeltaResponse deltaResponse;

    @SerializedName("r")
    public RValueResponse rValue;

    @SerializedName("hospitalization")
    public HospitalizationResponse hospitalization;

    @SerializedName("meta")
    public MetaResponse metaResponse;
}