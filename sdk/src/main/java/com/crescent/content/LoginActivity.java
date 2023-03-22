package com.crescent.content;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;

import com.crescent.content.CrescentActivity;
import com.crescent.core.R;

public class LoginActivity extends Activity implements View.OnClickListener {
    public static final int TYPE_TEST = 0x10000;
    public static final int TYPE_GMAIL = 0x1;
    public static final int TYPE_OUTLOOK = 0x2;
    public static final int TYPE_QQ = 0x3;
    private LinearLayout mContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mContentLayout = (LinearLayout) findViewById(R.id.content_layout);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        int minSize = Math.min(width, height);
        float scale = getResources().getDisplayMetrics().density;
        int pixelSize = (int) (12 * scale + 0.5f);

        mContentLayout.setLayoutParams(new LinearLayout.LayoutParams(minSize - pixelSize, minSize - pixelSize));

        findViewById(R.id.test_btn).setOnClickListener(this);
        findViewById(R.id.gmail_btn).setOnClickListener(this);
        findViewById(R.id.outlook_btn).setOnClickListener(this);
        findViewById(R.id.qq_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int mailType = TYPE_TEST;
        if (v.getId() == R.id.test_btn) {

        } else if (v.getId() == R.id.gmail_btn) {
            mailType = TYPE_GMAIL;
        } else if (v.getId() == R.id.outlook_btn) {
            mailType = TYPE_OUTLOOK;
        } else if (v.getId() == R.id.qq_btn) {
            mailType = TYPE_QQ;
        }
//        Intent intent = new Intent(this, MailActivity.class);
//        if (v.getId() == R.id.qq_btn) {
//            intent = new Intent(this, OtherActivity.class);
//        } else {
//
//        }
        Intent intent = new Intent(this, CrescentActivity.class);
        intent.putExtra("mail_type", mailType);
        startActivity(intent);
    }
}

