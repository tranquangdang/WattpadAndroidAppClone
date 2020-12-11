package com.example.wattpadclone.Search;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wattpadclone.Bell.Bell;
import com.example.wattpadclone.Library.Library;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.MainAdapter;
import com.example.wattpadclone.R;
import com.example.wattpadclone.one;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Search extends AppCompatActivity {
    GridView gridView;
    String[] name={"Bí ẩn","Cổ điển","Hài hước","Hành động","KH viễn tưởng","Kinh dị","Lãng mạn",
    "Người sói","Ngẫu nhiên","Phi tiểu thuyết","Phiêu lưu","Siêu nhiên","Thơ ca","TT chung",
            "Thriller","TT lịch sử","TT thiếu niên","Truyện ngắn","Truyện tâm linh","Viễn tưởng"};
    int[] img={R.drawable.mystery,R.drawable.newadult,R.drawable.humor,R.drawable.action,R.drawable.scifi,R.drawable.horror,
            R.drawable.romance,R.drawable.werewolf,R.drawable.random,R.drawable.nonfiction,R.drawable.adventure,R.drawable.paranormal,
            R.drawable.poetry,R.drawable.urban,R.drawable.thriller,R.drawable.historicalfic,R.drawable.teenfic,R.drawable.shortstory,R.drawable.diverselit,
            R.drawable.fanfic};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        gridView=findViewById(R.id.grid);
        MainAdapter adapter=new MainAdapter(Search.this,name,img);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0) {
                    Intent intent = new Intent(Search.this, one.class);
                    startActivity(intent);
                }else if(position==1){
                    Intent intent = new Intent(Search.this, two.class);
                    startActivity(intent);
                }
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_bottom_navigation:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.lib_bottom_navigation:
                        startActivity(new Intent(getApplicationContext(), Library.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search_bottom_navigation:
                        startActivity(new Intent(getApplicationContext(), Search.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.noti_bottom_navigation:
                        startActivity(new Intent(getApplicationContext(), Bell.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_home,menu);
        return true;
    }
}