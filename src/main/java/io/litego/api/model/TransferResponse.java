package io.litego.api.model;

import java.util.Date;
import java.util.UUID;

public class TransferResponse {
    public UUID id;
    public String txid;
    public String address;
    public String account;
    public long amount_sat;
    public double amount_eos;
    public long blockchain_fee;
    public String status;
    public String direction;
    public String comment;
    public String memo;
    public Date created_at;
    public Date status_changed_at;
}
