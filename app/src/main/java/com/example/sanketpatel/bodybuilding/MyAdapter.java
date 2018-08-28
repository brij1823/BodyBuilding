package com.example.sanketpatel.bodybuilding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifTextView;

/**
 * Created by Sanket Patel on 15-12-2017.
 */

class MyAdapter extends BaseAdapter {
    String exc[];
    int x[];
    Context context;
    int count;
    int decide;
    public MyAdapter(Context context, String[] name,int []images,int i) {
       this.context=context;
       exc=name;
       count=name.length;
      x=images;
      decide=i;
    }

    @Override
    public int getCount() {
        return count;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(decide==0){
        view = LayoutInflater.from(context).inflate(R.layout.zoo, null);
        TextView t=(TextView) view.findViewById(R.id.head);
        //ImageView img=(ImageView) view.findViewById(R.id.gif);
        t.setText(exc[i]);
       GifTextView img1=(GifTextView) view.findViewById(R.id.gif);

       img1.setBackgroundResource(x[i]);

        return view;  }
        else{
            view=LayoutInflater.from(context).inflate(R.layout.activity_medalist,null);
            TextView t=(TextView) view.findViewById(R.id.head1);
            t.setText(exc[i]);
            ImageView img=(ImageView) view.findViewById(R.id.paste);
            img.setImageResource(x[i]);
           return  view;
        }

    }
}
