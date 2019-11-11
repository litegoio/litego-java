package io.litego.api.model;

import java.util.Optional;

public class ChargeRequest {
    private Boolean isPaid;
    private Long page;
    private Long pageSize;
    private Long startDate;
    private Long endDate;
    private Long minAmount;
    private Long maxAmount;
    private Long minAmountPaid;
    private Long maxAmountPaid;
    private String sortBy;
    private Boolean ascending;

    public ChargeRequest() {
    }

    public Optional<Boolean> getIsPaid() {
        return Optional.ofNullable(isPaid);
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
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

    public Optional<Long> getStartDate() {
        return Optional.ofNullable(startDate);
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Optional<Long> getEndDate() {
        return Optional.ofNullable(endDate);
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
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

    public Optional<Long> getMinAmountPaid() {
        return Optional.ofNullable(minAmountPaid);
    }

    public void setMinAmountPaid(Long minAmountPaid) {
        this.minAmountPaid = minAmountPaid;
    }

    public Optional<Long> getMaxAmountPaid() {
        return Optional.ofNullable(maxAmountPaid);
    }

    public void setMaxAmountPaid(Long maxAmountPaid) {
        this.maxAmountPaid = maxAmountPaid;
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
