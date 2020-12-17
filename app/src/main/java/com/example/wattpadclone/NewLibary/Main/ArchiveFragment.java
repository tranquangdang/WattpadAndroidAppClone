package com.example.wattpadclone.NewLibary.Main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.wattpadclone.NewLibary.Adapter.ReadingList;
import com.example.wattpadclone.NewLibary.Adapter.ReadingListAdapter;
import com.example.wattpadclone.NewLibary.Adapter.offline;
import com.example.wattpadclone.NewLibary.Adapter.offlineAdapter;
import com.example.wattpadclone.NewLibary.Adapter.offline_2;
import com.example.wattpadclone.NewLibary.Adapter.watpad;
import com.example.wattpadclone.NewLibary.Adapter.watpadAdapter;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class ArchiveFragment extends Fragment {
    ListView lv_readinglist;
    GridView gr_watpad,gr_Current_off,gr_Current_off_2;
    com.example.wattpadclone.NewLibary.Adapter.offlineAdapter_2 offlineAdapter_2;
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
        View view = inflater.inflate(R.layout.archive_fragment, container, false);
        addArchive(view);
        return view;
    }
    private void addArchive(View view) {
        GridView gr_watpad= view.findViewById(R.id.gr_watpad);
        ArrayList<watpad> watpadArrayList=new ArrayList<watpad>();
        watpadArrayList.add(new watpad(R.mipmap.bccmerlin, "Jacob","King Of Element"));
        watpadArrayList.add(new watpad(R.mipmap.badboy, "Tim Hand","Bad Boy"));
        watpadArrayList.add(new watpad(R.mipmap.sweetoflife, "Han Sara","Sweet Of Life"));
        watpadArrayList.add(new watpad(R.mipmap.thelove, "Julie Tran","The Love"));
        watpadAdapter adapter =new watpadAdapter(watpadArrayList,getContext());
        gr_watpad.setAdapter(adapter);
    }
}