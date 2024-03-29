package com.crescent.content;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.crescent.core.CrescentSdk;
import com.crescent.core.R;
import com.crescent.core.TransactionInfo;
import com.crescent.core.TransactionResult;
import com.crescent.core.UserInfo;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.crescent.content.EmailBean.AOL_JS;
import static com.crescent.content.EmailBean.AOL_JS_CLICKCOMPOSE;
import static com.crescent.content.EmailBean.AOL_JS_GETACCOUNT;
import static com.crescent.content.EmailBean.AOL_URL;
import static com.crescent.content.EmailBean.GMAIL_JS;
import static com.crescent.content.EmailBean.GMAIL_URL;
import static com.crescent.content.EmailBean.MAIL163_HIDE_JS;
import static com.crescent.content.EmailBean.MAIL163_URL;
import static com.crescent.content.EmailBean.MAIL163_JS;
import static com.crescent.content.EmailBean.OUTLOOK_JS;
import static com.crescent.content.EmailBean.OUTLOOK_URL;
import static com.crescent.content.EmailBean.QQ_JS;
import static com.crescent.content.EmailBean.TEST_JS;
import static com.crescent.content.EmailBean.TYPE_163;
import static com.crescent.content.EmailBean.TYPE_AOL;
import static com.crescent.content.EmailBean.TYPE_GMAIL;
import static com.crescent.content.EmailBean.TYPE_OUTLOOK;
import static com.crescent.content.EmailBean.TYPE_QQ;
import static com.crescent.content.EmailBean.TYPE_TEST;
import static com.crescent.content.EmailBean.TYPE_YAHOO;
import static com.crescent.content.EmailBean.YAHOO_JS;
import static com.crescent.content.EmailBean.YAHOO_JS_CLICKCOMPOSE;
import static com.crescent.content.EmailBean.YAHOO_JS_GETACCOUNT;
import static com.crescent.content.EmailBean.YAHOO_URL;

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

    private boolean mHasPreInject = false;

    private boolean mHasPreInject2 = false;
    private boolean mHasShowLoading = false;
    private String publicKey = null;
    private String walletKeytore = null;
    private int mMailTYPE = TYPE_GMAIL;
    private boolean mHasGetAccount = false;

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
                if (!mHasGetAccount || walletKeytore != null) {
                    finish();
                }
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
                        LogU.e(TAG, "onJsPrompt: " + message);
                        String emailUrl = null;
                        if (message != null) {
                            String[] parts = message.split(";", 2);
                            if (parts.length == 2) {
                                if (TextUtils.equals(parts[0], "url")) {
                                    final String urlLink = parts[1];
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlLink));
                                    startActivity(intent);
                                    result.confirm();
                                    return true;
                                }
                                if (TextUtils.equals(parts[0], "error")) {
                                    Toast.makeText(CrescentActivity.this, "Failed to create wallet, please try again", Toast.LENGTH_LONG).show();
                                    mReactWeb.clearWebCache();
                                    finish();
                                    result.confirm();
                                    return true;
                                }
                                if (TextUtils.equals(parts[0], "walletKeystore")) {
                                    walletKeytore = parts[1];
                                    result.confirm();
                                    return true;
                                }
                                if (TextUtils.equals(parts[0], "print")) {
                                    String printInfo = parts[1];
                                    android.util.Log.d("==Crescent", printInfo);
                                    result.confirm();
                                    return true;
                                }
                                if (TextUtils.equals(parts[0], "sendTx")) {
                                    String sendHash = parts[1];
                                    if (sendHash != null && CrescentSdk.getInstance().getTransactionCallback() != null) {
                                        TransactionResult sendResult = new TransactionResult(sendHash);
                                        CrescentSdk.getInstance().getTransactionCallback().onSendSuccess(sendResult);
                                    }
                                    result.confirm();
                                    return true;
                                }
                                if (TextUtils.equals(parts[0], "pasteboard")) {
                                    String pasteboardText = parts[1];
                                    // 获取剪贴板管理器
                                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                    ClipData clip = ClipData.newPlainText("label", pasteboardText);
                                    clipboard.setPrimaryClip(clip);
                                    result.confirm();
                                    return true;
                                }
                                if (TextUtils.equals(parts[0], "userInfo")) {
                                    String userInfoJson = parts[1];
                                    try {
                                        JSONObject jsonObject = new JSONObject(userInfoJson);
                                        String email = jsonObject.getString("email");
                                        String address = jsonObject.getString("address");
                                        SharedPreferences preferences = getSharedPreferences(EmailBean.SP_BASE_USER_INFO, Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = preferences.edit();
                                        editor.putString(EmailBean.SP_EMAIL_KEY, email);
                                        editor.putString(EmailBean.SP_ADDRESS_KEY, address);
                                        editor.apply();
                                        if (CrescentSdk.getInstance().getConnectCallback() != null) {
                                            UserInfo info = new UserInfo(email, address);
                                            CrescentSdk.getInstance().getConnectCallback().onConnectSuccess(info);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                    result.confirm();
                                    return true;
                                }
                                if (TextUtils.equals(parts[0], "gmail")) {
                                    if (publicKey != null) {
                                        result.confirm();
                                        return true;
                                    }
                                    isPcUA = false;
                                    mMailTYPE = TYPE_GMAIL;
                                    emailUrl = GMAIL_URL;
                                    publicKey = parts[1];
                                } else if (TextUtils.equals(parts[0], "outlook")) {
                                    if (publicKey != null) {
                                        result.confirm();
                                        return true;
                                    }
                                    isPcUA = true;
                                    mMailTYPE = TYPE_OUTLOOK;
                                    emailUrl = OUTLOOK_URL;
                                    publicKey = parts[1];
                                } else if (TextUtils.equals(parts[0], "mail163")) {
                                    if (publicKey != null) {
                                        result.confirm();
                                        return true;
                                    }
                                    mMailTYPE = TYPE_163;
                                    emailUrl = MAIL163_URL;
                                    publicKey = parts[1];
                                } else if (TextUtils.equals(parts[0], "yahoo")) {
                                    if (publicKey != null) {
                                        result.confirm();
                                        return true;
                                    }
                                    mMailTYPE = TYPE_YAHOO;
                                    emailUrl = YAHOO_URL;
                                    publicKey = parts[1];
                                } else if (TextUtils.equals(parts[0], "aol")) {
                                    if (publicKey != null) {
                                        result.confirm();
                                        return true;
                                    }
                                    mMailTYPE = TYPE_AOL;
                                    emailUrl = AOL_URL;
                                    publicKey = parts[1];
                                } else {
                                    result.confirm();
                                    return true;
                                }
                                mEmailWeb.getWebCreator().getWebView().getSettings().setUserAgentString(getUserAgentString());
                                mEmailWeb.getUrlLoader().loadUrl(emailUrl);
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (!mHasInject && !mHasShowLoading) {
                                            mReactLayout.setVisibility(View.INVISIBLE);
                                            mEamilWrapLayout.setVisibility(View.VISIBLE);
                                        }
                                    }
                                }, 3000);
                            }
                        }

                        result.confirm();
                        return true;
                    }
                }).setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        final JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("width", webContentSize);
                            jsonObject.put("height", webContentSize);
                            jsonObject.put("paymasterUrl", CrescentSdk.getInstance().getConfig().paymasterUrl);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (CrescentSdk.getInstance().isConnected(CrescentActivity.this)) {
                            TransactionInfo tx = CrescentSdk.getInstance().getTx();
                            if (tx != null) {
                                try {
                                    JSONObject txObject = new JSONObject();
                                    txObject.put("to", tx.to);
                                    txObject.put("chainId", tx.chainId);
                                    txObject.put("data", tx.data);
                                    txObject.put("value", tx.value);
                                    jsonObject.put("tx", txObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
//                            android.util.Log.d("===jsonObject = ", jsonObject.toString());
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    mReactWeb.getJsAccessEntrace().quickCallJs("initLoad", jsonObject.toString());
                                }
                            });
                        } else {
//                            android.util.Log.d("===jsonObject = ", jsonObject.toString());
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    mReactWeb.getJsAccessEntrace().quickCallJs("loadSelectEmail", jsonObject.toString());
                                }
                            });

                        }

                    }
                })
                .createAgentWeb()
                .ready()
                .go(htmlFileName);
