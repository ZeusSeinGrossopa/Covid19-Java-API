package de.zeus.covid19.loading.api;

import de.zeus.covid19.api.country.history.deaths.DeathResponse;
import de.zeus.covid19.api.country.history.deaths.HistoryDeathResponse;
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
public class DeathsHistory {

    private final CountryData countryData;

    private DeathResponse data;

    public DeathsHistory(CountryData countryData) {
        this.countryData = countryData;

        this.refresh();
    }

    /**
     * Refresh the stored data
     */
    public void refresh() {
        this.countryData.getDataCollector().refreshDeathsHistory();
        this.data = this.countryData.getDataCollector().getDeathsHistory();
    }

    /**
     * @return getting the latest death information
     */
    public HistoryDeathResponse getLatestDeaths() {
        return Covid19API.reverseArrayToList(this.data.deaths).get(0);
    }

    /**
     * @return getting the oldest death information
     */
    public HistoryDeathResponse getOldestDeaths() {
        return this.data.deaths[0];
    }

    /**
     * Getting the deaths in a specific date range
     *
     * @param days the range number of days to get the deaths for
     * @return the deaths in the specific date range
     */
    public List<HistoryDeathResponse> getDeathsBefore(int days) {
        return Arrays.asList(this.data.deaths).subList(this.data.deaths.length - days, this.data.deaths.length);
    }

    /**
     * Returning the raw data collector
     *
     * @return the death response
     */
    public DeathResponse getCasesResponse() {
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