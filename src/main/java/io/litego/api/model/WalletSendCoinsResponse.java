package io.litego.api.model;

import java.util.UUID;

public class WalletSendCoinsResponse {
    public UUID id;
    public String txid;
    public long amount_sat;
    public double amount_eos;
    public long blockchain_fee;
    public String comment;
    public String memo;
}
