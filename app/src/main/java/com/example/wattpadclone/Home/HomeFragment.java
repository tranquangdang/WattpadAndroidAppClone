package com.example.wattpadclone.Home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.wattpadclone.Base.IntroActivity;
import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.Chung.Bean.FirstZoomHorizontalLayoutManager;
import com.example.wattpadclone.Chung.WebServices;
import com.example.wattpadclone.Home.Account.AccountActivity;
import com.example.wattpadclone.Home.Adapters.Beans.VerticalRecyclerViewHomeBean;
import com.example.wattpadclone.Home.Adapters.VerticalRecyclerViewHomeAdapter;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {

    RecyclerView verticalRecyclerView;
    VerticalRecyclerViewHomeAdapter vAdapter;
    ArrayList<VerticalRecyclerViewHomeBean> arrayListVertical;
    RecyclerView recyclerView2;
    String urlGetData = "http://tranquangdang.000webhostapp.com/index.php";
    public HomeFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar_home);
        toolbar.inflateMenu(R.menu.menu_toolbar_home);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()== R.id.toolbar_home_account)
                {
                    Intent intent = new Intent(getActivity(), AccountActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        arrayListVertical = new ArrayList<>();
        verticalRecyclerView = view.findViewById(R.id.home_recyclerViewMain);
        verticalRecyclerView.setHasFixedSize(true);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));

        vAdapter = new VerticalRecyclerViewHomeAdapter(getContext(),arrayListVertical);
        verticalRecyclerView.setAdapter(vAdapter);

        WebServices webServices = new WebServices(getActivity());
        webServices.GetData(urlGetData,arrayListVertical,vAdapter);
        recyclerView2 = view.findViewById(R.id.home_recyclerView2);

        return view;
    }



}
