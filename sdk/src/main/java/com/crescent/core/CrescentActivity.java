package com.crescent.core;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JsPromptResult;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;

import java.util.HashMap;
import java.util.Map;

import static com.crescent.core.EmailBean.GMAIL_JS;
import static com.crescent.core.EmailBean.GMAIL_URL;
import static com.crescent.core.EmailBean.OUTLOOK_JS;
import static com.crescent.core.EmailBean.OUTLOOK_URL;
import static com.crescent.core.EmailBean.QQ_JS;
import static com.crescent.core.EmailBean.TEST_JS;
import static com.crescent.core.EmailBean.TYPE_GMAIL;
import static com.crescent.core.EmailBean.TYPE_OUTLOOK;
import static com.crescent.core.EmailBean.TYPE_QQ;
import static com.crescent.core.EmailBean.TYPE_TEST;

public class CrescentActivity extends Activity {
    private static final String TAG = "=====CrescentActivity";
    private static final boolean CLEAR_WEB_COOKIE = false;
    private RelativeLayout mBaseLayout;
    private LinearLayout mReactLayout;
    private LinearLayout mEmailLayout;
    private LinearLayout mEamilWrapLayout;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean isPcUA = false;
    private String mailAccount = null;
    private boolean mHasInject = false;
    private String publicKey = null;
    private int mMailTYPE = TYPE_GMAIL;

    int minPixelsSize = 0;
    float density = 0;
    int minDpSize = 0;
    int paddingDipSize = 0;
    int paddingPixelSize = 0;
    int webContentSize = 0;
    int webviewSize = 0;

    private AgentWeb mReactWeb;
    private AgentWeb mEmailWeb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_activity);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        minPixelsSize = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        density = displayMetrics.density;
        minDpSize = (int) (minPixelsSize / density);  // 屏幕宽度(dp)
        paddingDipSize = 12;
        paddingPixelSize = (int) (paddingDipSize * density + 0.5f);
        webContentSize = minDpSize - paddingDipSize;
        webviewSize = minPixelsSize - paddingPixelSize;

        mBaseLayout = findViewById(R.id.base_layout);
        mBaseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mReactLayout = findViewById(R.id.webview_layout);
        mEmailLayout = findViewById(R.id.webview_email_layout);
        mEamilWrapLayout = findViewById(R.id.email_wrap_layout);
        mEamilWrapLayout.setVisibility(View.INVISIBLE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            WebView.enableSlowWholeDocumentDraw();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WebView.setWebContentsDebuggingEnabled(true);
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        }

        String htmlFileName = "file:///android_asset/index.html";

        mReactWeb = AgentWeb.with(this).setAgentWebParent(mReactLayout, new LinearLayout.LayoutParams(webviewSize, webviewSize))
                .closeIndicator().setWebChromeClient(new WebChromeClient() {
                    @Override
                    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                        Log.e(TAG, "onJsPrompt: " + message);
                        String emailUrl = null;
                        if (message != null) {
                            String[] parts = message.split(";");
                            if (parts.length == 2) {
                                if (TextUtils.equals(parts[0], "url")) {
                                    final String urlLink = parts[1];
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlLink));
                                    startActivity(intent);
                                    result.confirm();
                                    return true;
                                }
                                if (TextUtils.equals(parts[0], "gmail")) {
                                    isPcUA = false;
                                    mMailTYPE = TYPE_GMAIL;
                                    emailUrl = GMAIL_URL;
                                    publicKey = parts[1];
                                } else if (TextUtils.equals(parts[0], "outlook")) {
                                    isPcUA = true;
                                    mMailTYPE = TYPE_OUTLOOK;
                                    emailUrl = OUTLOOK_URL;
                                    publicKey = parts[1];
                                } else {
                                    result.confirm();
                                    return true;
                                }
                                mEmailWeb.getWebCreator().getWebView().getSettings().setUserAgentString(getUserAgentString());
                                mEmailWeb.getUrlLoader().loadUrl(emailUrl);
                                mReactLayout.setVisibility(View.INVISIBLE);
                                mEamilWrapLayout.setVisibility(View.VISIBLE);
                            }
                        }

                        result.confirm();
                        return true;
                    }
                }).setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);

                        HashMap<String, String> map = new HashMap<>();
                        map.put("width", String.valueOf(webContentSize));
                        map.put("height", String.valueOf(webContentSize));
                        mReactWeb.getJsAccessEntrace().quickCallJs("initLoad", mapToString(map));
                    }
                })
                .createAgentWeb()
                .ready()
