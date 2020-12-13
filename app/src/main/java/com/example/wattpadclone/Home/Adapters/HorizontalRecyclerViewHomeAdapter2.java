package com.example.wattpadclone.Home.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wattpadclone.Home.Adapters.Beans.HorizontalRecyclerViewHomeBean2;
import com.example.wattpadclone.Chung.ActivityBookDetails;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class HorizontalRecyclerViewHomeAdapter2 extends RecyclerView.Adapter<HorizontalRecyclerViewHomeAdapter2.HorizontalRVViewHolder2> {

    Context context;
    ArrayList<HorizontalRecyclerViewHomeBean2> arrayList;

    public HorizontalRecyclerViewHomeAdapter2(Context context, ArrayList<HorizontalRecyclerViewHomeBean2> arrayList) {
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
        HorizontalRecyclerViewHomeBean2 horizontalRecyclerViewHomeBean2 = arrayList.get(position);
        holder.imgCover2.setImageResource(horizontalRecyclerViewHomeBean2.getImg());
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
