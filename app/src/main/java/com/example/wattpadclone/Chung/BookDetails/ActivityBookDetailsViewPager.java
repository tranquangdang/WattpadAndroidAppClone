package com.example.wattpadclone.Chung.BookDetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.WebServices;
import com.example.wattpadclone.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ActivityBookDetailsViewPager extends AppCompatActivity {
    ViewPager viewPager;
    vpBookDetailsAdapter adapter;
    ArrayList<Book> arrayList;
    RecyclerView recyclerView;
    RecyclerViewBookDetailsAdapter adapter1;
    TextView name, username, seen, fav, chapter, intro;
    ImageView background;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details_viewpager);
        WebServices webServices = new WebServices(this);

        intent = getIntent();
        String BookID = intent.getStringExtra("BookID");
        int Position = intent.getIntExtra("Position", 1);

        name = findViewById(R.id.book_details_bookName);
        username = findViewById(R.id.book_details_username);
        seen = findViewById(R.id.book_details_seen);
        fav = findViewById(R.id.book_details_fav);
        chapter = findViewById(R.id.book_details_chapter);
        intro = findViewById(R.id.book_details_intro);
        background = findViewById(R.id.img_book_details_background);

        Toolbar toolbar = findViewById(R.id.toolbar_book_details);
        toolbar.setLogo(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(0);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }

        });
        recyclerView = findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        adapter1 = new RecyclerViewBookDetailsAdapter(this,arrayList);
        recyclerView.setAdapter(adapter1);
        webServices.GetDataRecyclerView("http://tranquangdang.000webhostapp.com/index.php",arrayList,adapter1);

        viewPager   = (ViewPager) findViewById(R.id.viewPager_detail);
        viewPager.setPadding(getResources().getDimensionPixelOffset(R.dimen.dp65), 0, getResources().getDimensionPixelOffset(R.dimen.dp65),0);
        arrayList   = new ArrayList<>();
        adapter  = new vpBookDetailsAdapter(arrayList, ActivityBookDetailsViewPager.this);
        viewPager.setAdapter(adapter);
        webServices.GetDataViewPagerImg("http://tranquangdang.000webhostapp.com/index.php",arrayList,adapter);
        RequestQueue requestQueue = Volley.newRequestQueue(ActivityBookDetailsViewPager.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://tranquangdang.000webhostapp.com/index.php?BookID=" + BookID, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(0);
                            String bookname = jsonObject.getString("BookName");
                            name.setText(bookname);
                            toolbar.setTitle(bookname);
                            Glide.with(ActivityBookDetailsViewPager.this).load(jsonObject.getString("BookImg")).into(background);
                            username.setText(jsonObject.getString("Author"));
                            seen.setText(String.valueOf(jsonObject.getInt("Written")));
                            fav.setText(String.valueOf(jsonObject.getInt("Favorite")));
                            chapter.setText(jsonObject.getInt("Chapter") + " phần");
                            intro.setText(jsonObject.getString("Intro"));
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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(ViewPager.SCROLL_STATE_IDLE == state) {
                    View view = (View) viewPager.findViewWithTag("myview" + viewPager.getCurrentItem());
                    TextView txt =  view.findViewById(R.id.details_book_id);
                    RequestQueue requestQueue = Volley.newRequestQueue(ActivityBookDetailsViewPager.this);
                    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://tranquangdang.000webhostapp.com/index.php?BookID=" + txt.getText().toString(), null,
                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    try {
                                        JSONObject jsonObject = response.getJSONObject(0);
                                        String bookname = jsonObject.getString("BookName");
                                        name.setText(bookname);
                                        toolbar.setTitle(bookname);
                                        Glide.with(ActivityBookDetailsViewPager.this).load(jsonObject.getString("BookImg")).into(background);
                                        username.setText(jsonObject.getString("Author"));
                                        seen.setText(String.valueOf(jsonObject.getInt("Written")));
                                        fav.setText(String.valueOf(jsonObject.getInt("Favorite")));
                                        chapter.setText(jsonObject.getInt("Chapter") + " phần");
                                        intro.setText(jsonObject.getString("Intro"));
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


        viewPager.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                viewPager.setCurrentItem(Position, true);
            }
        }, 2000);
    }

}