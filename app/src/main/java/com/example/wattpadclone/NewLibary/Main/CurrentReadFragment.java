package com.example.wattpadclone.NewLibary.Main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.wattpadclone.NewLibary.Adapter.offline;
import com.example.wattpadclone.NewLibary.Adapter.offlineAdapter;
import com.example.wattpadclone.NewLibary.Adapter.offlineAdapter_2;
import com.example.wattpadclone.NewLibary.Adapter.offline_2;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class CurrentReadFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.current_read_fragment, container, false);
        addCurrent_off(view);
        addCurrent_off_2(view);
        return view;
    }
    public void addCurrent_off_2(View view) {
        GridView gr_Current_off_2= view.findViewById(R.id.gr_current_off_2);
        ArrayList<offline_2> offline_2ArrayList=new ArrayList<offline_2>();
        offline_2ArrayList.add(new offline_2(R.mipmap.mtp,"Sky for us","M-TP"));
//        offline_2ArrayList.add(new offline_2(R.drawable.mtp,"Sky for us","M-TP"));
//        offline_2ArrayList.add(new offline_2(R.drawable.mtp,"Sky for us","M-TP"));
        offlineAdapter_2 offlineAdapter_2=new offlineAdapter_2(offline_2ArrayList,getContext());
        gr_Current_off_2.setAdapter(offlineAdapter_2);
    }
    private void addCurrent_off(View view) {
        GridView gr_Current_off= view.findViewById(R.id.gr_current_off);
        ArrayList<offline> offlineArrayList=new ArrayList<offline>();
        offlineArrayList.add(new offline(R.mipmap.elish,"Billie Eilish","The Best"));
        offlineArrayList.add(new offline(R.mipmap.shawn,"Shawn Mendes","Imagines"));
        offlineArrayList.add(new offline(R.mipmap.shawn2,"Shawn Mendes","Imagines"));
        offlineAdapter offlineAdapterr=new offlineAdapter(offlineArrayList,getContext());
        gr_Current_off.setAdapter(offlineAdapterr);
    }
}