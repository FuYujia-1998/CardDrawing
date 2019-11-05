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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class choukaActivity extends AppCompatActivity {
    private Button back;
    private Button randone;
    private Button randten;
    private TextView tv;
    private SharedPreferences spCard,spMoney;
    private SharedPreferences.Editor editorCard,editorMoney;
    private CardSet cardSet;
    private int money;
    private static final int SETMONEY=1000;
    private  AlertDialog.Builder cbuilder,cbuilder1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chouka);
        Log.d("chouka","here");
        tv=findViewById(R.id.textView4);
        cardSet=new CardSet();
        cardSet.initial();
        cbuilder = new AlertDialog.Builder(this);
        cbuilder1 = new AlertDialog.Builder(this);
        randone=findViewById(R.id.randone);
        randten=findViewById(R.id.randten);
        spCard=getSharedPreferences("gotcard",MODE_PRIVATE);
        spMoney=getSharedPreferences("money",MODE_PRIVATE);
        editorCard=spCard.edit();
        editorMoney=spMoney.edit();
        money=spMoney.getInt("money",-1);
        if(money==-1){
            editorMoney.putInt("money",SETMONEY);
            editorMoney.commit();
            money=SETMONEY;
        }
        tv.setText(money+"");
        randten=findViewById(R.id.randten);
        randone=findViewById(R.id.randone);
        back=findViewById(R.id.ck_back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        randone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money==0){
                    cbuilder.setMessage("游戏结束，请前往<我的成就>面板查看你和HMH48的缘分~");
                    cbuilder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = cbuilder.create();
                    dialog.show();
                }

                else {
                    money = money - 10;
                    if (money < 0) {
                        Toast toast = Toast.makeText(choukaActivity.this, "您的余额不足", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        money = money + 10;

                    } else {
                        Card rcone = cardSet.rand();
                        tv.setText(money + "");
                        editorMoney.putInt("money", money);
                        editorCard.putBoolean(rcone.name, true);
                        editorMoney.commit();
                        editorCard.commit();
                        Intent intent = new Intent(choukaActivity.this, cardShowActivity.class);
                        intent.putExtra("picture", rcone.picture);
                        intent.putExtra("type", 1);
                        startActivity(intent);
                    }
                }
            }
        });

        randten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(money==0){
                    cbuilder1.setMessage("游戏结束，请前往<我的成就>面板查看你和HMH48的缘分~");
                    cbuilder1.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog1 = cbuilder1.create();
                    dialog1.show();
                }
                else {

                    money = money - 90;
                    if (money < 0) {

                        Toast toast = Toast.makeText(choukaActivity.this, "您的余额不足", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        money = money + 90;

                    } else {
                        editorMoney.putInt("money", money);
                        editorMoney.commit();
                        tv.setText(money + "");
                        ArrayList<Card> rcten = cardSet.randlist(10);
                        Intent intent = new Intent(choukaActivity.this, cardShowActivity.class);
                        intent.putExtra("type", 10);
                        intent.putExtra("picture10", rcten);
                        for (Card c : rcten) {
                            editorCard.putBoolean(c.name, true);
                            editorCard.commit();
                        }
                        startActivity(intent);
                    }
                }

            }
        });


    }


}
