package com.example.wattpadclone.Home.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.Detalts.ActivityBookDetails;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class HorizontalRecyclerViewHomeAdapter2 extends RecyclerView.Adapter<HorizontalRecyclerViewHomeAdapter2.HorizontalRVViewHolder2> {

    Context context;
    ArrayList<Book> arrayList;

    public HorizontalRecyclerViewHomeAdapter2(Context context, ArrayList<Book> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HorizontalRVViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_rv_home_adapter2,parent,false);
        return new HorizontalRVViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRVViewHolder2 holder, int position) {
        Book book = arrayList.get(position);
        if(holder.imgCover2.equals("default"))
            holder.imgCover2.setImageResource(R.mipmap.book1);
        else {
            Glide.with(context).load(book.getBookImg()).into(holder.imgCover2);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityBookDetails.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HorizontalRVViewHolder2 extends RecyclerView.ViewHolder {

        ImageView imgCover2;
        public HorizontalRVViewHolder2(@NonNull View itemView) {
            super(itemView);
            imgCover2 = (ImageView)itemView.findViewById(R.id.home_cover2);

        }
    }
}
