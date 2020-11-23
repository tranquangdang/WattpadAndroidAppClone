package com.example.wattpadclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class two extends AppCompatActivity {

    ListView lv;
    ListViewBaseAdapter adapter;
    ArrayList<ListViewBean> arr_bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        lv=findViewById(R.id.listview);
        arr_bean=new ArrayList<ListViewBean>();
        arr_bean.add(new ListViewBean(R.drawable.a1,"Đối lập","239 K","1.7 K",
                "39","\"Want to be something nobody can do, you need to more try\"","truyện","phiêu lưu",
                "phiêu lưu"));
        arr_bean.add(new ListViewBean(R.drawable.a2,"Gun fire at the dock","120 K","9.7 K",
                "41","\"Want to be something nobody can do, you need to more try\"","gun","cổ điển",
                "viễn tưởng"));
        arr_bean.add(new ListViewBean(R.drawable.a3,"Collins","81 K","10.6 K",
                "4","\"Want to be something nobody can do, you need to more try\"","collins","hài hước",
                "lãng mạn"));
        arr_bean.add(new ListViewBean(R.drawable.a4,"Con đường hồi giáo","740 K","5.2 K",
                "78","\"Want to be something nobody can do, you need to more try\"","đường","thơ ca",
                "bí ẩn"));
        arr_bean.add(new ListViewBean(R.drawable.a5,"Xóm trọ","19 K","3.5 K",
                "91","\"Want to be something nobody can do, you need to more try\"","xóm","cổ điển",
                "hài hước"));
        arr_bean.add(new ListViewBean(R.drawable.a6,"Cucho cậu bé hiếu thảo","899 K","6.9 K",
                "24","\"Want to be something nobody can do, you need to more try\"","cucho","thơ ca",
                "cổ điển"));
        adapter=new ListViewBaseAdapter(arr_bean,this);
        lv.setAdapter(adapter);
    }

    public void bt_return(View view) {
        startActivity(new Intent(getApplicationContext(),Search.class));
    }
}