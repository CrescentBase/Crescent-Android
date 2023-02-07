package com.crescent.core;

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

    public void login(LoginCallback loginCallback) {
        mLoginCallback = loginCallback;
        if (loginCallback != null) {
            loginCallback.onFail();
        }
    }

    public void logout() {

    }

    public void sendTransaction(TransactionInfo info, SendTransactionCallback sendTransactionCallback) {
        mSendTransactionCallback = sendTransactionCallback;
        if (sendTransactionCallback != null) {
            sendTransactionCallback.onFail();;
        }
    }

}
