package com.example.wattpadclone.Search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class FragmentSearchList extends BaseFragment {
    ListView lv;
    Adapter.ListViewBaseAdapter adapter;
    ArrayList<Adapter.ListViewBean> arr_bean;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_list, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar_search_list);
        toolbar.setLogo(ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.popFragments();
            }
        });

        lv=view.findViewById(R.id.listview);
        arr_bean=new ArrayList<Adapter.ListViewBean>();
        arr_bean.add(new Adapter.ListViewBean(R.drawable.a1,"Đối lập","239 K","1.7 K",
                "39","\"Want to be something nobody can do, you need to more try\"","truyện","phiêu lưu",
                "phiêu lưu"));
        arr_bean.add(new Adapter.ListViewBean(R.drawable.a2,"Gun fire at the dock","120 K","9.7 K",
                "41","\"Want to be something nobody can do, you need to more try\"","gun","cổ điển",
                "viễn tưởng"));
        arr_bean.add(new Adapter.ListViewBean(R.drawable.a3,"Collins","81 K","10.6 K",
                "4","\"Want to be something nobody can do, you need to more try\"","collins","hài hước",
                "lãng mạn"));
        arr_bean.add(new Adapter.ListViewBean(R.drawable.a4,"Con đường hồi giáo","740 K","5.2 K",
                "78","\"Want to be something nobody can do, you need to more try\"","đường","thơ ca",
                "bí ẩn"));
        arr_bean.add(new Adapter.ListViewBean(R.drawable.a5,"Xóm trọ","19 K","3.5 K",
                "91","\"Want to be something nobody can do, you need to more try\"","xóm","cổ điển",
                "hài hước"));
        arr_bean.add(new Adapter.ListViewBean(R.drawable.a6,"Cucho cậu bé hiếu thảo","899 K","6.9 K",
                "24","\"Want to be something nobody can do, you need to more try\"","cucho","thơ ca",
                "cổ điển"));
        adapter=new Adapter.ListViewBaseAdapter(arr_bean,getContext());
        lv.setAdapter(adapter);
        return view;
    }
}