package com.example.wattpadclone.Libary.Main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.Libary.Adapter.ViewPagerAdapter;
import com.example.wattpadclone.R;
import com.google.android.material.tabs.TabLayout;
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
        Toolbar toolbar = myFragment.findViewById(R.id.toolbar_libary);
        toolbar.inflateMenu(R.menu.menu_toolbar_lib);
        toolbar.setLogo(ContextCompat.getDrawable(getContext(), R.drawable.ic_logo));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
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