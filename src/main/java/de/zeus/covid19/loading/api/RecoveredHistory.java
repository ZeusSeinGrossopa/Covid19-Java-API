package de.zeus.covid19.loading.api;


import de.zeus.covid19.api.country.history.recovered.HistoryRecoveredResponse;
import de.zeus.covid19.api.country.history.recovered.RecoveredResponse;
import de.zeus.covid19.loading.CountryData;
import de.zeus.covid19.loading.Covid19API;

import java.util.Arrays;
import java.util.List;

public class RecoveredHistory {

    private final CountryData countryData;

    private RecoveredResponse data;

    public RecoveredHistory(CountryData countryData) {
        this.countryData = countryData;

        this.refresh();
    }

    public void refresh() {
        this.countryData.getDataCollector().refreshRecoveredHistory();

        this.data = this.countryData.getDataCollector().getRecoveredHistory();
    }

    public HistoryRecoveredResponse getLatestRecoveredData() {
        return Covid19API.reverseArrayToList(this.data.recovered).get(0);
    }

    public HistoryRecoveredResponse getOldestRecoveredData() {
        return this.data.recovered[0];
    }

    public List<HistoryRecoveredResponse> getRecoveredDataBefore(int days) {
        return Arrays.asList(this.data.recovered).subList(this.data.recovered.length - days, this.data.recovered.length);
    }

    public RecoveredResponse getRecoveredData() {
        return this.data;
    }

    public CountryData getCountryData() {
        return countryData;
    }
}