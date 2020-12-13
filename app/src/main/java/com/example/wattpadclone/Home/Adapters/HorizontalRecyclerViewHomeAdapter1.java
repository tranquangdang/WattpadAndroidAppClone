package com.example.wattpadclone.Home.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wattpadclone.Chung.ActivityBookDetails;
import com.example.wattpadclone.Home.Adapters.Beans.HorizontalRecyclerViewHomeBean1;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class HorizontalRecyclerViewHomeAdapter1 extends RecyclerView.Adapter<HorizontalRecyclerViewHomeAdapter1.HorizontalRVViewHolder1> {

    Context context;
    ArrayList<HorizontalRecyclerViewHomeBean1> arrayList;

    public HorizontalRecyclerViewHomeAdapter1(Context context, ArrayList<HorizontalRecyclerViewHomeBean1> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HorizontalRVViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_rv_home_adapter1,parent,false);
        return new HorizontalRVViewHolder1(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRVViewHolder1 holder, int position) {
        HorizontalRecyclerViewHomeBean1 horizontalRecyclerViewHomeBean1 = arrayList.get(position);
        holder.imgCover1.setImageResource(horizontalRecyclerViewHomeBean1.getImg());
        holder.title1.setText(horizontalRecyclerViewHomeBean1.getTitle());
        holder.content1.setText(horizontalRecyclerViewHomeBean1.getContent());
        holder.tag1.setText(horizontalRecyclerViewHomeBean1.getTag());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HorizontalRVViewHolder1 extends RecyclerView.ViewHolder {

        ImageView imgCover1;
        TextView title1, content1, tag1;
        CardView cv;
        public HorizontalRVViewHolder1(@NonNull View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardVieww) ;
            imgCover1 = (ImageView)itemView.findViewById(R.id.home_cover1);
            title1 = (TextView)itemView.findViewById(R.id.home_title1);
            content1 = (TextView)itemView.findViewById(R.id.home_content1);
            tag1 = (TextView)itemView.findViewById(R.id.home_tag1);

        }
    }
}
