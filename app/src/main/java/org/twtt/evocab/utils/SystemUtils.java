package org.twtt.evocab.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by neotran on 4/5/16.
 */
public class SystemUtils {
    public static String getStringFromLocalStorage(Context context, String textkey) {
        if(context != null) {
            SharedPreferences mPrefs = context.getSharedPreferences("evocab", 0);
            return mPrefs.getString(textkey, "");
        }
        return "";
    }

    public static void saveStringToLocalStorage(Context context, String textkey, String value) {
        if(context != null) {
            SharedPreferences mPrefs = context.getSharedPreferences("evocab", 0);
            if(mPrefs != null) {
                SharedPreferences.Editor mEditor = mPrefs.edit();
                if(mEditor != null)
                    mEditor.putString(textkey, value).commit();
            }
        }
    }
}
