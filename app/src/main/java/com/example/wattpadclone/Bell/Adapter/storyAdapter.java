package com.example.wattpadclone.Bell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wattpadclone.R;

import java.util.ArrayList;

public class storyAdapter extends RecyclerView.Adapter<storyAdapter.ViewHolder> {
    public Context context;
    private ArrayList<story> arrayList;

    //Tạo ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img1;
        private TextView tv1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.chu);
            img1 = itemView.findViewById(R.id.hinh);
        }
    }

    //Hoàn thiện Adapter


    public storyAdapter(Context context, ArrayList<story> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public storyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View heroView = inflater.inflate(R.layout.customlistview, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull storyAdapter.ViewHolder holder, int position) {
        story story = arrayList.get(position);
        Glide.with(context)
                .load(story.getImage())
                .into(holder.img1);
        holder.tv1.setText(story.getName());

    }

    @Override
    public int getItemCount() {
          return arrayList.size();
    }
}
