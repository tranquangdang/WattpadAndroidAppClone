package com.example.wattpadclone.Search;

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

public class Adapter {
    public static class ListViewBaseAdapter extends BaseAdapter {
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
                int image = mListenerList.get(i).getLv_topic_anh();
                holder.lv_topic_anh.setImageResource(mListenerList.get(i).getLv_topic_anh());
                holder.lv_topic_title.setText(mListenerList.get(i).getLv_topic_title());
                holder.lv_topic_eye.setText(mListenerList.get(i).getLv_topic_eye());
                holder.lv_topic_star.setText(mListenerList.get(i).getLv_topic_star());
                holder.lv_topic_menu.setText(mListenerList.get(i).getLv_topic_menu());
                holder.lv_topic_contentt.setText(mListenerList.get(i).getLv_topic_contentt());
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

    public static class ListViewBean {
        int Lv_topic_anh;
        String lv_topic_title,lv_topic_eye,lv_topic_star,lv_topic_menu,lv_topic_contentt, lv_topic_more, lv_topic_sum_tag;

        public ListViewBean(int lv_topic_anh, String lv_topic_title, String lv_topic_eye, String lv_topic_star, String lv_topic_menu, String lv_topic_contentt, String lv_topic_more, String lv_topic_sum_tag) {
            Lv_topic_anh = lv_topic_anh;
            this.lv_topic_title = lv_topic_title;
            this.lv_topic_eye = lv_topic_eye;
            this.lv_topic_star = lv_topic_star;
            this.lv_topic_menu = lv_topic_menu;
            this.lv_topic_contentt = lv_topic_contentt;
            this.lv_topic_more = lv_topic_more;
            this.lv_topic_sum_tag = lv_topic_sum_tag;
        }

        public int getLv_topic_anh() {
            return Lv_topic_anh;
        }

        public void setLv_topic_anh(int lv_topic_anh) {
            Lv_topic_anh = lv_topic_anh;
        }

        public String getLv_topic_title() {
            return lv_topic_title;
        }

        public void setLv_topic_title(String lv_topic_title) {
            this.lv_topic_title = lv_topic_title;
        }

        public String getLv_topic_eye() {
            return lv_topic_eye;
        }

        public void setLv_topic_eye(String lv_topic_eye) {
            this.lv_topic_eye = lv_topic_eye;
        }

        public String getLv_topic_star() {
            return lv_topic_star;
        }

        public void setLv_topic_star(String lv_topic_star) {
            this.lv_topic_star = lv_topic_star;
        }

        public String getLv_topic_menu() {
            return lv_topic_menu;
        }

        public void setLv_topic_menu(String lv_topic_menu) {
            this.lv_topic_menu = lv_topic_menu;
        }

        public String getLv_topic_contentt() {
            return lv_topic_contentt;
        }

        public void setLv_topic_contentt(String lv_topic_contentt) {
            this.lv_topic_contentt = lv_topic_contentt;
        }

        public String getLv_topic_more() {
            return lv_topic_more;
        }

        public void setLv_topic_more(String lv_topic_more) {
            this.lv_topic_more = lv_topic_more;
        }

        public String getLv_topic_sum_tag() {
            return lv_topic_sum_tag;
        }

        public void setLv_topic_sum_tag(String lv_topic_sum_tag) {
            this.lv_topic_sum_tag = lv_topic_sum_tag;
        }
    }
}
