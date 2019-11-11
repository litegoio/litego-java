package io.litego.api.model;

import io.litego.api.enums.Currency;

import java.util.Optional;

public class EosTransfersRequest extends TransferRequest {
    private Double minAmount;
    private Double maxAmount;
    private final Currency currency = Currency.EOS;

    @Override
    public Optional<Double> getMinAmount() {
        return Optional.ofNullable(minAmount);
    }

    @Override
    public Optional<Double> getMaxAmount() {
        return Optional.ofNullable(maxAmount);
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

}
