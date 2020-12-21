package com.example.wattpadclone.Libary.Main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wattpadclone.R;

public class ReadingListFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.reading_list_fragment, container, false);
        //addRedingList(view);
        return view;
    }
//    private void addRedingList(View view) {
//        ListView lv_readinglist= view.findViewById(R.id.lv_reading);
//        ArrayList<ReadingList> readingArrayList=new ArrayList<ReadingList>();
//        readingArrayList.add(new ReadingList(R.mipmap.mtp,R.mipmap.shawn,R.mipmap.badboy,"Thang's List","5 stories"));
//        readingArrayList.add(new ReadingList(R.mipmap.bccmerlin,R.mipmap.shawn2,R.mipmap.thelove,"List for day","3 stories"));
//        readingArrayList.add(new ReadingList(R.mipmap.thelove,R.mipmap.badboy,R.mipmap.mtp,"For Happy'List","6 stories"));
//        ReadingListAdapter readingadapter=new ReadingListAdapter(readingArrayList,getContext());
//        lv_readinglist.setAdapter(readingadapter);
//    }
}