package com.example.wattpadclone.Libary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.R;

import java.util.ArrayList;
import java.util.List;

public class offlineAdapter extends BaseAdapter {
    public ArrayList<Book> arraylistListener;
    private List<Book> mListenerList;
    Context mContext;
    public offlineAdapter(List<Book> mListenerList, Context context) {
        mContext = context;
        this.mListenerList = mListenerList;
        this.arraylistListener = new ArrayList<Book>();
        this.arraylistListener.addAll(mListenerList);
    }
    public class ViewHolder {
        ImageView gr_anh_off;
        TextView gr_name_off;
        TextView gr_title_off;
    }
    @Override
    public int getCount() {
        return mListenerList.size();
    }
    @Override
    public Object getItem(int i) {
        return mListenerList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final offlineAdapter.ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout1_offlline, null);
            holder = new ViewHolder();
            holder.gr_anh_off =  view.findViewById(R.id.lv_anh_offline);
            holder.gr_name_off=view.findViewById(R.id.lv_name_offline);
            holder.gr_title_off=view.findViewById(R.id.lv_title_offline);
            view.setTag(holder);
        } else {
            holder = (offlineAdapter.ViewHolder) view.getTag();
        }
        try {
            String image = mListenerList.get(i).getBookImg();
            holder.gr_anh_off.setImageResource(Integer.parseInt(mListenerList.get(i).getBookImg()));
            holder.gr_name_off.setText(mListenerList.get(i).getAuthor());
            holder.gr_title_off.setText(mListenerList.get(i).getBookName());
        }catch (Exception ex){

        }
        return view;
    }
    }

