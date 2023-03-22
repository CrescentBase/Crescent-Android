package com.crescent.content;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.crescent.core.R;

import java.lang.reflect.Method;

public class MailOldActivity extends Activity {
    private static final String TAG = "=====MailActivity";
    private static final boolean DEBUG = true;
    private static final boolean SHOW_DIALOG = false;
    private static final boolean CLEAR_WEB_COOKIE = false;

    private static final String TEST_URL = "https://www.baidu.com/";
    private static final String GMAIL_URL = "https://mail.google.com/";//"https://www.baidu.com";//
    private static final String QQ_URL = "https://mail.qq.com/";//"https://mail.qq.com/";
    private static final String OUTLOOK_URL = "https://outlook.live.com/owa/?nlp=1";

    private static final String TEST_JS_1 = "" +
            "async function sdk4337Fun() {" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*2000+300)));" +
            "document.location = \"js4377://webview?arg1=test&arg2=end\" " +
            "}; " +
            "sdk4337Fun();";

    private static final String TEST_JS = "" +
            "async function sdk4337Fun() {" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));" +
            "prompt(\"js4337://4337sdk?arg1=test&arg2=begin\");" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));" +
            "prompt(\"js4337://4337sdk?arg1=test&arg2=end\")" +
            "}; " +
            "sdk4337Fun();";

    private static final String GMAIL_JS = "" +
            "async function sdk4337Fun(isAndroid) {" +
            "if (window.hasSend4337 != true && (!document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') || document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length <= 0)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));}" +
            "if (window.hasSend4337 != true && (!document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') || document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length <= 0)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+4000)));}" +
            "if (window.hasSend4337 != true && document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') && document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length > 0) {" +
            "if (isAndroid) {prompt('js4337://4337sdk?arg1=gmail&arg2=begin');} else {window.webkit.messageHandlers.CsCallBack.postMessage('gmail;begin');}" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
            "document.getElementsByClassName('Gl d Pp Ze nm ol kl  ')[0].click();" +
            "var account = document.getElementsByClassName('il bk KA hf')[0].innerHTML;" +
            "if (isAndroid) {prompt('js4337://4337sdk?arg1=gmail&arg2=account&arg3=' + account);} else {window.webkit.messageHandlers.CsCallBack.postMessage('gmail;account;' + account);}" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));" +
            "if (!document.getElementsByClassName('oj Vp hf')[0]) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));}" +
            "if (!document.getElementsByClassName('oj Vp hf')[0]) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+3000)));}" +
            "if (!document.getElementsByClassName('oj Vp hf')[0]) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+6000)));}" +
            "document.getElementsByClassName('oj Vp hf')[0].click();" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+800)));" +
            "document.getElementsByClassName(\"Gl d Pp Ze nm ol Sb\")[0].click();" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
            "document.querySelector(\".Mt .Ll.Ou\").value = \"cyh2023@163.com\";" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
            "document.querySelector(\".Bt.Ut .Ql\").value = \"test1 theme\";" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
            "document.querySelector(\".Vt .Nl\").innerHTML = \"test1 content…\" + new Date().getTime();" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
            "document.querySelector(\".Gl.d.Pp.Ze.nm.ul.Mb\").click();" +
            "window.hasSend4337 = true; " +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*2000+300)));" +
            "if (isAndroid) {prompt('js4337://4337sdk?arg1=gmail&arg2=end');} else {window.webkit.messageHandlers.CsCallBack.postMessage('gmail;end');}" +
            "}" +
            "}; ";

    private static final String QQ_JS =
            "async function myFun() {" +
                    "if (document.querySelector(\"#composebtn\")) {" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+600)));" +
                    "location.href = document.querySelector(\"#composebtn\").href;" +
                    "}" +
                    "};" +
                    "myFun();";

    private static final String QQ_JS_2 =
            "async function myFun() {" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "document.querySelector('#mainFrameContainer iframe').contentDocument.querySelector('#toAreaCtrl .js_input').value = 'cyh2023@163.com';" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+600)));" +
                    "document.querySelector('#mainFrameContainer iframe').contentDocument.querySelector('#subject').value = 'from qq test subject';" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+600)));" +
                    "document.querySelector('#mainFrameContainer iframe').contentDocument.querySelector('#QMEditorArea iframe').contentDocument.body.querySelector('div').innerHTML = 'from qq test content';" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+600)));" +
                    "document.querySelector('#mainFrameContainer iframe').contentDocument.querySelector('#toolbar .btn_gray.btn_space').click();" +
                    "};" +
                    "myFun();";
    private static final String OUTLOOK_JS =
            "async function sdk4337Fun(isAndroid) {" +
                    "if (isAndroid) {prompt('js4337://4337sdk?arg1=outlook&arg2=begin');} else {window.webkit.messageHandlers.CsCallBack.postMessage('outlook;begin');}" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+3000)));" +
                    "if (!window.hasSend4337 && (!document.getElementById('innerRibbonContainer') || !document.getElementById('innerRibbonContainer').querySelectorAll('button') || document.getElementById('innerRibbonContainer').querySelectorAll('button').length <= 1)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));}" +
                    "if (!window.hasSend4337 && (!document.getElementById('innerRibbonContainer') || !document.getElementById('innerRibbonContainer').querySelectorAll('button') || document.getElementById('innerRibbonContainer').querySelectorAll('button').length <= 1)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+5000)));}" +
                    "if (!window.hasSend4337 && document.getElementById('innerRibbonContainer') && document.getElementById('innerRibbonContainer').querySelectorAll('button') && document.getElementById('innerRibbonContainer').querySelectorAll('button').length > 1) {" +
                    "document.getElementById('O365_MainLink_Me').click();" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+4000)));};" +
                    "var account = document.getElementById('mectrl_currentAccount_secondary').innerHTML;" +
                    "if (isAndroid) {prompt('js4337://4337sdk?arg1=outlook&arg2=account&arg3=' + account);} else {window.webkit.messageHandlers.CsCallBack.postMessage('outlook;account;' + account);}" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
                    "document.getElementById('innerRibbonContainer').querySelectorAll('button')[1].click();" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));" +
                    "document.querySelector('.EditorClass').innerHTML = '514124773@qq.com';" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1300)));" +
                    "document.querySelector('[id^=editorParent] div').innerHTML = 'from outlook test content' + new Date().getTime();" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1300)));" +
                    "document.getElementById('ReadingPaneContainerId').querySelectorAll('[role=\"button\"]')[1].click();" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "document.querySelector('[id^=ok-]').click();" +
                    "window.hasSend4337 = true; " +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
                    "if (isAndroid) {prompt('js4337://4337sdk?arg1=outlook&arg2=end');} else {window.webkit.messageHandlers.CsCallBack.postMessage('outlook;end');}" +
                    "}" +
                    "};";

    private WebView mWebView;
    private LinearLayout mContentLayout;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean isPcUA = false;
    private String mailAccount = null;
    private boolean mHasInject = false;
    private int mMailTYPE = LoginActivity.TYPE_GMAIL;

    private ProgressDialog mLoadingDialog = null;

    //outlook发错了，容易被识别异常， 安卓跑通了，中间加载延时比较长；ios还没跑
    //andorid qq加载不出来；qq邮箱location原因，会重新加载页面，所以拿到document.querySelector("#composebtn").href，webview需要重新加载网页，然后注入js搞事情；两边是分开跑

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = this.getIntent();
        mMailTYPE = intent.getIntExtra("mail_type", LoginActivity.TYPE_TEST);

        setContentView(R.layout.mail_activity);

        mContentLayout = (LinearLayout) findViewById(R.id.webview_layout);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        int minSize = Math.min(width, height);
        float scale = getResources().getDisplayMetrics().density;
        int pixelSize = (int) (12 * scale + 0.5f);

        mContentLayout.setLayoutParams(new LinearLayout.LayoutParams(minSize - pixelSize, minSize - pixelSize));

        isPcUA = true;
