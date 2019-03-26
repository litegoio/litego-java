package io.litego.api.model;

import java.util.Date;

public class ChargeResponse {
    public String id;
    public String merchant_id;
    public String description;
    public int amount;
    public int amount_satoshi;
    public String payment_request;
    public boolean paid;
    public Date created;
    public int expiry_seconds;
    public String object;
}
