package io.litego.api.model;

import io.litego.api.enums.Currency;

import java.util.Optional;

public abstract class TransferRequest<T> {
    private Integer page;
    private Integer pageSize;
    private String status;
    private String direction;
    private T minAmount;
    private T maxAmount;
    private Long startCreatedAt;
    private Long endCreatedAt;
    private Long startStatusChangedAt;
    private Long endStatusChangedAt;
    private String sortBy;
    private Boolean ascending;
    private Currency currency;


    public Optional<Integer> getPage() {
        return Optional.ofNullable(page);
    }

    public Optional<Integer> getPageSize() {
        return Optional.ofNullable(pageSize);
    }

    public Optional<String> getStatus() {
        return Optional.ofNullable(status);
    }

    public Optional<String> getDirection() {
        return Optional.ofNullable(direction);
    }

    public Optional<Long> getStartCreatedAt() {
        return Optional.ofNullable(startCreatedAt);
    }

    public Optional<Long> getEndCreatedAt() {
        return Optional.ofNullable(endCreatedAt);
    }

    public Optional<Long> getStartStatusChangedAt() {
        return Optional.ofNullable(startStatusChangedAt);
    }

    public Optional<Long> getEndStatusChangedAt() {
        return Optional.ofNullable(endStatusChangedAt);
    }

    public Optional<String> getSortBy() {
        return Optional.ofNullable(sortBy);
    }

    public Optional<Boolean> getAscending() {
        return Optional.ofNullable(ascending);
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setStartCreatedAt(Long startCreatedAt) {
        this.startCreatedAt = startCreatedAt;
    }

    public void setEndCreatedAt(Long endCreatedAt) {
        this.endCreatedAt = endCreatedAt;
    }

    public void setStartStatusChangedAt(Long startStatusChangedAt) {
        this.startStatusChangedAt = startStatusChangedAt;
    }

    public void setEndStatusChangedAt(Long endStatusChangedAt) {
        this.endStatusChangedAt = endStatusChangedAt;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setAscending(Boolean ascending) {
        this.ascending = ascending;
    }

    public abstract Optional<T> getMinAmount();

    public abstract Optional<T>  getMaxAmount();

    public Currency getCurrency() {
        return currency;
    }
}

