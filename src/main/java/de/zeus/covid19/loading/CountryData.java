package de.zeus.covid19.loading;

import de.zeus.covid19.loading.api.CasesHistory;
import de.zeus.covid19.loading.api.DeathsHistory;
import de.zeus.covid19.loading.api.IncidenceHistory;
import de.zeus.covid19.loading.api.RecoveredHistory;

/**
 * Data class for a country.
 * This class is only for the API features. The API is using the {@link CountryDataCollector} for get and manage the data.
 * <p>
 * Get the instance of the class in the {@link Covid19API#getCountry(String)}} method.
 *
 * @author ZeusSeinGrossopa
 * @version 1.0
 */
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

    /**
     * @return the cases history
     */
    public CasesHistory getCasesHistory() {
        return casesHistory;
    }

    /**
     * @return the deaths history
     */
    public DeathsHistory getDeathsHistory() {
        return deathsHistory;
    }

    /**
     * @return the incidence history
     */
    public IncidenceHistory getIncidenceHistory() {
        return incidenceHistory;
    }

    /**
     * @return the recovered history
     */
    public RecoveredHistory getRecoveredHistory() {
        return recoveredHistory;
    }

    /**
     * @return data collector
     * @see CountryDataCollector
     */
    public CountryDataCollector getDataCollector() {
        return dataCollector;
    }
}