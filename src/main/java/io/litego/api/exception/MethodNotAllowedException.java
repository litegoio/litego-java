package io.litego.api.exception;

public class MethodNotAllowedException extends LitegoException {
    public MethodNotAllowedException(int code, String message) {
        super(code, message);
    }
}
