package org.twtt.evocab.settings;

import android.util.Log;


/**
 * Created by neotran on 4/5/16.
 */
public class Logger {
    public static void v(String tag, String value) {
        if(!BuildConfigs.isLive())
            Log.v(tag, value);
    }
    public static void e(String tag, String value) {
        if(!BuildConfigs.isLive())
            Log.e(tag, value);
    }
}
