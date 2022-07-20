package de.zeus.covid19.loading;

import de.zeus.covid19.api.country.CountryResponse;
import de.zeus.covid19.api.country.agegroups.AgeGroupsDataResponse;
import de.zeus.covid19.api.country.history.cases.HistoryCasesResponse;
import de.zeus.covid19.api.country.history.deaths.DeathResponse;
import de.zeus.covid19.api.country.history.incidence.IncidenceResponse;
import de.zeus.covid19.api.country.history.recovered.RecoveredResponse;

/**
 * This class is used to collect the data from the API and store it. For better using of this data see {@link CountryData}.
 *
 * @author ZeusSeinGrossopa
 * @version 1.0
 */
public class CountryDataCollector {

    private final String country;
    private boolean autoRefresh;
    private CountryResponse response;

    private HistoryCasesResponse caseHistory;
    private IncidenceResponse incidenceHistory;
    private DeathResponse deathResponse;
    private RecoveredResponse recoveredHistory;
    private AgeGroupsDataResponse ageGroupsResponse;

    /**
     * @param country The country to load.
     * @param autoRefresh if true the data will be refreshed automatically. See {@link #setAutoRefresh(boolean)}
     */
    public CountryDataCollector(String country, boolean autoRefresh) {
        this.country = country;
        this.autoRefresh = autoRefresh;
    }

    /**
     * @param country the country to load.
     */
    public CountryDataCollector(String country) {
        this(country, true);
    }

    /**
     * @return the global response of the country.
     * @see CountryResponse
     */
    public CountryResponse getResponse() {
        CountryResponse tempResponse = null;
        if(!autoRefresh || this.response == null)
            tempResponse = Covid19API.getObject(Covid19API.COVID_19_API_URL + country, CountryResponse.class);

        if(!autoRefresh)
            return tempResponse;

        if (this.response == null) {
            return (this.response = tempResponse);
        }
        return response;
    }

    /**
     * @return the case history of the country.
     * @see HistoryCasesResponse
     */
    public HistoryCasesResponse getCasesHistory() {
        HistoryCasesResponse tempCaseHistory = null;

        if(!autoRefresh || this.caseHistory == null)
            tempCaseHistory = Covid19API.getObject(Covid19API.COVID_19_API_URL + country + "/history/cases/", HistoryCasesResponse.class);

        if(!autoRefresh)
            return tempCaseHistory;

        if (this.caseHistory == null) {
            return (this.caseHistory = tempCaseHistory);
        }
        return this.caseHistory;
    }

    /**
     * @return the incidence history of the country
     * @see IncidenceResponse
     */
    public IncidenceResponse getIncidenceHistory() {
        IncidenceResponse tempIncidenceHistory = null;

        if(!autoRefresh ||  this.incidenceHistory == null)
            tempIncidenceHistory = Covid19API.getObject(Covid19API.COVID_19_API_URL + country + "/history/incidence/", IncidenceResponse.class);

        if(!autoRefresh)
            return tempIncidenceHistory;

        if (this.incidenceHistory == null) {
            return (this.incidenceHistory = tempIncidenceHistory);
        }
        return this.incidenceHistory;
    }

    /**
     * @return the death history of the country
     * @see DeathResponse
     */
    public DeathResponse getDeathsHistory() {
        DeathResponse tempDeathsHistory = null;

        if(!autoRefresh || this.deathResponse == null)
            tempDeathsHistory = Covid19API.getObject(Covid19API.COVID_19_API_URL + country + "/history/deaths/", DeathResponse.class);

        if(!autoRefresh)
            return tempDeathsHistory;

        if (this.deathResponse == null) {
            return (this.deathResponse = tempDeathsHistory);
        }
        return this.deathResponse;
    }

    /**
     * @return the recovered history of the country
     * @see RecoveredResponse
     */
    public RecoveredResponse getRecoveredHistory() {
        RecoveredResponse tempRecoveredHistory = null;

        if(!autoRefresh || recoveredHistory == null)
            tempRecoveredHistory =  Covid19API.getObject(Covid19API.COVID_19_API_URL + country + "/history/recovered/", RecoveredResponse.class);

        if(!autoRefresh)
            return tempRecoveredHistory;

        if (this.recoveredHistory == null) {
            return (this.recoveredHistory = tempRecoveredHistory);
        }
        return this.recoveredHistory;
    }

    /**
     * @return the age groups of the country
     * @see AgeGroupsDataResponse
     */
    public AgeGroupsDataResponse getAgeGroupsResponse() {
        AgeGroupsDataResponse tempAgeGroupsResponse = null;

        if(!autoRefresh || this.ageGroupsResponse == null)
            tempAgeGroupsResponse = Covid19API.getObject(Covid19API.COVID_19_API_URL + country + "/age-groups/", AgeGroupsDataResponse.class);

        if(!autoRefresh)
            return Covid19API.getObject(Covid19API.COVID_19_API_URL + country + "/age-groups/", AgeGroupsDataResponse.class);

        if (this.ageGroupsResponse == null) {
            return (this.ageGroupsResponse = tempAgeGroupsResponse);
        }
        return this.ageGroupsResponse;
    }


    /**
     * See {@link CountryValue} for the default countries
     *
     * @return the country name
     */
    public final String getCountry() {
        return country;
    }

    /**
     * Resetting the stored data. This is used when the data is outdated.
     *
     * The data gets loaded when the method for the data gets called.
     */
    public final void refresh() {
        this.response = null;
        this.caseHistory = null;
        this.incidenceHistory = null;
        this.deathResponse = null;
        this.recoveredHistory = null;
        this.ageGroupsResponse = null;
    }

    /**
     * Refreshing global response data.
     * For global refreshing see {@link #refresh()}
     */
    public void refreshGlobalResponse() {
        this.response = null;
    }

    /**
     * Refreshing case history data.
     * For global refreshing see {@link #refresh()}
     */
    public void refreshCaseHistory() {
        this.caseHistory = null;
    }

    /**
     * Refreshing incidence history data.
     * For global refreshing see {@link #refresh()}
     */
    public void refreshIncidenceHistory() {
        this.incidenceHistory = null;
    }

    /**
     * Refreshing death history data.
     * For global refreshing see {@link #refresh()}
     */
    public void refreshDeathsHistory() {
        this.deathResponse = null;
    }

    /**
     * Refreshing recovered history data.
     * For global refreshing see {@link #refresh()}
     */
    public void refreshRecoveredHistory() {
        this.recoveredHistory = null;
    }

    /**
     * Refreshing age groups data.
     * For global refreshing see {@link #refresh()}
     */
    public void refreshAgeGroupsResponse() {
        this.ageGroupsResponse = null;
    }

    /**
     * If false the data will be every time gets refreshed when the method for the data gets called.
     *
     * @param autoRefresh if true, the data will be refreshed automatically.
     */
    public void setAutoRefresh(boolean autoRefresh) {
        this.autoRefresh = autoRefresh;
    }

    /**
     * If false the data will be every time gets refreshed when the method for the data gets called.
     *
     * @return if the data is automatically refreshed.
     */
    public boolean isAutoRefresh() {
        return autoRefresh;
    }
}