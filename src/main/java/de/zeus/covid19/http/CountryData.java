package de.zeus.covid19.http;

import de.zeus.covid19.api.country.CountryResponse;
import de.zeus.covid19.api.country.agegroups.AgeGroupsDataResponse;
import de.zeus.covid19.api.country.history.cases.HistoryCasesResponse;
import de.zeus.covid19.api.country.history.deaths.DeathResponse;
import de.zeus.covid19.api.country.history.incidence.IncidenceResponse;
import de.zeus.covid19.api.country.history.recovered.RecoveredHistory;

public class CountryData {

    private CountryResponse response;

    private HistoryCasesResponse caseHistory;
    private IncidenceResponse incidenceHistory;
    private DeathResponse deathResponse;
    private RecoveredHistory recoveredHistory;

    private AgeGroupsDataResponse ageGroupsResponse;

    private final String country;

    public CountryData(String country) {
        this.country = country;
    }

    public CountryResponse getResponse() {
        if(response == null) {
            return (response = Covid19API.getObject(Covid19API.COVID_19_API_URL + country, CountryResponse.class));
        }
        return response;
    }

    public HistoryCasesResponse getCasesHistory() {
        if(caseHistory == null) {
            return (caseHistory = Covid19API.getObject(Covid19API.COVID_19_API_URL + country + "/history/cases/", HistoryCasesResponse.class));
        }
        return caseHistory;
    }

    public IncidenceResponse getIncidenceHistory() {
        if(incidenceHistory == null) {
            return (incidenceHistory = Covid19API.getObject(Covid19API.COVID_19_API_URL + country + "/history/incidence/", IncidenceResponse.class));
        }
        return incidenceHistory;
    }

    public DeathResponse getDeathsHistory() {
        if(deathResponse == null) {
            return (deathResponse = Covid19API.getObject(Covid19API.COVID_19_API_URL + country + "/history/deaths/", DeathResponse.class));
        }
        return deathResponse;
    }

    public RecoveredHistory getRecoveredHistory() {
        if(recoveredHistory == null) {
            return (recoveredHistory = Covid19API.getObject(Covid19API.COVID_19_API_URL + country + "/history/recovered/", RecoveredHistory.class));
        }
        return recoveredHistory;
    }

    public AgeGroupsDataResponse getAgeGroupsResponse() {
        if(ageGroupsResponse == null) {
            return (ageGroupsResponse = Covid19API.getObject(Covid19API.COVID_19_API_URL + country + "/age-groups/", AgeGroupsDataResponse.class));
        }
        return ageGroupsResponse;
    }


    public String getCountry() {
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
}