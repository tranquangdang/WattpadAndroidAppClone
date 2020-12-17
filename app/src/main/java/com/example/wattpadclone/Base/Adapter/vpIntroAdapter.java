package com.example.wattpadclone.Base.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.wattpadclone.Base.Adapter.Bean.IntroBean;
import com.example.wattpadclone.R;

import java.util.List;

public class vpIntroAdapter extends PagerAdapter {

    private List<IntroBean> img ;
    private Context context ;

    public vpIntroAdapter(List<IntroBean> img , Context context ) {
        this.img  = img ;
        this.context  = context ;
    }

    @Override
    public int getCount() {
        return img.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view  = LayoutInflater.from(context ).inflate(R.layout.vp_login_adapter, container,false);

        ImageView imageView ;
        imageView  = view .findViewById(R.id.img_intro);

        imageView .setImageResource(img.get(position).getImg());

        container.addView(view , 0);
        return view ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
