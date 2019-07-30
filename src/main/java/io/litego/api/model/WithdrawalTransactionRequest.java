package io.litego.api.model;

import java.util.Optional;

public class WithdrawalTransactionRequest {
    private Optional<String> status = Optional.empty();
    private Optional<Long> page = Optional.empty();
    private Optional<Long> pageSize = Optional.empty();
    private Optional<String> address = Optional.empty();
    private Optional<String> type = Optional.empty();
    private Optional<Long> startCreatedAt = Optional.empty();
    private Optional<Long> endCreatedAt = Optional.empty();
    private Optional<Long> minAmount = Optional.empty();
    private Optional<Long> maxAmount = Optional.empty();
    private Optional<Long> startChangedAt = Optional.empty();
    private Optional<Long> endChangedAt = Optional.empty();
    private Optional<String> sortBy = Optional.empty();
    private Optional<Boolean> ascending = Optional.empty();

    public WithdrawalTransactionRequest() {
    }

    public Optional<String> getStatus() {
        return status;
    }

    public void setStatus(Optional<String> status) {
        this.status = status;
    }

    public Optional<Long> getPage() {
        return page;
    }

    public void setPage(Optional<Long> page) {
        this.page = page;
    }

    public Optional<Long> getPageSize() {
        return pageSize;
    }

    public void setPageSize(Optional<Long> pageSize) {
        this.pageSize = pageSize;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }

    public Optional<String> getType() {
        return type;
    }

    public void setType(Optional<String> type) {
        this.type = type;
    }

    public Optional<Long> getStartCreatedAt() {
        return startCreatedAt;
    }

    public void setStartCreatedAt(Optional<Long> startCreatedAt) {
        this.startCreatedAt = startCreatedAt;
    }

    public Optional<Long> getEndCreatedAt() {
        return endCreatedAt;
    }

    public void setEndCreatedAt(Optional<Long> endCreatedAt) {
        this.endCreatedAt = endCreatedAt;
    }

    public Optional<Long> getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Optional<Long> minAmount) {
        this.minAmount = minAmount;
    }

    public Optional<Long> getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Optional<Long> maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Optional<Long> getStartChangedAt() {
        return startChangedAt;
    }

    public void setStartChangedAt(Optional<Long> startChangedAt) {
        this.startChangedAt = startChangedAt;
    }

    public Optional<Long> getEndChangedAt() {
        return endChangedAt;
    }

    public void setEndChangedAt(Optional<Long> endChangedAt) {
        this.endChangedAt = endChangedAt;
    }

    public Optional<String> getSortBy() {
        return sortBy;
    }

    public void setSortBy(Optional<String> sortBy) {
        this.sortBy = sortBy;
    }

    public Optional<Boolean> getAscending() {
        return ascending;
    }

    public void setAscending(Optional<Boolean> ascending) {
        this.ascending = ascending;
    }
}
