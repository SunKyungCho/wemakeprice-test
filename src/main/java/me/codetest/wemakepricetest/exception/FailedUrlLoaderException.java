package me.codetest.wemakepricetest.exception;

public class FailedUrlLoaderException extends RuntimeException {

    public FailedUrlLoaderException() {
        super();
    }

    public FailedUrlLoaderException(String message) {
        super(message);
    }

    public FailedUrlLoaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedUrlLoaderException(Throwable cause) {
        super(cause);
    }

    protected FailedUrlLoaderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
