package com.example.wattpadclone.Base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wattpadclone.Base.Adapter.Bean.IntroBean;
import com.example.wattpadclone.Base.Adapter.vpIntroAdapter;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {
    DotsIndicator indicator_vp;
    ViewPager viewPager;
    vpIntroAdapter adapter;
    List<IntroBean> ImgList;
    Button btnSignUp;
    TextView btnLogIn;
    FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser != null) {
            Intent intent = new Intent(IntroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        indicator_vp   = (DotsIndicator) findViewById(R.id.indicator_vp);
        viewPager   = (ViewPager) findViewById(R.id.viewPager_intro);

        ImgList  = new ArrayList<>();
        ImgList.add(new  IntroBean(R.mipmap.intro_login_1));
        ImgList.add(new  IntroBean(R.mipmap.intro_login_2));
        ImgList.add(new  IntroBean(R.mipmap.intro_login_3));

        adapter  = new vpIntroAdapter(ImgList,IntroActivity.this);
        viewPager.setAdapter(adapter);
        indicator_vp .setViewPager(viewPager);

        btnLogIn = findViewById(R.id.btn_intro_login);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
        btnSignUp = findViewById(R.id.btn_intro_signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}