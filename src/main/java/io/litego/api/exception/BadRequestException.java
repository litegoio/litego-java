package io.litego.api.exception;

public class BadRequestException extends LitegoException {
    public BadRequestException(int code, String message) {
        super(code, message);
    }
}
