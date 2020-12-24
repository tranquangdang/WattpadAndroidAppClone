package com.example.wattpadclone.Base;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wattpadclone.Chung.LoadingDialog;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {
    TextView fb, gg, txt_goto_signUp;
    LoginButton loginButtonFb;
    SignInButton loginButtonGg;
    EditText usernameLogin, passwordLogin;
    Button btnLogin;
    LoadingDialog loadingDialog;

    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        loadingDialog = new LoadingDialog(LogInActivity.this);

//        loginButtonFb = findViewById(R.id.login_facebook_button);
//        loginButtonGg = findViewById(R.id.login_google_button);
//        fb = findViewById(R.id.fb_login);
//        gg = findViewById(R.id.gg_login);
        txt_goto_signUp = findViewById(R.id.txt_goto_signup);
        btnLogin = findViewById(R.id.btn_login);

//        fb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loginButtonFb.performClick();
//            }
//        });
//
//        gg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loginButtonGg.performClick();
//            }
//        });

        txt_goto_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        auth = FirebaseAuth.getInstance();
        usernameLogin = findViewById(R.id.username_login);
        passwordLogin = findViewById(R.id.password_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_username = usernameLogin.getText().toString().trim();
                String txt_password = passwordLogin.getText().toString().trim();
                if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(LogInActivity.this, "Chưa điền đầy đủ cho các trường!", Toast.LENGTH_SHORT).show();
                } else {
                    loadingDialog.Loading();
                    reference = FirebaseDatabase.getInstance().getReference("Users");
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int check = 0, checkUser = 0;
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                String username = dataSnapshot.child("username").getValue(String.class);
                                if(username.equals(txt_username)) {
                                    checkUser = 1;
                                    check = 1;
                                    String txt_email = dataSnapshot.child("email").getValue(String.class);
                                    auth.signInWithEmailAndPassword(txt_email,txt_password)
                                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(LogInActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                                                        Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                                                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                                                Intent.FLAG_ACTIVITY_NEW_TASK);
                                                        startActivity(intent);
                                                        finish();
                                                    } else {
                                                        Toast.makeText(LogInActivity.this, "Sai mật khẩu!", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                                } else {
                                    check = 0;
                                }
                            }
                            if (check == 0 && checkUser != 1) {
                                Toast.makeText(LogInActivity.this, "Sai tên đăng nhập hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
                            }
                            loadingDialog.Dismiss();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        findViewById(R.id.forgetPass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputLayout textInputLayout = new TextInputLayout(LogInActivity.this);
                EditText input = new EditText(LogInActivity.this);
                textInputLayout.addView(input);
                input.setBackground(null);
                textInputLayout.setPadding(getResources().getDimensionPixelOffset(R.dimen.dp19),0, getResources().getDimensionPixelOffset(R.dimen.dp19), 0);

                AlertDialog.Builder builder = new AlertDialog.Builder(LogInActivity.this);
                builder.setTitle("Đặt lại mật khẩu");
                builder.setMessage("Gõ email của bạn vào bên dưới và chúng tôi sẽ gửi bạn hướng dẫn cách đặt lại");
                builder.setView(textInputLayout);
                builder.setPositiveButton("GỬI HƯỚNG DẪN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!input.getText().toString().isEmpty()) {
                            loadingDialog.Loading();
                            FirebaseAuth.getInstance().sendPasswordResetEmail(input.getText().toString().trim())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(LogInActivity.this, "Đã gửi yêu cầu, vui lòng kiểm tra email!", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(LogInActivity.this, "Lỗi!", Toast.LENGTH_SHORT).show();
                                        }
                                        loadingDialog.Dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(LogInActivity.this, "Sai email, vui lòng kiểm tra lại!", Toast.LENGTH_SHORT).show();
                                        loadingDialog.Dismiss();
                                    }
                                });
                        } else {
                            Toast.makeText(LogInActivity.this, "Không được để trống!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("HỦY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
        });
    }

}