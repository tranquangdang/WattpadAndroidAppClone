package com.example.wattpadclone.Bell.Tabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wattpadclone.Bell.Message.Contacts;
import com.example.wattpadclone.R;
import com.example.wattpadclone.Bell.Tabs.thembanbe.thembanbe;

public class Bell_tab2 extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2,container,false);


        view.findViewById(R.id.bell_new_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Contacts.class);
                startActivity(intent);
            }
        });




        return view;
    }
}
