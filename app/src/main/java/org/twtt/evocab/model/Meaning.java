package org.twtt.evocab.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by neotran on 4/5/16.
 */
public class Meaning extends RealmObject {
    @PrimaryKey
    private int mId;
    private Word mWord;
    private String mValue;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public Word getWord() {
        return mWord;
    }

    public void setWord(Word word) {
        this.mWord = word;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        this.mValue = value;
    }
}
