package com.example.wattpadclone.Search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.wattpadclone.Chung.ActivityBookDetails;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class SearchListActivity extends AppCompatActivity {
    ListView lv;
    Adapter.ListViewBaseAdapter adapter;
    ArrayList<Adapter.ListViewBean> arr_bean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);

        Toolbar toolbar = findViewById(R.id.toolbar_search_list);
        toolbar.setLogo(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        lv = findViewById(R.id.listview);
        arr_bean=new ArrayList<Adapter.ListViewBean>();
        arr_bean.add(new Adapter.ListViewBean(R.mipmap.a1,"Đối lập","239 K","1.7 K",
                "39","\"Want to be something nobody can do, you need to more try\"","truyện","+ 3 tag"));
        arr_bean.add(new Adapter.ListViewBean(R.mipmap.a2,"Gun fire at the dock","120 K","9.7 K",
                "39","\"Want to be something nobody can do, you need to more try\"","truyện","+ 3 tag"));
        arr_bean.add(new Adapter.ListViewBean(R.mipmap.a3,"Collins","81 K","10.6 K",
                "39","\"Want to be something nobody can do, you need to more try\"","truyện","+ 3 tag"));
        arr_bean.add(new Adapter.ListViewBean(R.mipmap.a4,"Con đường hồi giáo","740 K","5.2 K",
                "39","\"Want to be something nobody can do, you need to more try\"","truyện","+ 3 tag"));
        arr_bean.add(new Adapter.ListViewBean(R.mipmap.a5,"Xóm trọ","19 K","3.5 K",
                "39","\"Want to be something nobody can do, you need to more try\"","truyện","+ 3 tag"));
        arr_bean.add(new Adapter.ListViewBean(R.mipmap.a6,"Cucho cậu bé hiếu thảo","899 K","6.9 K",
                "39","\"Want to be something nobody can do, you need to more try\"","truyện","+ 3 tag"));
        adapter=new Adapter.ListViewBaseAdapter(arr_bean,this);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SearchListActivity.this, ActivityBookDetails.class);
                startActivity(intent);
            }
        });
    }

}