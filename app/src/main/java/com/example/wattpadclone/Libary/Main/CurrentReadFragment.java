package com.example.wattpadclone.Libary.Main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.wattpadclone.R;
import com.example.wattpadclone.Search.SearchListActivity;

public class CurrentReadFragment extends Fragment {
    TextView topic1,topic2,topic3;
    GridView gr_Current_off_2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.current_read_fragment, container, false);
        //addCurrent_off(view);
        //addCurrent_off_2(view);
        topic1=view.findViewById(R.id.topic1);
        topic2=view.findViewById(R.id.topic2);
        topic3=view.findViewById(R.id.topic3);
        //registerForContextMenu(gr_Current_off_2);
        topic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchListActivity.class);
                startActivity(intent);
            }
        });
        topic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchListActivity.class);
                startActivity(intent);
            }
        });
        topic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchListActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu_curentread,menu);
        menu.setHeaderTitle("MTP title");
    }
//    public void addCurrent_off_2(View view) {
//         gr_Current_off_2= view.findViewById(R.id.gr_current_off_2);
//        ArrayList<offline_2> offline_2ArrayList=new ArrayList<offline_2>();
//        offline_2ArrayList.add(new offline_2(R.mipmap.mtp,"Sky for us","M-TP"));
////        offline_2ArrayList.add(new offline_2(R.drawable.mtp,"Sky for us","M-TP"));
////        offline_2ArrayList.add(new offline_2(R.drawable.mtp,"Sky for us","M-TP"));
//        offlineAdapter_2 offlineAdapter_2=new offlineAdapter_2(offline_2ArrayList,getContext());
//        gr_Current_off_2.setAdapter(offlineAdapter_2);
//    }
//    private void addCurrent_off(View view) {
//        GridView gr_Current_off= view.findViewById(R.id.gr_current_off);
//        ArrayList<Book> offlineArrayList=new ArrayList<offline>();
//        offlineArrayList.add(new offline(R.mipmap.elish,"Billie Eilish","The Best"));
//        offlineArrayList.add(new offline(R.mipmap.shawn,"Shawn Mendes","Imagines"));
//        offlineArrayList.add(new offline(R.mipmap.shawn2,"Shawn Mendes","Imagines"));
//        offlineAdapter offlineAdapterr=new offlineAdapter(offlineArrayList,getContext());
//        gr_Current_off.setAdapter(offlineAdapterr);
//    }
}