package de.zeus.covid19.loading;

import de.zeus.covid19.loading.api.CasesHistory;
import de.zeus.covid19.loading.api.DeathsHistory;

public class CountryData {

    private final CountryDataCollector dataCollector;

    private final CasesHistory casesHistory;
    private final DeathsHistory deathsHistory;

    public CountryData(CountryDataCollector dataCollector) {
        this.dataCollector = dataCollector;

        this.casesHistory = new CasesHistory(this);
        this.deathsHistory = new DeathsHistory(this);
    }

    public CasesHistory getCasesHistory() {
        return casesHistory;
    }

    public DeathsHistory getDeathsHistory() {
        return deathsHistory;
    }

    public CountryDataCollector getDataCollector() {
        return dataCollector;
    }
}