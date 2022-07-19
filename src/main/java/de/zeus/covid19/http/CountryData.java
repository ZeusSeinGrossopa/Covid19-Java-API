package de.zeus.covid19.http;

import de.zeus.covid19.api.country.CountryResponse;
import de.zeus.covid19.api.country.history.CountryHistoryCasesResponse;

public class CountryData {

    private CountryResponse response;
    private CountryHistoryCasesResponse history;

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

    public CountryHistoryCasesResponse getHistory() {
        if(history == null) {
            return (history = Covid19API.getObject(Covid19API.COVID_19_API_URL + country, CountryHistoryCasesResponse.class));
        }
        return history;
    }

    public String getCountry() {
        return country;
    }
}