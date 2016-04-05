package org.twtt.evocab.settings;

/**
 * Created by neotran on 4/5/16.
 */
public class BuildConfigs {
    public static final String ALPHA_VERSION = "alpha version";
    public static final String BETA_VERSION = "beta version";
    public static final String LIVE_VERSION = "live version";
    private static String mTypeVersion = ALPHA_VERSION;

    public static boolean isAlpha() {
        return mTypeVersion == ALPHA_VERSION;
    }
    public static boolean isBeta() {
        return mTypeVersion == BETA_VERSION;
    }
    public static boolean isLive() {
        return mTypeVersion == LIVE_VERSION;
    }
}
