package com.crescent.content;

//If it is a debug, output the Log
public class LogU {

    private static final boolean DEBUG = true;

    public static void i(String tag, String message) {
        if (DEBUG) {
            android.util.Log.i(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (DEBUG) {
            android.util.Log.e(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (DEBUG) {
            android.util.Log.d(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (DEBUG) {
            android.util.Log.v(tag, message);
        }
    }
}
