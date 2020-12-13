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

import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.R;
import com.example.wattpadclone.Bell.Adapter.story;
import com.example.wattpadclone.Bell.Adapter.storyAdapter;

import java.util.ArrayList;


public class FragmentBookDetails extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_details, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar_book_details);
        toolbar.setLogo(ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.popFragments();
            }
        });

        ArrayList<story> arrayList;
        RecyclerView recyclerView;
        storyAdapter adapter;

        recyclerView = view.findViewById(R.id.recycler);
        arrayList = new ArrayList<>();
        arrayList.add(new story("Yêu Thương Và Friendzone",R.drawable.truyen2));
        arrayList.add(new story("Nếu Như Yêu",R.drawable.tr3));
        arrayList.add(new story("Buông Tay Ra Là Ăn Đấm Đấy",R.drawable.tr4));
        arrayList.add(new story("Phượng Hoàng",R.drawable.tr5));
        arrayList.add(new story("Con Rồng Cháu Tiên",R.drawable.tr6));
        arrayList.add(new story("SaberTooth Là Nơi Tôi Thuộc Về",R.drawable.truyen1));
        adapter = new storyAdapter(getContext(),arrayList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);

        //animator
        //decorationg recyclerview
        DividerItemDecoration dividerHorizontal = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.setHasFixedSize(true);

        return view;
    }




}