//        String chromeUserAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36";
        String chromeUserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299";

        mWebView = findViewById(R.id.webview);
        mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.getSettings().setDomStorageEnabled(true);
        int a = 1;
        mWebView.getSettings().setUserAgentString(getUserAgentString());


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            WebView.enableSlowWholeDocumentDraw();
//        }
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            // for Android 8 and above, you need to enable cleartext traffic in your app's manifest file
//            // to allow HTTP connections
//            WebView.setWebContentsDebuggingEnabled(true);
//            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
//        }

//        mWebView.setBackgroundColor(Color.TRANSPARENT);
//        mWebView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
//        gradientDrawable.setCornerRadius(10f);
//        mWebView.setBackground(gradientDrawable);

//        mWebView.setWebViewClient(mInsideWebViewClient);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view,
                                           SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String a = view.getSettings().getUserAgentString();
//                Log.e(TAG, "==shouldOverrideUrlLoading = " + a);
//                view.getSettings().setUserAgentString("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.loadUrl(OUTLOOK_URL);
        if (true) {
            return;
        }

//        syncSetting(mWebView.getSettings());
//        syncStaticSettings(this, mWebView.getSettings());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            WebView.enableSlowWholeDocumentDraw();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // for Android 8 and above, you need to enable cleartext traffic in your app's manifest file
            // to allow HTTP connections
            WebView.setWebContentsDebuggingEnabled(true);
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        }

        mWebView.setBackgroundColor(Color.TRANSPARENT);
        mWebView.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        GradientDrawable gradientDrawable1 = new GradientDrawable();
        gradientDrawable1.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable1.setCornerRadius(10f);
        mWebView.setBackground(gradientDrawable1);
