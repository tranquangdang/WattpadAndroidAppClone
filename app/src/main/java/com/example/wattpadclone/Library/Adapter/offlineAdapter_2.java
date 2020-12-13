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

public class offlineAdapter_2 extends BaseAdapter {
    public ArrayList<offline_2> arraylistListener_2;
    private List<offline_2> mListenerList_2;
    Context mContext_2;
    public offlineAdapter_2(ArrayList<offline_2> mListenerList_2, Context context_2) {
        mContext_2=context_2;
        this.mListenerList_2 = mListenerList_2;
        this.arraylistListener_2 = new ArrayList<offline_2>();
        this.arraylistListener_2.addAll(mListenerList_2);
    }
public class ViewHolder_2{
    ImageView gr_anh_off_2;
    TextView gr_name_off_2;
    TextView gr_title_off_2;
    }
    @Override
    public int getCount() {
        return mListenerList_2.size();
    }

    @Override
    public Object getItem(int i) {
        return mListenerList_2.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final offlineAdapter_2.ViewHolder_2 holder_2;
        if(view==null){
            view = LayoutInflater.from(mContext_2).inflate(R.layout.layout2_offline,null);
            holder_2=new ViewHolder_2();
            holder_2.gr_anh_off_2=view.findViewById(R.id.lv_anh_offline_2);
            holder_2.gr_name_off_2=view.findViewById(R.id.lv_name_offline_2);
            holder_2.gr_title_off_2=view.findViewById(R.id.lv_title_offline_2);
            view.setTag(holder_2);
        }else{
            holder_2= (offlineAdapter_2.ViewHolder_2)view.getTag();
            try{
                int image_2=mListenerList_2.get(i).getGr_anh_off_2();
                holder_2.gr_anh_off_2.setImageResource(mListenerList_2.get(i).getGr_anh_off_2());
                holder_2.gr_name_off_2.setText(mListenerList_2.get(i).getGr_name_off_2());
                holder_2.gr_title_off_2.setText(mListenerList_2.get(i).getGr_title_off_2());
            }catch (Exception e){

            }
        }
        return view;
    }
}
