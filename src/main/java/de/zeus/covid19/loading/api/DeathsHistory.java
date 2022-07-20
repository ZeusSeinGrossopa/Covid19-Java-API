package de.zeus.covid19.loading.api;

import de.zeus.covid19.api.country.history.cases.CasesResponse;
import de.zeus.covid19.api.country.history.deaths.DeathResponse;
import de.zeus.covid19.api.country.history.deaths.HistoryDeathResponse;
import de.zeus.covid19.loading.CountryData;
import de.zeus.covid19.loading.Covid19API;

import java.util.Arrays;
import java.util.List;

public class DeathsHistory {

    private final CountryData countryData;

    private DeathResponse data;

    public DeathsHistory(CountryData countryData) {
        this.countryData = countryData;

        this.refresh();
    }

    public void refresh() {
        this.countryData.getDataCollector().refreshDeathsHistory();

        this.data = this.countryData.getDataCollector().getDeathsHistory();
    }

    public HistoryDeathResponse getLatestDeaths() {
        return Covid19API.reverseArrayToList(this.data.deaths).get(0);
    }

    public HistoryDeathResponse getOldestDeaths() {
        return this.data.deaths[0];
    }

    public List<HistoryDeathResponse> getDeathsBefore(int days) {
        return Arrays.asList(this.data.deaths).subList(this.data.deaths.length - days, this.data.deaths.length);
    }

    public DeathResponse getCasesResponse() {
        return this.data;
    }

    public CountryData getCountryData() {
        return countryData;
    }
}