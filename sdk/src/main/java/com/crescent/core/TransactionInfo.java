package com.crescent.core;

public class TransactionInfo {
    public String to;
    public String value;
    public String data;
    public String chainId;
    public TransactionInfo() {}

    public TransactionInfo(String chainId, String to, String value, String data) {
        this.chainId = chainId;
        this.to = to;
        this.value = value;
        this.data = data;
    }
}
