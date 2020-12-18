package com.example.wattpadclone.Libary.Main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.Libary.Adapter.ReadingList;
import com.example.wattpadclone.Libary.Adapter.ReadingListAdapter;
import com.example.wattpadclone.Libary.Adapter.ViewPagerAdapter;
import com.example.wattpadclone.Libary.Adapter.offline;
import com.example.wattpadclone.Libary.Adapter.offlineAdapter;
import com.example.wattpadclone.Libary.Adapter.offline_2;
import com.example.wattpadclone.Libary.Adapter.watpad;
import com.example.wattpadclone.Libary.Adapter.watpadAdapter;
import com.example.wattpadclone.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class LibaryFragement extends BaseFragment {
    View myFragment;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.libary_fragement, container, false);
        viewPager = (ViewPager) myFragment.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) myFragment.findViewById(R.id.tabs);
        return myFragment;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new CurrentReadFragment(), "Đọc gần đây");
        adapter.addFragment(new ArchiveFragment(), "Kho lưu trữ");
        adapter.addFragment(new ReadingListFragment(), "Danh sách");
        viewPager.setAdapter(adapter);

    }

}