//
//
        mWebView.setWebViewClient(mInsideWebViewClient);
//        mWebView.setWebChromeClient(mWebChromeClient);
//        if (true) {
//            mWebView.loadUrl("http://192.168.2.43:5849/index.html");
////            mWebView.loadUrl("file:///android_asset/index.html");
//            return;
//        }



        if (CLEAR_WEB_COOKIE) {
            mWebView.clearCache(true);
            mWebView.clearHistory();
            CookieSyncManager.createInstance(this);
            CookieManager.getInstance().removeAllCookie();
        }

        String url = TEST_URL;
        if (mMailTYPE == LoginActivity.TYPE_GMAIL) {
            url = GMAIL_URL;
        } else if (mMailTYPE == LoginActivity.TYPE_OUTLOOK) {
            url = OUTLOOK_URL;
            isPcUA = true;
        } else if (mMailTYPE == LoginActivity.TYPE_QQ) {
            url = QQ_URL;
            isPcUA = true;
        }

        isPcUA = true;
        if (isPcUA) {
            mWebView.getSettings().setUserAgentString(getUserAgentString());
        }

        url = OUTLOOK_URL;
//        Log.e(TAG, url);
        mWebView.loadUrl(url);
//        mWebView.loadUrl("file:///android_asset/oldindex.html");
    }

    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            Uri uri = Uri.parse(message);
            if (uri.getScheme().equals("js4337")) {
                if (uri.getAuthority().equals("4337sdk")) {
                    if (TextUtils.equals(uri.getQueryParameter("arg2"), "end")) {
                        final String mailName = uri.getQueryParameter("arg1");
//                        Log.e(TAG, "onJsPrompt end mailName = " + mailName + "; mailAccount = " + mailAccount);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (mLoadingDialog != null) {
                                    mLoadingDialog.hide();
                                }
                                Toast.makeText(MailOldActivity.this, "创建成功", Toast.LENGTH_LONG).show();
                            }
                        });

                    } else if (TextUtils.equals(uri.getQueryParameter("arg2"), "begin")) {
//                        Log.e(TAG, "onJsPrompt begin to send");
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (SHOW_DIALOG) {
                                    if (mLoadingDialog == null) {
                                        mLoadingDialog = ProgressDialog.show(MailOldActivity.this, "",
                                                "Loading. Create Wallet...", true);
                                    }
                                    mLoadingDialog.show();
                                    mWebView.setVisibility(View.INVISIBLE);
                                }
                            }
                        });
                    } else if (TextUtils.equals(uri.getQueryParameter("arg2"), "account")) {
                        mailAccount = uri.getQueryParameter("arg3");
                    }
                }
                result.confirm();
                return true;//super.onJsPrompt(view, url, message, defaultValue, result);
            }
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }
    };

    private WebViewClient mInsideWebViewClient = new WebViewClient() {

//        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//            Log.e(TAG, "shouldOverrideUrlLoading 2 url = " + request.getUrl().getHost());
//            return false;
            return super.shouldOverrideUrlLoading(view, request);
        }
//
//        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            String a = view.getSettings().getUserAgentString();
//            Log.e(TAG, "shouldOverrideUrlLoading ua = " + a);
            view.loadUrl(url);

//            Log.e(TAG, "shouldOverrideUrlLoading url = " + url);
            return true;
//            view.loadUrl(url);
//            return false;
//            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            mWebView.loadUrl("javascript:var parent = document.getElementsByTagName('head').item(0);\n" +
//                    "    var a = parent.getElementsByTagName('script').item(0);\n" +
//                    "    parent.removeChild(a);");
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
//            Log.e(TAG, "====page url = " + url);
            if (true) {
                super.onPageFinished(view, url);
                return;
            }
