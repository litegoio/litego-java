package io.litego.api.exception;

public class LitegoException extends Exception {
    private int code;

    public LitegoException(int code, String message) {
        this(message, null);
        this.code = code;
    }

    public LitegoException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return super.toString() + "; code=" + code;
    }
}
