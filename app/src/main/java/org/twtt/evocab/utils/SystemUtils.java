package org.twtt.evocab.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import org.twtt.evocab.R;
import org.twtt.evocab.ui.fragment.BaseFragment;

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
    public static void showFragment(AppCompatActivity activity, int idContainer, BaseFragment newFragment, boolean isSaved) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft = ft.replace(idContainer, newFragment);
        if(isSaved) ft.addToBackStack("");
        ft.commit();
    }
}
