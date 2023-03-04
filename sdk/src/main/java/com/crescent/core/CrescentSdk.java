package com.crescent.core;

import android.content.Context;
import android.content.Intent;

public class CrescentSdk {
    private static final CrescentSdk mInstance = new CrescentSdk();
    private CrescentConfigure mConfigure;
    private LoginCallback mLoginCallback;
    private SendTransactionCallback mSendTransactionCallback;

    public static CrescentSdk getInstance() {
        return mInstance;
    }

    public void init(CrescentConfigure configure) {
        mConfigure = configure;
    }

    public boolean isLogin() {
        return false;
    }

    public void login(Context context, LoginCallback loginCallback) {
        mLoginCallback = loginCallback;
        if (loginCallback != null) {
            loginCallback.onLoginFail();
        }

        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.crescent.core.CrescentActivity");
        context.startActivity(intent);
    }

    public void logout() {

    }

    public void sendTransaction(TransactionInfo info, SendTransactionCallback sendTransactionCallback) {
        mSendTransactionCallback = sendTransactionCallback;
        if (sendTransactionCallback != null) {
            sendTransactionCallback.onSendFail();;
        }
    }

}
