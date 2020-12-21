package com.example.wattpadclone.Libary.Main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.WebServices;
import com.example.wattpadclone.Libary.Adapter.ReadingListAdapter;
import com.example.wattpadclone.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ReadingListFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.reading_list_fragment, container, false);
        ListView lv_readinglist = view.findViewById(R.id.lv_reading);
        ArrayList<Book> readingArrayList=new ArrayList<Book>();
        ReadingListAdapter readingadapter = new ReadingListAdapter(readingArrayList,getContext());
        lv_readinglist.setAdapter(readingadapter);
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://tranquangdang.000webhostapp.com/index.php?BookID=1", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i <= response.length(); i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                readingArrayList.add(new Book(
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
                        readingadapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

        //addRedingList(view);
        return view;
    }
//    private void addRedingList(View view) {
//
//
//        readingArrayList.add(new ReadingList(R.mipmap.mtp,R.mipmap.shawn,R.mipmap.badboy,"Thang's List","5 stories"));
//        readingArrayList.add(new ReadingList(R.mipmap.bccmerlin,R.mipmap.shawn2,R.mipmap.thelove,"List for day","3 stories"));
//        readingArrayList.add(new ReadingList(R.mipmap.thelove,R.mipmap.badboy,R.mipmap.mtp,"For Happy'List","6 stories"));
//
//    }
}