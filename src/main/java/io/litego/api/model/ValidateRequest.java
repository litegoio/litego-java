package io.litego.api.model;

public class ValidateRequest {
    public String payment_request_string;
    public long amount_satoshi;

    public ValidateRequest(String payment_request_string, long amount_satoshi) {
        this.payment_request_string = payment_request_string;
        this.amount_satoshi = amount_satoshi;
    }
}
