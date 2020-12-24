package com.example.wattpadclone.Write;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.wattpadclone.Bell.Tabs.Bell_tab1;
import com.example.wattpadclone.Bell.Tabs.Bell_tab2;
import com.example.wattpadclone.Bell.Tabs.thembanbe.thembanbe;
import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.Libary.Adapter.ViewPagerAdapter;
import com.example.wattpadclone.R;
import com.google.android.material.tabs.TabLayout;

public class WriteFragment extends BaseFragment {
    View myFragment;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_write, container, false);
        viewPager = (ViewPager) myFragment.findViewById(R.id.write_viewpaper);
        tabLayout = (TabLayout) myFragment.findViewById(R.id.write_tabs);

        Toolbar toolbar = myFragment.findViewById(R.id.toolbar_write);
        toolbar.setLogo(ContextCompat.getDrawable(getContext(), R.drawable.ic_logo));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        toolbar.inflateMenu(R.menu.menu_write_fragment);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()== R.id.toolbar_write_now)
                {
                    Intent intent = new Intent(getContext(), NewBookActivity.class);
                    startActivity(intent);
                }
                return false;
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
        adapter.addFragment(new Write_tab1(), "Đã đăng");
        adapter.addFragment(new Write_tab2(), "Bản thảo");
        viewPager.setAdapter(adapter);
    }
}
