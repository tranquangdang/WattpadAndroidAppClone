package com.example.wattpadclone;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

//import android.widget.TabHost;

public class Library extends AppCompatActivity {
    ListView lv_readinglist;
    GridView gr_watpad,gr_Current_off,gr_Current_off_2;
    offlineAdapter_2 offlineAdapter_2;
    ArrayList<offline_2> offline_2ArrayList;
    offlineAdapter offlineAdapterr;
    ArrayList<offline> offlineArrayList;
    ReadingListAdapter readingadapter;
    ArrayList<ReadingList> readingArrayList;
    watpadAdapter adapter;
    ArrayList<watpad> watpadArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library);
        addArchive();
        addRedingList();
        addCurrent_off();
        addCurrent_off_2();
        loadTab();
        registerForContextMenu(gr_watpad);
        registerForContextMenu(gr_Current_off);
        //registerForContextMenu(gr_Current_off_2);
        registerForContextMenu(lv_readinglist);
        //getSupportActionBar().setTitle("  Library");
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.coloractionabr)));
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_bottom_navigation:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.lib_bottom_navigation:
                        startActivity(new Intent(getApplicationContext(), Library.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search_bottom_navigation:
                        startActivity(new Intent(getApplicationContext(), Search.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.noti_bottom_navigation:
                        startActivity(new Intent(getApplicationContext(), Bell.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
    public void openTopic(View view) {
        startActivity(new Intent(getApplicationContext(),lv_topic.class));
    }
    private void addCurrent_off_2() {
        gr_Current_off_2=findViewById(R.id.gr_current_off_2);
        offline_2ArrayList=new ArrayList<offline_2>();
        offline_2ArrayList.add(new offline_2(R.drawable.mtp,"Sky for us","M-TP"));
//        offline_2ArrayList.add(new offline_2(R.drawable.mtp,"Sky for us","M-TP"));
//        offline_2ArrayList.add(new offline_2(R.drawable.mtp,"Sky for us","M-TP"));
        offlineAdapter_2=new offlineAdapter_2(offline_2ArrayList,this);
        gr_Current_off_2.setAdapter(offlineAdapter_2);
    }
    private void addCurrent_off() {
        gr_Current_off=findViewById(R.id.gr_current_off);
        offlineArrayList=new ArrayList<offline>();
        offlineArrayList.add(new offline(R.drawable.elish,"Billie Eilish","The Best"));
        offlineArrayList.add(new offline(R.drawable.shawn,"Shawn Mendes","Imagines"));
        offlineArrayList.add(new offline(R.drawable.shawn2,"Shawn Mendes","Imagines"));
        offlineAdapterr=new offlineAdapter(offlineArrayList,this);
        gr_Current_off.setAdapter(offlineAdapterr);
    }
    private void addRedingList() {
        lv_readinglist=findViewById(R.id.lv_reading);
        readingArrayList=new ArrayList<ReadingList>();
        readingArrayList.add(new ReadingList(R.drawable.mtp,R.drawable.shawn,R.drawable.badboy,"Thang's List","5 stories"));
        readingArrayList.add(new ReadingList(R.drawable.bccmerlin,R.drawable.shawn2,R.drawable.thelove,"List for day","3 stories"));
        readingArrayList.add(new ReadingList(R.drawable.thelove,R.drawable.badboy,R.drawable.mtp,"For Happy'List","6 stories"));
        readingadapter=new ReadingListAdapter(readingArrayList,this);
        lv_readinglist.setAdapter(readingadapter);
    }
    private void addArchive() {
        gr_watpad=findViewById(R.id.gr_watpad);
        watpadArrayList=new ArrayList<watpad>();
        watpadArrayList.add(new watpad(R.drawable.bccmerlin, "Jacob","King Of Element"));
        watpadArrayList.add(new watpad(R.drawable.badboy, "Tim Hand","Bad Boy"));
        watpadArrayList.add(new watpad(R.drawable.sweetoflife, "Han Sara","Sweet Of Life"));
        watpadArrayList.add(new watpad(R.drawable.thelove, "Julie Tran","The Love"));
        adapter=new watpadAdapter(watpadArrayList,this);
        gr_watpad.setAdapter(adapter);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Shawn Mendes Imagines");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        getMenuInflater().inflate(R.menu.menu_toolbar_home,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void loadTab() {
        final TabHost tab=(TabHost) findViewById (android.R.id.tabhost);
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