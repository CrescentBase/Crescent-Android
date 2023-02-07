package com.crescent.core;

public class TransactionInfo {
    private String mFrom;
    private String mTo;
    private String mValue;
    private String mData;
    public TransactionInfo(String from, String to, String value, String data) {
        mFrom = from;
        mTo = to;
        mValue = value;
        mData = data;
    }

    public String getFrom() {
        return mFrom;
    }

    public void setFrom(String from) {
        this.mFrom = from;
    }

    public String getTo() {
        return mTo;
    }

    public void setTo(String to) {
        this.mTo = to;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        this.mValue = value;
    }

    public String getData() {
        return mData;
    }

    public void setData(String data) {
        this.mData = data;
    }
}
