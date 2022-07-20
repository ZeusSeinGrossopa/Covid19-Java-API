package de.zeus.covid19api.test;

import de.zeus.covid19.loading.CountryData;
import de.zeus.covid19.loading.CountryDataCollector;
import de.zeus.covid19.loading.CountryValue;
import de.zeus.covid19.loading.Covid19API;

public class Testing {

    public static void main(String[] args) {
        CountryData response = Covid19API.getCountry(CountryValue.GERMANY);

        System.out.println(response.getCasesHistory().getLatestCase().cases + " " + response.getCasesHistory().getLatestCase().date);
        response.getDataCollector().refreshCaseHistory();
//        System.out.println(response.getAgeGroupsResponse().data.A15A34.casesFemale);
    }
}