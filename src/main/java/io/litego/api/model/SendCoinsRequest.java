package io.litego.api.model;

import io.litego.api.enums.Currency;

public class SendCoinsRequest {
    public String address;
    public long amount_sat;
    public String comment;
    public String account;
    public double amount_eos;
    public String memo;
    public Currency currency;

    public SendCoinsRequest(String address, long amount_sat, String comment, Currency currency) {
        this.address = address;
        this.amount_sat = amount_sat;
        this.comment = comment;
        this.currency = currency;
    }

    public SendCoinsRequest(String account, double amount_eos, String memo, Currency currency) {
        this.account = account;
        this.amount_eos = amount_eos;
        this.memo = memo;
        this.currency = currency;
    }

    public SendCoinsRequest(String address, long amount_sat) {
        this.address = address;
        this.amount_sat = amount_sat;
    }
}
