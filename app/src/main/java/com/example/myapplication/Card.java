package com.example.myapplication;

import java.io.Serializable;

public class Card implements Serializable {
    public String charactor;
    public String dengji;
    public String name;
    public int picture;


    public Card(String charactor, String dengji,String name,int picture){
        this.charactor=charactor;
        this.dengji=dengji;
        this.name=name;
        this.picture=picture;

    }

}
