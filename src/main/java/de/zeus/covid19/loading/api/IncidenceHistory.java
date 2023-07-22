package de.zeus.covid19.loading.api;

import de.zeus.covid19.api.country.history.incidence.HistoryIncidenceResponse;
import de.zeus.covid19.api.country.history.incidence.IncidenceResponse;
import de.zeus.covid19.loading.CountryData;
import de.zeus.covid19.loading.Covid19API;

import java.util.Arrays;
import java.util.List;

/**
 * API class for storing data
 *
 * @author ZeusSeinGrossopa
 * @version 1.0
 */
public class IncidenceHistory {

    private final CountryData countryData;

    private IncidenceResponse data;

    public IncidenceHistory(CountryData countryData) {
        this.countryData = countryData;

        this.refresh();
    }

    /**
     * Refresh the stored data
     */
    public void refresh() {
        this.countryData.getDataCollector().refreshDeathsHistory();
        this.data = this.countryData.getDataCollector().getIncidenceHistory();
    }

    /**
     * @return getting the latest incidence information
     */
    public HistoryIncidenceResponse getLatestIncidence() {
        return Covid19API.reverseArrayToList(this.data.incidences).get(0);
    }

    /**
     * @return getting the oldest incidence information
     */
    public HistoryIncidenceResponse getOldestIncidence() {
        return this.data.incidences[0];
    }

    /**
     * Getting the incidences in a specific date range
     *
     * @param days the range number of days to get the incidences for
     * @return the incidences in the specific date range
     */
    public List<HistoryIncidenceResponse> getIncidencesBefore(int days) {
        return Arrays.asList(this.data.incidences).subList(this.data.incidences.length - days, this.data.incidences.length);
    }

    /**
     * Returning the raw data collector
     *
     * @return the incidence response
     */
    public IncidenceResponse getIncidencesData() {
        return this.data;
    }

    /**
     * @return the country data
     * @see CountryData
     */
    public CountryData getCountryData() {
        return countryData;
    }
}