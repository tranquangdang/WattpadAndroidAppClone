package com.example.wattpadclone.Libary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.wattpadclone.Base.Adapter.Bean.UserBean;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;

public class ReadingListAdapter extends BaseAdapter {
    Context mContext;
    public ArrayList<Book> arraylistListener3;
    private List<Book> mListenerList3;
    FirebaseUser firebaseUser;
    DatabaseReference databaseReference;

    public ReadingListAdapter(ArrayList<Book> mListenerList3, Context context) {
        mContext = context;
        this.mListenerList3 = mListenerList3;
        this.arraylistListener3 = new ArrayList<Book>();
        this.arraylistListener3.addAll(mListenerList3);
    }

    public class ViewHolder {
        ImageView anh1, anh2, anh3;
        TextView title;
        TextView stories;
    }

    @Override
    public int getCount() {
        return mListenerList3.size();
    }

    @Override
    public Object getItem(int i) {
        return mListenerList3.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ReadingListAdapter.ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout3_watpad, null);
            holder = new ReadingListAdapter.ViewHolder();
            holder.anh1 = (ImageView) view.findViewById(R.id.anh1);
            holder.anh2 = (ImageView) view.findViewById(R.id.anh2);
            holder.anh3 = (ImageView) view.findViewById(R.id.anh3);
            holder.title = (TextView) view.findViewById(R.id.lv_reading_title);
            holder.stories = view.findViewById(R.id.lv_reading_stories);
            view.setTag(holder);
        } else {
            holder = (ReadingListAdapter.ViewHolder) view.getTag();
        }
        try {
            Glide.with(mContext).load(mListenerList3.get(i).getBookImg()).into(holder.anh1);
            Glide.with(mContext).load(mListenerList3.get(i).getBookImg()).into(holder.anh2);
            Glide.with(mContext).load(mListenerList3.get(i).getBookImg()).into(holder.anh3);
            holder.title.setText(String.valueOf(mListenerList3.get(i).getBookName()));

            firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    UserBean user = snapshot.getValue(UserBean.class);
                    holder.stories.setText("@" + user.getUsername());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        } catch (Exception ex) {

        }

        return view;
    }
}
