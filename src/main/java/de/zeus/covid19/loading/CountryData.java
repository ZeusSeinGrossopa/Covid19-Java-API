package de.zeus.covid19.loading;

import de.zeus.covid19.loading.api.CasesHistory;
import de.zeus.covid19.loading.api.DeathsHistory;
import de.zeus.covid19.loading.api.IncidenceHistory;
import de.zeus.covid19.loading.api.RecoveredHistory;

public class CountryData {

    private final CountryDataCollector dataCollector;

    private final CasesHistory casesHistory;
    private final DeathsHistory deathsHistory;
    private final IncidenceHistory incidenceHistory;
    private final RecoveredHistory recoveredHistory;

    public CountryData(CountryDataCollector dataCollector) {
        this.dataCollector = dataCollector;

        this.casesHistory = new CasesHistory(this);
        this.deathsHistory = new DeathsHistory(this);
        this.incidenceHistory = new IncidenceHistory(this);
        this.recoveredHistory = new RecoveredHistory(this);
    }

    public CasesHistory getCasesHistory() {
        return casesHistory;
    }

    public DeathsHistory getDeathsHistory() {
        return deathsHistory;
    }

    public IncidenceHistory getIncidenceHistory() {
        return incidenceHistory;
    }

    public RecoveredHistory getRecoveredHistory() {
        return recoveredHistory;
    }

    public CountryDataCollector getDataCollector() {
        return dataCollector;
    }
}