package org.twtt.evocab.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by neotran on 4/7/16.
 */
public abstract class BaseFragment extends Fragment {
    protected ViewGroup mContentView;

    public abstract int getLayoutResource();
    public abstract void initiateUI(ViewGroup mainView);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return getContentView(inflater);
    }

    protected View getContentView(LayoutInflater inflater) {
        if(mContentView == null) {
            mContentView = (ViewGroup) inflater.inflate(getLayoutResource(), null);
            initiateUI(mContentView);
        }
        return mContentView;
    }
}
