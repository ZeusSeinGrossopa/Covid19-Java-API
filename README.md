# Covid19-Java-Api

[![](https://jitpack.io/v/ZeusSeinGrossopa/Covid19-Java-API.svg)](https://jitpack.io/#ZeusSeinGrossopa/Covid19-Java-API)

### General information

The Covid-19-API is a useful API for getting an overview about the Covid-19 cases and other information.
The data is stored in different java classes.

### How it works

The API works with the [Gson](https://github.com/google/gson) library to collect the information with a simple data
class. The exact data structure of the [COVID-19 API](https://corona-zahlen.org) is provided in the
API [package](https://github.com/ZeusSeinGrossopa/Covid19-Java-API/tree/master/src/main/java/de/zeus/covid19/api).
You can store and collect the data in the classes.

Note: The API based on the [COVID-19 API](https://corona-zahlen.org)
by [Marlon Lückert](https://github.com/marlon360/rki-covid-api). (This API is only available for Germany). Based on this
API, additional functions are added.

---

## Additional implemented functions

To achieve better handling, the API is expanded with a new simple prefabricated loading and store system.
Additional functions:

- Adjustable timeslots to collect data
- Summarized data for Germany available (incidence, deaths, recovered, cases, age-groups, ...)
- Improved performance because of collecting only dedicated data
- Simple information classes provided for use in java

### How to use

#### Load and store information

```
//Loading and storing the data as a variable
CountryData countryData = Covid19API.getCountry(CountryValue.GERMANY);

String cases = countryData.getCasesHistory().getLatestCases().cases; 
String date = countryData.getCasesHistory().getLatestCases().date;

//Refreshing certain stored data values
countryData.getDataCollector().refreshCaseHistory();
```

---

## Implement the API

#### Maven

```xml

<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.ZeusSeinGrossopa</groupId>
    <artifactId>Covid19-Java-API</artifactId>
    <version>1.0</version>
</dependency>
```

#### Gradle

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.ZeusSeinGrossopa:Covid19-Java-API:1.0'
}
```

---