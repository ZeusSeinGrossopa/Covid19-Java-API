# Covid19-Java-Api

The Covid19-API is a useful tool for getting an overview about the covid19 cases

- This API is based on the [COVID-19 API](https://corona-zahlen.org)
- Make sure that the API is currently only for Germany

---

## How it works

The API works with the [Gson](https://github.com/google/gson) library to collect the information with a simple data
class.

```
CountryData response = Covid19API.getCountry("germany");
String deaths = response.getResponse().deaths;
```

See in
the [CountryData](https://github.com/ZeusSeinGrossopa/Covid19-Java-API/blob/master/src/main/java/de/zeus/covid19/http/CountryData.java)
class for the different data usages

---