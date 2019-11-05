package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class chengjiu extends AppCompatActivity {

    private ListView lv;
    private Button cj_back;
    private Button jieju;
    private SharedPreferences spCard,spdacheng,spMoney;
    private SharedPreferences.Editor editorCard,editordacheng;
    private  AlertDialog.Builder builder;
    private  ArrayList<Chengjiuitem> listcj;
    private int money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengjiu);

        cj_back=findViewById(R.id.cj_back);
        cj_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lv=findViewById(R.id.listview);
        jieju=findViewById(R.id.cj_jieju);
        builder = new AlertDialog.Builder(this);
        spCard=getSharedPreferences("gotcard",MODE_PRIVATE);
        spdacheng=getSharedPreferences("chengjiu",MODE_PRIVATE);
        spMoney=getSharedPreferences("money",MODE_PRIVATE);
        editordacheng=spdacheng.edit();
        editorCard=spCard.edit();
        listcj=new ArrayList<Chengjiuitem>();
//

        listcj.add(new Chengjiuitem("欧气满满","收集十一张SR，可获得justin热爱物品一件","sr",R.drawable.chengjiu_srouqimanman,11));
        listcj.add(new Chengjiuitem("欧气十足","收集五十张R，可获得justin热爱物品一件","r",R.drawable.chengjiu_ssr2002,50));
        listcj.add(new Chengjiuitem("纯血欧洲人","收集八张SSR，可获得justin热爱物品一件","ssr",R.drawable.chengjiu_ssrchunxueouzhouren,8));
        listcj.add(new Chengjiuitem("欧神","收集十三张SSR，可获得justin热爱物品一件","ssr",R.drawable.chengjiu_ssroushen,13));
        listcj.add(new Chengjiuitem("春卷自拍","收集四张春卷卡牌，可欣赏春卷自拍","chunjuan",R.drawable.chengjiu_chunjuanzipai,4));
        listcj.add(new Chengjiuitem("春卷的包包头","收集六张春卷卡牌，可欣赏春卷扶包包头","chunjuan",R.drawable.chengjiu_chunjuanlitoubao,6));
        listcj.add(new Chengjiuitem("昊哥的惊喜","收集八张昊哥卡牌，可收获昊哥的惊喜","haoge",R.drawable.chengjiu_haogedejingxi,8));
        listcj.add(new Chengjiuitem("昊哥的爱","收集十六张昊哥卡牌，可拥有昊哥的爱","haoge",R.drawable.chengjiu_haogedeai,16));
        listcj.add(new Chengjiuitem("昊昊的花裤子","收集十二张昊昊卡牌，送你一条昊昊的花裤子","haohao",R.drawable.chengjiu_haohaodehuakuzi,12));
        listcj.add(new Chengjiuitem("昊昊壁咚","收集十五张昊昊卡牌，获得昊昊壁咚一次","haohao",R.drawable.chengjiu_haohaobidong,15));
        listcj.add(new Chengjiuitem("昊昊等你放学","收集十九张昊昊卡牌，昊昊在等你放学","haohao",R.drawable.chengjiu_haohaodengnifangxue,19));
        listcj.add(new Chengjiuitem("黄姐qq爱","收集六张黄姐卡牌，与黄姐qq爱","huangjie",R.drawable.chengjiu_huangjieqqai,6));
        listcj.add(new Chengjiuitem("黄姐和姐妹","收集十一张黄姐卡牌，欣赏黄姐和姐妹的大尺度合照","huangjie",R.drawable.chengjiu_huangjiehejiemei,11));
        listcj.add(new Chengjiuitem("佳佳的祝福","收集十张佳佳卡牌，收获世界上最好的佳佳祝福一份","jiajia",R.drawable.chengjiu_jiajiadezhufu,10));
        listcj.add(new Chengjiuitem("睡美人佳佳","收集十五张佳佳卡牌，欣赏睡美人佳佳","jiajia",R.drawable.chengjiu_jiajiashuimeiren,15));
        listcj.add(new Chengjiuitem("佳佳的屁股","收集二十张佳佳卡牌，偷偷给你看佳佳的屁股","jiajia",R.drawable.chengjiu_jiajiapigu,20));
        listcj.add(new Chengjiuitem("生气的妙妙","收集四张妙妙卡牌，了解可爱的人是怎么生气的","miaomiao",R.drawable.chengjiu_miaoshizenmeshengqi,4));
        listcj.add(new Chengjiuitem("妙妙浴缸照","收集七张妙妙卡牌，可欣赏妙妙浴缸照","miaomiao",R.drawable.chengjiu_miaomiaoyugang,7));
        listcj.add(new Chengjiuitem("妙妙床照","收集九张妙妙卡牌，可欣赏妙妙绝美床照","miaomiao",R.drawable.chengjiu_miaochuangzhao,9));
        listcj.add(new Chengjiuitem("小佳寺町自拍","收集两张小佳寺町卡牌，可欣赏绝版小佳寺町自拍","xiaojiasiting",R.drawable.chengjiu_xiaojiasitingzipai,2));
        listcj.add(new Chengjiuitem("萱萱带胖娃","收集五张萱萱卡牌，欣赏萱萱带胖娃","xuanxuan",R.drawable.chengjiu_xuandaiwa,5));
        listcj.add(new Chengjiuitem("铲车公主萱萱","收集八张萱萱卡牌，收获铲车公主黄萱萱","xuanxuan",R.drawable.chengjiu_xuanchanchegongzhu,8));

        for(Chengjiuitem c:listcj){
            setchengjiu(c);
        }
        LvAdapter adapter=new LvAdapter(listcj,lv.getContext());
        lv.setAdapter(adapter);

        jieju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                money=spMoney.getInt("money",-10);
                if(money!=0){
                    builder.setMessage("游戏未结束，抽完所有卡牌后才能查看分析哦！");
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else if(money==0){




                    String chengjiu="";
                    for(Chengjiuitem cj:listcj){
                        if (spdacheng.getBoolean(cj.title,false)){
                            chengjiu+="["+cj.title+"]\n";
                        };
                    }
                    int nssr=spCard.getInt("ssr",-1);
                    int nsr=spCard.getInt("sr",-1);
                    int nr=spCard.getInt("r",-1);

                    int xing=5;
                    String ou="";
                    int total=1456*nssr+648*nsr+80*nr;
                    if(total<17000){
                        xing=1;ou="你是非洲来的吧？";
                    }else if(total<18700){
                        xing=2;ou="手气一般般。";
                    }else if(total<22000){
                        xing=3;ou="运气还可以。";
                    }else if(total<24000){
                        xing=4;ou="真是欧气满满！";
                    }else{
                        xing=5;ou="简直是欧皇本皇！";
                    }

                    int nishu=spCard.getInt("chunjuan",-1)+spCard.getInt("huangjie",-1)+
                            spCard.getInt("jiajia",-1)+spCard.getInt("miaomiao",-1)+
                            spCard.getInt("xuanxuan",-1);
                    int zhengshu=spCard.getInt("haohao",-1)+spCard.getInt("haoge",-1)
                            +spCard.getInt("xiaojiasiting",-1);

                    double ncj=spCard.getInt("chunjuan",-1)*1.0/CardSet.NUMCHUN;
                    double haohao=spCard.getInt("haohao",-1)*1.0/CardSet.NUMHH;
                    double haoge=spCard.getInt("haoge",-1)*1.0/CardSet.NUMHG;
                    double huangjie=spCard.getInt("huangjie",-1)*1.0/CardSet.NUMHJ;
                    double jiajia=spCard.getInt("jiajia",-1)*1.0/CardSet.NUMJJ;
                    double miaomiao=spCard.getInt("miaomiao",-1)*1.0/CardSet.NUMMM;
                    double xuanxuan=spCard.getInt("xuanxuan",-1)*1.0/CardSet.NUMXX;
                    double min=ncj;String x="春卷";
                    double max=ncj;String d="春卷";
                    if(haohao<min){
                        x="昊昊";
                        min=haohao;
                    }else if(haohao>max){
                        d="昊昊";
                        max=haohao;
                    }
                    if(haoge<min){
                        x="昊哥";
                        min=haoge;
                    }else if(haoge>max){
                        d="昊哥";
                        max=haohao;
                    }
                    if(huangjie<min){
                        x="黄姐";
                        min=huangjie;
                    }else if(huangjie>max){
                        d="黄姐";
                        max=huangjie;
                    }
                    if(jiajia<min){
                        x="佳佳";
                        min=jiajia;
                    }else if(jiajia>max){
                        d="佳佳";
                        max=jiajia;
                    }
                    if(miaomiao<min){
                        x="妙妙";
                        min=miaomiao;
                    }else if(miaomiao>max){
                        d="妙妙";
                        max=miaomiao;
                    }

                    if(xuanxuan<min){
                        x="萱萱";
                        min=xuanxuan;
                    }else if(xuanxuan>max){
                        d="萱萱";
                        max=xuanxuan;
                    }





                    String yi="抽卡结束！本轮抽卡也是一次你和HMH48的缘分测试，来看看游戏分析吧~\n\n在本轮游戏" +
                            "中，你达成了:\n"+chengjiu+"等成就，收获到了HMH48各个成员满满的爱(〃∀〃)\n\n" +
                            "你共获得"+nssr+"张SSR卡，"+nsr+"张SR卡,"+nr+"张R卡，根据权重计算欧气值为"+total+"，欧气指数为"+xing+"星（5星满星），"+ou+"\n\n根据抽卡结果分析，在HMH48中你和"+d+
                            "缘分最深,"+d+"是你上天注定的爱豆 ヽ✿゜▽゜)ノ\n\n你和"+x+"最没缘分，你和"+x+"的故事是你偏要勉强 T^T \n\n" ;

                    if(nishu>40){
                         yi+="另外，恭喜你触发了“泥塑之光”隐藏属性！，命中注定你要做HMH的泥塑粉\n\n";

                    }
                    if(zhengshu>27) {
                        yi += "另外，恭喜你触发了“整肃扛把子”隐藏属性！，命中注定你要做HMH的整肃粉\n\n";
                    }
                    if(nishu<=40&&zhengshu<=27){
                        yi+="你没有触发隐藏属性，要不要再试试？\n\n";
                    }


                    yi+="本轮游戏结束，想再试一次可前往<重新开始>界面";









                    builder.setMessage(yi);
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
//                    Log.d("chengjiu","------------------------运气："+total);
//                    Log.d("chengjiu","泥塑："+nishu+" 整肃："+zhengshu);
                }
            }
        });

    }


    private void setchengjiu(Chengjiuitem cj){
//        Log.d("chengjiu","------------------ "+cj.title);
        CardSet cs=new CardSet();
        cs.initial();
        int mtime=0;
        ArrayList<Card> lei=cs.select(cj.fenlei);
        boolean dacheng=false;
        if(money!=0){
        for(Card c:lei){
            boolean get=spCard.getBoolean(c.name,false);
//            Log.d("chengjiu_nei",c.name+" "+get);
            if(get){
                mtime=mtime+1;
            }
            if(mtime>=cj.time){
                dacheng=true;
                break;
            }
        }
        }
        else{
            for(Card c:lei){
                boolean get=spCard.getBoolean(c.name,false);
//            Log.d("chengjiu_nei",c.name+" "+get);
                if(get){
                    mtime=mtime+1;
                }
                if(mtime>=cj.time){
                    dacheng=true;
                }
            }
            editorCard.putInt(cj.fenlei,mtime);
            editorCard.commit();



        }
//        Log.d("chengjiu_wai","-------zuizhong"+dacheng);
        if(dacheng){
            editordacheng.putBoolean(cj.title,true);
            editordacheng.commit();
//            boolean you=spdacheng.getBoolean(cj.id,false);
//            Log.d("chengjiu","cecshi"+you);
        }


    }



}
