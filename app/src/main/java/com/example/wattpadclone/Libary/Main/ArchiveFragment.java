package com.example.wattpadclone.Libary.Main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.WebServices;
import com.example.wattpadclone.Libary.Adapter.LibraryAdapter;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class ArchiveFragment extends Fragment {
    GridView gr_watpad;
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
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu_archive,menu);
        menu.setHeaderTitle("Shawn Mendes Imagines");
    }
    private void addArchive(View view) {
        gr_watpad= view.findViewById(R.id.gr_watpad);
        ArrayList<Book> watpadArrayList=new ArrayList<>();
        LibraryAdapter adapter =new LibraryAdapter(watpadArrayList,getContext());
        gr_watpad.setAdapter(adapter);
        WebServices webServices = new WebServices(getActivity());
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=3", watpadArrayList,adapter);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=5", watpadArrayList,adapter);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=7", watpadArrayList,adapter);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=10", watpadArrayList,adapter);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=3", watpadArrayList,adapter);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=5", watpadArrayList,adapter);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=7", watpadArrayList,adapter);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=10", watpadArrayList,adapter);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=3", watpadArrayList,adapter);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=5", watpadArrayList,adapter);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=7", watpadArrayList,adapter);
        webServices.GetDataLibraryAdapter("http://tranquangdang.000webhostapp.com/index.php?BookID=10", watpadArrayList,adapter);
    }
}