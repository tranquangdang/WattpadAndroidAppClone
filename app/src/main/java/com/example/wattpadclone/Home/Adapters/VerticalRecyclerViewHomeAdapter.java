package com.example.wattpadclone.Home.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.wattpadclone.Base.LogInActivity;
import com.example.wattpadclone.Chung.ActivityBookDetails;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.Bean.FirstZoomHorizontalLayoutManager;
import com.example.wattpadclone.Chung.WebServices;
import com.example.wattpadclone.Home.Adapters.Beans.VerticalRecyclerViewHomeBean;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;
import com.example.wattpadclone.Chung.Bean.StartSnapHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        ArrayList<Book> arrayList = verticalRecyclerViewHomeBean.getArrayList();

        holder.categoryTitle.setText(verticalRecyclerViewHomeBean.getTitle1());
        holder.categoryContent.setText(verticalRecyclerViewHomeBean.getContent1());
        HorizontalViewPagerHomeAdapter1 horizontalViewPagerHomeAdapter1 = new HorizontalViewPagerHomeAdapter1(arrayList,context);
        holder.viewPager1.setAdapter(horizontalViewPagerHomeAdapter1);

        holder.categoryTitle2.setText(verticalRecyclerViewHomeBean.getTitle2());
        holder.categoryContent2.setText(verticalRecyclerViewHomeBean.getContent2());
        HorizontalRecyclerViewHomeAdapter2 horizontalRecyclerViewHomeAdapter2 = new HorizontalRecyclerViewHomeAdapter2(context,arrayList);
        holder.recyclerView2.setLayoutManager(new FirstZoomHorizontalLayoutManager(context,FirstZoomHorizontalLayoutManager.HORIZONTAL,false));
        holder.recyclerView2.setPadding(0,0,context.getResources().getSystem().getDisplayMetrics().widthPixels-210,0);
        holder.recyclerView2.setAdapter(horizontalRecyclerViewHomeAdapter2);
        SnapHelper startSnapHelper2 = new StartSnapHelper();
        startSnapHelper2.attachToRecyclerView(holder.recyclerView2);
        holder.title.setText(arrayList.get(position).getBookName());
        holder.intro.setText(arrayList.get(position).getIntro());
        holder.chapter.setText(arrayList.get(position).getChapter() + " phần");
        if(arrayList.get(position).getStatus() == 1){
            holder.status.setText("Hoàn thành");
            holder.status.setBackgroundResource(R.drawable.home_complete_rounded);
        } else {
            holder.status.setText("Đang tiếp diễn");
            holder.status.setBackgroundResource(R.drawable.home_incomplete_rounded);
        }
        holder.status.setPadding(20,3,20,3);
        holder.recyclerView2.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    TextView txt =  ((MainActivity)context).findViewById(R.id.home_book_id);
                    RequestQueue requestQueue = Volley.newRequestQueue(context);
                    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://tranquangdang.000webhostapp.com/index.php?BookID=" + txt.getText().toString(), null,
                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    try {
                                        JSONObject jsonObject = response.getJSONObject(0);
                                        holder.title.setText(jsonObject.getString("BookName"));
                                        holder.intro.setText(jsonObject.getString("Intro"));
                                        holder.chapter.setText(jsonObject.getInt("Chapter") + " phần");
                                        if(jsonObject.getInt("Status") == 1){
                                            holder.status.setText("Hoàn thành");
                                            holder.status.setBackgroundResource(R.drawable.home_complete_rounded);
                                        } else {
                                            holder.status.setText("Đang tiếp diễn");
                                            holder.status.setBackgroundResource(R.drawable.home_incomplete_rounded);
                                        }
                                        holder.status.setPadding(20,3,20,3);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }
                    );
                    requestQueue.add(jsonArrayRequest);

                }
            }
        });
        holder.home_more_rv2.setOnClickListener(new View.OnClickListener() {
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

    public class VerticalRVHomeViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView2;
        ViewPager viewPager1;
        TextView categoryTitle, categoryContent,categoryTitle2, categoryContent2;
        TextView home_more_rv2;

        TextView title, intro, chapter, status, more;
        ImageButton menu;
        public VerticalRVHomeViewHolder(@NonNull View itemView) {
            super(itemView);
            viewPager1 = itemView.findViewById(R.id.home_viewPager1);
            categoryTitle = itemView.findViewById(R.id.home_category_title);
            viewPager1.setPadding(context.getResources().getDimensionPixelOffset(R.dimen.dp19), 0, context.getResources().getDimensionPixelOffset(R.dimen.dp19),0);
            categoryContent = itemView.findViewById(R.id.home_category_content);

            recyclerView2 = itemView.findViewById(R.id.home_recyclerView2);
            categoryTitle2 = itemView.findViewById(R.id.home_category_title2);
            categoryContent2 = itemView.findViewById(R.id.home_category_content2);
            home_more_rv2 = itemView.findViewById(R.id.home_more_rv2);
            title = itemView.findViewById(R.id.home_title_rv2);
            intro = itemView.findViewById(R.id.home_content_rv2);
            chapter = itemView.findViewById(R.id.home_chapter_rv2);
            status = itemView.findViewById(R.id.home_status_rv2);
            more = itemView.findViewById(R.id.home_more_rv2);
            menu = itemView.findViewById(R.id.home_menu_rv2);


        }

    }
}
