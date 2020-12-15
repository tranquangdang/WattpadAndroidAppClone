package com.example.wattpadclone.Home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.wattpadclone.Chung.Bean.BaseFragment;
import com.example.wattpadclone.Home.Account.AccountActivity;
//import com.example.wattpadclone.Home.Adapters.Beans.HorizontalViewPagerHomeBean1;
import com.example.wattpadclone.Home.Adapters.Beans.HorizontalRecyclerViewHomeBean2;
import com.example.wattpadclone.Home.Adapters.Beans.HorizontalViewPagerHomeBean1;
import com.example.wattpadclone.Home.Adapters.Beans.VerticalRecyclerViewHomeBean;
import com.example.wattpadclone.Home.Adapters.HorizontalViewPagerHomeAdapter1;
import com.example.wattpadclone.Home.Adapters.VerticalRecyclerViewHomeAdapter;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {

    RecyclerView verticalRecyclerView;
    VerticalRecyclerViewHomeAdapter vAdapter;
    ArrayList<VerticalRecyclerViewHomeBean> arrayListVertical;

    public HomeFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar_home);
        toolbar.inflateMenu(R.menu.menu_toolbar_home);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.toolbar_home_setting)
                {
                    // do something
                }
                else if(item.getItemId()== R.id.toolbar_home_account)
                {
                    Intent intent = new Intent(getActivity(), AccountActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        arrayListVertical = new ArrayList<>();
        verticalRecyclerView = view.findViewById(R.id.home_recyclerViewMain);
        verticalRecyclerView.setHasFixedSize(true);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));

        vAdapter = new VerticalRecyclerViewHomeAdapter(getContext(),arrayListVertical);
        verticalRecyclerView.setAdapter(vAdapter);


        completedBookAdd();
        test2();
        test3();

        return view;
    }


    private void completedBookAdd() {
       ArrayList<HorizontalViewPagerHomeBean1> arrayListHorizontal1 = new ArrayList<>();
         arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book1, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book2, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hayccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book3, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book4, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book5, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hayccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book7, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book8, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));

        ArrayList<HorizontalRecyclerViewHomeBean2> arrayListHorizontal2 = new ArrayList<>();
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book9));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book10));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book7));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book5));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book4));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book3));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book2));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book1));
        VerticalRecyclerViewHomeBean mVerticalRecyclerViewHomeBean = new VerticalRecyclerViewHomeBean("Truyện đã Hoàn Thành", "Đọc say sưa từ đầu đến cuối",
                "Truyện được thảo luận nhiều", "Các truyện có nhiều bình luận nhất", arrayListHorizontal1, arrayListHorizontal2);
        arrayListVertical.add(mVerticalRecyclerViewHomeBean);
        vAdapter.notifyDataSetChanged();
    }

    private void test2() {
        ArrayList<HorizontalViewPagerHomeBean1> arrayListHorizontal1 = new ArrayList<>();
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book2, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book5, "aaaaaaaaaaaaaaa", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book8, "bbbbbbbbbbbbbbbb", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book7, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book3, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book1, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book9, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));

        ArrayList<HorizontalRecyclerViewHomeBean2> arrayListHorizontal2 = new ArrayList<>();
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book7));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book4));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book3));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book2));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book1));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book10));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book5));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book2));
        VerticalRecyclerViewHomeBean mVerticalRecyclerViewHomeBean = new VerticalRecyclerViewHomeBean("Truyện đã Hoàn Thành", "Đọc say sưa từ đầu đến cuối",
                "Truyện được thảo luận nhiều", "Các truyện có nhiều bình luận nhất", arrayListHorizontal1, arrayListHorizontal2);
        arrayListVertical.add(mVerticalRecyclerViewHomeBean);
        vAdapter.notifyDataSetChanged();
    }


    private void test3() {
        ArrayList<HorizontalViewPagerHomeBean1> arrayListHorizontal1 = new ArrayList<>();
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book2, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book5, "aaaaaaaaaaaaaaa", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book8, "bbbbbbbbbbbbbbbb", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book7, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book3, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book1, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));
        arrayListHorizontal1.add(new HorizontalViewPagerHomeBean1(R.mipmap.book9, "Guns, germs and steel", "Súng vi trùng và thép là một quyển sách hay", "Jared Diamond"));

        ArrayList<HorizontalRecyclerViewHomeBean2> arrayListHorizontal2 = new ArrayList<>();
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book7));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book4));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book3));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book2));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book1));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book10));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book5));
        arrayListHorizontal2.add(new HorizontalRecyclerViewHomeBean2(R.mipmap.book2));
        VerticalRecyclerViewHomeBean mVerticalRecyclerViewHomeBean = new VerticalRecyclerViewHomeBean("Xu huớng", "Xu hướng trong tuần qua",
                "Có thể bạn cũng thích", "Có thể bạn sẽ thích truyện này", arrayListHorizontal1, arrayListHorizontal2);
        arrayListVertical.add(mVerticalRecyclerViewHomeBean);
        vAdapter.notifyDataSetChanged();
    }

}
