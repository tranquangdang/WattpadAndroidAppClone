package com.example.wattpadclone.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter {
    public static class ListViewBaseAdapter extends BaseAdapter {
        public ArrayList<Book> arraylistListener;
        private List<Book> mListenerList;
        Context mContext;

        public ListViewBaseAdapter(ArrayList<Book> mListenerList, Context context) {
            mContext = context;
            this.mListenerList = mListenerList;
            this.arraylistListener = new ArrayList<>();
            this.arraylistListener.addAll(mListenerList);
        }

        public class ViewHolder {
            ImageView lv_topic_anh;
            TextView lv_topic_title,lv_topic_eye,lv_topic_star,lv_topic_menu,lv_topic_contentt,lv_topic_more,lv_topic_sum_tag;
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
                holder.lv_topic_more=view.findViewById(R.id.lv_topic_more);
                holder.lv_topic_sum_tag=view.findViewById(R.id.lv_topic_sum_tag);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            try {
                Glide.with(mContext).load(mListenerList.get(i).getBookImg()).into(holder.lv_topic_anh);
                holder.lv_topic_title.setText(String.valueOf(mListenerList.get(i).getBookName()));
                holder.lv_topic_contentt.setText(String.valueOf(mListenerList.get(i).getIntro()));
                holder.lv_topic_eye.setText(String.valueOf(Integer.valueOf(mListenerList.get(i).getWritten())));
                holder.lv_topic_star.setText(String.valueOf(Integer.valueOf(mListenerList.get(i).getFavorite())));
                holder.lv_topic_menu.setText(String.valueOf(Integer.valueOf(mListenerList.get(i).getChapter()) + " phần"));
                holder.lv_topic_more=view.findViewById(R.id.lv_topic_more);
                holder.lv_topic_sum_tag=view.findViewById(R.id.lv_topic_sum_tag);
            }catch (Exception ex){

            }
            return view;
        }
    }

    public static class MainAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;
        private String[] name;
        private int[] img;

        public MainAdapter(Context c, String[] name, int[] img) {
            this.context = c;
            this.name = name;
            this.img = img;
        }

        @Override
        public int getCount() {
            return name.length;
        }


        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if(inflater==null){
                inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            }
            if(view==null){
                view=inflater.inflate(R.layout.row_item,null);
            }
            TextView textView=view.findViewById(R.id.text);
            ImageView imageView= view.findViewById(R.id.image);
            imageView.setImageResource(img[position]);
            textView.setText(name[position]);
            return view;
        }
    }

}
