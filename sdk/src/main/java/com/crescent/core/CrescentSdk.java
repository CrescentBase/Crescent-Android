package com.crescent.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class CrescentSdk {
    private static final CrescentSdk mInstance = new CrescentSdk();
    private CrescentConfigure mConfigure;
    private ConnectCallback mConnectCallback;
    private TransactionCallback mSendTransactionCallback;
    private TransactionInfo mTx;

    public static CrescentSdk getInstance() {
        return mInstance;
    }

    public void init(CrescentConfigure configure) {
        mConfigure = configure;
    }

    public CrescentConfigure getConfig() {
        return mConfigure;
    }

    public ConnectCallback getConnectCallback() {
        return mConnectCallback;
    }

    public TransactionCallback getTransactionCallback() {
        return mSendTransactionCallback;
    }

    public TransactionInfo getTx() {
        return mTx;
    }

    public boolean isConnected(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(EmailBean.SP_BASE_USER_INFO, Context.MODE_PRIVATE);
        String email = preferences.getString(EmailBean.SP_EMAIL_KEY, null);
        String address = preferences.getString(EmailBean.SP_ADDRESS_KEY, null);
        return email != null && address != null;
    }

    public void connect(Context context, ConnectCallback connectCallback) {
        if (mConfigure == null || mConfigure.paymasterUrl == null) {
            return;
        }
        mConnectCallback = connectCallback;
        mTx = null;
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.crescent.core.CrescentActivity");
        context.startActivity(intent);
    }

    public void disconnect(Context context) {
        mTx = null;
        SharedPreferences preferences = context.getSharedPreferences(EmailBean.SP_BASE_USER_INFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(EmailBean.SP_EMAIL_KEY, null);
        editor.putString(EmailBean.SP_ADDRESS_KEY, null);
        editor.apply();
    }

    public void sendTransaction(Context context, TransactionInfo info, TransactionCallback sendTransactionCallback) {
        if (mConfigure == null || mConfigure.paymasterUrl == null) {
            return;
        }
        mTx = info;
        mSendTransactionCallback = sendTransactionCallback;
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.crescent.core.CrescentActivity");
        context.startActivity(intent);
    }

}
