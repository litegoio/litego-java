package io.litego.api.model;

import java.util.Optional;

public class ChargeRequest {
    private Optional<Boolean> isPaid = Optional.empty();
    private Optional<Long> page = Optional.empty();
    private Optional<Long> pageSize = Optional.empty();
    private Optional<Long> startDate = Optional.empty();
    private Optional<Long> endDate = Optional.empty();
    private Optional<Long> minAmount = Optional.empty();
    private Optional<Long> maxAmount = Optional.empty();
    private Optional<Long> minAmountPaid = Optional.empty();
    private Optional<Long> maxAmountPaid = Optional.empty();
    private Optional<String> sortBy = Optional.empty();
    private Optional<Boolean> ascending = Optional.empty();

    public ChargeRequest() {
    }

    public Optional<Boolean> getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Optional<Boolean> isPaid) {
        this.isPaid = isPaid;
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

    public Optional<Long> getStartDate() {
        return startDate;
    }

    public void setStartDate(Optional<Long> startDate) {
        this.startDate = startDate;
    }

    public Optional<Long> getEndDate() {
        return endDate;
    }

    public void setEndDate(Optional<Long> endDate) {
        this.endDate = endDate;
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

    public Optional<Long> getMinAmountPaid() {
        return minAmountPaid;
    }

    public void setMinAmountPaid(Optional<Long> minAmountPaid) {
        this.minAmountPaid = minAmountPaid;
    }

    public Optional<Long> getMaxAmountPaid() {
        return maxAmountPaid;
    }

    public void setMaxAmountPaid(Optional<Long> maxAmountPaid) {
        this.maxAmountPaid = maxAmountPaid;
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
