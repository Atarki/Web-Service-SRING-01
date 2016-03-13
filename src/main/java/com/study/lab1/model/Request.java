package com.study.lab1.model;

public class Request {
    private long accountFromId;
    private long accountToId;
    private long userId;
    private String operation;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAccountFromId() {
        return accountFromId;
    }

    public void setAccountFromId(long accountFromId) {
        this.accountFromId = accountFromId;
    }

    public long getAccountToId() {
        return accountToId;
    }

    public void setAccountToId(long accountToId) {
        this.accountToId = accountToId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Request{" +
                "accountFromId=" + accountFromId +
                ", accountToId=" + accountToId +
                ", userId=" + userId +
                ", operation=" + operation +
                '}';
    }
}
