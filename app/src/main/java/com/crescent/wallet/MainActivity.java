package com.crescent.wallet;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.crescent.core.CrescentConfigure;
import com.crescent.core.CrescentSdk;
import com.crescent.core.LoginCallback;
import com.crescent.core.SendTransactionCallback;
import com.crescent.core.TransactionInfo;

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
                CrescentConfigure config = new CrescentConfigure(this);
                CrescentSdk.getInstance().init(config);
                break;
            case R.id.loginBtn:
                CrescentSdk.getInstance().login(new LoginCallback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onFail() {
                        Log.d(TAG, "login onFail");
                    }
                });
                break;
            case R.id.logoutBtn:
                CrescentSdk.getInstance().logout();
                break;
            case R.id.sendTransaction:
                TransactionInfo info = new TransactionInfo(null, null, null, null);
                CrescentSdk.getInstance().sendTransaction(info, new SendTransactionCallback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onFail() {
                        Log.d(TAG, "sendTransaction onFail");
                    }
                });
                break;
        }
    }
}
