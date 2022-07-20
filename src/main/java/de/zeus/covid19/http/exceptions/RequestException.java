package de.zeus.covid19.http.exceptions;

public class RequestException extends RuntimeException {
    public RequestException(String message) {
        super(message);
    }

    public RequestException(Throwable cause) {
        super(cause);
    }
}
