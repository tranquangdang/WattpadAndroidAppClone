package com.example.wattpadclone.Search;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.Chung.BookDetails.ActivityBookDetails;
import com.example.wattpadclone.Chung.BookDetails.ActivityBookDetailsViewPager;
import com.example.wattpadclone.MainActivity;
import com.example.wattpadclone.R;
import com.example.wattpadclone.Write.NewBookActivity;
import com.example.wattpadclone.Write.WriteFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adapter {
    public static class ListViewBaseAdapter extends BaseAdapter {
        public ArrayList<Book> arraylistListener;
        private List<Book> mListenerList;
        Context mContext;

        public ListViewBaseAdapter(ArrayList<Book> mListenerList, Context context) {
            mContext = context;
            this.mListenerList = mListenerList;
            this.arraylistListener = new ArrayList<>();
            this.arraylistListener.addAll(mListenerList);
        }

        public class ViewHolder {
            ImageView lv_topic_anh;
            TextView lv_topic_title,lv_topic_eye,lv_topic_star,lv_topic_menu,lv_topic_contentt,lv_topic_more,lv_topic_sum_tag,search_book_id;
        }

        @Override
        public int getCount() {
            return mListenerList.size();
        }

        @Override
        public Object getItem(int position) {
            return mListenerList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int i, View view, ViewGroup parent) {
            final ViewHolder holder;
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.layout_lv_adapter, null);
                holder = new ViewHolder();
                holder.search_book_id = view.findViewById(R.id.search_book_id);
                holder.search_book_id.setVisibility(View.GONE);
                holder.lv_topic_anh = (ImageView) view.findViewById(R.id.lv_topic_anh);
                holder.lv_topic_title=view.findViewById(R.id.lv_topic_title);
                holder.lv_topic_eye=view.findViewById(R.id.lv_topic_eye);
                holder.lv_topic_star=view.findViewById(R.id.lv_topic_star);
                holder.lv_topic_menu=view.findViewById(R.id.lv_topic_menu);
                holder.lv_topic_contentt=view.findViewById(R.id.lv_topic_contentt);
                holder.lv_topic_more=view.findViewById(R.id.lv_topic_more);
                holder.lv_topic_sum_tag=view.findViewById(R.id.lv_topic_sum_tag);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            try {
                Glide.with(mContext).load(mListenerList.get(i).getBookImg()).into(holder.lv_topic_anh);
                holder.search_book_id.setText(String.valueOf(Integer.valueOf(mListenerList.get(i).getBookID())));
                holder.lv_topic_title.setText(String.valueOf(mListenerList.get(i).getBookName()));
                holder.lv_topic_contentt.setText(String.valueOf(mListenerList.get(i).getIntro()));
                holder.lv_topic_eye.setText(String.valueOf(Integer.valueOf(mListenerList.get(i).getWritten())));
                holder.lv_topic_star.setText(String.valueOf(Integer.valueOf(mListenerList.get(i).getFavorite())));
                holder.lv_topic_menu.setText(Integer.valueOf(mListenerList.get(i).getChapter()) + " phần");
                holder.lv_topic_more=view.findViewById(R.id.lv_topic_more);
                holder.lv_topic_sum_tag=view.findViewById(R.id.lv_topic_sum_tag);
            }catch (Exception ex){

            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, ActivityBookDetails.class);
                    intent.putExtra("BookID", holder.search_book_id.getText().toString());
                    mContext.startActivity(intent);
                }
            });
            if(mContext instanceof MainActivity){
                view.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
                        dialog.setMessage("Bạn có muốn sửa hay xóa?").setCancelable(false)
                                .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
                                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://tranquangdang.000webhostapp.com/deletebook.php",
                                                new Response.Listener<String>() {
                                                    @Override
                                                    public void onResponse(String response) {
                                                        if(response.trim().equals("success")){
                                                            Toast.makeText(mContext, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                                                            ((MainActivity)mContext).gotoFragment(new WriteFragment());
                                                        }else {
                                                            Toast.makeText(mContext, "Lỗi!" +response, Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                },
                                                new Response.ErrorListener() {
                                                    @Override
                                                    public void onErrorResponse(VolleyError error) {
                                                        Toast.makeText(mContext, "Lỗi" + error.toString(), Toast.LENGTH_SHORT).show();
                                                    }
                                                }){
                                            @Override
                                            protected Map<String, String> getParams() throws AuthFailureError {
                                                Map<String, String> params = new HashMap<>();
                                                TextView txt =  view.findViewById(R.id.details_book_id);
                                                params.put("BookID", holder.search_book_id.getText().toString().trim());
                                                return params;
                                            }
                                        };
                                        requestQueue.add(stringRequest);
                                    }
                                })
                                .setNegativeButton("Sửa", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(mContext, NewBookActivity.class);
                                        intent.putExtra("Action", holder.search_book_id.getText().toString().trim());
                                        mContext.startActivity(intent);
                                    }
                                }).setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });

                        AlertDialog alert = dialog.create();
                        alert.setTitle("Lựa chọn");
                        alert.show();
                        return false;
                    }
                });
            }

            return view;
        }
    }

    public static class MainAdapter extends BaseAdapter {
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

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, SearchListActivity.class);
                    intent.putExtra("name", textView.getText().toString());
                    context.startActivity(intent);
                }
            });
            return view;
        }
    }

}
