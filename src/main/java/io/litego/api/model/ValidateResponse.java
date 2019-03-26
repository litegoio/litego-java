package io.litego.api.model;

public class ValidateResponse {
    public String payment_request_string;
    public long amount_satoshi;
    public String memo;
    public boolean path_found;
    public boolean expired;
}
