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
    ListView lv_readinglist;
    GridView gr_watpad,gr_Current_off,gr_Current_off_2;
    com.example.wattpadclone.Libary.Adapter.offlineAdapter_2 offlineAdapter_2;
    ArrayList<offline_2> offline_2ArrayList;
    offlineAdapter offlineAdapterr;
    ArrayList<offline> offlineArrayList;
    ReadingListAdapter readingadapter;
    ArrayList<ReadingList> readingArrayList;
    watpadAdapter adapter;
    ArrayList<watpad> watpadArrayList;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.libary_fragement, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(mActivity.getSupportFragmentManager());
        adapter.addFragment(new CurrentReadFragment(), "Đọc gần đây");
        adapter.addFragment(new ArchiveFragment(), "Lưu trữ");
        adapter.addFragment(new ReadingListFragment(), "Danh sách ");
        viewPager.setAdapter(adapter);
    }

}