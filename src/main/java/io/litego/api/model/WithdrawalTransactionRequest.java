package io.litego.api.model;

import java.util.Optional;

public class WithdrawalTransactionRequest {
    private String status;
    private Long page;
    private Long pageSize;
    private String address;
    private String type;
    private Long startCreatedAt;
    private Long endCreatedAt;
    private Long minAmount;
    private Long maxAmount;
    private Long startChangedAt;
    private Long endChangedAt;
    private String sortBy;
    private Boolean ascending;

    public WithdrawalTransactionRequest() {
    }

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Optional<Long> getPage() {
        return Optional.ofNullable(page);
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Optional<Long> getPageSize() {
        return Optional.ofNullable(pageSize);
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Optional<String> getAddress() {
        return Optional.ofNullable(address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Optional<String> getType() {
        return Optional.ofNullable(type);
    }

    public void setType(String type) {
        this.type = type;
    }

    public Optional<Long> getStartCreatedAt() {
        return Optional.ofNullable(startCreatedAt);
    }

    public void setStartCreatedAt(Long startCreatedAt) {
        this.startCreatedAt = startCreatedAt;
    }

    public Optional<Long> getEndCreatedAt() {
        return Optional.ofNullable(endCreatedAt);
    }

    public void setEndCreatedAt(Long endCreatedAt) {
        this.endCreatedAt = endCreatedAt;
    }

    public Optional<Long> getMinAmount() {
        return Optional.ofNullable(minAmount);
    }

    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

    public Optional<Long> getMaxAmount() {
        return Optional.ofNullable(maxAmount);
    }

    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Optional<Long> getStartChangedAt() {
        return Optional.ofNullable(startChangedAt);
    }

    public void setStartChangedAt(Long startChangedAt) {
        this.startChangedAt = startChangedAt;
    }

    public Optional<Long> getEndChangedAt() {
        return Optional.ofNullable(endChangedAt);
    }

    public void setEndChangedAt(Long endChangedAt) {
        this.endChangedAt = endChangedAt;
    }

    public Optional<String> getSortBy() {
        return Optional.ofNullable(sortBy);
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Optional<Boolean> getAscending() {
        return Optional.ofNullable(ascending);
    }

    public void setAscending(Boolean ascending) {
        this.ascending = ascending;
    }
}
