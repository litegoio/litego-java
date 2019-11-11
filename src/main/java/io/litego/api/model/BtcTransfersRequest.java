package io.litego.api.model;

import io.litego.api.enums.Currency;

import java.util.Optional;

public class BtcTransfersRequest extends TransferRequest {
    private Long minAmount;
    private Long maxAmount;
    private final Currency currency = Currency.EOS;

    @Override
    public Optional<Long> getMinAmount() {
        return Optional.ofNullable(minAmount);
    }

    @Override
    public Optional<Long> getMaxAmount() {
        return Optional.ofNullable(maxAmount);
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

}
