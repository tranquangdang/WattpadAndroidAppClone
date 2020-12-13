package com.example.wattpadclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;

import com.example.wattpadclone.Home.HomeFragment;
import com.example.wattpadclone.Library.LibraryFragment;
import com.example.wattpadclone.Search.SearchFragment;
import com.example.wattpadclone.Bell.BellFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import java.util.HashMap;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    public static HashMap<String, Stack<Fragment>> mStacks;
    public static final String STACK = "STACK";
    public static final String HOME_FRAGMENT = "HOME_FRAGMENT";
    public static final String SEARCH_FRAGMENT = "SEARCH_FRAGMENT";
    public static final String LIBRARY_FRAGMENT = "LIBRARY_FRAGMENT";
    public static final String BELL_FRAGMENT = "BELL_FRAGMENT";
    public static BottomNavigationViewEx bottomNavigationViewEx;

    FirebaseUser firebaseUser;

    private String mCurrentTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom_navigation_main);
        bottomNavigationViewEx.setTextVisibility(false);
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mStacks = new HashMap<String, Stack<Fragment>>();
        mStacks.put(STACK, new Stack<Fragment>());
        mStacks.put(HOME_FRAGMENT, new Stack<Fragment>());
        mStacks.put(SEARCH_FRAGMENT, new Stack<Fragment>());
        mStacks.put(LIBRARY_FRAGMENT, new Stack<Fragment>());
        mStacks.put(BELL_FRAGMENT, new Stack<Fragment>());

        bottomNavigationViewEx.setSelectedItemId(R.id.action_home);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_home:
                    selectedTab(HOME_FRAGMENT);
                    return true;
                case R.id.action_search:
                    selectedTab(SEARCH_FRAGMENT);
                    return true;
                case R.id.action_library:
                    selectedTab(LIBRARY_FRAGMENT);
                    return true;
                case R.id.action_bell:
                    selectedTab(BELL_FRAGMENT);
                    return true;
            }
            return false;
        }

    };

    public void gotoFragment(Fragment selectedFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, selectedFragment);
        fragmentTransaction.commit();
    }

    private void selectedTab(String tabId) {
        mCurrentTab = STACK;

        if (mStacks.get(tabId).size() == 0) {
            if (tabId.equals(HOME_FRAGMENT)) {
                pushFragments(tabId, new HomeFragment(), true);
            } else if (tabId.equals(SEARCH_FRAGMENT)) {
                pushFragments(tabId, new SearchFragment(), true);
            } else if (tabId.equals(LIBRARY_FRAGMENT)) {
                pushFragments(tabId, new LibraryFragment(), true);
            } else if (tabId.equals(BELL_FRAGMENT)) {
                pushFragments(tabId, new BellFragment(), true);
            }
        } else {
            pushFragments(STACK, mStacks.get(STACK).lastElement(), false);
        }
    }

    public void pushFragments(String tag, Fragment fragment, boolean shouldAdd) {
        if (shouldAdd)
            mStacks.get(STACK).push(fragment);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.main_container, fragment);
        ft.commit();

    }

    public void popFragments() {
        Fragment fragment = mStacks.get(mCurrentTab).elementAt(mStacks.get(mCurrentTab).size() - 2);

        mStacks.get(mCurrentTab).pop();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.main_container, fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (mStacks.get(mCurrentTab).size() == 1) {
            bottomNavigationViewEx.setSelectedItemId(R.id.action_home);
            gotoFragment(new HomeFragment());
            return;
        }
        popFragments();
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(!isInternetAvailable()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Please connect to the internet")
                    .setCancelable(false)
                    .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            onStart();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        if(firebaseUser != null) {
            bottomNavigationViewEx.setSelectedItemId(R.id.action_home);
        }
    }


    public boolean isInternetAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) MainActivity.this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED)
                || (connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState() == NetworkInfo.State.CONNECTED)) {
            return true;
        } else {
            return false;
        }
    }
}