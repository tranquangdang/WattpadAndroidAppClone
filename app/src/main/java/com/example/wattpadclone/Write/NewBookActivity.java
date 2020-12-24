package com.example.wattpadclone.Write;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.wattpadclone.Base.Adapter.Bean.UserBean;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.WebServices;
import com.example.wattpadclone.Home.Adapters.Beans.VerticalRecyclerViewHomeBean;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public class NewBookActivity extends AppCompatActivity {
    TextView title, info, category, button;
    ImageView img;
    String txt, radio, bookID;
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;
    Intent action;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                if(data.hasExtra("title")) {
                    txt = data.getStringExtra("title");
                    title.setText(txt);
                }
                if(data.hasExtra("info")) {
                    txt = data.getStringExtra("info");
                    info.setText(txt);
                }
                if(data.hasExtra("radio")) {
                    radio = data.getStringExtra("radio");
                    category.setText(radio);
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        Toolbar toolbar = findViewById(R.id.toolbar_new_book);
        title = findViewById(R.id.write_title);
        info = findViewById(R.id.write_info);
        category = findViewById(R.id.write_category);
        img = findViewById(R.id.write_img);
        button = findViewById(R.id.btn_create_new_book);

        action = getIntent();
        if(action.hasExtra("Action")) {
            bookID = action.getStringExtra("Action");
            toolbar.setTitle("Chỉnh sửa truyện");
            button.setText("Cập nhật truyện");
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://tranquangdang.000webhostapp.com/index.php?BookID=" + bookID, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(0);
                                int cate = jsonObject.getInt("CategoryNo");
                                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://tranquangdang.000webhostapp.com/category.php?CategoryID=" + cate, null,
                                        new Response.Listener<JSONArray>() {
                                            @Override
                                            public void onResponse(JSONArray response) {
                                                try {
                                                    JSONObject jsonObject = response.getJSONObject(0);
                                                    category.setText(jsonObject.getString("CategoryName"));
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
                                title.setText(jsonObject.getString("BookName"));
                                info.setText(jsonObject.getString("Intro"));
                                Glide.with(NewBookActivity.this).load(jsonObject.getString("BookImg")).into(img);
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

        toolbar.setLogo(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewBookActivity.this, EditLayoutActivity.class);
                intent.putExtra("title", title.getText());
                startActivityForResult(intent, 1);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewBookActivity.this, EditLayoutActivity.class);
                intent.putExtra("info", info.getText());
                startActivityForResult(intent, 1);
            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewBookActivity.this, RadioButtonCategoryActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_title = title.getText().toString().trim();
                String txt_info = info.getText().toString().trim();
                String txt_cate = category.getText().toString().trim();
                if(txt_title.isEmpty()  || txt_info.isEmpty() || txt_cate.equals("Chọn thể loại")){
                    Toast.makeText(NewBookActivity.this, "Vui lòng không được để trống!", Toast.LENGTH_SHORT).show();
                } else {
                    if(action.hasExtra("Action")) {
                        UpdateBook();
                    } else {
                        InsertBook();
                    }
                    Intent intent = new Intent(NewBookActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void InsertBook(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserBean user = snapshot.getValue(UserBean.class);
                String username = user.getUsername();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://tranquangdang.000webhostapp.com/createbook.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(response.trim().equals("insert success")) {
                                    Toast.makeText(NewBookActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(NewBookActivity.this, "Lỗi!" + response, Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(NewBookActivity.this, "Lỗi" + error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("CategoryNo", "1");
                        params.put("BookName", title.getText().toString().trim());
                        params.put("Intro", info.getText().toString().trim());
                        params.put("Author", username.trim());
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void UpdateBook() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://tranquangdang.000webhostapp.com/updatebook.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("update success")){
                            Toast.makeText(NewBookActivity.this, "Sửa thành công!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(NewBookActivity.this, "Lỗi!" + response, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(NewBookActivity.this, "Lỗi" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("CategoryNo", "1");
                params.put("BookName", title.getText().toString().trim());
                params.put("Intro", info.getText().toString().trim());
                params.put("BookID", bookID);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}