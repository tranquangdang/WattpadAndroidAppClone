package com.example.wattpadclone.Base;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wattpadclone.Base.Adapter.Bean.UserBean;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LogInActivity extends AppCompatActivity {
    TextView fb, gg, txt_goto_signUp;
    LoginButton loginButtonFb;
    SignInButton loginButtonGg;
    EditText usernameLogin, passwordLogin;
    Button btnLogin;
    String txt_email;

    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);

        loginButtonFb = findViewById(R.id.login_facebook_button);
        loginButtonGg = findViewById(R.id.login_google_button);
        fb = findViewById(R.id.fb_login);
        gg = findViewById(R.id.gg_login);
        txt_goto_signUp = findViewById(R.id.txt_goto_signup);
        btnLogin = findViewById(R.id.btn_login);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginButtonFb.performClick();
            }
        });

        gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginButtonGg.performClick();
            }
        });

        txt_goto_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        auth = FirebaseAuth.getInstance();
        usernameLogin = findViewById(R.id.username_login);
        passwordLogin = findViewById(R.id.password_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_username = usernameLogin.getText().toString();
                String txt_password = passwordLogin.getText().toString();
                if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(LogInActivity.this, "Chưa điền đầy đủ cho các trường!", Toast.LENGTH_SHORT).show();
                } else {
                    reference = FirebaseDatabase.getInstance().getReference("Users");
                    reference.orderByChild("username").equalTo(txt_username).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                txt_email = dataSnapshot.child("email").getValue(String.class);
                                auth.signInWithEmailAndPassword(txt_email,txt_password)
                                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if (task.isSuccessful()) {
                                                    Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                                                    startActivity(intent);
                                                    finish();
                                                } else {
                                                    Toast.makeText(LogInActivity.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }
            }
        });
    }

}