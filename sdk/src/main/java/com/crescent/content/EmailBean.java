package com.crescent.content;

public class EmailBean {
    public static String SP_BASE_USER_INFO = "CRESCENT_SS_USER_INFO";
    public static String SP_EMAIL_KEY = "CRESCENT_SS_EMAIL_KEY";
    public static String SP_ADDRESS_KEY = "CRESCENT_SS_ADDRESS_KEY";

    public static final int TYPE_TEST = 0x10000;
    public static final int TYPE_GMAIL = 0x1;
    public static final int TYPE_OUTLOOK = 0x2;
    public static final int TYPE_QQ = 0x3;
    public static final int TYPE_163 = 0x4;
    public static final int TYPE_YAHOO = 0x5;
    public static final int TYPE_AOL = 0x6;

    public static final String TEST_URL = "https://www.baidu.com/";
    public static final String GMAIL_URL = "https://mail.google.com/";//"https://www.baidu.com";//
    public static final String QQ_URL = "https://mail.qq.com/";//"https://mail.qq.com/";
    public static final String OUTLOOK_URL = "https://outlook.live.com/owa/?nlp=1";
    public static final String MAIL163_URL = "https://smart.mail.163.com/login.htm";
    public static final String YAHOO_URL = "https://mail.yahoo.com/mb/listfolders/";
    public static final String AOL_URL = "https://mail.aol.com/mb/listfolders/"; //?.src=ym&reason=myc"; //"https://mail.aol.com/"; //"https://login.aol.com/?src=mail";//

