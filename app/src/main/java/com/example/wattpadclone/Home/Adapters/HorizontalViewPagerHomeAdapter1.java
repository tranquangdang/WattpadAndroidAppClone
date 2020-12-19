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

import com.bumptech.glide.Glide;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;

import java.util.ArrayList;
import java.util.List;

public class HorizontalViewPagerHomeAdapter1 extends PagerAdapter {

    private ArrayList<Book> arrayList;
    private Context context;

    public HorizontalViewPagerHomeAdapter1(ArrayList<Book> arrayList, Context context) {
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

        if(imgCover1.equals("default"))
            imgCover1.setImageResource(R.mipmap.book1);
        else {
            Glide.with(context).load(arrayList.get(position).getBookImg()).into(imgCover1);
        }
        title1.setText(arrayList.get(position).getBookName());
        content1.setText(arrayList.get(position).getIntro());
        tag1.setText("Tag");

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
