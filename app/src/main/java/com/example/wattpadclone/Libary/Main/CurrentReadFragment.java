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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.Bean.MyGridView;
import com.example.wattpadclone.Chung.Detalts.ActivityBookDetails;
import com.example.wattpadclone.Chung.WebServices;
import com.example.wattpadclone.Libary.Adapter.CurrentReadAdapter;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class CurrentReadFragment extends Fragment {
    MyGridView gr_Current_off_2,gr_Current_off;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.current_read_fragment, container, false);
        addCurrent_Read_1(view);
        addCurrent_Read_2(view);
        registerForContextMenu(gr_Current_off_2);
        registerForContextMenu(gr_Current_off);
        return view;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu_curentread,menu);
        menu.setHeaderTitle("Book title");
    }
    private void addCurrent_Read_1(View view) {
         gr_Current_off= view.findViewById(R.id.gr_current_off);
         gr_Current_off.setPadding(getResources().getDimensionPixelOffset(R.dimen.dp10),0,getResources().getDimensionPixelOffset(R.dimen.dp10),0);
        gr_Current_off.setVerticalSpacing(getResources().getDimensionPixelOffset(R.dimen.dp19));
        gr_Current_off.setHorizontalSpacing(getResources().getDimensionPixelOffset(R.dimen.dp10));
        ArrayList<Book> offlineArrayList=new ArrayList<>();
        CurrentReadAdapter offlineAdapterr=new CurrentReadAdapter(offlineArrayList,getContext());
        gr_Current_off.setAdapter(offlineAdapterr);
        WebServices webServices = new WebServices(getActivity());
        webServices.GetDataCurrentReadAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=1", offlineArrayList,offlineAdapterr);
        webServices.GetDataCurrentReadAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=2", offlineArrayList,offlineAdapterr);
        webServices.GetDataCurrentReadAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=11", offlineArrayList,offlineAdapterr);
        webServices.GetDataCurrentReadAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=4", offlineArrayList,offlineAdapterr);
        webServices.GetDataCurrentReadAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=8", offlineArrayList,offlineAdapterr);
        gr_Current_off.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ActivityBookDetails.class);
                intent.putExtra("BookID", "2");
                getContext().startActivity(intent);
            }
        });
    }
    public void addCurrent_Read_2(View view) {
         gr_Current_off_2= view.findViewById(R.id.gr_current_off_2);
        gr_Current_off_2.setPadding(getResources().getDimensionPixelOffset(R.dimen.dp10),0,getResources().getDimensionPixelOffset(R.dimen.dp10),0);
         gr_Current_off_2.setVerticalSpacing(getResources().getDimensionPixelOffset(R.dimen.dp19));
         gr_Current_off_2.setHorizontalSpacing(getResources().getDimensionPixelOffset(R.dimen.dp10));
        ArrayList<Book> offline_2ArrayList=new ArrayList<>();
        CurrentReadAdapter offlineAdapter_2 =new CurrentReadAdapter(offline_2ArrayList,getContext());
        gr_Current_off_2.setAdapter(offlineAdapter_2);
        WebServices webServices = new WebServices(getActivity());
        webServices.GetDataCurrentReadAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=3", offline_2ArrayList,offlineAdapter_2);
        webServices.GetDataCurrentReadAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=5", offline_2ArrayList,offlineAdapter_2);
        webServices.GetDataCurrentReadAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=7", offline_2ArrayList,offlineAdapter_2);
        webServices.GetDataCurrentReadAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=9", offline_2ArrayList,offlineAdapter_2);
        gr_Current_off_2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ActivityBookDetails.class);
                intent.putExtra("BookID", "2");
                getContext().startActivity(intent);
            }
        });
    }
}