//                .go("http://192.168.2.43:5918/index.html");


        final int radiusPixelSize = (int) (20 * density + 0.5f);
        mEmailWeb = AgentWeb.with(this).setAgentWebParent(mEmailLayout, new LinearLayout.LayoutParams(webviewSize - radiusPixelSize, webviewSize - radiusPixelSize))
                .closeIndicator().setWebChromeClient(mEmailWebChromeClient).setWebViewClient(mEmailWebViewClient)
                .createAgentWeb()
                .get();
        if (!CrescentSdk.getInstance().isConnected(this)) {
            mEmailWeb.clearWebCache();
        }
        if (CLEAR_WEB_COOKIE) {
            mEmailWeb.clearWebCache();
        }
    }

    private WebChromeClient mEmailWebChromeClient = new WebChromeClient() {
        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            Uri uri = Uri.parse(message);
            LogU.e(TAG, "===message = " + message);
            if (uri.getScheme().equals("js4337")) {
                if (uri.getAuthority().equals("4337sdk")) {
                    if (TextUtils.equals(uri.getQueryParameter("arg2"), "end")) {
                        final String mailName = uri.getQueryParameter("arg1");
//                        Log.e(TAG, "onJsPrompt end mailName = " + mailName + "; mailAccount = " + mailAccount);

                    } else if (TextUtils.equals(uri.getQueryParameter("arg2"), "begin")) {
                    } else if (TextUtils.equals(uri.getQueryParameter("arg2"), "account")) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mailAccount = uri.getQueryParameter("arg3");
//                        android.util.Log.e(TAG, "backContnet = " + mailAccount);
                                mHasGetAccount = true;
                                HashMap<String, String> map = new HashMap<>();
                                map.put("width", String.valueOf(webContentSize));
                                map.put("height", String.valueOf(webContentSize));
                                map.put("initView", "CreateLoading");
                                map.put("emailAccount", mailAccount);
                                map.put("paymasterUrl", CrescentSdk.getInstance().getConfig().paymasterUrl);
                                mReactWeb.getJsAccessEntrace().quickCallJs("loadMain", mapToString(map));
//                                Toast.makeText(CrescentActivity.this, "创建成功", Toast.LENGTH_LONG).show();
                                mReactLayout.setVisibility(View.VISIBLE);
                                mEamilWrapLayout.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                }
                result.confirm();
                return true;
            }
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }
    };

    private void showLoading() {
        if (mHasShowLoading) {
            return;
        }
        mHasShowLoading = true;
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                HashMap<String, String> map = new HashMap<>();
                map.put("width", String.valueOf(webContentSize));
                map.put("height", String.valueOf(webContentSize));
                mReactLayout.setVisibility(View.VISIBLE);
                mEamilWrapLayout.setVisibility(View.INVISIBLE);
                mReactWeb.getJsAccessEntrace().quickCallJs("loadLoading", mapToString(map));
            }
        });
    }


    private WebViewClient mEmailWebViewClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                LogU.e(TAG, "shouldOverrideUrlLoading1 = " + request.getUrl().toString());
