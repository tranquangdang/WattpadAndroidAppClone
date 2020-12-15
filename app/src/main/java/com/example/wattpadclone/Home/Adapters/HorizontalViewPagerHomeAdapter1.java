package com.example.wattpadclone.Home.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.wattpadclone.Home.Adapters.Beans.HorizontalViewPagerHomeBean1;
import com.example.wattpadclone.R;

import java.util.ArrayList;
import java.util.List;

public class HorizontalViewPagerHomeAdapter1 extends PagerAdapter {

    private ArrayList<HorizontalViewPagerHomeBean1> arrayList;
    private Context context;

    public HorizontalViewPagerHomeAdapter1(ArrayList<HorizontalViewPagerHomeBean1> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.horizontal_vp_home_adapter1, container,false);

        ImageView imgCover1;
        TextView title1, content1, tag1;
        imgCover1 = (ImageView)view.findViewById(R.id.home_cover1);
        title1 = (TextView)view.findViewById(R.id.home_title1);
        content1 = (TextView)view.findViewById(R.id.home_content1);
        tag1 = (TextView)view.findViewById(R.id.home_tag1);

        imgCover1.setImageResource(arrayList.get(position).getImg());
        title1.setText(arrayList.get(position).getTitle());
        content1.setText(arrayList.get(position).getContent());
        tag1.setText(arrayList.get(position).getTag());


        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
