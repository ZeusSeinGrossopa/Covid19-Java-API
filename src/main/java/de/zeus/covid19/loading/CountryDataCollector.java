package de.zeus.covid19.loading;

import de.zeus.covid19.api.country.CountryResponse;
import de.zeus.covid19.api.country.agegroups.AgeGroupsDataResponse;
import de.zeus.covid19.api.country.history.cases.HistoryCasesResponse;
import de.zeus.covid19.api.country.history.deaths.DeathResponse;
import de.zeus.covid19.api.country.history.incidence.IncidenceResponse;
import de.zeus.covid19.api.country.history.recovered.RecoveredResponse;

public class CountryDataCollector {

    private final String country;
    private boolean autoRefresh;
    private CountryResponse response;

    private HistoryCasesResponse caseHistory;
    private IncidenceResponse incidenceHistory;
    private DeathResponse deathResponse;
    private RecoveredResponse recoveredHistory;
    private AgeGroupsDataResponse ageGroupsResponse;

    public CountryDataCollector(String country, boolean autoRefresh) {
        this.country = country;
        this.autoRefresh = autoRefresh;
    }

    public CountryDataCollector(String country) {
        this(country, true);
    }

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


    public final String getCountry() {
        return country;
    }

    public final void reset() {
        this.response = null;
        this.caseHistory = null;
        this.incidenceHistory = null;
        this.deathResponse = null;
        this.recoveredHistory = null;
        this.ageGroupsResponse = null;
    }

    public void refreshGlobalResponse() {
        this.response = null;
    }

    public void refreshCaseHistory() {
        this.caseHistory = null;
    }

    public void refreshIncidenceHistory() {
        this.incidenceHistory = null;
    }

    public void refreshDeathsHistory() {
        this.deathResponse = null;
    }

    public void refreshRecoveredHistory() {
        this.recoveredHistory = null;
    }

    public void refreshAgeGroupsResponse() {
        this.ageGroupsResponse = null;
    }

    public void setAutoRefresh(boolean autoRefresh) {
        this.autoRefresh = autoRefresh;
    }

    public boolean isAutoRefresh() {
        return autoRefresh;
    }
}