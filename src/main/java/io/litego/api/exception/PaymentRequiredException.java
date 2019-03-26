package io.litego.api.exception;

public class PaymentRequiredException extends LitegoException {
    public PaymentRequiredException(int code, String message) {
        super(code, message);
    }
}
