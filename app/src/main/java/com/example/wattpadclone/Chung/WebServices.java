package com.example.wattpadclone.Chung;

import android.app.Activity;
import android.widget.Adapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Home.Adapters.Beans.VerticalRecyclerViewHomeBean;
import com.example.wattpadclone.Home.Adapters.VerticalRecyclerViewHomeAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WebServices {
    private Activity activity;
    private VerticalRecyclerViewHomeAdapter adapter;

    public WebServices(Activity activity) {
        this.activity = activity;
    }

    public void GetData (String url, ArrayList<VerticalRecyclerViewHomeBean> arrayListVertical,
                             VerticalRecyclerViewHomeAdapter verticalRecyclerViewHomeAdapter){
        ArrayList<Book> arrayList = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i <= response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            arrayList.add(new Book(
                                    jsonObject.getInt("BookID"),
                                    jsonObject.getInt("CategoryNo"),
                                    jsonObject.getString("BookName"),
                                    jsonObject.getString("Intro"),
                                    jsonObject.getString("BookImg"),
                                    jsonObject.getString("Author"),
                                    jsonObject.getString("TimeCreate"),
                                    jsonObject.getInt("Status"),
                                    jsonObject.getInt("Chapter"),
                                    jsonObject.getInt("Written"),
                                    jsonObject.getInt("Favorite")
                            ));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    VerticalRecyclerViewHomeBean mVerticalRecyclerViewHomeBean = new VerticalRecyclerViewHomeBean("Truyện đã Hoàn Thành", "Đọc say sưa từ đầu đến cuối",
                            "Truyện được thảo luận nhiều", "Các truyện có nhiều bình luận nhất", arrayList);
                    arrayListVertical.add(mVerticalRecyclerViewHomeBean);
                    verticalRecyclerViewHomeAdapter.notifyDataSetChanged();
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
