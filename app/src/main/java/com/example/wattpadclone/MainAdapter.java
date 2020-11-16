package com.example.wattpadclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] name;
    private int[] img;

    public MainAdapter(Context c, String[] name, int[] img) {
        this.context = c;
        this.name = name;
        this.img = img;
    }

    @Override
    public int getCount() {
        return name.length;
    }


    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(inflater==null){
            inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        }
        if(view==null){
            view=inflater.inflate(R.layout.row_item,null);
        }
        TextView textView=view.findViewById(R.id.text);
        ImageView imageView= view.findViewById(R.id.image);
        imageView.setImageResource(img[position]);
        textView.setText(name[position]);
        return view;
    }
}
