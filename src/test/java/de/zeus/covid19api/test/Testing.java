package de.zeus.covid19api.test;

import de.zeus.covid19.api.country.CountryResponse;
import de.zeus.covid19.api.country.history.CountryHistoryCasesResponse;
import de.zeus.covid19.http.Covid19API;

public class Testing {

    public static void main(String[] args) {
        CountryHistoryCasesResponse response = Covid19API.getCountryHistoryCasesResponse("germany");

        System.out.println(response.cases[response.cases.length - 1].cases);
    }

}