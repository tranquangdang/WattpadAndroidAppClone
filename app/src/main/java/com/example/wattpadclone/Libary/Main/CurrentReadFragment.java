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

import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.WebServices;
import com.example.wattpadclone.Libary.Adapter.LibraryAdapter;
import com.example.wattpadclone.R;
import com.example.wattpadclone.Search.SearchListActivity;

import java.util.ArrayList;

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
        addCurrent_off(view);
        addCurrent_off_2(view);
        topic1=view.findViewById(R.id.topic1);
        topic2=view.findViewById(R.id.topic2);
        topic3=view.findViewById(R.id.topic3);
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
    public void addCurrent_off_2(View view) {
         gr_Current_off_2= view.findViewById(R.id.gr_current_off_2);
        ArrayList<Book> offline_2ArrayList=new ArrayList<>();
        LibraryAdapter offlineAdapter_2 =new LibraryAdapter(offline_2ArrayList,getContext());
        gr_Current_off_2.setAdapter(offlineAdapter_2);
        WebServices webServices = new WebServices(getActivity());
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=3", offline_2ArrayList,offlineAdapter_2);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=5", offline_2ArrayList,offlineAdapter_2);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=7", offline_2ArrayList,offlineAdapter_2);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=10", offline_2ArrayList,offlineAdapter_2);
    }
    private void addCurrent_off(View view) {
        GridView gr_Current_off= view.findViewById(R.id.gr_current_off);
        ArrayList<Book> offlineArrayList=new ArrayList<>();
        LibraryAdapter offlineAdapterr=new LibraryAdapter(offlineArrayList,getContext());
        gr_Current_off.setAdapter(offlineAdapterr);
        WebServices webServices = new WebServices(getActivity());
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=1", offlineArrayList,offlineAdapterr);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=2", offlineArrayList,offlineAdapterr);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=3", offlineArrayList,offlineAdapterr);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=9", offlineArrayList,offlineAdapterr);
    }
}