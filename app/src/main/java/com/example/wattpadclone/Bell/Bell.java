
package com.example.wattpadclone.Bell;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.wattpadclone.Library.Library;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;
import com.example.wattpadclone.Search.Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Bell extends AppCompatActivity {
    ImageButton btn1,btn2;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bell);

        Toolbar toolbar = findViewById(R.id.toolbar_noti);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.toolbar_noti_add)
                {
                    // do something
                }
                return false;
            }
        });
        btn1 = (ImageButton) findViewById(R.id.btnlogo);
        btn2 = (ImageButton) findViewById(R.id.btnadd);

        //Tab Selector
        setSupportActionBar(toolbar);
        addTabSelector();

        //Button
        button1();

        button2();

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
        getMenuInflater().inflate(R.menu.menu_toolbar_noti,menu);
        return true;
    }

    private void button2() {
    }

    private void button1() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Bell.this,"Chạy được",Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void addTabSelector() {
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("THÔNG BÁO");
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setIndicator("TIN NHẮN");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);
        

        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).getBackground().setColorFilter(Color.parseColor("#FF5722"), PorterDuff.Mode.MULTIPLY);

        
    }
}