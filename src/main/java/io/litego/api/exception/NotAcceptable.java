package io.litego.api.exception;

public class NotAcceptable extends LitegoException {
    public NotAcceptable(int code, String message) {
        super(code, message);
    }
}
