package com.example.wattpadclone.Search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;

public class SearchFragment extends BaseFragment {

    public SearchFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar_search);
        toolbar.setLogo(ContextCompat.getDrawable(getContext(), R.drawable.ic_logo));
        View logoView = toolbar.getChildAt(2);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        GridView gridView;
        String[] name = {"Bí ẩn", "Cổ điển", "Hài hước", "Hành động", "Khoa Học Viễn Tưởng", "Kinh dị", "Lãng mạn",
                "Người sói", "Ngẫu nhiên", "Phi tiểu thuyết", "Phiêu lưu", "Siêu nhiên", "Thơ ca", "TT chung",
                "Thriller", "TT lịch sử", "TT thiếu niên", "Truyện ngắn", "Truyện tâm linh", "Viễn tưởng"};
        int[] img = {R.drawable.mystery, R.drawable.newadult, R.drawable.humor, R.drawable.action, R.drawable.scifi, R.drawable.horror,
                R.drawable.romance, R.drawable.werewolf, R.drawable.random, R.drawable.nonfiction, R.drawable.adventure, R.drawable.paranormal,
                R.drawable.poetry, R.drawable.urban, R.drawable.thriller, R.drawable.historicalfic, R.drawable.teenfic, R.drawable.shortstory, R.drawable.diverselit,
                R.drawable.fanfic};

        gridView = view.findViewById(R.id.grid);
        Adapter.MainAdapter adapter = new Adapter.MainAdapter(getActivity(), name, img);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mActivity.pushFragments(MainActivity.SEARCH_FRAGMENT, new FragmentSearchList(), true);
            }
        });

        return view;
    }
}