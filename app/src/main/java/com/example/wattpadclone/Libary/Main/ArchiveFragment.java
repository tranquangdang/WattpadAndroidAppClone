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

import com.example.wattpadclone.R;

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
        //addArchive(view);
        //registerForContextMenu(gr_watpad);
        return view;

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu_archive,menu);
        menu.setHeaderTitle("Shawn Mendes Imagines");
    }
//    private void addArchive(View view) {
//        gr_watpad= view.findViewById(R.id.gr_watpad);
//        ArrayList<watpad> watpadArrayList=new ArrayList<watpad>();
//        watpadArrayList.add(new watpad(R.mipmap.bccmerlin, "Jacob","King Of Element"));
//        watpadArrayList.add(new watpad(R.mipmap.badboy, "Tim Hand","Bad Boy"));
//        watpadArrayList.add(new watpad(R.mipmap.sweetoflife, "Han Sara","Sweet Of Life"));
//        watpadArrayList.add(new watpad(R.mipmap.thelove, "Julie Tran","The Love"));
//        watpadAdapter adapter =new watpadAdapter(watpadArrayList,getContext());
//        gr_watpad.setAdapter(adapter);
//
//    }
}