package io.litego.api.exception;

public class UnauthorizedException extends LitegoException {
    public UnauthorizedException(int code, String message) {
        super(code, message);
    }
}
