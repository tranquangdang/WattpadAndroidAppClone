package com.example.wattpadclone.thembanbe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.wattpadclone.Bell.BellFragment;
import com.example.wattpadclone.Home.Account.AccountActivity;
import com.example.wattpadclone.Home.Account.Account_intro;
import com.example.wattpadclone.Home.Account.Account_message;
import com.example.wattpadclone.Home.Adapters.SectionsPageAdapter;
import com.example.wattpadclone.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;

public class thembanbe extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehavior;
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thembanbe);


        Toolbar toolbar = findViewById(R.id.toolbar_thembanbe);

        toolbar.setLogo(ContextCompat.getDrawable(getApplicationContext(), R.drawable.back));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.addfr_viewpaper);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.addfr_tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF5722"));
        tabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor("#000000"));



    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new thembanbe_tab1(), "Giới thiệu");
        adapter.addFragment(new thembanbe_tab2(), "Cuộc hội thoại");
        viewPager.setAdapter(adapter);
    }
}