# Covid19-Java-Api

The Covid19-API is a useful REST API for getting an overview about the Covid-19 cases and other information.

The data is stored in the API classes.

- This API is based on the [COVID-19 API](https://corona-zahlen.org) by [Marlon Lückert](https://github.com/marlon360/rki-covid-api)
- Make sure that the API is currently only variable for Germany

---

## How it works

The API works with the [Gson](https://github.com/google/gson) library to collect the information with a simple data
class. The exact data structure of the [COVID-19 API](https://corona-zahlen.org) is provided in the API [package](https://github.com/ZeusSeinGrossopa/Covid19-Java-API/tree/master/src/main/java/de/zeus/covid19/api)


You can store and collect the data in the classes.

---

### Prefabricated data load and store system 

Also, the API provides a simple prefabricated loading and store system. 
- The concept of easy to use and simple. 
- Performance is not a problem.
- Use more variations to get the data you need.

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

## Use the API

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