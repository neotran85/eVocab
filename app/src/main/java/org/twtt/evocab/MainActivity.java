package org.twtt.evocab;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.twtt.evocab.model.DatabaseManager;
import org.twtt.evocab.ui.fragment.AboutFragment;
import org.twtt.evocab.ui.fragment.BaseFragment;
import org.twtt.evocab.ui.fragment.FeedbackFragment;
import org.twtt.evocab.ui.fragment.MyVocabsFragment;
import org.twtt.evocab.ui.fragment.PlayVocabsFragment;
import org.twtt.evocab.ui.fragment.SettingsFragment;
import org.twtt.evocab.ui.fragment.ShareFragment;
import org.twtt.evocab.ui.fragment.StoreFragment;
import org.twtt.evocab.utils.SystemUtils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private BaseFragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        DatabaseManager.initiate(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        this.setTitle(item.getTitle());

        if(id == R.id.nav_my_vocab) {
            MyVocabsFragment fragment = new MyVocabsFragment();
            showFragment(fragment, true);
        } else if(id == R.id.nav_store) {
            StoreFragment fragment = new StoreFragment();
            showFragment(fragment, true);
        } else if(id == R.id.nav_play_vocab) {
            PlayVocabsFragment fragment = new PlayVocabsFragment();
            showFragment(fragment, true);
        } else if(id == R.id.nav_settings) {
            SettingsFragment fragment = new SettingsFragment();
            showFragment(fragment, true);
        } else if(id == R.id.nav_share) {
            ShareFragment fragment = new ShareFragment();
            showFragment(fragment, true);
        } else if(id == R.id.nav_send) {
            FeedbackFragment fragment = new FeedbackFragment();
            showFragment(fragment, true);
        } else if(id == R.id.nav_about) {
            AboutFragment fragment = new AboutFragment();
            showFragment(fragment, true);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(BaseFragment newFragment, boolean isSaved) {
        SystemUtils.showFragment(this, R.id.fragment_container, newFragment, isSaved);
        mCurrentFragment = newFragment;
    }
}
