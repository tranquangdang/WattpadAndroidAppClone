package com.example.wattpadclone.thembanbe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.wattpadclone.R;

public class thembanbe extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thembanbe);


        Toolbar toolbar = findViewById(R.id.toolbar_thembanbe);

        toolbar.setLogo(ContextCompat.getDrawable(getApplicationContext(), R.drawable.back));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        //Tab Selector
        setSupportActionBar(toolbar);
        addTabSelector();


    }




    public void addTabSelector() {
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Tìm Bạn Bè");
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setIndicator("Mời Bạn Bè");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);


        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).getBackground().setColorFilter(Color.parseColor("#FF5722"), PorterDuff.Mode.MULTIPLY);


    }
}