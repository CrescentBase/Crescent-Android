package com.crescent.core;

public class EmailBean {
    public static String SP_BASE_USER_INFO = "CRESCENT_SS_USER_INFO";
    public static String SP_EMAIL_KEY = "CRESCENT_SS_EMAIL_KEY";
    public static String SP_ADDRESS_KEY = "CRESCENT_SS_ADDRESS_KEY";

    public static final int TYPE_TEST = 0x10000;
    public static final int TYPE_GMAIL = 0x1;
    public static final int TYPE_OUTLOOK = 0x2;
    public static final int TYPE_QQ = 0x3;

    public static final String TEST_URL = "https://www.baidu.com/";
    public static final String GMAIL_URL = "https://mail.google.com/";//"https://www.baidu.com";//
    public static final String QQ_URL = "https://mail.qq.com/";//"https://mail.qq.com/";
    public static final String OUTLOOK_URL = "https://outlook.live.com/owa/?nlp=1";

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
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
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
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('O365_MainLink_Me')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +

                    "if (!window.hasSend4337 && document.getElementById('O365_MainLink_Me')) {" +
                    "document.getElementById('O365_MainLink_Me').click();" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));};" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+4000)));};" +
                    "var account = document.getElementById('mectrl_currentAccount_secondary').innerHTML;" +
                    "if (isAndroid) {prompt('js4337://4337sdk?arg1=outlook&arg2=account&arg3=' + account);} else {window.webkit.messageHandlers.CsCallBack.postMessage('outlook;account;' + account);}" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +

                    "document.querySelectorAll('[role=\"region\"] button.ms-Button')[1].click();" +

                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +
                    "if (!document.querySelector('.ms-BasePicker-input')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1000)));};" +

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

    public static final String OUTLOOK_JS_OLD =
            "async function sdk4337Fun(isAndroid, receiverEmail, publicKey) {" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
                    "if (isAndroid) {prompt('js4337://4337sdk?arg1=outlook&arg2=begin');} else {window.webkit.messageHandlers.CsCallBack.postMessage('outlook;begin');}" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+3000)));" +
                    "if (!window.hasSend4337 && (!document.getElementById('innerRibbonContainer') || !document.getElementById('innerRibbonContainer').querySelectorAll('button') || document.getElementById('innerRibbonContainer').querySelectorAll('button').length <= 1)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));}" +
                    "if (!window.hasSend4337 && (!document.getElementById('innerRibbonContainer') || !document.getElementById('innerRibbonContainer').querySelectorAll('button') || document.getElementById('innerRibbonContainer').querySelectorAll('button').length <= 1)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+5000)));}" +
                    "if (!window.hasSend4337 && (!document.getElementById('innerRibbonContainer') || !document.getElementById('innerRibbonContainer').querySelectorAll('button') || document.getElementById('innerRibbonContainer').querySelectorAll('button').length <= 1)) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+7000)));}" +
                    "if (!window.hasSend4337 && document.getElementById('innerRibbonContainer') && document.getElementById('innerRibbonContainer').querySelectorAll('button') && document.getElementById('innerRibbonContainer').querySelectorAll('button').length > 1) {" +
                    "document.getElementById('O365_MainLink_Me').click();" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));" +
                    "if (!document.getElementById('mectrl_currentAccount_secondary')) {await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+4000)));};" +
                    "var account = document.getElementById('mectrl_currentAccount_secondary').innerHTML;" +
                    "if (isAndroid) {prompt('js4337://4337sdk?arg1=outlook&arg2=account&arg3=' + account);} else {window.webkit.messageHandlers.CsCallBack.postMessage('outlook;account;' + account);}" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
                    "document.getElementById('innerRibbonContainer').querySelectorAll('button')[1].click();" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+2000)));" +
                    "document.querySelector('.EditorClass').innerHTML = receiverEmail;" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+800)));" +
                    "document.querySelector('[id^=editorParent] div').innerHTML = 'PK:' + publicKey;" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+800)));" +
                    "document.getElementById('ReadingPaneContainerId').querySelectorAll('[role=\"button\"]')[1].click();" +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+1500)));" +
                    "document.querySelector('[id^=ok-]').click();" +
                    "window.hasSend4337 = true; " +
                    "await new Promise(r => setTimeout(r, Math.floor(Math.random()*500+500)));" +
                    "if (isAndroid) {prompt('js4337://4337sdk?arg1=outlook&arg2=end');} else {window.webkit.messageHandlers.CsCallBack.postMessage('outlook;end');}" +
                    "}" +
                    "};";

}
