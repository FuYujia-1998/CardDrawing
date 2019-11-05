package com.example.myapplication;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class CardSet {
    public  static ArrayList<Card> ssr=new ArrayList<Card>();
    public  static ArrayList<Card> sr=new ArrayList<Card>();
    public  static ArrayList<Card> r=new ArrayList<Card>();
    public static final int NUMCHUN=8;
    public static final int NUMHG=17;
    public static final int NUMHH=28;
    public static final int NUMHJ=12;
    public static final int NUMJJ=29;
    public static final int NUMMM=12;
    public static final int NUMXJST=4;
    public static final int NUMXX=10;
    public static final int NUMSSR=26;
    public static final int NUMSR=27;
    public static final int NUMR=67;
    public static final double pro_ssr=0.06;
    public static final double pro_sr=0.14;
    public static final double pro_r=1-pro_sr-pro_ssr;
    public static boolean initilaized=false;
    public static ArrayList<Card> allcard=new ArrayList<Card>();


    public void add(String charactor,String dengji,String name,int picture){
        Card card=new Card(charactor,dengji,name,picture);
        if(dengji.equals("ssr")){
            ssr.add(card);
        }else if(dengji.equals("sr")){
            sr.add(card);
        }else if(dengji.equals("r")){
            r.add(card);
        }else{
            Log.d("cardset","等级设置有问题");
        }
    }

    public void initial(){//可能有问题
        if(!initilaized) {
            initilaized = true;
            this.add("chunjuan","ssr","chunjuan1",R.drawable.card_chunjuan1_ssr_jup);
            this.add("chunjuan","ssr","chunjuan2",R.drawable.card_chunjuan2_ssr_jup);
            this.add("chunjuan","ssr","chunjuan4",R.drawable.card_chunjuan4_ssr_fo);
            this.add("chunjuan","r","chunjuan5",R.drawable.card_chunjuan5_r_fo);
            this.add("chunjuan","r","chunjuan6",R.drawable.card_chunjuan6_r_fo);
            this.add("chunjuan","ssr","chunjuan7",R.drawable.card_chunjuan7_ssr_ha);
            this.add("chunjuan","sr","chunjuan8",R.drawable.card_chunjuan8_sr_ka);
            this.add("chunjuan","sr","chunjuan9",R.drawable.card_chunjuan9_sr_mar);
            this.add("haoge", "sr", "haoge1", R.drawable.card_haoge1_sr_jup);
            this.add("haoge", "r", "haoge2", R.drawable.card_haoge2_r_jup);
            this.add("haoge", "sr", "haoge3", R.drawable.card_haoge3_sr_ka);
            this.add("haoge", "r", "haoge4", R.drawable.card_haoge4_r_jup);
            this.add("haoge", "r", "haoge2", R.drawable.card_haoge5_r_jup);
            this.add("haoge", "r", "haoge6", R.drawable.card_haoge6_r_jup);
            this.add("haoge", "r", "haoge7", R.drawable.card_haoge7_r_chocolateshot);
            this.add("haoge", "r", "haoge8", R.drawable.card_haoge8_r_cos);
            this.add("haoge", "r", "haoge9", R.drawable.card_haoge9_r_cos);
            this.add("haoge", "r", "haoge10", R.drawable.card_haoge10_r_cos);
            this.add("haoge", "ssr", "haoge11", R.drawable.card_haoge11_ssr_cos);
            this.add("haoge", "r", "haoge12", R.drawable.card_haoge12_r_ha);
            this.add("haoge", "r", "haoge13", R.drawable.card_haoge13_r_ha);
            this.add("haoge", "sr", "haoge14", R.drawable.card_haoge14_sr_ka);
            this.add("haoge", "r", "haoge15", R.drawable.card_haoge15_r_ka);
            this.add("haoge", "r", "haoge16", R.drawable.card_haoge16_r_mar);
            this.add("haoge", "r", "haoge17", R.drawable.card_haoge17_r_jup);
            this.add("haohao", "ssr", "haohao1", R.drawable.card_haohao1_ssr_jup);
            this.add("haohao", "ssr", "haohao2", R.drawable.card_haohao2_ssr_ka);
            this.add("haohao", "ssr", "haohao3", R.drawable.card_haohao3_ssr_jup);
            this.add("haohao", "sr", "haohao4", R.drawable.card_haohao4_sr_fo);
            this.add("haohao", "r", "haohao5", R.drawable.card_haohao5_r_jup);
            this.add("haohao", "r", "haohao6", R.drawable.card_haohao6_r_jup);
            this.add("haohao", "ssr", "haohao7", R.drawable.card_haohao7_ssr_jup);
            this.add("haohao", "r", "haohao9", R.drawable.card_haohao9_r_ha);
            this.add("haohao", "r", "haohao10", R.drawable.card_haohao10_r_jup);
            this.add("haohao", "ssr", "haohao13", R.drawable.card_haohao13_ssr_jup);
            this.add("haohao", "ssr", "haohao14", R.drawable.card_haohao14_ssr_jup);
            this.add("haohao", "r", "haohao16", R.drawable.card_haohao16_r_ace);
            this.add("haohao", "r", "haohao17", R.drawable.card_haohao17_r_ast);
            this.add("haohao", "r", "haohao18", R.drawable.card_haohao18_r_coastline);
            this.add("haohao", "r", "haohao20", R.drawable.card_haohao20_r_coastline);
            this.add("haohao", "r", "haohao22", R.drawable.card_haohao22_r_cos);
            this.add("haohao", "r", "haohao23", R.drawable.card_haohao23_r_cos);
            this.add("haohao", "r", "haohao24", R.drawable.card_haohao24_r_fo);
            this.add("haohao", "sr", "haohao25", R.drawable.card_haohao25_sr_ha);
            this.add("haohao", "sr", "haohao26", R.drawable.card_haohao26_sr_ha);
            this.add("haohao", "sr", "haohao27", R.drawable.card_haohao27_sr_ha);
            this.add("haohao", "sr", "haohao28", R.drawable.card_haohao28_sr_ha);
            this.add("haohao", "sr", "haohao29", R.drawable.card_haohao29_sr_ha);
            this.add("haohao", "ssr", "haohao30", R.drawable.card_haohao30_ssr_ha);
            this.add("haohao", "ssr", "haohao31", R.drawable.card_haohao31_ssr_ka);
            this.add("haohao", "ssr", "haohao32", R.drawable.card_haohao32_ssr_ka);
            this.add("haohao", "r", "haohao33", R.drawable.card_haohao33_r_ka);
            this.add("haohao", "r", "haohao34", R.drawable.card_haohao34_r_mar);
            this.add("huangjie", "r", "huangjie2", R.drawable.card_huangjie2_r_jup);
            this.add("huangjie", "r", "huangjie4", R.drawable.card_huangjie4_r_jup);
            this.add("huangjie", "r", "huangjie5", R.drawable.card_huangjie5_r_jup);
            this.add("huangjie", "ssr", "huangjie6", R.drawable.card_huangjie6_ssr_ke);
            this.add("huangjie", "sr", "huangjie7", R.drawable.card_huangjie7_sr_jup);
            this.add("huangjie", "sr", "huangjie9", R.drawable.card_huangjie9_sr_ke);
            this.add("huangjie", "sr", "huangjie10", R.drawable.card_huangjie10_sr_ke);
            this.add("huangjie", "r", "huangjie12", R.drawable.card_huangjie12_r_chocolateshot);
            this.add("huangjie", "sr", "huangjie13", R.drawable.card_huangjie13_sr_ha);
            this.add("huangjie", "r", "huangjie14", R.drawable.card_huangjie14_r_ha);
            this.add("huangjie", "r", "huangjie15", R.drawable.card_huangjie15_r_ha);
            this.add("huangjie", "r", "huangjie16", R.drawable.card_huangjie16_r_mar);
            this.add("jiajia", "ssr", "jiajia1", R.drawable.card_jiajia1_ssr_jup);
            this.add("jiajia", "ssr", "jiajia2", R.drawable.card_jiajia2_ssr_jup);
            this.add("jiajia", "r", "jiajia3", R.drawable.card_jiajia3_r_jup);
            this.add("jiajia", "r", "jiajia4", R.drawable.card_jiajia4_r_contrail);
            this.add("jiajia", "ssr", "jiajia5", R.drawable.card_jiajia5_ssr_jup);
            this.add("jiajia", "sr", "jiajia7", R.drawable.card_jiajia7_sr_jup);
            this.add("jiajia", "r", "jiajia8", R.drawable.card_jiajia8_r_jup);
            this.add("jiajia", "r", "jiajia9", R.drawable.card_jiajia9_r_coas);
            this.add("jiajia", "r", "jiajia10", R.drawable.card_jiajia10_r_coas);
            this.add("jiajia", "r", "jiajia11", R.drawable.card_jiajia11_r_bloossomtryst_0219);
            this.add("jiajia", "r", "jiajia12", R.drawable.card_jiajia12_r_bloossomtryst_0219);
            this.add("jiajia", "r", "jiajia13", R.drawable.card_jiajia13_r_cas);
            this.add("jiajia", "r", "jiajia14", R.drawable.card_jiajia14_r_cas);
            this.add("jiajia", "sr", "jiajia15", R.drawable.card_jiajia15_sr_jcos);
            this.add("jiajia", "sr", "jiajia16", R.drawable.card_jiajia16_sr_contrail);
            this.add("jiajia", "r", "jiajia17", R.drawable.card_jiajia17_r_fo);
            this.add("jiajia", "sr", "jiajia18", R.drawable.card_jiajia18_sr_ha);
            this.add("jiajia", "sr", "jiajia19", R.drawable.card_jiajia19_sr_ha);
            this.add("jiajia", "sr", "jiajia20", R.drawable.card_jiajia20_sr_ha);
            this.add("jiajia", "r", "jiajia24", R.drawable.card_jiajia24_r_ka);
            this.add("jiajia", "r", "jiajia25", R.drawable.card_jiajia25_r_mar);
            this.add("jiajia", "ssr", "jiajia27", R.drawable.card_jiajia27_ssr_mar);
            this.add("jiajia", "r", "jiajia29", R.drawable.card_jiajia29_r_keaiduo);
            this.add("jiajia", "r", "jiajia30", R.drawable.card_jiajia30_r_puber);
            this.add("jiajia", "r", "jiajia31", R.drawable.card_jiajia31_r_selectletter);
            this.add("jiajia", "r", "jiajia32", R.drawable.card_jiajia32_r_selectletter);
            this.add("jiajia", "r", "jiajia33", R.drawable.card_jiajia33_r_selectletter);
            this.add("jiajia", "r", "jiajia34", R.drawable.card_jiajia34_r_selectletter);
            this.add("jiajia", "r", "jiajia35", R.drawable.card_jiajia35_r_selectletter);
            this.add("miaomiao","sr","miaomiao1",R.drawable.card_miaomiao1_sr_jup);
            this.add("miaomiao","r","miaomiao13",R.drawable.card_miaomiao13_r_fo);
            this.add("miaomiao","r","miaomiao15",R.drawable.card_miaomiao15_r_ha);
            this.add("miaomiao","r","miaomiao16",R.drawable.card_miaomiao16_r_ha);
            this.add("miaomiao","sr","miaomiao17",R.drawable.card_miaomiao17_sr_lo);
            this.add("miaomiao","r","miaomiao19",R.drawable.card_miaomiao19_r_ke);
            this.add("miaomiao","ssr","miaomiao21",R.drawable.card_miaomiao21_ssr_ke);
            this.add("miaomiao","sr","miaomiao22",R.drawable.card_miaomiao22_sr_mar);
            this.add("miaomiao","ssr","miaomiao24",R.drawable.card_miaomiao24_ssr_puberty);
            this.add("miaomiao","r","miaomiao25",R.drawable.card_miaomiao25_r_puberty);
            this.add("miaomiao","r","miaomiao26",R.drawable.card_miaomiao26_r_puberty);
            this.add("miaomiao","sr","miaomiao27",R.drawable.card_miaomiao27_sr_puberty);
            this.add("xiaojiasiting","ssr","xiaojiasiting1",R.drawable.card_xiaojiasiting1_ssr_jup);
            this.add("xiaojiasiting","ssr","xiaojiasiting2",R.drawable.card_xiaojiasiting2_ssr_jup);
            this.add("xiaojiasiting","ssr","xiaojiasiting4",R.drawable.card_xiaojiasiting4_ssr_lovletter);
            this.add("xiaojiasiting","sr","xiaojiasiting6",R.drawable.card_xiaojiasiting6_sr_lovletter);
            this.add("xuanxuan","r","xuanxuan4",R.drawable.card_xuanxuan4_r_jup);
            this.add("xuanxuan","sr","xuanxuan5",R.drawable.card_xuanxuan5_sr_jup);
            this.add("xuanxuan","ssr","xuanxuan6",R.drawable.card_xuanxuan6_ssr_ace);
            this.add("xuanxuan","ssr","xuanxuan7",R.drawable.card_xuanxuan7_ssr_cos);
            this.add("xuanxuan","r","xuanxuan8",R.drawable.card_xuanxuan8_r_fo);
            this.add("xuanxuan","r","xuanxuan9",R.drawable.card_xuanxuan9_r_fo);
            this.add("xuanxuan","r","xuanxuan11",R.drawable.card_xuanxuan11_r_ha);
            this.add("xuanxuan","r","xuanxuan14",R.drawable.card_xuanxuan14_r_ka);
            this.add("xuanxuan","r","xuanxuan15",R.drawable.card_xuanxuan15_r_mar);
            this.add("xuanxuan","r","xuanxuan19",R.drawable.card_xuanxuan19_r_puberty);
            allcard=this.all();
        }
    }



    public ArrayList<Card> rand_dengji(){
        Random rd=new Random();
        double d=rd.nextDouble();
        if(d<pro_ssr)return ssr;
        else if(d>pro_ssr+pro_sr)return r;
        else return sr;
    }

    public Card rand(){
        ArrayList<Card> mcs=this.rand_dengji();
        int l=mcs.size();
        Random rd=new Random();
        int i=rd.nextInt(l);
        return mcs.get(i);
    }

    public ArrayList<Card> randlist(int t){
        ArrayList<Card> rcs=new ArrayList<Card>();
        for(int i=0;i<t;i++){
            rcs.add(this.rand());
        }
        return rcs;
    }
    public ArrayList<Card> all(){
        ArrayList<Card> cs_all=new ArrayList<Card>();
        if(ssr!=null){ cs_all.addAll(ssr);}
        if(sr!=null){ cs_all.addAll(sr);}
        if(r!=null){ cs_all.addAll(r);}
        return cs_all;
    }

    public ArrayList<Card> select(String character){
        if(character.equals("ssr"))return getSsr();
        else if(character.equals("sr"))return getSr();
        else if(character.equals("r"))return getR();
        else {
            ArrayList<Card> cs = new ArrayList<Card>();
            for (Card c : this.allcard) {
                if (c.charactor.equals(character)) {
                    cs.add(c);
                }
            }
            return cs;
        }
    }

    public static ArrayList<Card> staselect(ArrayList<Card> precs,String character){
        if(character.equals("ssr")||character.equals("sr")||character.equals("r")){
            ArrayList<Card> cs = new ArrayList<Card>();
            for (Card c : precs) {
                if (c.dengji.equals(character)) {
                    cs.add(c);
                }
            }
            return cs;
        }
        else {
            ArrayList<Card> cs = new ArrayList<Card>();
            for (Card c : precs) {
                if (c.charactor.equals(character)) {
                    cs.add(c);
                }
            }
            return cs;
        }
    }

    public ArrayList<Card> getSsr(){
        ArrayList<Card> getssr=new ArrayList<Card>();
        getssr.addAll(ssr);
        return getssr;
    }

    public ArrayList<Card> getSr(){
        ArrayList<Card> getsr=new ArrayList<Card>();
        getsr.addAll(sr);
        return getsr;
    }

    public ArrayList<Card> getR(){
        ArrayList<Card> getr=new ArrayList<Card>();
        getr.addAll(r);
        return getr;
    }

    public ArrayList<Card> getall(){
        ArrayList<Card> getall=new ArrayList<Card>();
        getall.addAll(allcard);
        return getall;
    }

}
