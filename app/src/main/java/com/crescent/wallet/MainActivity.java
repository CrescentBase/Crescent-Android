package com.crescent.wallet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.crescent.core.CrescentConfigure;
import com.crescent.core.CrescentSdk;
import com.crescent.core.ConnectCallback;
import com.crescent.core.TransactionCallback;
import com.crescent.core.TransactionInfo;
import com.crescent.core.TransactionResult;
import com.crescent.core.UserInfo;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "cyh::MainActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.initSdk).setOnClickListener(this);
        findViewById(R.id.loginBtn).setOnClickListener(this);
        findViewById(R.id.logoutBtn).setOnClickListener(this);
        findViewById(R.id.sendTransaction).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.initSdk:
                CrescentConfigure config = new CrescentConfigure();
                config.paymasterUrl = "https://wallet.crescentbase.com/api/v1/signOp";
                CrescentSdk.getInstance().init(config);
                break;
            case R.id.loginBtn:
                CrescentSdk.getInstance().connect(this, new ConnectCallback() {
                    @Override
                    public void onConnectSuccess(UserInfo info) {
                        String email = info.email;
                        String address = info.address;
                        android.util.Log.d("==MainActivity = ", "email:" + email);
                        android.util.Log.d("==MainActivity = ", "address:" + address);
                    }

                    @Override
                    public void onConnectFail() {
                    }
                });
                break;
            case R.id.logoutBtn://327 114
                CrescentSdk.getInstance().disconnect(this);
                break;
            case R.id.sendTransaction:
                TransactionInfo info = new TransactionInfo();
                info.chainId = "137";
                info.to = "0x6De6b8B22241A753495ed1C3289aBc9Bf61F5D2e";
                info.value = "0x2386f26fc10000";
//                    info.data = "0xa9059cbb0000000000000000000000000648cea573a37ad78738c9ed861dd8ad9ca53bec0000000000000000000000000000000000000000000000000000000000002710";
                CrescentSdk.getInstance().sendTransaction(this, info, new TransactionCallback() {
                    @Override
                    public void onSendSuccess(TransactionResult result) {
                        String hash = result.hash;
                        android.util.Log.d("==MainActivity = ", "hash:" + hash);
                    }

                    @Override
                    public void onSendFail() {
                    }
                });
                break;
        }
    }
}
