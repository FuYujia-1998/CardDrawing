package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class GvAdapter extends BaseAdapter {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private Context context;
    private LayoutInflater inf;
    private ArrayList<Card> cs;



    public GvAdapter(Context context, ArrayList<Card> cs)
    {
        this.cs=cs;

        this.context=context;
        this.inf=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cs.size();
    }

    @Override
    public Object getItem(int position) {
        return cs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder;
        if(convertView==null)
        {
            convertView=View.inflate(context, R.layout.item_grid_view,null);

            holder=new ViewHolder();
            holder.img=  convertView.findViewById(R.id.gv_iv);
            holder.tv= convertView.findViewById(R.id.gv_tv);
            convertView.setTag(holder);
        } else {

            holder= (ViewHolder) convertView.getTag();
        }

        Card c=cs.get(position);
        sp=context.getSharedPreferences("gotcard",context.MODE_PRIVATE);
        boolean got=sp.getBoolean(c.name,false);
        if(got){
            holder.tv.setText("已获得");
            holder.img.setImageResource(c.picture);
        }else{
            holder.tv.setText("未获得");
            holder.img.setAlpha(0.6f);
            holder.img.setImageResource(c.picture);
        }


        return convertView;
    }

    public class ViewHolder
    {
        ImageView img;
        TextView tv;
    }



}
