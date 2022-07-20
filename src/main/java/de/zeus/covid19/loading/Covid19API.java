package de.zeus.covid19.loading;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import de.zeus.covid19.loading.exceptions.RequestException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Covid19API {

    public static final String COVID_19_API_URL = "https://api.corona-zahlen.org/";
    private static final Gson gson = new Gson();

    public static CountryDataCollector getCountryData(String country) {
        return new CountryDataCollector(country);
    }

    public static CountryDataCollector getCountryData(CountryValue country) {
        return getCountryData(country.getCountry());
    }

    public static CountryData getCountry(CountryValue country) {
        return getCountry(country.getCountry());
    }

    public static CountryData getCountry(String country) {
        return new CountryData(getCountryData(country));
    }

    public static <T> T getObject(String url, Class<T> clazz) throws RequestException {
        try {
            return gson.fromJson(getJson(url), clazz);
        } catch (JsonSyntaxException e) {
            throw new JsonParseException("Could not parse JSON information. (url: " + url + " Class: " + clazz.getSimpleName() + ")", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getJson(String url) throws RequestException, IOException {
        InputStream inputStream = getInputStream(url);

        if (inputStream == null) {
            throw new RequestException("Failed to get input stream from " + url);
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        for (int length; (length = inputStream.read(buffer)) != -1; ) {
            output.write(buffer, 0, length);
        }

        String json = output.toString(StandardCharsets.UTF_8);
        if (json.toLowerCase().startsWith("Cannot get".toLowerCase()))
            throw new RequestException("Failed to get data from " + url + ". URL returned: " + json);

        return json;
    }

    public static InputStream getInputStream(String url) throws RequestException {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

            connection.setReadTimeout(5000);
            connection.setConnectTimeout(2000);

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Covid19-Java-API (" + System.getProperty("os.name") + "; " + System.getProperty("os.arch") + ")");

            connection.connect();

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return connection.getInputStream();
            }
            throw new RequestException("Request failed for url (" + url + "): Response Code: " + responseCode);
        } catch (Exception e) {
            throw new RequestException(e);
        }
    }

    public static <T> List<T> reverseArrayToList(T[] array) {
        List<T> list = Arrays.asList(array.clone());
        Collections.reverse(list);
        return list;
    }
}