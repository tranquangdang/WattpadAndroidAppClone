package com.example.wattpadclone.Bell.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class viewpaperAdapter extends FragmentPagerAdapter {
    private List<Fragment> FragmentList = new ArrayList<>();
    private  List<String> TitleList = new ArrayList<>();

    public viewpaperAdapter(FragmentManager manager) {
        super(manager);
    }

    public Fragment getItem(int position) {
        return FragmentList.get(position);
    }

    public int getCount() {
        return FragmentList.size();
    }

    @Nullable

    public CharSequence getPageTitle(int position) {
        return TitleList.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        FragmentList.add(fragment);
        TitleList.add(title);
    }
}
