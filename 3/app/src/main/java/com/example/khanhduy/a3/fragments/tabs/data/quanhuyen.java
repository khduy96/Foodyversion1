package com.example.khanhduy.a3.fragments.tabs.data;
public class quanhuyen {
    //khai báo cấu trúc quanhuyen
    public int id;
    public String name;
    //get giá trị của từng biến thành phần
    public int getid() {
        return this.id;
    }
    public String getname() {return this.name;}
    //set giá trị của từng biến thành phần
    public void setname(String ID) {this.name = ID;}
    public void setid(int ID) {this.id = ID;}
    // set giá trị của cấu trúc quanhuyen
    public quanhuyen(int a,String b){
        this.id = a;
        this.name = b;
    }
}
