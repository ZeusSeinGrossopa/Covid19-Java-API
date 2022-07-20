package de.zeus.covid19.loading.api;

import de.zeus.covid19.api.country.history.cases.CasesResponse;
import de.zeus.covid19.api.country.history.cases.HistoryCasesResponse;
import de.zeus.covid19.loading.CountryData;
import de.zeus.covid19.loading.Covid19API;

import java.util.Arrays;
import java.util.List;

public class CasesHistory {

    private final CountryData countryData;

    private HistoryCasesResponse data;

    public CasesHistory(CountryData countryData) {
        this.countryData = countryData;

        this.refresh();
    }

    public void refresh() {
        this.countryData.getDataCollector().refreshCaseHistory();

        this.data = this.countryData.getDataCollector().getCasesHistory();
    }

    public CasesResponse getLatestCases() {
        return Covid19API.reverseArrayToList(this.data.cases).get(0);
    }

    public CasesResponse getOldestCases() {
        return this.data.cases[0];
    }

    public List<CasesResponse> getCasesBefore(int days) {
        return Arrays.asList(this.data.cases).subList(this.data.cases.length - days, this.data.cases.length);
    }

    public HistoryCasesResponse getCasesResponse() {
        return this.data;
    }

    public CountryData getCountryData() {
        return countryData;
    }
}