package org.twtt.evocab.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by neotran on 4/5/16.
 */
public class Type extends RealmObject {
    @PrimaryKey
    private int mId;
    private String mValue;
    private String mDescription;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        this.mValue = value;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }
}
