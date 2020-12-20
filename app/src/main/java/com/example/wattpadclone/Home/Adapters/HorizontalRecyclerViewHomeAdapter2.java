package com.example.wattpadclone.Home.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.ActivityBookDetails;
import com.example.wattpadclone.Chung.Bean.FirstZoomHorizontalLayoutManager;
import com.example.wattpadclone.MainActivity;
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
        RecyclerView recyclerView2 =  ((MainActivity)context).findViewById(R.id.home_recyclerView2);
        Book book = arrayList.get(position);
        if(holder.imgCover2.equals("default"))
            holder.imgCover2.setImageResource(R.mipmap.book1);
        else {
            Glide.with(context).load(book.getBookImg()).into(holder.imgCover2);
        }
        holder.bookID.setText(String.valueOf(book.getBookID()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstZoomHorizontalLayoutManager layoutManager = (FirstZoomHorizontalLayoutManager)
                        recyclerView2.getLayoutManager();
                int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
                if(firstVisiblePosition == position) {
                    Intent intent = new Intent(context, ActivityBookDetails.class);
                    context.startActivity(intent);
                } else {
                    recyclerView2.smoothScrollToPosition(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HorizontalRVViewHolder2 extends RecyclerView.ViewHolder {
        TextView bookID;
        ImageView imgCover2;
        public HorizontalRVViewHolder2(@NonNull View itemView) {
            super(itemView);
            bookID = itemView.findViewById(R.id.home_book_id);
            bookID.setVisibility(View.GONE);
            imgCover2 = itemView.findViewById(R.id.home_cover2);

            imgCover2.getLayoutParams().width = Resources.getSystem().getDisplayMetrics().widthPixels-800;
            imgCover2.getLayoutParams().height = Resources.getSystem().getDisplayMetrics().widthPixels-580;
            itemView.setPadding(context.getResources().getDimensionPixelOffset(R.dimen.dp5),0,context.getResources().getDimensionPixelOffset(R.dimen.dp5),0);
        }

    }
}
