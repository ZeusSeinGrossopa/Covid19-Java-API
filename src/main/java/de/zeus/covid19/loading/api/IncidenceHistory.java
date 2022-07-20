package de.zeus.covid19.loading.api;

import de.zeus.covid19.api.country.history.cases.CasesResponse;
import de.zeus.covid19.api.country.history.cases.HistoryCasesResponse;
import de.zeus.covid19.api.country.history.incidence.HistoryIncidenceResponse;
import de.zeus.covid19.api.country.history.incidence.IncidenceResponse;
import de.zeus.covid19.loading.CountryData;
import de.zeus.covid19.loading.Covid19API;

import java.util.Arrays;
import java.util.List;

public class IncidenceHistory {

    private final CountryData countryData;

    private IncidenceResponse data;

    public IncidenceHistory(CountryData countryData) {
        this.countryData = countryData;

        this.refresh();
    }

    public void refresh() {
        this.countryData.getDataCollector().refreshDeathsHistory();

        this.data = this.countryData.getDataCollector().getIncidenceHistory();
    }

    public HistoryIncidenceResponse getLatestIncidence() {
        return Covid19API.reverseArrayToList(this.data.incidences).get(0);
    }

    public HistoryIncidenceResponse getOldestIncidence() {
        return this.data.incidences[0];
    }

    public List<HistoryIncidenceResponse> getIncidencesBefore(int days) {
        return Arrays.asList(this.data.incidences).subList(this.data.incidences.length - days, this.data.incidences.length);
    }

    public IncidenceResponse getIncidencesData() {
        return this.data;
    }

    public CountryData getCountryData() {
        return countryData;
    }
}