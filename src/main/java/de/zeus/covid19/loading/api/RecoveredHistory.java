package de.zeus.covid19.loading.api;


import de.zeus.covid19.api.country.history.recovered.HistoryRecoveredResponse;
import de.zeus.covid19.api.country.history.recovered.RecoveredResponse;
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
public class RecoveredHistory {

    private final CountryData countryData;

    private RecoveredResponse data;

    public RecoveredHistory(CountryData countryData) {
        this.countryData = countryData;

        this.refresh();
    }

    /**
     * Refresh the stored data
     */
    public void refresh() {
        this.countryData.getDataCollector().refreshRecoveredHistory();
        this.data = this.countryData.getDataCollector().getRecoveredHistory();
    }

    /**
     * @return getting the latest recovered information
     */
    public HistoryRecoveredResponse getLatestRecoveredData() {
        return Covid19API.reverseArrayToList(this.data.recovered).get(0);
    }

    /**
     * @return getting the oldest recovered information
     */
    public HistoryRecoveredResponse getOldestRecoveredData() {
        return this.data.recovered[0];
    }

    /**
     * Getting the recovered in a specific date range
     *
     * @param days the range number of days to get the recovered for
     * @return the recovered in the specific date range
     */
    public List<HistoryRecoveredResponse> getRecoveredDataBefore(int days) {
        return Arrays.asList(this.data.recovered).subList(this.data.recovered.length - days, this.data.recovered.length);
    }

    /**
     * Returning the raw data collector
     *
     * @return the incidence response
     */
    public RecoveredResponse getRecoveredData() {
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