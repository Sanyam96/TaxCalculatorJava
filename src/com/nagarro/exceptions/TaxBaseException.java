package com.nagarro.exceptions;

/**
 *
 */
public class TaxBaseException extends RuntimeException {

    public TaxBaseException() {
    }

    public TaxBaseException(String message) {
        super(message);
    }

    public TaxBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaxBaseException(Throwable cause) {
        super(cause);
    }

    public TaxBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
