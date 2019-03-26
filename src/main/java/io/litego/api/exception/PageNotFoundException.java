package io.litego.api.exception;

public class PageNotFoundException extends LitegoException {
    public PageNotFoundException(int code, String message) {
        super(code, message);
    }
}
