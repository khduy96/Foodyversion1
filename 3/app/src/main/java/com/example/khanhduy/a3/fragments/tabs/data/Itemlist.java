package com.example.khanhduy.a3.fragments.tabs.data;
public class Itemlist {
    //khai báo cấu trúc Itemlisst
    public String Sum_rating_custom;
    public String Name_store_custom;
    public String Adress_custom;
    public byte[] Hinh_custom;
    public String Sum_comment_custom;
    //get giá trị của từng biến thành phần
    public String getSum_rating_custom() {
        return this.Sum_rating_custom;
    }
    public String getName_store_custom() {return Name_store_custom;}
    public String getAdress_custom() {
        return Adress_custom;
    }
    public byte[] getHinh_custom() {
        return Hinh_custom;
    }
    public String getSum_comment_custom() {
        return Sum_comment_custom;
    }
    //set giá trị của từng biến thành phần
    public void setSum_comment_custom(String Sum_comment) {
        this.Sum_comment_custom = Sum_comment;
    }
    public void setSum_rating_custom(String Sum_rating){this.Sum_rating_custom = Sum_rating;}
    public void setName_store_custom(String Name_store) {
        this.Name_store_custom = Name_store;
    }
    public void setAdress_custom(String Adress) {
        this.Adress_custom = Adress;
    }
    public void setHinh_custom(byte[] Hinh) {
        this.Hinh_custom = Hinh;
    }
    // set giá trị của cấu trúc Itemlist
    public Itemlist (String Sum_rating, String Name_store, String Adress,
                     byte[] Hinh,String Sum_comment){
        this.Sum_rating_custom = Sum_rating;
        this.Name_store_custom = Name_store;
        this.Adress_custom = Adress;
        this.Hinh_custom = Hinh;
        this.Sum_comment_custom = Sum_comment;
    }
    public Itemlist (){}
}