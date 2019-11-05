package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class guancangxuanze extends AppCompatActivity {
    private Button wode;
    private Button suoyou;
    private Button back;
    private ProgressBar pb_main_download;//进度条
    private CardSet cs;
    private ArrayList<Card> cs_s;
    private SharedPreferences spCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guancangxuanze);
        back=findViewById(R.id.xz_back);
        wode=findViewById(R.id.xz_wode);
        suoyou=findViewById(R.id.xz_suoyou);
        pb_main_download=findViewById(R.id.xz_pb);
        pb_main_download.setVisibility(View.GONE);
        spCard=getSharedPreferences("gotcard",MODE_PRIVATE);
        cs_s=new ArrayList<Card>();
        cs=new CardSet();
        cs.initial();//可能有问题

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        suoyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb_main_download.setVisibility(View.VISIBLE);
                cs_s=cs.getall();

                Intent intent= new Intent(guancangxuanze.this,suoyoukapaiActivity.class);
                intent.putExtra("cs", cs_s);
                startActivity(intent);
            }
        });
        wode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Card> yhd=new ArrayList<Card>();
                for(Card c:cs.allcard){
                    if(spCard.getBoolean(c.name,false)){
                        yhd.add(c);
                    }
                }
                cs_s=yhd;
                pb_main_download.setVisibility(View.VISIBLE);
                Intent intent= new Intent(guancangxuanze.this,wodekapai.class);
                intent.putExtra("cs", cs_s);
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
