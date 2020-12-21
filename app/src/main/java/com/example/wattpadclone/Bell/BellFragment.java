
package com.example.wattpadclone.Bell;

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
import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.Libary.Adapter.ViewPagerAdapter;
import com.example.wattpadclone.R;
import com.example.wattpadclone.Bell.Tabs.thembanbe.thembanbe;
import com.google.android.material.tabs.TabLayout;


public class BellFragment extends BaseFragment {
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
        myFragment = inflater.inflate(R.layout.fragment_bell, container, false);
        viewPager = (ViewPager) myFragment.findViewById(R.id.bell_viewpaper);
        tabLayout = (TabLayout) myFragment.findViewById(R.id.bell_tabs);

        Toolbar toolbar = myFragment.findViewById(R.id.toolbar_bell);
        toolbar.inflateMenu(R.menu.menu_toolbar_noti);
        toolbar.setLogo(ContextCompat.getDrawable(getContext(), R.drawable.ic_logo));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.toolbar_noti_add)
                {
                    Intent intent = new Intent(getActivity(), thembanbe.class);
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
        adapter.addFragment(new Bell_tab1(), "Thông báo");
        adapter.addFragment(new Bell_tab2(), "Tin nhắn");
        viewPager.setAdapter(adapter);
    }
}