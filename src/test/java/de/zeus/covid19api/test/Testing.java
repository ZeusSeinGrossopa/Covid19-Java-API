package de.zeus.covid19api.test;

import de.zeus.covid19.http.CountryData;
import de.zeus.covid19.http.Covid19API;

public class Testing {

    public static void main(String[] args) {
        CountryData response = Covid19API.getCountry("germany");

        System.out.println(response.getAgeGroupsResponse().data.A15A34.casesFemale);
    }
}