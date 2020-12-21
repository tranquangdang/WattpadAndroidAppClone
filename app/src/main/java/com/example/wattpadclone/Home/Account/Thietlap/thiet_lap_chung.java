package com.example.wattpadclone.Home.Account.Thietlap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wattpadclone.Base.IntroActivity;
import com.example.wattpadclone.Chung.LoadingDialog;
import com.example.wattpadclone.R;
import com.google.firebase.auth.FirebaseAuth;

public class thiet_lap_chung extends AppCompatActivity {
    TextView txtThietLapTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thiet_lap_chung);
        LoadingDialog loadingDialog = new LoadingDialog(thiet_lap_chung.this);

        Toolbar toolbar = findViewById(R.id.toolbar_thiet_lap_chung);
        toolbar.setLogo(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txtThietLapTK = findViewById(R.id.txtThietLapTK);
        txtThietLapTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thiet_lap_chung.this, ThietLapTaiKhoan.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.txtLogOut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingDialog.Loading();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(thiet_lap_chung.this, IntroActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.txtThongBao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thiet_lap_chung.this, ThietLapThongBao.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.txtThietLapDoc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thiet_lap_chung.this, ThietLapDoc.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.txtTuyChinh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thiet_lap_chung.this, tuy_chinh_chu_de.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.txtBanDem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thiet_lap_chung.this, che_do_ban_dem.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.txtTKBiChan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thiet_lap_chung.this, thiet_lap_chan.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.txtNgonNgu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thiet_lap_chung.this, thiet_lap_ngon_ngu.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.txtTroGiup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thiet_lap_chung.this, thiet_lap_tro_giup.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.txtWattpad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thiet_lap_chung.this, thong_tin_wattpad.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.txtDangKi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thiet_lap_chung.this, ThietLapDangKi.class);
                startActivity(intent);
            }
        });
    }
}