package com.crescent.core;

public interface TransactionCallback {
    public void onSendSuccess(TransactionResult result);
    public void onSendFail();
}
