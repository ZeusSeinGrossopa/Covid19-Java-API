package de.zeus.covid19.loading.api;

import de.zeus.covid19.api.country.history.cases.CasesResponse;
import de.zeus.covid19.api.country.history.cases.HistoryCasesResponse;
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
public class CasesHistory {

    private final CountryData countryData;

    private HistoryCasesResponse data;

    public CasesHistory(CountryData countryData) {
        this.countryData = countryData;

        this.refresh();
    }

    /**
     * Refresh the stored data
     */
    public void refresh() {
        this.countryData.getDataCollector().refreshCaseHistory();
        this.data = this.countryData.getDataCollector().getCasesHistory();
    }

    /**
     * @return getting the latest case information
     */
    public CasesResponse getLatestCases() {
        return Covid19API.reverseArrayToList(this.data.cases).get(0);
    }

    /**
     * @return getting the oldest case information
     */
    public CasesResponse getOldestCases() {
        return this.data.cases[0];
    }

    /**
     * Getting the cases in a specific date range
     *
     * @param days the range number of days to get the cases for
     * @return the cases in the specific date range
     */
    public List<CasesResponse> getCasesBefore(int days) {
        return Arrays.asList(this.data.cases).subList(this.data.cases.length - days, this.data.cases.length);
    }

    /**
     * Returning the raw data collector
     *
     * @return the cases response
     */
    public HistoryCasesResponse getCasesResponse() {
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