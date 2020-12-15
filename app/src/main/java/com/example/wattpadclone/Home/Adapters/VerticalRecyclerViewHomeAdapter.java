package com.example.wattpadclone.Home.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import com.example.wattpadclone.Chung.ActivityBookDetails;
import com.example.wattpadclone.Chung.Bean.FirstZoomHorizontalLayoutManager;
import com.example.wattpadclone.Home.Adapters.Beans.HorizontalRecyclerViewHomeBean2;
import com.example.wattpadclone.Home.Adapters.Beans.HorizontalViewPagerHomeBean1;
import com.example.wattpadclone.Home.Adapters.Beans.VerticalRecyclerViewHomeBean;
import com.example.wattpadclone.R;
import com.example.wattpadclone.Chung.Bean.StartSnapHelper;

import java.util.ArrayList;

public class VerticalRecyclerViewHomeAdapter extends RecyclerView.Adapter<VerticalRecyclerViewHomeAdapter.VerticalRVHomeViewHolder> {

    Context context;
    ArrayList<VerticalRecyclerViewHomeBean> arrayList;

    public VerticalRecyclerViewHomeAdapter(Context context, ArrayList<VerticalRecyclerViewHomeBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public VerticalRVHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_rv_home_adapter1,parent,false);
        return new VerticalRVHomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalRVHomeViewHolder holder, int position) {
        VerticalRecyclerViewHomeBean verticalRecyclerViewHomeBean = arrayList.get(position);
        String title1 = verticalRecyclerViewHomeBean.getTitle1();
        String content1 = verticalRecyclerViewHomeBean.getContent1();
        String title2 = verticalRecyclerViewHomeBean.getTitle2();
        String content2 = verticalRecyclerViewHomeBean.getContent2();
        ArrayList<HorizontalViewPagerHomeBean1> singleItem1 = verticalRecyclerViewHomeBean.getArrayList1();
        ArrayList<HorizontalRecyclerViewHomeBean2> singleItem2 = verticalRecyclerViewHomeBean.getArrayList2();

        holder.categoryTitle.setText(title1);
        holder.categoryContent.setText(content1);
        holder.categoryTitle2.setText(title2);
        holder.categoryContent2.setText(content2);
        HorizontalViewPagerHomeAdapter1 horizontalViewPagerHomeAdapter1 = new HorizontalViewPagerHomeAdapter1(singleItem1,context);

        HorizontalRecyclerViewHomeAdapter2 horizontalRecyclerViewHomeAdapter2 = new HorizontalRecyclerViewHomeAdapter2(context,singleItem2);
        holder.recyclerView2.setHasFixedSize(false);
        holder.recyclerView2.setLayoutManager(new FirstZoomHorizontalLayoutManager(context,FirstZoomHorizontalLayoutManager.HORIZONTAL,false));

        holder.recyclerView2.setAdapter(horizontalRecyclerViewHomeAdapter2);
        holder.viewPager1.setAdapter(horizontalViewPagerHomeAdapter1);

        holder.home_more_rv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivityBookDetails.class);
                context.startActivity(intent);
            }
        });
        SnapHelper startSnapHelper2 = new StartSnapHelper();
        startSnapHelper2.attachToRecyclerView(holder.recyclerView2);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VerticalRVHomeViewHolder extends RecyclerView.ViewHolder {

        RecyclerView  recyclerView, recyclerView2;
        ViewPager viewPager1;
        TextView categoryTitle, categoryContent,categoryTitle2, categoryContent2;
        Button home_more_rv2;
        public VerticalRVHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            viewPager1 = itemView.findViewById(R.id.home_viewPager1);
            categoryTitle = (TextView)itemView.findViewById(R.id.home_category_title);
            categoryContent = (TextView)itemView.findViewById(R.id.home_category_content);

            recyclerView2 = (RecyclerView)itemView.findViewById(R.id.home_recyclerView2);
            categoryTitle2 = (TextView)itemView.findViewById(R.id.home_category_title2);
            categoryContent2 = (TextView)itemView.findViewById(R.id.home_category_content2);
            home_more_rv2 = itemView.findViewById(R.id.home_more_rv2);

            viewPager1.setPadding(40, 0, 40,0);
        }

    }
}
