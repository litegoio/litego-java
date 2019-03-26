package io.litego.api.exception;

public class ServerErrorException extends LitegoException {
    public ServerErrorException(int code, String message) {
        super(code, message);
    }
}
