package com.example.wattpadclone.Base;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
    TextView fb, gg, txtBackPressed, dob_signup;
    LoginButton sinUpButtonFb;
    SignInButton sinUpButtonGg;
    Button btn_signup;
    EditText emailSignUp, userSignUp, passSignUp;
    int year, month, day;
    String msg;
    LoadingDialog loadingDialog;

    FirebaseAuth auth;
    DatabaseReference reference;

    private void Register(String email, String username, String password, String dob) {
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            assert firebaseUser != null;
                            String userid = firebaseUser.getUid();
                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("email", email);
                            hashMap.put("username", username);
                            hashMap.put("dob", dob);

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                                Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        Toast.makeText(SignUpActivity.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } else {
                            loadingDialog.Dismiss();
                            Toast.makeText(SignUpActivity.this, "Email này đã được đăng kí trước đó!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_sign_up);
        loadingDialog = new LoadingDialog(SignUpActivity.this);

        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day= calendar.get(Calendar.DAY_OF_MONTH);
        emailSignUp = findViewById(R.id.email_signup);
        userSignUp = findViewById(R.id.username_signup);
        passSignUp = findViewById(R.id.password_signup);
        dob_signup = findViewById(R.id.dob_signup);

//        sinUpButtonFb = findViewById(R.id.login_facebook_button);
//        sinUpButtonGg = findViewById(R.id.login_google_button);
//        fb = findViewById(R.id.fb_signup);
//        gg = findViewById(R.id.gg_signup);
        txtBackPressed = findViewById(R.id.txt_back_pressed_login);
        btn_signup = findViewById(R.id.btn_signup);


//        fb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sinUpButtonFb.performClick();
//            }
//        });
//
//        gg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sinUpButtonGg.performClick();
//            }
//        });

        txtBackPressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });

        dob_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SignUpActivity.this, dateSetListener, year, month, day).show();
            }
        });

        auth = FirebaseAuth.getInstance();

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = emailSignUp.getText().toString();
                String txt_username = userSignUp.getText().toString();
                String txt_pass = passSignUp.getText().toString();
                String txt_dob = dob_signup.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_pass) || TextUtils.isEmpty(txt_dob)) {
                    Toast.makeText(SignUpActivity.this, "Các trường không được trống!", Toast.LENGTH_SHORT).show();
                } else if (txt_pass.length() < 6) {
                    Toast.makeText(SignUpActivity.this, "Mật khẩu phải nhiều hơn 6 kí tự!", Toast.LENGTH_SHORT).show();
                } else {
                    loadingDialog.Loading();
                    reference = FirebaseDatabase.getInstance().getReference("Users");
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int check = 1;
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                String username = dataSnapshot.child("username").getValue(String.class);
                                if (username.equals(txt_username)){
                                    check = 0;
                                    Toast.makeText(SignUpActivity.this, "Username này đã được sử dụng bởi người khác!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            loadingDialog.Dismiss();
                            if(check == 1){
                                Register(txt_email, txt_username, txt_pass, txt_dob);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        findViewById(R.id.policy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://policies.wattpad.com/terms/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            msg = String.format("%d - %d - %d", dayOfMonth, monthOfYear, year);
            dob_signup.setText(msg);
        }
    };

}