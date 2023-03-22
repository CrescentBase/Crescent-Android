package com.crescent.content;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
//
//import org.jetbrains.annotations.NotNull;
//import org.mozilla.geckoview.GeckoResult;
//import org.mozilla.geckoview.GeckoRuntime;
//import org.mozilla.geckoview.GeckoRuntimeSettings;
//import org.mozilla.geckoview.GeckoSession;
//import org.mozilla.geckoview.GeckoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.crescent.core.R;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebView;

public class OtherActivity extends Activity {
//
//    private GeckoView geckoView;
//    private GeckoSession geckoSession;

    private AgentWebView webView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity);

        webView = findViewById(R.id.geckoview);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            WebView.enableSlowWholeDocumentDraw();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // for Android 8 and above, you need to enable cleartext traffic in your app's manifest file
            // to allow HTTP connections
            WebView.setWebContentsDebuggingEnabled(true);
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        }
//
//
//        geckoView = new GeckoView(this);
//        GeckoRuntime runtime = GeckoRuntime.getDefault(this);//GeckoRuntime.create(this);
//        geckoSession = new GeckoSession();
//        geckoSession.open(runtime);
//        geckoView.setSession(geckoSession);

        String htmlFileName = "file:///android_asset/index.html";
        String mimeType = "text/html";
        String encoding = "UTF-8";
        String baseUrl = "file:///android_asset/";

//        geckoSession.load();
//        geckoSession.loadDataWithBaseURL(baseUrl, htmlFileName, mimeType, encoding, null);


//        geckoSession.loadUri("resource://android/assets/index.html");
//        geckoSession.loadUri("http://192.168.2.43:5849/index.html");

        AgentWeb.with(this).setAgentWebParent((ViewGroup) webView, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go("http://192.168.2.43:5849/index.html");

//        geckoSession.setPromptDelegate(new GeckoSession.PromptDelegate() {
//            @Nullable
//            @org.jetbrains.annotations.Nullable
//            @Override
//            public GeckoResult<PromptResponse> onTextPrompt(@NonNull @NotNull GeckoSession geckoSession, @NonNull @NotNull TextPrompt textPrompt) {
//                String a = textPrompt.message;
//                android.util.Log.e("====textPrompt.message", textPrompt.message + textPrompt.title);
//                textPrompt.confirm("");
//                return null;
//            }
//
//            @Nullable
//            @org.jetbrains.annotations.Nullable
//            @Override
//            public GeckoResult<PromptResponse> onAlertPrompt(@NonNull @NotNull GeckoSession session, @NonNull @NotNull AlertPrompt prompt) {
//                android.util.Log.e("=onAlertPrompt.message", prompt.message + prompt.title);
//                return null;
//            }
//        });

    }
}