//                view.loadUrl(request.getUrl().toString());
            }
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            LogU.e(TAG, "shouldOverrideUrlLoading2 = " + url);
//            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            LogU.e(TAG, "====page url = " + url);
            String injectJs = null;
            String receiverEmail = "crescentweb3@gmail.com";
            if (mMailTYPE == TYPE_GMAIL) {
                if (url.startsWith("https://mail.google.com/mail/mu/mp/")) {
                    injectJs = GMAIL_JS;
                    receiverEmail = "crescentweb3@zohomail.cn";
                }
            } else if (mMailTYPE == TYPE_OUTLOOK) {
                if (url.startsWith("https://outlook.live.com/mail/0/")) {
                    injectJs = OUTLOOK_JS;
                }
            } else if (mMailTYPE == TYPE_QQ) {
                injectJs = QQ_JS;
            } else if (mMailTYPE == TYPE_TEST) {
                injectJs = TEST_JS;
            } else if (mMailTYPE == TYPE_163) {
                if (url.startsWith("https://mail.163.com/m/main.jsp")) {
                    injectJs = MAIL163_JS;
                } else if (!mHasPreInject && url.startsWith("https://smart.mail.163.com/login.htm")) {
                    mHasPreInject = true;
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final String funcName = "hideTopInstall();";
                            mEmailWeb.getUrlLoader().loadUrl("javascript:" + MAIL163_HIDE_JS + funcName);
                        }
                    }, 200);

                }
            } else if (mMailTYPE == TYPE_YAHOO) {
                if (url.startsWith("https://mail.yahoo.com/mb/compose") || url.startsWith("https://canary-mg.mail.yahoo.com/mb/compose")) {
                    injectJs = YAHOO_JS;
                } else if (!mHasPreInject && (url.startsWith("https://mail.yahoo.com/mb/listfolders/") || url.startsWith("https://canary-mg.mail.yahoo.com/mb/listfolders/"))) {
                    mHasPreInject = true;
                    showLoading();
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final String funcName = "sdk4337GetAccount(true);";
                            mEmailWeb.getUrlLoader().loadUrl("javascript:" + YAHOO_JS_GETACCOUNT + funcName);
                        }
                    }, 200);
                } else if (!mHasPreInject2 && (url.startsWith("https://mail.yahoo.com/mb/folders/") || url.startsWith("https://canary-mg.mail.yahoo.com/mb/folders/"))) {
                    mHasPreInject2 = true;
                    showLoading();
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final String funcName = "sdk4337ClickCompose();";
                            mEmailWeb.getUrlLoader().loadUrl("javascript:" + YAHOO_JS_CLICKCOMPOSE + funcName );
                        }
                    }, 200);
                }
            } else if (mMailTYPE == TYPE_AOL) {
                if (url.startsWith("https://mail.aol.com/mb/compose") || url.startsWith("https://canary-mg.mail.aol.com/mb/compose")) {
                    injectJs = AOL_JS;
                } else if (!mHasPreInject && (url.startsWith("https://mail.aol.com/mb/listfolders/") || url.startsWith("https://canary-mg.mail.aol.com/mb/listfolders/"))) {
                    mHasPreInject = true;
                    showLoading();
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final String funcName = "sdk4337GetAccount(true);";
                            mEmailWeb.getUrlLoader().loadUrl("javascript:" + AOL_JS_GETACCOUNT + funcName);
                        }
                    }, 200);
                } else if (!mHasPreInject2 && (url.startsWith("https://mail.aol.com/mb/folders/") || url.startsWith("https://canary-mg.mail.aol.com/mb/folders/"))) {
                    mHasPreInject2 = true;
                    showLoading();
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            final String funcName = "sdk4337ClickCompose();";
                            mEmailWeb.getUrlLoader().loadUrl("javascript:" + AOL_JS_CLICKCOMPOSE + funcName );
                        }
                    }, 200);
                }
            }
            if (injectJs != null && !mHasInject) {
                mHasInject = true;
                showLoading();

                final String funcName = "sdk4337Fun(true, '"+ receiverEmail+ "', '" + publicKey +"');";
//                android.util.Log.e(TAG, "===funcitonName = " + funcName);
//                android.util.Log.e(TAG, "===injectJs = " + injectJs);
                final String newInjectJs = injectJs;
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mEmailWeb.getUrlLoader().loadUrl("javascript:" + newInjectJs + funcName);
                    }
                }, 1500);

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
            if (mMailTYPE == mMailTYPE) {
                long currentTimeMillis = System.currentTimeMillis();
                String currentTimeString = Long.toString(currentTimeMillis);
                String lastFiveDigits = currentTimeString.substring(currentTimeString.length() - 5);
                return "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16." + lastFiveDigits;
            } else {
                return "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36";
            }
        }
        return null;
    }
}
