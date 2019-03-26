package io.litego.api.model;

public class MerchantInfoResponse {
    public String id;
    public String name;
    public long available_balance_satoshi;
    public long pending_withdrawal_satoshi;
    public long withdrawn_total_satoshi;
    public WithdrawalAddressResponse withdrawal_address;
    public String object;
}
