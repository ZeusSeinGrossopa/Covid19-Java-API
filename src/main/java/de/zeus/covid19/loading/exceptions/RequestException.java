package de.zeus.covid19.loading.exceptions;

public class RequestException extends RuntimeException {
    public RequestException(String message) {
        super(message);
    }

    public RequestException(Throwable cause) {
        super(cause);
    }
}