//                .go(htmlFileName);
                .go("http://192.168.2.43:613/index.html");

        final int radiusPixelSize = (int) (20 * density + 0.5f);
        mEmailWeb = AgentWeb.with(this).setAgentWebParent(mEmailLayout, new LinearLayout.LayoutParams(webviewSize - radiusPixelSize, webviewSize - radiusPixelSize))
                .closeIndicator().setWebChromeClient(mEmailWebChromeClient).setWebViewClient(mEmailWebViewClient)
                .createAgentWeb()
                .get();

        if (CLEAR_WEB_COOKIE) {
            mEmailWeb.clearWebCache();
        }

    }

    private WebChromeClient mEmailWebChromeClient = new WebChromeClient() {
        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            Uri uri = Uri.parse(message);
            if (uri.getScheme().equals("js4337")) {
                if (uri.getAuthority().equals("4337sdk")) {
                    if (TextUtils.equals(uri.getQueryParameter("arg2"), "end")) {
                        final String mailName = uri.getQueryParameter("arg1");
                        Log.e(TAG, "onJsPrompt end mailName = " + mailName + "; mailAccount = " + mailAccount);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                HashMap<String, String> map = new HashMap<>();
                                map.put("width", String.valueOf(webContentSize));
                                map.put("height", String.valueOf(webContentSize));
                                map.put("initView", "CreateLoading");
                                map.put("emailAccount", mailAccount);
//                                Log.e(TAG, "map = " + mapToString(map));
                                mReactWeb.getJsAccessEntrace().quickCallJs("loadMain", mapToString(map));
//                                Toast.makeText(CrescentActivity.this, "创建成功", Toast.LENGTH_LONG).show();
                                mReactLayout.setVisibility(View.VISIBLE);
                                mEamilWrapLayout.setVisibility(View.INVISIBLE);
                            }
                        });

                    } else if (TextUtils.equals(uri.getQueryParameter("arg2"), "begin")) {
                        Log.e(TAG, "onJsPrompt begin to send");
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                HashMap<String, String> map = new HashMap<>();
                                map.put("width", String.valueOf(webContentSize));
                                map.put("height", String.valueOf(webContentSize));
                                mReactWeb.getJsAccessEntrace().quickCallJs("loadLoading", mapToString(map));
                                mReactLayout.setVisibility(View.VISIBLE);
                                mEamilWrapLayout.setVisibility(View.INVISIBLE);
                            }
                        });
                    } else if (TextUtils.equals(uri.getQueryParameter("arg2"), "account")) {
                        mailAccount = uri.getQueryParameter("arg3");
                    }
                }
                result.confirm();
                return true;
            }
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }
    };

    private WebViewClient mEmailWebViewClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Log.e(TAG, "====page url = " + url);
            String injectJs = null;
            String receiverEmail = "crescentweb3@gmail.com";
            if (mMailTYPE == TYPE_GMAIL) {
                if (!mHasInject && url.startsWith("https://mail.google.com/mail/mu/mp/")) {
                    injectJs = GMAIL_JS;
                    receiverEmail = "crescentweb3@outlook.com";
                    mHasInject = true;
                }
            } else if (mMailTYPE == TYPE_OUTLOOK) {
                if (!mHasInject && TextUtils.equals(url, "https://outlook.live.com/mail/0/")) {
                    injectJs = OUTLOOK_JS;
                    mHasInject = true;
                }
            } else if (mMailTYPE == TYPE_QQ) {
                injectJs = QQ_JS;
            } else if (mMailTYPE == TYPE_TEST) {
                injectJs = TEST_JS;
            }
            if (injectJs != null) {
                String funcName = "sdk4337Fun(true, '"+ receiverEmail+ "', '" + publicKey +"');";
                mEmailWeb.getUrlLoader().loadUrl("javascript:" + injectJs + funcName);
//                mEmailWeb.getJsAccessEntrace().quickCallJs(injectJs + "sdk4337Fun", "true");
//                mWebView.loadUrl("javascript:" + injectJs + "sdk4337Fun(true);");
            }
            super.onPageFinished(view, url);
        }
    };

    @Override
    public void onBackPressed() {
//        if (mEamilWrapLayout.getVisibility() == View.VISIBLE) {
//            mEamilWrapLayout.setVisibility(View.INVISIBLE);
//            mReactLayout.setVisibility(View.VISIBLE);
//            return;
//        }
        super.onBackPressed();
    }

    private String mapToString(HashMap<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for(Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (!isNumeric(value)) {
               value = "'" + value + "'";
            }
            stringBuilder.append(entry.getKey())
                    .append(":")
                    .append(value)
                    .append(",");
        }
        String result = stringBuilder.toString();

        // 移除最后一个逗号
        if(result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        result = result + "}";
        return result;
    }

    public boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private String getUserAgentString() {
        if (isPcUA) {
            return "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36";
        }
        return null;
    }
}
