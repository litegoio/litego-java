package io.litego.api.model;

import io.litego.api.enums.Currency;

import java.util.Arrays;
import java.util.List;

public class SendManyRequest {
    public List<SendCoinsRequest> amounts;
    public String comment;
    public Currency currency;

    public SendManyRequest(String comment, Currency currency, SendCoinsRequest... sendCoinsRequests) {
        this.amounts = Arrays.asList(sendCoinsRequests);
        this.comment = comment;
        this.currency = currency;
    }
}
