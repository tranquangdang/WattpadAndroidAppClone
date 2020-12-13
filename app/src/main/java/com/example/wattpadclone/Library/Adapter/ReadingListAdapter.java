package com.example.wattpadclone.Library.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wattpadclone.R;

import java.util.ArrayList;
import java.util.List;

public class ReadingListAdapter extends BaseAdapter {
    Context mContext;
    public ArrayList<ReadingList> arraylistListener3;
    private List<ReadingList> mListenerList3;

    public ReadingListAdapter(ArrayList<ReadingList> mListenerList3, Context context) {
        mContext = context;
        this.mListenerList3 = mListenerList3;
        this.arraylistListener3 = new ArrayList<ReadingList>();
        this.arraylistListener3.addAll(mListenerList3);
    }
    public class ViewHolder {
        ImageView anh1,anh2,anh3;
        TextView title;
        TextView stories;
    }
    @Override
    public int getCount() {
        return mListenerList3.size();
    }

    @Override
    public Object getItem(int i) {
        return mListenerList3.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ReadingListAdapter.ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout3_watpad, null);
            holder = new ReadingListAdapter.ViewHolder();
            holder.anh1 = (ImageView) view.findViewById(R.id.anh1);
            holder.anh2 = (ImageView) view.findViewById(R.id.anh2);
            holder.anh3 = (ImageView) view.findViewById(R.id.anh3);
            holder.title=(TextView)view.findViewById(R.id.lv_reading_title);
            holder.stories=view.findViewById(R.id.lv_reading_stories);
            view.setTag(holder);
        } else {
            holder = (ReadingListAdapter.ViewHolder) view.getTag();
        }
        try {
            int image1 = mListenerList3.get(i).getAnh1();
            int image2 = mListenerList3.get(i).getAnh2();
            int image3 = mListenerList3.get(i).getAnh3();
            holder.anh1.setImageResource(mListenerList3.get(i).getAnh1());
            holder.anh2.setImageResource(mListenerList3.get(i).getAnh2());
            holder.anh3.setImageResource(mListenerList3.get(i).getAnh3());
            holder.title.setText(mListenerList3.get(i).getTitle());
            holder.stories.setText(mListenerList3.get(i).getStories());
        }catch (Exception ex){

        }
        return view;
    }
}
