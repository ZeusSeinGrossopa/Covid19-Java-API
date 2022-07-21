# Covid19-Java-Api

### General information
The Covid19-API is a useful REST API for getting an overview about the Covid-19 cases and other information.
The data are stored in different API classes.

### How it works

The API works with the [Gson](https://github.com/google/gson) library to collect the information with a simple data
class. The exact data structure of the [COVID-19 API](https://corona-zahlen.org) is provided in the
API [package](https://github.com/ZeusSeinGrossopa/Covid19-Java-API/tree/master/src/main/java/de/zeus/covid19/api)

You can store and collect the data in the classes.

Note: The API based on the [COVID-19 API](https://corona-zahlen.org) by [Marlon Lückert](https://github.com/marlon360/rki-covid-api). (This API is only available for Germany). Based on this API additional functions are added. 

---

## Additional implemented functions 

To achieve a better handling the API is expanded with a new simple prefabricated loading and store system.
Additional functions: 
- Adjustable timeslots to collect data
- Summarized data for Germany available (incidence, deaths, recovered, cases, age-groups)
- Improved performance because of collect only dedicated data 
- Simple information classes provided for use in JAVA 

### How to use
#### Load and store information

```
//Loading and storing the data 
CountryData response = Covid19API.getCountry(CountryValue.GERMANY);

String cases = response.getCasesHistory().getLatestCases().cases; 
String date = response.getCasesHistory().getLatestCases().date;

//Refreshing certain data values
response.getDataCollector().refreshCaseHistory();
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
