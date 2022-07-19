package de.zeus.covid19api.test;

import de.zeus.covid19.api.country.CountryResponse;
import de.zeus.covid19.http.Covid19API;

public class Testing {

    public static void main(String[] args) {
        CountryResponse response = Covid19API.getCountryResponse("germany");

        System.out.println(response.deaths + " " + response.rValue.value);
    }

}