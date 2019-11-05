package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LvAdapter extends BaseAdapter {
    private SharedPreferences spchengjiu;
    private Context context;
    private ArrayList<Chengjiuitem> listcj;

    public LvAdapter(ArrayList<Chengjiuitem> listcj, Context context){
        this.context=context;
        this.listcj=listcj;
    }
    @Override
    public int getCount() {
        return listcj.size();
    }
    @Override
    public Object getItem(int position) {
        return listcj.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LvAdapter.ViewHolder holder;
        if(convertView==null)
        {
            convertView=View.inflate(context, R.layout.item_list_view,null);

            holder=new ViewHolder();
            holder.img=  convertView.findViewById(R.id.lv_iv);
            holder.name= convertView.findViewById(R.id.lv_mingcheng);
            holder.explain=convertView.findViewById(R.id.lv_shuoming);
            holder.dacheng=convertView.findViewById(R.id.lv_dacheng);
            holder.bg=convertView.findViewById(R.id.lv_bg);
            convertView.setTag(holder);
        } else {

            holder= (LvAdapter.ViewHolder) convertView.getTag();
        }

        Chengjiuitem chengjiuitem=listcj.get(position);

        holder.explain.setText(chengjiuitem.explain);
        holder.name.setText(chengjiuitem.title);
        spchengjiu=context.getSharedPreferences("chengjiu",context.MODE_PRIVATE);
        final boolean dacheng=spchengjiu.getBoolean(chengjiuitem.title,false);
        final int mp=chengjiuitem.picture;
        if(dacheng){
            holder.dacheng.setText("已达成");
            holder.img.setImageResource(chengjiuitem.picture);
            holder.dacheng.setBackground(context.getResources().getDrawable(R.drawable.shape_pinkdark));


        }else{
            holder.dacheng.setText("未达成");
            holder.img.setImageResource(R.drawable.wenhao);
            holder.dacheng.setBackground(context.getResources().getDrawable(R.drawable.shape_pink));
        }

        holder.bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dacheng) {

                    Intent intent = new Intent(context, cardShowActivity.class);
                    intent.putExtra("picture", mp);
                    intent.putExtra("type", 1);
                    context.startActivity(intent);
                }


            }
        });







        return convertView;
    }

    public class ViewHolder
    {
        ImageView img,bg;
        TextView name,explain,dacheng;

    }


}
