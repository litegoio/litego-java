package io.litego.api.exception;

public class AuthenticationException extends LitegoException {
    public AuthenticationException(int code, String message) {
        super(code, message);
    }
}
