package io.litego.api.model;

import java.util.Date;

public class WithdrawalTransactionResponse {
    public String transaction_id;
    public String merchant_id;
    public String status;
    public String address;
    public String transaction_id_str;
    public long total_amount;
    public long relative_fee;
    public long manual_fee;
    public Date created_at;
    public Date status_changed_at;
    public String type;
    public String object;
}
