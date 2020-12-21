package com.example.wattpadclone.Chung.Detalts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.wattpadclone.Base.Adapter.Bean.IntroBean;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.R;

import java.util.List;

public class detailts_headAdapter extends PagerAdapter {
    private List<Book> book ;
    private Context context ;

    public detailts_headAdapter(List<Book> book, Context context) {
        this.book = book;
        this.context = context;
    }

    @Override
    public int getCount() {
        return book.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view  = LayoutInflater.from(context ).inflate(R.layout.details_adapter, container,false);

        ImageView image ;
        image  = view .findViewById(R.id.img_book_details);

        Glide.with(context).load(book.get(position).getBookImg()).into(image);
        container.addView(view , 0);
        return view ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

