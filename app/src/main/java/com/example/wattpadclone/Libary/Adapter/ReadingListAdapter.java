package com.example.wattpadclone.Libary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.R;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

public class ReadingListAdapter extends BaseAdapter {
    Context mContext;
    public ArrayList<Book> arraylistListener3;
    private List<Book> mListenerList3;

    public ReadingListAdapter(ArrayList<Book> mListenerList3, Context context) {
        mContext = context;
        this.mListenerList3 = mListenerList3;
        this.arraylistListener3 = new ArrayList<Book>();
        this.arraylistListener3.addAll(mListenerList3);
    }

    public class ViewHolder {
        ImageView anh1, anh2, anh3;
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
            holder.title = (TextView) view.findViewById(R.id.lv_reading_title);
            holder.stories = view.findViewById(R.id.lv_reading_stories);
            view.setTag(holder);
        } else {
            holder = (ReadingListAdapter.ViewHolder) view.getTag();
        }
        try {
            String image1 = mListenerList3.get(i).getBookImg();
            String image2 = mListenerList3.get(i).getBookImg();
            String image3 = mListenerList3.get(i).getBookImg();
            holder.anh1.setImageResource(Integer.parseInt(mListenerList3.get(i).getBookImg()));
            holder.anh2.setImageResource(Integer.parseInt(mListenerList3.get(i).getBookImg()));
            holder.anh3.setImageResource(Integer.parseInt(mListenerList3.get(i).getBookImg()));
            holder.title.setText(mListenerList3.get(i).getBookName());
            holder.stories.setText(mListenerList3.get(i).getAuthor());
        } catch (Exception ex) {

        }
//
        return view;
    }
}
