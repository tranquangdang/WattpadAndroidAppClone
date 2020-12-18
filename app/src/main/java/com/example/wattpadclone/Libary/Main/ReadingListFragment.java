package com.example.wattpadclone.Libary.Main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.wattpadclone.Libary.Adapter.ReadingList;
import com.example.wattpadclone.Libary.Adapter.ReadingListAdapter;
import com.example.wattpadclone.Libary.Adapter.offline;
import com.example.wattpadclone.Libary.Adapter.offlineAdapter;
import com.example.wattpadclone.Libary.Adapter.offline_2;
import com.example.wattpadclone.Libary.Adapter.watpad;
import com.example.wattpadclone.Libary.Adapter.watpadAdapter;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class ReadingListFragment extends Fragment {
    ListView lv_readinglist;
    GridView gr_watpad,gr_Current_off,gr_Current_off_2;
    com.example.wattpadclone.Libary.Adapter.offlineAdapter_2 offlineAdapter_2;
    ArrayList<offline_2> offline_2ArrayList;
    offlineAdapter offlineAdapterr;
    ArrayList<offline> offlineArrayList;
    ReadingListAdapter readingadapter;
    ArrayList<ReadingList> readingArrayList;
    watpadAdapter adapter;
    ArrayList<watpad> watpadArrayList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.reading_list_fragment, container, false);
        addRedingList(view);
        return view;
    }
    private void addRedingList(View view) {
        ListView lv_readinglist= view.findViewById(R.id.lv_reading);
        ArrayList<ReadingList> readingArrayList=new ArrayList<ReadingList>();
        readingArrayList.add(new ReadingList(R.mipmap.mtp,R.mipmap.shawn,R.mipmap.badboy,"Thang's List","5 stories"));
        readingArrayList.add(new ReadingList(R.mipmap.bccmerlin,R.mipmap.shawn2,R.mipmap.thelove,"List for day","3 stories"));
        readingArrayList.add(new ReadingList(R.mipmap.thelove,R.mipmap.badboy,R.mipmap.mtp,"For Happy'List","6 stories"));
        ReadingListAdapter readingadapter=new ReadingListAdapter(readingArrayList,getContext());
        lv_readinglist.setAdapter(readingadapter);
    }
}