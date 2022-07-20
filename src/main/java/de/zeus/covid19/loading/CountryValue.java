package de.zeus.covid19.loading;

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