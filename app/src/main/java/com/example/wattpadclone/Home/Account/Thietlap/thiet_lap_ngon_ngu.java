package com.example.wattpadclone.Home.Account.Thietlap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.wattpadclone.R;

public class thiet_lap_ngon_ngu extends AppCompatActivity {

    AlertDialog dialog;
    AlertDialog.Builder builder;
    String []item={"English","Thai","Deutsch","Italiano","Nederlands","Polski","Tiếng Việt"};
    String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thiet_lap_ngon_ngu);
        builder= new AlertDialog.Builder(thiet_lap_ngon_ngu.this);
        builder.setTitle("Lựa chọn ngôn ngữ của bạn");
        builder.setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int whitch) {
                result=item[whitch];
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog=builder.create();
        dialog.show();
    }
}