//            mWebView.loadUrl("javascript:(function() {" +
//                    "var parent = document.getElementsByTagName('head').item(0);" +
//                    "var style = document.createElement('style');" +
//                    "style.type = 'text/css';" +
//                    "style.innerHTML = window.atob('" + qrcss + "');" +
//                    "parent.appendChild(style)" +
//                    "})()");
//            mWebView.loadUrl("javascript:var parent = document.getElementsByTagName('head').item(0);\n" +
//                    "    var a = parent.getElementsByTagName('script').item(0);\n" +
//                    "    parent.removeChild(a);");
            String injectJs = null;
            if (mMailTYPE == LoginActivity.TYPE_GMAIL) {
                if (!mHasInject && url.startsWith("https://mail.google.com/mail/mu/mp/")) {
                    injectJs = GMAIL_JS;
                    mHasInject = true;
                }
            } else if (mMailTYPE == LoginActivity.TYPE_OUTLOOK) {
                if (!mHasInject && TextUtils.equals(url, "https://outlook.live.com/mail/0/")) {
                    injectJs = OUTLOOK_JS;
                    mHasInject = true;
                }
            } else if (mMailTYPE == LoginActivity.TYPE_QQ) {
                injectJs = QQ_JS;
            } else if (mMailTYPE == LoginActivity.TYPE_TEST) {
                injectJs = TEST_JS;
            }
            if (injectJs != null) {
                mWebView.loadUrl("javascript:" + injectJs + "sdk4337Fun(true);");
            }
            super.onPageFinished(view, url);
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void syncSetting(WebSettings settings) {
        settings.setJavaScriptEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setDefaultTextEncodingName(getDefaultTextEncoding());
        settings.setPluginState(getPluginState());
        settings.setJavaScriptCanOpenWindowsAutomatically(JSCanOpenWindow());
//        settings.setLoadsImagesAutomatically(loadImagesAutomatically());
        settings.setLoadWithOverviewMode(loadPageInOverviewMode());
        settings.setSavePassword(isRememberPasswords());
        settings.setSaveFormData(isSaveFormdata());
        settings.setUseWideViewPort(isWideViewport());

        if (isPcUA) {
            settings.setUserAgentString(getUserAgentString());
        }
    }

    private boolean enableJavascript() {
        return true;
    }

    private String getUserAgentString() {
        if (isPcUA) {
//            return "Mozilla/5.0 (X11; Linux aarch64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.188 Safari/537.36 CrKey/1.54.250320";
            return "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36";
//            return "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36";
        }
        return null;
    }

    private boolean isWideViewport() {
        return true;
    }

    private boolean isSaveFormdata() {
        return true;
    }

    private boolean isRememberPasswords() {
        return true;
    }

    private boolean loadPageInOverviewMode() {
        return true;
    }


    private boolean JSCanOpenWindow() {
        return false;
    }

    private WebSettings.PluginState getPluginState() {
        return WebSettings.PluginState.valueOf("ON_DEMAND");
    }

    private String getDefaultTextEncoding() {
        return "GBK";
    }

    private boolean enableGeolocation() {
        return true;
    }



    private void syncStaticSettings(Context context, WebSettings settings) {
        // Enable the built-in zoom
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);

        // 禁止页面自己弹出新的窗口，新的标签只能由用户手动打开，这样同时可以避免一些chrome内核问题
        settings.setSupportMultipleWindows(false);

        settings.setDefaultFontSize(16);
        settings.setDefaultFixedFontSize(13);
        // Normal Font Size
        settings.setTextZoom(100);

        // WebView inside Browser doesn't want initial focus to be set.
        settings.setNeedInitialFocus(false);

        // enable smooth transition for better performance during panning or zooming
        settings.setEnableSmoothTransition(true);
        settings.setAllowContentAccess(false);

        // HTML5 API flags
        settings.setAppCacheEnabled(true);
        String dbPath = context.getDir("database", Context.MODE_PRIVATE).getPath();
        settings.setDatabasePath(dbPath);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCachePath(context.getDir("appcache", 0).getPath());
        settings.setDatabasePath(context.getDir("databases", 0).getPath());
        settings.setGeolocationDatabasePath(context.getDir("geolocation", 0).getPath());

        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);

        try {
            /**
             * 在高版本的Android系统中，默认禁止一个secure的origin加载其他origin的insecure的内容， 这回会导致有些网页内容显示不全，例如腾讯新闻的页面；
             * 暂时将这个标志为设成Mix Mode, 如果还有问题，可以考虑尝试Always Allow的标志位。
             */
            // settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            Method method = initMethod(null, settings.getClass(), "setMixedContentMode", int.class);
            method.invoke(settings, 2);
        } catch (Exception e) {
        }
    }

    public Method initMethod(Method method, Class<?> clazz,
                             String name, Class<?>... parameterTypes)
            throws NoSuchMethodException {
        if (method == null) {
            method = clazz.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
        }

        return method;
    }

    public void myFunClick(View e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                MyPlugin.getInstance().sendCallMsg();
//                MyPlugin.getInstance().sendMessage2Unity("new-new-new");
//                boolean a = MyPlugin.getInstance().callUnity("BtnScript", "callBackAndroid", "right--");
//                android.util.Log.e(TAG, "===myFunClick = " + a);
            }
        });
    }

}
