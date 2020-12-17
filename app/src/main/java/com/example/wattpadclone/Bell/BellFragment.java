
package com.example.wattpadclone.Bell;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.wattpadclone.Bell.Tabs.Bell_tab1;
import com.example.wattpadclone.Bell.Tabs.Bell_tab2;
import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.Home.Account.AccountActivity;
import com.example.wattpadclone.Home.Account.Account_intro;
import com.example.wattpadclone.Home.Account.Account_message;
import com.example.wattpadclone.Home.Adapters.SectionsPageAdapter;
import com.example.wattpadclone.Library.LibraryFragment;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;
import com.example.wattpadclone.Search.SearchFragment;
import com.example.wattpadclone.thembanbe.thembanbe;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;


public class BellFragment extends BaseFragment {
    ImageButton btn1,btn2;
    private BottomSheetBehavior mBottomSheetBehavior;
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    private RelativeLayout hasReadLayout, followersLayout;
    Context context;

    public BellFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bell, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar_bell);
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




        mSectionsPageAdapter = new SectionsPageAdapter(getFragmentManager());

        mViewPager = view.findViewById(R.id.bell_viewpaper);
        setupViewPager(mViewPager);

        TabLayout tabLayout = view.findViewById(R.id.bell_tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF5722"));
        tabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor("#000000"));




        return view;
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getFragmentManager());
        adapter.addFragment(new Bell_tab1(), "Tìm Bạn Bè");
        adapter.addFragment(new Bell_tab2(), "Thêm Bạn Bè");
        viewPager.setAdapter(adapter);
    }



}