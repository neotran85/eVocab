package org.twtt.evocab.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by neotran on 4/5/16.
 */
public class Tag extends RealmObject {
    @PrimaryKey
    private String mName;

    public String getValue() {
        return mName;
    }

    public void setValue(String value) {
        this.mName = value;
    }
}
