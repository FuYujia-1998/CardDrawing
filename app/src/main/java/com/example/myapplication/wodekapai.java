package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class wodekapai extends AppCompatActivity {
    private ArrayList<Card> precs;
    private Button back;
    private Button quanbu;
    private Button chunjuan;
    private Button haoge;
    private Button haohao;
    private Button huangjie;
    private Button jiajia;
    private Button miaomiao;
    private Button xiaojiasiting;
    private Button xuanxuan;
    private Button ssr;
    private Button sr;
    private Button r;
    private TextView biaoti;
    private  TextView jishu;
    private Fragment_guancang fragment_guancang;
    private CardSet cs;
    private ArrayList<Card> cs_s;
    private SharedPreferences spCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.suoyoukapai);


        biaoti=findViewById(R.id.suoyou_biaoti);
        biaoti.setText("我的卡牌");
        quanbu=findViewById(R.id.sy_quanbu);
        chunjuan=findViewById(R.id.sy_chunjuan);
        haoge=findViewById(R.id.sy_hg);
        haohao=findViewById(R.id.sy_hh);
        huangjie=findViewById(R.id.sy_hj);
        jiajia=findViewById(R.id.sy_jj);
        miaomiao=findViewById(R.id.sy_mm);
        xiaojiasiting=findViewById(R.id.sy_xjst);
        xuanxuan=findViewById(R.id.sy_xx);
        back=findViewById(R.id.imageView6);
        ssr=findViewById(R.id.sy_ssr);
        sr=findViewById(R.id.sy_sr);
        r=findViewById(R.id.sy_r);
        jishu=findViewById(R.id.sy_jishu);
        spCard=getSharedPreferences("gotcard",MODE_PRIVATE);
        Bundle bundle1 = getIntent().getExtras();
        Serializable s = bundle1.getSerializable("cs");
        precs= (ArrayList<Card>) s;
        cs_s=new ArrayList<>();
        cs_s.addAll(precs);

        jishu.setText("已获得<"+cs_s.size()+">张全部卡牌");


        Fragment_guancang fragment_guancang= new Fragment_guancang();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data",cs_s);
        fragment_guancang.setArguments(bundle);//数据传递到fragment中
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sy_fl,fragment_guancang);
        fragmentTransaction.commit();
        setListeners();
    }



    private void setListeners(){
        wodekapai.MOnClick onClick=new wodekapai.MOnClick();
        quanbu.setOnClickListener(onClick);
        back.setOnClickListener(onClick);
        huangjie.setOnClickListener(onClick);
        haohao.setOnClickListener(onClick);
        haoge.setOnClickListener(onClick);
        jiajia.setOnClickListener(onClick);
        miaomiao.setOnClickListener(onClick);
        chunjuan.setOnClickListener(onClick);
        xiaojiasiting.setOnClickListener(onClick);
        xuanxuan.setOnClickListener(onClick);
        ssr.setOnClickListener(onClick);
        sr.setOnClickListener(onClick);
        r.setOnClickListener(onClick);
    }


    private class MOnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){

            switch(v.getId()){
                case R.id.imageView6:
                    finish();
                    break;
                case R.id.sy_quanbu:
                    cs_s=precs;
                    jishu.setText("已获得<"+cs_s.size()+">张全部卡牌");
                    break;
                case R.id.sy_chunjuan:
                    cs_s=CardSet.staselect(precs,"chunjuan");
                    jishu.setText("已获得<"+cs_s.size()+">张"+"春卷"+"卡牌");
                    break;
                case R.id.sy_hg:
                    cs_s=CardSet.staselect(precs,"haoge");
                    jishu.setText("已获得<"+cs_s.size()+">张"+"昊哥"+"卡牌");
                    break;
                case R.id.sy_hh:
                    cs_s=CardSet.staselect(precs,"haohao");
                    jishu.setText("已获得<"+cs_s.size()+">张"+"昊昊"+"卡牌");
                    break;
                case R.id.sy_hj:
                    cs_s=CardSet.staselect(precs,"huangjie");
                    jishu.setText("已获得<"+cs_s.size()+">张"+"黄姐"+"卡牌");
                    break;
                case R.id.sy_jj:
                    cs_s=CardSet.staselect(precs,"jiajia");
                    jishu.setText("已获得<"+cs_s.size()+">张"+"佳佳"+"卡牌");
                    break;
                case R.id.sy_mm:
                    cs_s=CardSet.staselect(precs,"miaomiao");
                    jishu.setText("已获得<"+cs_s.size()+">张"+"妙妙"+"卡牌");
                    break;
                case R.id.sy_xjst:
                    cs_s=CardSet.staselect(precs,"xiaojiasiting");
                    jishu.setText("已获得<"+cs_s.size()+">张"+"小佳寺町"+"卡牌");
                    break;
                case R.id.sy_xx:
                    cs_s=CardSet.staselect(precs,"xuanxuan");
                    jishu.setText("已获得<"+cs_s.size()+">张"+"萱萱"+"卡牌");
                    break;
                case R.id.sy_ssr:
                    cs_s=CardSet.staselect(precs,"ssr");
                    jishu.setText("已获得<"+cs_s.size()+">张"+"SSR"+"卡牌");
                    break;
                case R.id.sy_sr:
                    cs_s=CardSet.staselect(precs,"sr");
                    jishu.setText("已获得<"+cs_s.size()+">张"+"SR"+"卡牌");
                    break;
                case R.id.sy_r:
                    cs_s=CardSet.staselect(precs,"r");
                    jishu.setText("已获得<"+cs_s.size()+">张"+"R"+"卡牌");
                    break;

            }

            Fragment_guancang fragment_guancang= new Fragment_guancang();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data",cs_s);
            fragment_guancang.setArguments(bundle);//数据传递到fragment中
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.sy_fl,fragment_guancang);
            fragmentTransaction.commit();

        }
    }





}
