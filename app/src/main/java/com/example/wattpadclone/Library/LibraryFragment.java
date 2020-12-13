package com.example.wattpadclone.Library;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.R;

import java.util.ArrayList;

//import android.widget.TabHost;

public class LibraryFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar_library);
        toolbar.setLogo(ContextCompat.getDrawable(getContext(), R.drawable.ic_logo));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        addArchive(view);
        addRedingList(view);
        addCurrent_off(view);
        addCurrent_off_2(view);
        loadTab(view);
        registerForContextMenu(view);
        registerForContextMenu(view);
        //registerForContextMenu(gr_Current_off_2);
        registerForContextMenu(view);
        //getSupportActionBar().setTitle("  Library");
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.coloractionabr)));


        return view;
    }

    public void openTopic() {
        startActivity(new Intent(getActivity(), lv_topic.class));
    }
    public void addCurrent_off_2(View view) {
        GridView gr_Current_off_2= view.findViewById(R.id.gr_current_off_2);
        ArrayList<offline_2> offline_2ArrayList=new ArrayList<offline_2>();
        offline_2ArrayList.add(new offline_2(R.drawable.mtp,"Sky for us","M-TP"));
//        offline_2ArrayList.add(new offline_2(R.drawable.mtp,"Sky for us","M-TP"));
//        offline_2ArrayList.add(new offline_2(R.drawable.mtp,"Sky for us","M-TP"));
        offlineAdapter_2 offlineAdapter_2=new offlineAdapter_2(offline_2ArrayList,getContext());
        gr_Current_off_2.setAdapter(offlineAdapter_2);
    }
    private void addCurrent_off(View view) {
        GridView gr_Current_off= view.findViewById(R.id.gr_current_off);
        ArrayList<offline> offlineArrayList=new ArrayList<offline>();
        offlineArrayList.add(new offline(R.drawable.elish,"Billie Eilish","The Best"));
        offlineArrayList.add(new offline(R.drawable.shawn,"Shawn Mendes","Imagines"));
        offlineArrayList.add(new offline(R.drawable.shawn2,"Shawn Mendes","Imagines"));
        offlineAdapter offlineAdapterr=new offlineAdapter(offlineArrayList,getContext());
        gr_Current_off.setAdapter(offlineAdapterr);
    }
    private void addRedingList(View view) {
        ListView lv_readinglist= view.findViewById(R.id.lv_reading);
        ArrayList<ReadingList> readingArrayList=new ArrayList<ReadingList>();
        readingArrayList.add(new ReadingList(R.drawable.mtp,R.drawable.shawn,R.drawable.badboy,"Thang's List","5 stories"));
        readingArrayList.add(new ReadingList(R.drawable.bccmerlin,R.drawable.shawn2,R.drawable.thelove,"List for day","3 stories"));
        readingArrayList.add(new ReadingList(R.drawable.thelove,R.drawable.badboy,R.drawable.mtp,"For Happy'List","6 stories"));
        ReadingListAdapter readingadapter=new ReadingListAdapter(readingArrayList,getContext());
        lv_readinglist.setAdapter(readingadapter);
    }
    private void addArchive(View view) {
        GridView gr_watpad= view.findViewById(R.id.gr_watpad);
        ArrayList<watpad> watpadArrayList=new ArrayList<watpad>();
        watpadArrayList.add(new watpad(R.drawable.bccmerlin, "Jacob","King Of Element"));
        watpadArrayList.add(new watpad(R.drawable.badboy, "Tim Hand","Bad Boy"));
        watpadArrayList.add(new watpad(R.drawable.sweetoflife, "Han Sara","Sweet Of Life"));
        watpadArrayList.add(new watpad(R.drawable.thelove, "Julie Tran","The Love"));
        watpadAdapter adapter =new watpadAdapter(watpadArrayList,getContext());
        gr_watpad.setAdapter(adapter);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater= getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Shawn Mendes Imagines");
    }

    private void loadTab(View view) {
        final TabHost tab=(TabHost) view.findViewById (android.R.id.tabhost);
        //tab.getTabWidget().getChildAt(tab.getCurrentTab()).getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
        //gọi lệnh setup
        tab.setup();
        TabHost.TabSpec spec;
        //Tạo tab1
        spec=tab.newTabSpec("t1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Current Reads");
        tab.addTab(spec);
        //Tạo tab2
        spec=tab.newTabSpec("t2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Archive");
        tab.addTab(spec);
        spec=tab.newTabSpec("t3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Reading Lists");
        tab.addTab(spec);
        //Thiết lập tab mặc định được chọn ban đầu là tab 0
        tab.setCurrentTab(0);
        tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String arg0) {
                String s="Tab tag="+arg0+"; index="+tab.getCurrentTab();
                //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
        });
    }


}