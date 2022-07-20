package de.zeus.covid19.api.country.agegroups;

import com.google.gson.annotations.SerializedName;

public class AgeGroupDataResponse {

    @SerializedName("casesMale")
    public String casesMale;

    @SerializedName("casesFemale")
    public String casesFemale;

    @SerializedName("deathsMale")
    public String deathsMale;

    @SerializedName("deathsFemale")
    public String deathsFemale;

    @SerializedName("casesMalePer100k")
    public String casesMalePer100k;

    @SerializedName("casesFemalePer100k")
    public String casesFemalePer100k;

    @SerializedName("deathsMalePer100k")
    public String deathsMalePer100k;

    @SerializedName("deathsFemalePer100k")
    public String deathsFemalePer100k;

    @SerializedName("hospitalization")
    public AgeGroupHospitalization hospitalization;
}