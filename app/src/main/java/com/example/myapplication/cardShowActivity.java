package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public class cardShowActivity extends AppCompatActivity {
    private ImageView picture;
    private ImageView bg;
    private int type;
    private ArrayList<Card> adressten;
    private int t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_show);
        picture=findViewById(R.id.cardshow_picture);
        bg=findViewById(R.id.cardshow_bg);
        t=1;
       Intent intent = getIntent();
        type =intent.getIntExtra("type",1);
        if (type == 1) {
           int adress = intent.getIntExtra("picture", R.drawable.biaoti);
            picture.setImageResource(adress);
        }
       else if(type==10){
            Bundle bundle = getIntent().getExtras();
            Serializable s = bundle.getSerializable("picture10");
            adressten= (ArrayList<Card>) s;
            Card c = adressten.get(0);
            picture.setImageResource(c.picture);
        }



    }
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:


                break;
            case MotionEvent.ACTION_MOVE:
                //移动

                break;
            case MotionEvent.ACTION_UP:
                //松开
                if(type==1){
                    finish();
                }else{
                    if(t<10) {
                        Card c = adressten.get(t);
                        picture.setImageResource(c.picture);
                        t=t+1;
                    }else{
                        finish();
                    }
                }

                break;
        }

        return super.onTouchEvent(event);
    }



}
