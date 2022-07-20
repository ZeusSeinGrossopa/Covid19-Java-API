package de.zeus.covid19.loading;

/**
 * Default set of countries to load.
 *
 * @author ZeusSeinGrossopa
 * @version 1.0
 */
public enum CountryValue {

    GERMANY("germany"),
    ;

    private final String country;

    CountryValue(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}