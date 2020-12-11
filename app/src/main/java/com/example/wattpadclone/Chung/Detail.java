package com.example.wattpadclone.Chung;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wattpadclone.R;
import com.example.wattpadclone.story;
import com.example.wattpadclone.storyAdapter;

import java.util.ArrayList;


public class Detail extends AppCompatActivity {
    private ArrayList<story> arrayList;
    public RecyclerView recyclerView;
    private storyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        recyclerView = findViewById(R.id.recycler);
        arrayList = new ArrayList<>();
        createlist();
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

    private void createlist() {
        arrayList.add(new story("Yêu Thương Và Friendzone",R.drawable.truyen2));
        arrayList.add(new story("Nếu Như Yêu",R.drawable.tr3));
        arrayList.add(new story("Buông Tay Ra Là Ăn Đấm Đấy",R.drawable.tr4));
        arrayList.add(new story("Phượng Hoàng",R.drawable.tr5));
        arrayList.add(new story("Con Rồng Cháu Tiên",R.drawable.tr6));
        arrayList.add(new story("SaberTooth Là Nơi Tôi Thuộc Về",R.drawable.truyen1));
    }


}