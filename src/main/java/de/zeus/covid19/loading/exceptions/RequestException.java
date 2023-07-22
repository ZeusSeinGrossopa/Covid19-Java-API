package de.zeus.covid19.loading.exceptions;

/**
 * Exception if the request was not successful
 *
 * @author ZeusSeinGrossopa
 * @version 1.0
 */
public class RequestException extends RuntimeException {

    public RequestException(String message) {
        super(message);
    }

    public RequestException(Throwable cause) {
        super(cause);
    }
}