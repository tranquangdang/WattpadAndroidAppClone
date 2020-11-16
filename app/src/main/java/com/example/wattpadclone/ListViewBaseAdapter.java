package com.example.wattpadclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewBaseAdapter extends BaseAdapter {
    public ArrayList<ListViewBean> arraylistListener;
    private List<ListViewBean> mListenerList;
    Context mContext;

    public ListViewBaseAdapter(List<ListViewBean> mListenerList, Context context) {

        mContext = context;
        this.mListenerList = mListenerList;
        this.arraylistListener = new ArrayList<ListViewBean>();
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
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_lv_adapter, null);
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
