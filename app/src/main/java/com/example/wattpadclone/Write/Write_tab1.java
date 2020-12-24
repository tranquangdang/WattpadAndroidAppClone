package com.example.wattpadclone.Write;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wattpadclone.Base.Adapter.Bean.UserBean;
import com.example.wattpadclone.Base.LogInActivity;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.WebServices;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;
import com.example.wattpadclone.Search.Adapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Write_tab1 extends Fragment {
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;
    ImageView imageView;
    ListView lv;
    Adapter.ListViewBaseAdapter adapter;
    ArrayList<Book> arr_bean;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.write_tab1,container,false);
        lv = view.findViewById(R.id.listview);
        lv.setLongClickable(true);
        arr_bean = new ArrayList<>();
        adapter=new Adapter.ListViewBaseAdapter(arr_bean,getContext());
        lv.setAdapter(adapter);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserBean user = snapshot.getValue(UserBean.class);
                WebServices webServices = new WebServices(getActivity());
                webServices.GetDataList("http://tranquangdang.000webhostapp.com/index.php?Author=" + user.getUsername(), arr_bean,adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}
