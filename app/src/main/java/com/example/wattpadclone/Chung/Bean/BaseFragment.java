package com.example.wattpadclone.Chung.Bean;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.wattpadclone.MainActivity;


public class BaseFragment extends Fragment {
	public MainActivity mActivity;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mActivity		=	(MainActivity) this.getActivity();
	}

	public boolean onBackPressed(){
		return false;
	}
}
