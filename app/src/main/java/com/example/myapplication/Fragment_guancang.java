package com.example.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.Serializable;
import java.util.ArrayList;


public class Fragment_guancang extends Fragment {



    private ArrayList<Card> cardset;
    private GridView gv;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;




    public Fragment_guancang(){

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_guancang, container, false);
        gv=view.findViewById(R.id.gridView);
        sp=gv.getContext().getSharedPreferences("gotcard",gv.getContext().MODE_PRIVATE);
        editor=sp.edit();
        Bundle bundle =this.getArguments();
        Serializable s = bundle.getSerializable("data");
        cardset= (ArrayList<Card>) s;
        GvAdapter gvAdapter=new GvAdapter(gv.getContext(),cardset);
        gv.setAdapter(gvAdapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int picture=cardset.get(position).picture;
                String name=cardset.get(position).name;
                boolean got=sp.getBoolean(name,false);
                if(got) {
                    Intent intent = new Intent(getActivity(), cardShowActivity.class);
                    intent.putExtra("picture", picture);
                    intent.putExtra("type", 1);
                    startActivity(intent);
                }else{
                    Toast toast =Toast.makeText(getActivity(),"还未获得卡牌，无法查看大图",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        }
        );
        return view;
    }






}
