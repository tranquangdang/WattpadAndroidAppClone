package com.example.wattpadclone;

import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wattpadclone.Search.Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationItemListener extends AppCompatActivity {

    public void onCreate() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_bottom_navigation:
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                overridePendingTransition(0,0);
                                return true;
                    case R.id.search_bottom_navigation:
                        startActivity(new Intent(getApplicationContext(), Search.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}
