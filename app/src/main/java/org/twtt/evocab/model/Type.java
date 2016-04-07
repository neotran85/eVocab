package org.twtt.evocab.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by neotran on 4/5/16.
 */
public class Type extends RealmObject {
    @PrimaryKey
    private String mName;
    private String mDescription;

    public String getName() {
        return mName;
    }

    public void setName(String value) {
        this.mName = value;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }
}
