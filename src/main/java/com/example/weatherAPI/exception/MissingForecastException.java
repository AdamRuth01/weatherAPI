package com.example.weatherAPI.exception;

public class MissingForecastException extends RuntimeException{
    public MissingForecastException() {
    }

    public MissingForecastException(String message) {
        super(message);
    }

    public MissingForecastException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingForecastException(Throwable cause) {
        super(cause);
    }

}

