package com.example.wattpadclone.Home.Account.Thietlap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;

import com.example.wattpadclone.R;

public class ThietLapThongBao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thiet_lap_thong_bao);
        Toolbar toolbar = findViewById(R.id.toolbar_thiet_lap_tb);
        toolbar.setLogo(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}