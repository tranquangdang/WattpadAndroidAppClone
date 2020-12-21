package com.example.wattpadclone.Chung.Detalts;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.wattpadclone.Base.Adapter.Bean.IntroBean;
import com.example.wattpadclone.Base.Adapter.vpIntroAdapter;
import com.example.wattpadclone.Base.IntroActivity;
import com.example.wattpadclone.Base.SignUpActivity;
import com.example.wattpadclone.Libary.Adapter.ViewPagerAdapter;
import com.example.wattpadclone.R;
import com.example.wattpadclone.Bell.Adapter.story;
import com.example.wattpadclone.Bell.Adapter.storyAdapter;

import java.util.ArrayList;
import java.util.List;


public class ActivityBookDetails extends AppCompatActivity {
    ViewPager viewPager;
    detailts_headAdapter adapter;
    List<IntroBean> ImgList;

    ArrayList<story> arrayList;
    RecyclerView recyclerView;
    storyAdapter adapter1;

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



        recyclerView = findViewById(R.id.recycler);
        arrayList = new ArrayList<>();
        arrayList.add(new story("Yêu Thương Và Friendzone",R.mipmap.truyen2));
        arrayList.add(new story("Nếu Như Yêu",R.mipmap.tr3));
        arrayList.add(new story("Buông Tay Ra Là Ăn Đấm Đấy",R.mipmap.tr4));
        arrayList.add(new story("Phượng Hoàng",R.mipmap.tr5));
        arrayList.add(new story("Con Rồng Cháu Tiên",R.mipmap.tr6));
        arrayList.add(new story("SaberTooth Là Nơi Tôi Thuộc Về",R.mipmap.truyen1));
        adapter1 = new storyAdapter(this,arrayList);
        recyclerView.setAdapter(adapter1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);

        //animator
        //decoration recyclerview
      DividerItemDecoration dividerHorizontal = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.setHasFixedSize(true);

        //viewpager head
        viewPager   = (ViewPager) findViewById(R.id.viewPager_detail);

        ImgList   = new ArrayList<>();
        ImgList  .add(new   IntroBean(R.mipmap.tr3));
        ImgList  .add(new   IntroBean(R.mipmap.truyen2));
        ImgList  .add(new   IntroBean(R.mipmap.tr4));
        ImgList  .add(new   IntroBean(R.mipmap.tr5));

        ImgList  .add(new   IntroBean(R.mipmap.tr6));
        ImgList  .add(new   IntroBean(R.mipmap.truyen1));

        adapter   = new detailts_headAdapter(ImgList, ActivityBookDetails.this);
        viewPager .setAdapter(adapter);

    }


}