package org.twtt.evocab.model;

import android.content.Context;

import org.twtt.evocab.R;
import org.twtt.evocab.settings.Logger;
import org.twtt.evocab.utils.SystemUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmObject;
import io.realm.RealmSchema;
import io.realm.annotations.PrimaryKey;

/**
 * Created by neotran on 4/5/16.
 */
public class DatabaseManager {
    private static final String mName = "evocab.realm";
    private static final String DATABASE_VERSION_KEY = "database_version";
    private static int mVersion = 0;
    private static DatabaseManager mInstance;
    private static RealmConfiguration mConfig;

    public DatabaseManager getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new DatabaseManager(context);
        }
        return mInstance;
    }

    private static boolean isFirstInstalled(Context context) {
        String version = SystemUtils.getStringFromLocalStorage(context, DATABASE_VERSION_KEY);
        Logger.v("isFirstInstalled", "version = " + version);
        return (version.length() <= 0);
    }

    public static void initiate(Context context) {
        if(mInstance == null) {
            mInstance = new DatabaseManager(context);
        }
    }

    private static boolean isUpgraded(Context context) {
        int oldVersion = Integer.valueOf(SystemUtils.getStringFromLocalStorage(context, DATABASE_VERSION_KEY));
        mVersion = context.getResources().getInteger(R.integer.database_version);
        return mVersion > oldVersion;
    }

    protected DatabaseManager(Context context) {
        mVersion = context.getResources().getInteger(R.integer.database_version);
        Realm.setDefaultConfiguration(getManualConfiguration(context));
        if(isFirstInstalled(context)) {
            Realm defaultRealm = Realm.getDefaultInstance();
            try {
                addToDatabaseFromJson(context, defaultRealm, R.raw.type, Type.class);
                addToDatabaseFromJson(context, defaultRealm, R.raw.category, Category.class);
            } catch (Exception e) {
                Logger.e("DatabaseManager initiation", e.toString());
            }
        }
        // save the new database version.
        SystemUtils.saveStringToLocalStorage(context, DATABASE_VERSION_KEY, mVersion + "");
    }

    private static RealmConfiguration getManualConfiguration(Context context) {
        if(mConfig == null) {
            mConfig = new RealmConfiguration.Builder(context)
                    .name("evocab.realm")
                    .schemaVersion(mVersion)
                    .migration(new RealmMigration() {
                        @Override
                        public void migrate(DynamicRealm realm, long oldVersion,
                                            long newVersion) {
                            Logger.v("migrate", "oldVersion = " + oldVersion);
                            Logger.v("migrate", "newVersion = " + newVersion);
                        }
                    })
                    .build();
        }
        return mConfig;
    }

    public static void addToDatabaseFromJson(Context context, Realm realm, int idRawFile, Class theClass) throws Exception {
        if(context != null) {
            InputStream inputStream = context.getResources().openRawResource(idRawFile);
            realm.beginTransaction();
            try {
                realm.createAllFromJson(theClass, inputStream);
                realm.commitTransaction();
            } catch (IOException e) {
                Logger.e("addToDatabaseFromJson", e.toString());
                realm.cancelTransaction();
            } finally {
                if(inputStream != null) {
                    inputStream.close();
                }
            }
        }
    }

}
