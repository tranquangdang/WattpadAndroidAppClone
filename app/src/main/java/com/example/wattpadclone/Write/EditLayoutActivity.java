package com.example.wattpadclone.Write;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.wattpadclone.Home.Account.AccountActivity;
import com.example.wattpadclone.R;

public class EditLayoutActivity extends AppCompatActivity {
    EditText editText;
    Intent intent;
    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_layout);
        editText = findViewById(R.id.edit_book);
        Toolbar toolbar = findViewById(R.id.toolbar_edit_book);
        intent = getIntent();
        if(intent.hasExtra("title")) {
            txt = intent.getStringExtra("title");
            toolbar.setTitle("Tiêu đề truyện");
            editText.setText(txt);
        }
        if(intent.hasExtra("info")) {
            txt = intent.getStringExtra("info");
            toolbar.setTitle("Mô tả truyện");
            editText.setText(txt);
        }
        toolbar.setLogo(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24));
        View logoView = toolbar.getChildAt(1);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbar.inflateMenu(R.menu.menu_write_edit_layout);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()== R.id.toolbar_check)
                {
                    passData();
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Bạn có muốn quay lưu?").setCancelable(false)
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        passData();
                    }
                })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        finish();
                    }
                });

        AlertDialog alert = dialog.create();
        alert.setTitle("Cảnh báo!");
        alert.show();
    }

    public void passData(){
        String result = editText.getText().toString();
        if(intent.hasExtra("title")) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("title",result);
            setResult(RESULT_OK,returnIntent);
        }
        if(intent.hasExtra("info")) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("info",result);
            setResult(RESULT_OK,returnIntent);
        }
        finish();
    }
}