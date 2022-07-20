package de.zeus.covid19.loading;

import de.zeus.covid19.loading.api.CasesHistory;

public class CountryData {

    private final CountryDataCollector dataCollector;

    private final CasesHistory casesHistory;

    public CountryData(CountryDataCollector dataCollector) {
        this.dataCollector = dataCollector;

        this.casesHistory = new CasesHistory(this);
    }

    public CasesHistory getCasesHistory() {
        return casesHistory;
    }

    public CountryDataCollector getDataCollector() {
        return dataCollector;
    }
}