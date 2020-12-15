package com.example.wattpadclone.Chung;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wattpadclone.R;
import com.example.wattpadclone.Bell.Adapter.story;
import com.example.wattpadclone.Bell.Adapter.storyAdapter;

import java.util.ArrayList;


public class ActivityBookDetails extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        Toolbar toolbar = findViewById(R.id.toolbar_book_details);
        toolbar.setLogo(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });

        ArrayList<story> arrayList;
        RecyclerView recyclerView;
        storyAdapter adapter;

        recyclerView = findViewById(R.id.recycler);
        arrayList = new ArrayList<>();
        arrayList.add(new story("Yêu Thương Và Friendzone",R.mipmap.truyen2));
        arrayList.add(new story("Nếu Như Yêu",R.mipmap.tr3));
        arrayList.add(new story("Buông Tay Ra Là Ăn Đấm Đấy",R.mipmap.tr4));
        arrayList.add(new story("Phượng Hoàng",R.mipmap.tr5));
        arrayList.add(new story("Con Rồng Cháu Tiên",R.mipmap.tr6));
        arrayList.add(new story("SaberTooth Là Nơi Tôi Thuộc Về",R.mipmap.truyen1));
        adapter = new storyAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);

        //animator
        //decorationg recyclerview
        DividerItemDecoration dividerHorizontal = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.setHasFixedSize(true);
    }




}