package io.litego.api.exception;

public class TooManyRequestsException extends LitegoException {
    public TooManyRequestsException(int code, String message) {
        super(code, message);
    }
}
