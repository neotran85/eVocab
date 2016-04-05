package org.twtt.evocab.model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by neotran on 4/5/16.
 */
public class Word extends RealmObject {
    @PrimaryKey
    private int mId;
    private String mValue;
    private RealmList<Type> mTypes;
    private RealmList<Meaning> mMeanings;
    private RealmList<Category> mCategories;
    private RealmList<Tag> mTags;

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

    public RealmList<Type> getTypes() {
        return mTypes;
    }

    public void setTypes(RealmList<Type> types) {
        this.mTypes = types;
    }

    public void addType(Type type) {
        if(this.mTypes != null)
            this.mTypes.add(type);
    }

    public void removeType(Type type) {
        if(this.mTypes != null)
            for(Type iType : mTypes) {
                if(iType.getId() == type.getId()) {
                    mTypes.remove(type);
                    return;
                }
            }
    }

    public RealmList<Meaning> getMeanings() {
        return mMeanings;
    }

    public void setMeanings(RealmList<Meaning> meanings) {
        this.mMeanings = meanings;
    }

    public void addType(Meaning meaning) {
        if(this.mMeanings != null)
            this.mMeanings.add(meaning);
    }

    public void removeMeaning(Meaning meaning) {
        if(this.mMeanings != null)
            for(Meaning iMeaning : mMeanings) {
                if(iMeaning.getId() == meaning.getId()) {
                    mTypes.remove(meaning);
                    return;
                }
            }
    }

    public RealmList<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(RealmList<Category> categories) {
        this.mCategories = categories;
    }

    public void addCategory(Category category) {
        if(this.mCategories != null)
            this.mCategories.add(category);
    }

    public void removeCategory(Category category) {
        if(this.mCategories != null)
            for(Category iCategory : mCategories) {
                if(iCategory.getId() == category.getId()) {
                    mCategories.remove(category);
                    return;
                }
            }
    }

    public RealmList<Tag> getTags() {
        return mTags;
    }

    public void setTags(RealmList<Tag> tags) {
        this.mTags = tags;
    }

    public void addTag(Tag tag) {
        if(this.mTags != null)
            this.mTags.add(tag);
    }

    public void removeTag(Tag tag) {
        if(this.mTags != null)
            for(Tag iTag : mTags) {
                if(iTag.getId() == tag.getId()) {
                    mTags.remove(tag);
                    return;
                }
            }
    }
}
