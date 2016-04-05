package org.twtt.evocab.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by neotran on 4/5/16.
 */
public class Package extends RealmObject {
    @PrimaryKey
    private int mId;
    private String mName;
    private String mDescription;
    private RealmList<Word> mWords;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public RealmList<Word> getWords() {
        return mWords;
    }

    public void setWords(RealmList<Word> words) {
        this.mWords = words;
    }

    public void addWord(Word word) {
        if(this.mWords != null)
            this.mWords.add(word);
    }

    public void removeTag(Word word) {
        if(this.mWords != null)
            for(Word iWork : mWords) {
                if(iWork.getId() == word.getId()) {
                    mWords.remove(word);
                    return;
                }
            }
    }
}
