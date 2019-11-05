package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.Serializable;
import java.util.ArrayList;

public class suoyoukapaiActivity extends AppCompatActivity  {
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
    private TextView jishu;
    private TextView biaoti;
    private Fragment_guancang fragment_guancang;
    private CardSet cs;
    private ArrayList<Card> cs_s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.suoyoukapai);
        biaoti=findViewById(R.id.suoyou_biaoti);
        biaoti.setText("所有卡牌");
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
        cs=new CardSet();
        cs.initial();
        cs_s=cs.getall();
        jishu.setText("共有<"+cs_s.size()+">张所有卡牌");
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
        OnClick onClick=new OnClick();
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


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){

            switch(v.getId()){
                case R.id.imageView6:
                    finish();
                    break;
                case R.id.sy_quanbu:
                    cs_s=cs.getall();
                    jishu.setText("共有<"+cs_s.size()+">张所有卡牌");
                    break;
                case R.id.sy_chunjuan:
                    cs_s=cs.select("chunjuan");
                    jishu.setText("共有<"+cs_s.size()+">张春卷卡牌");
                    break;
                case R.id.sy_hg:
                    cs_s=cs.select("haoge");
                    jishu.setText("共有<"+cs_s.size()+">张昊哥卡牌");
                    break;
                case R.id.sy_hh:
                    cs_s=cs.select("haohao");
                    jishu.setText("共有<"+cs_s.size()+">张昊昊卡牌");
                    break;
                case R.id.sy_hj:
                    cs_s=cs.select("huangjie");
                    jishu.setText("共有<"+cs_s.size()+">张黄姐卡牌");
                    break;
                case R.id.sy_jj:
                    cs_s=cs.select("jiajia");
                    jishu.setText("共有<"+cs_s.size()+">张佳佳卡牌");
                    break;
                case R.id.sy_mm:
                    cs_s=cs.select("miaomiao");
                    jishu.setText("共有<"+cs_s.size()+">张妙妙卡牌");
                    break;
                case R.id.sy_xjst:
                    cs_s=cs.select("xiaojiasiting");
                    jishu.setText("共有<"+cs_s.size()+">张小佳寺町卡牌");
                    break;
                case R.id.sy_xx:
                    cs_s=cs.select("xuanxuan");
                    jishu.setText("共有<"+cs_s.size()+">张萱萱卡牌");
                    break;
                case R.id.sy_ssr:
                    cs_s=cs.getSsr();
                    jishu.setText("共有<"+cs_s.size()+">张SSR卡牌");
                    break;
                case R.id.sy_sr:
                    cs_s=cs.getSr();
                    jishu.setText("共有<"+cs_s.size()+">张SR卡牌");
                    break;
                case R.id.sy_r:
                    cs_s=cs.getR();
                    jishu.setText("共有<"+cs_s.size()+">张R卡牌");
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
