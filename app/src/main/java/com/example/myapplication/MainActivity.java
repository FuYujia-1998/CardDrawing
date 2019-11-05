package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {
    private Button suoyoukapai;
    private Button chongxin;
    private Button chouka;
    private Button youxishuoming;
    private Button chengjiu;
    private SharedPreferences spCard,spMoney,spChengjiu;
    private SharedPreferences.Editor editorC,editorCh,editorM;
    private ProgressBar pb_main_download;//进度条
    private  AlertDialog.Builder builder,builder1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(this);
        builder1 = new AlertDialog.Builder(this);
        suoyoukapai=findViewById(R.id.button5);
        chongxin=findViewById(R.id.button6);
        chouka=findViewById(R.id.button4);
        youxishuoming=findViewById(R.id.youxishuoming);
        chengjiu=findViewById(R.id.m_chengjiu);
        pb_main_download=findViewById(R.id.pb_main_download);
        pb_main_download.setVisibility(View.GONE);




        suoyoukapai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb_main_download.setVisibility(View.VISIBLE);
                Intent intent= new Intent(MainActivity.this,guancangxuanze.class);
                startActivity(intent);
            }
        });

        chongxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("此选项将清空已抽卡牌，确定重新开始游戏？");

                builder.setPositiveButton(
                        "确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                spCard=getSharedPreferences("gotcard",MODE_PRIVATE);
                                editorC=spCard.edit();
                                editorC.clear();
                                editorC.commit();
                                spMoney=getSharedPreferences("money",MODE_PRIVATE);
                                editorM=spMoney.edit();
                                editorM.clear();
                                editorM.commit();
                                spChengjiu=getSharedPreferences("chengjiu",MODE_PRIVATE);
                                editorCh=spChengjiu.edit();
                                editorCh.clear();
                                editorCh.commit();

                                dialog.dismiss();
                            }

                        }

                        );
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        chouka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb_main_download.setVisibility(View.VISIBLE);
                Intent intent= new Intent(MainActivity.this,choukaActivity.class);
                startActivity(intent);
            }
        });

        youxishuoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder1.setMessage("本抽卡游戏初始金币设置为1000，收集各个成员卡牌达到一定数量可达成相应成就，解锁惊喜卡牌。抽完所有金币后，可查看" +
                        "结果分析，找到和你最有缘分的pick，还可解锁隐藏属性。金币抽空后可点击重新开始，卡牌清空，金币恢复，再次进行抽卡解锁更多成就。\n\n"+"卡面图片来源于各大图站，如有侵权请联系作者删除。\n \n卡牌等级计算方法：来源套图转发3000以上为SR；转发4000以上为SSR。\n " +
                        "\n抽卡概率：SSR概率"+CardSet.pro_ssr+"；SR概率"+CardSet.pro_sr+"；R概率 "+CardSet.pro_r+"\n\n因时间精力问题没有录入所有成员，非常抱歉。人格分类" +
                        "均为个人观点，如有意见不同之处请轻喷_(:_」∠)_\n\nHMH真的有很多好看的图，精心挑选了，做这个app也算是一个美图记录，希望大家看得养眼~感谢各个图站，感谢HMH48，感谢优秀会玩的nana，当然最重要的是感谢@jjjustin0219，谢谢你" +
                        "有这么多属性，帅气的，装逼的，可爱的，漂亮的，喜欢每个你：）\n\n作者新浪微博：@好萌好可爱hh" );
                builder1.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog1 = builder1.create();
                dialog1.show();
            }
        });

        chengjiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb_main_download.setVisibility(View.VISIBLE);
                Intent intent= new Intent(MainActivity.this,chengjiu.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        pb_main_download.setVisibility(View.GONE);

    }
}
