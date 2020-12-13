package com.example.wattpadclone.Home.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.wattpadclone.Chung.FragmentBookDetails;
import com.example.wattpadclone.Home.Adapters.Beans.HorizontalRecyclerViewHomeBean1;
import com.example.wattpadclone.Home.Adapters.Beans.HorizontalRecyclerViewHomeBean2;
import com.example.wattpadclone.Home.Adapters.Beans.VerticalRecyclerViewHomeBean;
import com.example.wattpadclone.MainActivity;
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
        ArrayList<HorizontalRecyclerViewHomeBean1> singleItem = verticalRecyclerViewHomeBean.getArrayList1();
        ArrayList<HorizontalRecyclerViewHomeBean2> singleItem2 = verticalRecyclerViewHomeBean.getArrayList2();

        holder.categoryTitle.setText(title1);
        holder.categoryContent.setText(content1);
        holder.categoryTitle2.setText(title2);
        holder.categoryContent2.setText(content2);
        HorizontalRecyclerViewHomeAdapter1 horizontalRecyclerViewHomeAdapter1 = new HorizontalRecyclerViewHomeAdapter1(context,singleItem);
        HorizontalRecyclerViewHomeAdapter2 horizontalRecyclerViewHomeAdapter2 = new HorizontalRecyclerViewHomeAdapter2(context,singleItem2);

        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView2.setHasFixedSize(true);
        holder.recyclerView2.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        holder.recyclerView.setAdapter(horizontalRecyclerViewHomeAdapter1);
        holder.recyclerView2.setAdapter(horizontalRecyclerViewHomeAdapter2);

        holder.home_more_rv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).pushFragments("HOME_FRAGMENT", new FragmentBookDetails(),true);
            }
        });
        SnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView(holder.recyclerView);
        SnapHelper startSnapHelper2 = new StartSnapHelper();
        startSnapHelper2.attachToRecyclerView(holder.recyclerView2);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VerticalRVHomeViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView, recyclerView2;
        TextView categoryTitle, categoryContent,categoryTitle2, categoryContent2;
        Button home_more_rv2;
        public VerticalRVHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = (RecyclerView)itemView.findViewById(R.id.home_recyclerView1);
            categoryTitle = (TextView)itemView.findViewById(R.id.home_category_title);
            categoryContent = (TextView)itemView.findViewById(R.id.home_category_content);

            recyclerView2 = (RecyclerView)itemView.findViewById(R.id.home_recyclerView2);
            categoryTitle2 = (TextView)itemView.findViewById(R.id.home_category_title2);
            categoryContent2 = (TextView)itemView.findViewById(R.id.home_category_content2);
            home_more_rv2 = itemView.findViewById(R.id.home_more_rv2);
        }
    }
}
