package com.example.wattpadclone.Library;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.Library.Adapter.ReadingList;
import com.example.wattpadclone.Library.Adapter.ReadingListAdapter;
import com.example.wattpadclone.Library.Adapter.lv_topic_content;
import com.example.wattpadclone.Library.Adapter.offline;
import com.example.wattpadclone.Library.Adapter.offlineAdapter;
import com.example.wattpadclone.Library.Adapter.offlineAdapter_2;
import com.example.wattpadclone.Library.Adapter.offline_2;
import com.example.wattpadclone.Library.Adapter.watpad;
import com.example.wattpadclone.Library.Adapter.watpadAdapter;
import com.example.wattpadclone.R;

import java.util.ArrayList;
import java.util.List;

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
        toolbar.inflateMenu(R.menu.menu_toolbar_lib);
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
    private void addRedingList(View view) {
        ListView lv_readinglist= view.findViewById(R.id.lv_reading);
        ArrayList<ReadingList> readingArrayList=new ArrayList<ReadingList>();
        readingArrayList.add(new ReadingList(R.mipmap.mtp,R.mipmap.shawn,R.mipmap.badboy,"Thang's List","5 stories"));
        readingArrayList.add(new ReadingList(R.mipmap.bccmerlin,R.mipmap.shawn2,R.mipmap.thelove,"List for day","3 stories"));
        readingArrayList.add(new ReadingList(R.mipmap.thelove,R.mipmap.badboy,R.mipmap.mtp,"For Happy'List","6 stories"));
        ReadingListAdapter readingadapter=new ReadingListAdapter(readingArrayList,getContext());
        lv_readinglist.setAdapter(readingadapter);
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


    public static class lv_topic_content_adapter extends BaseAdapter {
        public ArrayList<lv_topic_content> arraylistListener;
        private List<lv_topic_content> mListenerList;
        Context mContext;
        public lv_topic_content_adapter(List<lv_topic_content> mListenerList, Context context) {
            mContext = context;
            this.mListenerList = mListenerList;
            this.arraylistListener = new ArrayList<lv_topic_content>();
            this.arraylistListener.addAll(mListenerList);
        }
        public class ViewHolder {
            ImageView lv_topic_anh;
            TextView lv_topic_title,lv_topic_eye,lv_topic_star,lv_topic_menu,lv_topic_contentt,lv_topic_more_1,lv_topic_more_2,lv_topic_more_3;
        }

        @Override
        public int getCount() {
            return mListenerList.size();
        }

        @Override
        public Object getItem(int position) {
            return mListenerList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int i, View view, ViewGroup parent) {
            final ViewHolder holder;
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.lv_topic_item, null);
                holder = new ViewHolder();
                holder.lv_topic_anh = (ImageView) view.findViewById(R.id.lv_topic_anh);
                holder.lv_topic_title=view.findViewById(R.id.lv_topic_title);
                holder.lv_topic_eye=view.findViewById(R.id.lv_topic_eye);
                holder.lv_topic_star=view.findViewById(R.id.lv_topic_star);
                holder.lv_topic_menu=view.findViewById(R.id.lv_topic_menu);
                holder.lv_topic_contentt=view.findViewById(R.id.lv_topic_contentt);
                holder.lv_topic_more_1=view.findViewById(R.id.lv_topic_more_1);
                holder.lv_topic_more_2=view.findViewById(R.id.lv_topic_more_2);
                holder.lv_topic_more_3=view.findViewById(R.id.lv_topic_more_3);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            try {
                int image = mListenerList.get(i).getLv_topic_anh();
                holder.lv_topic_anh.setImageResource(mListenerList.get(i).getLv_topic_anh());
                holder.lv_topic_title.setText(mListenerList.get(i).getLv_topic_title());
                holder.lv_topic_eye.setText(mListenerList.get(i).getLv_topic_eye());
                holder.lv_topic_star.setText(mListenerList.get(i).getLv_topic_star());
                holder.lv_topic_menu.setText(mListenerList.get(i).getLv_topic_menu());
                holder.lv_topic_contentt.setText(mListenerList.get(i).getLv_topic_contentt());
                holder.lv_topic_more_1.setText(mListenerList.get(i).getLv_topic_more_1());
                holder.lv_topic_more_2.setText(mListenerList.get(i).getLv_topic_more_2());
                holder.lv_topic_more_3.setText(mListenerList.get(i).getLv_topic_more_3());
            }catch (Exception ex){

            }
            return view;
        }
    }
}