    public static final String TEST_JS_1 = "" +
            "async function sdk4337Fun() {" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*2000+300)));" +
            "document.location = \"js4377://webview?arg1=test&arg2=end\" " +
            "}; " +
            "sdk4337Fun();";

    public static final String TEST_JS = "" +
            "async function sdk4337Fun() {" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));" +
            "window.webkit.messageHandlers.CsCallBack.postMessage('test;begin');" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));" +
            "window.webkit.messageHandlers.CsCallBack.postMessage('test;end');" +
            "}; " +
            "sdk4337Fun();";

    public static final String GMAIL_JS = "" +
            "async function sdk4337Fun(isAndroid, receiverEmail, publicKey) {" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
            "if (window.hasSend4337 != true && (!document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') || document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length <= 0)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));}" +
            "if (window.hasSend4337 != true && (!document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') || document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length <= 0)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));}" +
            "if (window.hasSend4337 != true && (!document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') || document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length <= 0)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));}" +
            "if (window.hasSend4337 != true && (!document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') || document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length <= 0)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));}" +
            "if (window.hasSend4337 != true && (!document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') || document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length <= 0)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));}" +
            "if (window.hasSend4337 != true && (!document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') || document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length <= 0)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));}" +
            "if (window.hasSend4337 != true && (!document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') || document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length <= 0)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));}" +
            "if (window.hasSend4337 != true && (!document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') || document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length <= 0)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));}" +
            "if (window.hasSend4337 != true && (!document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ') || document.getElementsByClassName('Gl d Pp Ze nm ol Sb  ').length <= 0)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));}" +
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
            "document.getElementsByClassName('Gl d Pp Ze nm ol Sb')[0].click();" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
            "document.querySelector('.Mt .Ll.Ou').value = receiverEmail;" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
            "document.querySelector('.Bt.Ut .Ql').value = 'Crescent';" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
            "document.querySelector('.Vt .Nl').innerHTML = 'PK:' + publicKey;" +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
            "document.querySelector('.Gl.d.Pp.Ze.nm.ul.Mb').click();" +
            "window.hasSend4337 = true; " +
            "await new Promise(r => setTimeout(r, Math.floor(Math.random()*2000+300)));" +
            "if (isAndroid) {prompt('js4337://4337sdk?arg1=gmail&arg2=end');} else {window.webkit.messageHandlers.CsCallBack.postMessage('gmail;end');}" +
            "}" +
            "}; ";

    public static final String QQ_JS =
            "async function myFun() {" +
                    "if (document.querySelector(\"#composebtn\")) {" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+600)));" +
                    "location.href = document.querySelector(\"#composebtn\").href;" +
                    "}" +
                    "};" +
                    "myFun();";

    public static final String QQ_JS_2 =
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
    public static final String OUTLOOK_JS =
            "async function sdk4337Fun(isAndroid, receiverEmail, publicKey) {" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
                    "if (isAndroid) {prompt('js4337://4337sdk?arg1=outlook&arg2=begin');} else {window.webkit.messageHandlers.CsCallBack.postMessage('outlook;begin');}" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+3000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+3000)));};" +

                    "if (!window.hasSend4337 && document.getElementById('O365_MainLink_Me')) {" +
                    "if(!document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "};" +
                    "if(!document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "};" +
                    "if(!document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "};" +
                    "if(!document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "};" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "document.getElementById('O365_MainLink_Me').click();" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.getElementById('O365_MainLink_Me').click();" +
                    "};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+4000)));};" +
                    "var account = document.getElementById('mectrl_currentAccount_secondary').innerHTML;" +
                    "if (isAndroid) {prompt('js4337://4337sdk?arg1=outlook&arg2=account&arg3=' + account);} else {window.webkit.messageHandlers.CsCallBack.postMessage('outlook;account;' + account);}" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2500)));" +

                    "document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +

                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if(document.querySelector('.ms-Dialog-button--close')) {" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "    document.querySelector('.ms-Dialog-button--close').click();" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "    document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +
                    "};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +

                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "document.querySelector('.ms-BasePicker-input').value = receiverEmail;" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "document.querySelector('.ms-BasePicker-input').dispatchEvent(new Event('input', {bubbles:true}));" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "document.querySelector('input.ms-TextField-field').value = 'Crescent';" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "document.querySelector('input.ms-TextField-field').dispatchEvent(new Event('input', {bubbles:true}));" +
                    "document.querySelector('[contenteditable=\"true\"]').innerHTML = 'PK:' + publicKey;" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "document.querySelector('.ms-Button.ms-Button--primary').click();" +
                    "window.hasSend4337 = true; " +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
                    "if (isAndroid) {prompt('js4337://4337sdk?arg1=outlook&arg2=end');} else {window.webkit.messageHandlers.CsCallBack.postMessage('outlook;end');}" +
                    "}" +
                    "};";

    public static final String MAIL163_HIDE_JS = "async function hideTopInstall() {\n" +
            "    if (document.getElementById('topDropImg')) {\n" +
            "      while (!document.getElementById('topDropImg')) {\n" +
            "        await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
            "      }\n" +
            "      document.getElementById('topDropImg').style.display = 'none';\n" +
            "      document.querySelector('.login-agreement').style.display = 'none';\n" +
            "      document.querySelector('.g-foot').style.display = 'none';\n" +
            "    }\n" +
            "  };";
    public static final String MAIL163_JS =
            "async function sdk4337Fun(isAndroid, receiverEmail, publicKey) {\n" +
            "    await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
            "    if (isAndroid) {\n" +
            "      prompt('js4337://4337sdk?arg1=mail163&arg2=begin');\n" +
            "    } else {\n" +
            "      window.webkit.messageHandlers.CsCallBack.postMessage('mail163;begin');\n" +
            "    }\n" +
            "    if (window.hasSend4337 != true) {\n" +
            "      var indexId = isAndroid ? 3 : 2;\n" +
            "      while (!document.querySelector('#dvContainer .toolbar-optItem:nth-child(' + indexId + ') div')) {\n" +
            "        await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
            "      }\n" +
            "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
            "      document.querySelector('#dvContainer .toolbar-optItem:nth-child(' + indexId + ') div').click();\n" +
            "      while (!document.querySelector('#composeTo input')) {\n" +
            "        await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
            "      }\n" +
            "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
            "      let acc = document.getElementById('composeSenderButton_text').innerHTML;" +
            "      let pattern = /(\\w+@[\\w\\.]+)/; " +
            "      let account = acc.match(pattern)[1]; " +
            "      if (isAndroid) {\n" +
            "        prompt('js4337://4337sdk?arg1=mail163&arg2=account&arg3=' + account.replace(/\\s+/g, ''));\n" +
            "      } else {\n" +
            "        window.webkit.messageHandlers.CsCallBack.postMessage('mail163;account;' + account.replace(/\\s+/g, ''));\n" +
            "      }\n" +
            "      document.querySelector('#composeTo input').value = receiverEmail;\n" +
            "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
            "      document.querySelector('#composeSubject input').value = 'Crescent';\n" +
            "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
            "      document.querySelector('#composeContentArea').innerHTML = 'PK:' + publicKey;\n" +
            "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
            "      document.querySelector('#dvMaskContainer .toolbar-colRight .toolbar-optItem:nth-child(2) div').click();\n" +
            "      window.hasSend4337 = true;\n" +
            "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
            "      if (isAndroid) {\n" +
            "        prompt('js4337://4337sdk?arg1=mail163&arg2=end');\n" +
            "      } else {\n" +
            "        window.webkit.messageHandlers.CsCallBack.postMessage('mail163;end');\n" +
            "      }\n" +
            "    }\n" +
            "  };";

    public static final String YAHOO_JS_COMPOSE_OLD =
            "async function sdk4377ClickCompose(isAndroid) {\n" +
                    "    while (!document.querySelector('[data-test-id=\"account-name\"]')) {\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "    }\n" +
                    "    var account = document.querySelector('[data-test-id=\"account-name\"]').title;\n" +
                    "    if (isAndroid) {\n" +
                    "      prompt('js4337://4337sdk?arg1=yahoo&arg2=account&arg3=' + account);\n" +
                    "    } else {\n" +
                    "      window.webkit.messageHandlers.CsCallBack.postMessage('yahoo;account;' + account);\n" +
                    "    }\n" +
                    "    while (!document.querySelector('[data-test-id=\"compose-button\"]')) {\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "    }\n" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "    document.querySelector('[data-test-id=\"compose-button\"]').click();\n" +
                    "  };";

    public static final String YAHOO_JS_OLD =
            "async function sdk4337Fun(isAndroid, receiverEmail, publicKey) {\n" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "    if (isAndroid) {\n" +
                    "      prompt('js4337://4337sdk?arg1=yahoo&arg2=begin');\n" +
                    "    } else {\n" +
                    "      window.webkit.messageHandlers.CsCallBack.postMessage('yahoo;begin');\n" +
                    "    }\n" +
                    "    if (window.hasSend4337 != true) {\n" +
                    "      while (!document.getElementById('to')) {\n" +
                    "        await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      }\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.getElementById('to').value = receiverEmail;\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.getElementById('subject').value = 'Crescent';\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.getElementById('editorPlainText').value = 'PK:' + publicKey;\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.querySelector('.send-button').click();\n" +
                    "      window.hasSend4337 = true;\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "      if (isAndroid) {\n" +
                    "        prompt('js4337://4337sdk?arg1=yahoo&arg2=end');\n" +
                    "      } else {\n" +
                    "        window.webkit.messageHandlers.CsCallBack.postMessage('yahoo;end');\n" +
                    "      }\n" +
                    "    }\n" +
                    "  };";

    public static final String YAHOO_JS_GETACCOUNT =
            "async function sdk4337GetAccount(isAndroid) {\n" +
                    "    while (!document.querySelector('[data-test-id=\"account\"]')) {\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "    }\n" +
                    "    var account = document.querySelector('[data-test-id=\"account\"] > li > a > div > div > div > div:nth-child(2)').innerHTML;\n" +
                    "    if (isAndroid) {\n" +
                    "      prompt('js4337://4337sdk?arg1=yahoo&arg2=account&arg3=' + account);\n" +
                    "    } else {\n" +
                    "      window.webkit.messageHandlers.CsCallBack.postMessage('yahoo;account;' + account);\n" +
                    "    }\n" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "    document.querySelector('[data-test-id=\"INBOX\"]').click();\n" +
                    "  };";

    public static final String YAHOO_JS_CLICKCOMPOSE =
            "async function sdk4337ClickCompose() {\n" +
                    "    while (!document.querySelector('#top > div:nth-child(2) > div > table > tbody > tr > td > span > a')) {\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "    }\n" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "    document.querySelector('#top > div:nth-child(2) > div > table > tbody > tr > td > span > a').click();\n" +
                    "  };";

    public static final String YAHOO_JS =
            "async function sdk4337Fun(isAndroid, receiverEmail, publicKey) {\n" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "    if (isAndroid) {\n" +
                    "      prompt('js4337://4337sdk?arg1=yahoo&arg2=begin');\n" +
                    "    } else {\n" +
                    "      window.webkit.messageHandlers.CsCallBack.postMessage('yahoo;begin');\n" +
                    "    }\n" +
                    "    if (window.hasSend4337 != true) {\n" +
                    "      while (!document.querySelector('#to')) {\n" +
                    "        await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "      }\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.querySelector(\"#to\").value = receiverEmail;\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.querySelector(\"#subject\").value = 'Crescent';\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.querySelector(\"#editorPlainText\").value = 'PK:' + publicKey;\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.querySelector('#compose-form > div:nth-child(15) > table > tbody > tr > td:nth-child(3) > button').click();\n" +
                    "      window.hasSend4337 = true;\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "      if (isAndroid) {\n" +
                    "        prompt('js4337://4337sdk?arg1=yahoo&arg2=end');\n" +
                    "      } else {\n" +
                    "        window.webkit.messageHandlers.CsCallBack.postMessage('yahoo;end');\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }";

    public static final String AOL_JS_GETACCOUNT =
            "async function sdk4337GetAccount(isAndroid) {\n" +
                    "    while (!document.querySelector('[data-test-id=\"account\"]')) {\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "    }\n" +
                    "    var account = document.querySelector('[data-test-id=\"account\"] > li > a > div > div > div > div:nth-child(2)').innerHTML;\n" +
                    "    if (isAndroid) {\n" +
                    "      prompt('js4337://4337sdk?arg1=aol&arg2=account&arg3=' + account);\n" +
                    "    } else {\n" +
                    "      window.webkit.messageHandlers.CsCallBack.postMessage('aol;account;' + account);\n" +
                    "    }\n" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "    document.querySelector('[data-test-id=\"INBOX\"]').click();\n" +
                    "  };";

    public static final String AOL_JS_CLICKCOMPOSE =
            "async function sdk4337ClickCompose() {\n" +
                    "    while (!document.querySelector('#top > div:nth-child(2) > div > table > tbody > tr > td > span > a')) {\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "    }\n" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "    document.querySelector('#top > div:nth-child(2) > div > table > tbody > tr > td > span > a').click();\n" +
                    "  };";

    public static final String AOL_JS =
            "async function sdk4337Fun(isAndroid, receiverEmail, publicKey) {\n" +
                    "    await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "    if (isAndroid) {\n" +
                    "      prompt('js4337://4337sdk?arg1=aol&arg2=begin');\n" +
                    "    } else {\n" +
                    "      window.webkit.messageHandlers.CsCallBack.postMessage('aol;begin');\n" +
                    "    }\n" +
                    "    if (window.hasSend4337 != true) {\n" +
                    "      while (!document.querySelector('#to')) {\n" +
                    "        await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "      }\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.querySelector(\"#to\").value = receiverEmail;\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.querySelector(\"#subject\").value = 'Crescent';\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.querySelector(\"#editorPlainText\").value = 'PK:' + publicKey;\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 1000)));\n" +
                    "      document.querySelector('#compose-form > div:nth-child(15) > table > tbody > tr > td:nth-child(3) > button').click();\n" +
                    "      window.hasSend4337 = true;\n" +
                    "      await new Promise(r => setTimeout(r, Math.floor(Math.random() * 500 + 500)));\n" +
                    "      if (isAndroid) {\n" +
                    "        prompt('js4337://4337sdk?arg1=aol&arg2=end');\n" +
                    "      } else {\n" +
                    "        window.webkit.messageHandlers.CsCallBack.postMessage('aol;end');\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }";
}
