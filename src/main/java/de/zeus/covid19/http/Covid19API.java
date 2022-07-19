package de.zeus.covid19.http;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import de.zeus.covid19.api.country.CountryResponse;
import de.zeus.covid19.http.exceptions.RequestException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Covid19API {

    private static final String COVID_19_API_URL = "https://api.corona-zahlen.org/";
    private static final Gson gson = new Gson();

    public static CountryResponse getCountryResponse(String country) throws RequestException {
        try {
            return gson.fromJson(getJson(COVID_19_API_URL + country), CountryResponse.class);
        } catch(JsonSyntaxException e) {
            throw new JsonParseException("Could not parse JSON information.", e);
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
        if(json.toLowerCase().startsWith("Cannot get".toLowerCase()))
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

            if(responseCode == HttpURLConnection.HTTP_OK) {
                return connection.getInputStream();
            }
            throw new RequestException("Request failed for url (" + url + "): Response Code: " + responseCode);
        } catch(Exception e) {
            throw new RequestException(e);
        }
    }
}