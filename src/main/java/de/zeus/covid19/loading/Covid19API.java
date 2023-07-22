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

/**
 * This class is used to load the data from the COVID-19 API.
 *
 * @author ZeusSeinGrossopa
 * @version 1.0
 */
public class Covid19API {

    /**
     * The base URL of the API.
     *
     * @see <a href="https://api.corona-zahlen.org/">https://api.corona-zahlen.org/</a>
     */
    public static final String COVID_19_API_URL = "https://api.corona-zahlen.org/";
    private static final Gson gson = new Gson();

    /**
     * Creating an instance of a {@link CountryDataCollector} object. The {@link CountryDataCollector} is a raw data collector. It does not contain any other features.
     * To use other features, look to the {@link #getCountry(String)} method.
     *
     * @param country the country to load the data for
     * @return an instance of the data collector to use the data
     * @see CountryDataCollector
     */
    public static CountryDataCollector getCountryData(String country) {
        return new CountryDataCollector(country);
    }

    /**
     * Creating an instance of a {@link CountryDataCollector} object. The {@link CountryDataCollector} is a raw data collector. It does not contain any other features.
     * To use other features, look to the {@link #getCountry(CountryValue)} method.
     * This method is used for default registered country of the {@link CountryValue} class.
     *
     * @param country the country to load the data for
     * @return an instance of the data collector to use the data
     * @see CountryDataCollector
     */
    public static CountryDataCollector getCountryData(CountryValue country) {
        return getCountryData(country.getCountry());
    }

    /**
     * Gets an instance of the CountryData object. This object contains all the information and other features for working with the data.
     * For the raw version see {@link #getCountryData(CountryValue)}
     *
     * @param country the country to load the data for
     * @return an instance of the CountryData object
     * @see CountryData
     */
    public static CountryData getCountry(CountryValue country) {
        return getCountry(country.getCountry());
    }

    /**
     * Gets an instance of the CountryData object. This object contains all the information and other features for working with the data.
     * For the raw version see {@link #getCountryData(String)}}
     *
     * @param country the country to load the data for
     * @return an instance of the CountryData object
     * @see CountryData
     */
    public static CountryData getCountry(String country) {
        return new CountryData(getCountryData(country));
    }

    /**
     * Gets an instance of a defined class object by URL. This process is done by the GSON library.
     * The URL must contain a json file.
     *
     * @param url   the url to load the data from
     * @param clazz the class to load the data into
     * @param <T>   the type of the class
     * @return an instance of the class with the loaded values
     * @throws RequestException if the request failed
     */
    public static <T> T getObject(String url, Class<T> clazz) throws RequestException {
        try {
            return gson.fromJson(getJson(url), clazz);
        } catch (JsonSyntaxException e) {
            throw new JsonParseException("Could not parse JSON information. (url: " + url + " Class: " + clazz.getSimpleName() + ")", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the raw json data from the URL.
     *
     * @param url the url to load Json from
     * @return the json as string
     * @throws RequestException if the request failed
     * @throws IOException      if input stream could not be read
     */
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

    /**
     * Gets the input stream from the URL.
     *
     * @param url the url to load the input stream from
     * @return the input stream from the url
     * @throws RequestException if the request failed. For example if the response code is not 200.
     */
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

            if (responseCode == HttpURLConnection.HTTP_OK)
                return connection.getInputStream();

            throw new RequestException("Request failed for url (" + url + "): Response Code: " + responseCode);
        } catch (Exception e) {
            throw new RequestException(e);
        }
    }

    /**
     * Turning an array into a list and reversing the list.
     *
     * @param array the array to reverse it
     * @param <T>   the type of the array
     * @return the reversed list
     */
    public static <T> List<T> reverseArrayToList(T[] array) {
        List<T> list = Arrays.asList(array.clone());
        Collections.reverse(list);
        return list;
    }
}