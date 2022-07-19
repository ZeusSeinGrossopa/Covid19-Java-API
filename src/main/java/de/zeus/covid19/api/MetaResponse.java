package de.zeus.covid19.api;

import com.google.gson.annotations.SerializedName;

public class MetaResponse {

    @SerializedName("source")
    public String source;
    @SerializedName("contact")
    public String contact;
    @SerializedName("info")
    public String info;
    @SerializedName("lastUpdate")
    public String lastUpdate;
    @SerializedName("lastCheckedForUpdate")
    public String lastCheckedForUpdate;
}