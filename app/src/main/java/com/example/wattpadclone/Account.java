package com.example.wattpadclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.wattpadclone.Adapters.SectionsPageAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
//trường đệp trait 1232354124
public class Account extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehavior;
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Toolbar toolbar = findViewById(R.id.toolbar_account);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        View bottomSheet = findViewById(R.id.acc_bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.acc_viewPager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.acc_tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF5722"));
        tabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor("#000000"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_account,menu);
        return true;
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Account_tab1(), "Giới thiệu");
        adapter.addFragment(new Account_tab2(), "Cuộc hội thoại");
        viewPager.setAdapter(adapter);
    }
}