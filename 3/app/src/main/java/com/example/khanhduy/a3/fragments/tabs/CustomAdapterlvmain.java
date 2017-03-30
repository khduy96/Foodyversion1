package com.example.khanhduy.a3.fragments.tabs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khanhduy.a3.R;
import com.example.khanhduy.a3.fragments.tabs.data.Itemlist;

import java.util.List;

public class CustomAdapterlvmain extends BaseAdapter {
    //khai báo biến
    Context context;
    List<Itemlist> contactList ;
    private static LayoutInflater inflater=null;
    //tham chiếu đến đối tượng lớp cha gần nhất
    public CustomAdapterlvmain(Context context1, List<Itemlist> contact) {
        // TODO Auto-generated constructor stub
        contactList=contact;
        context=context1;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //lấy size của list truyền vào
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    //khai báo kiểu Struct
    public class Holder
    {
        TextView tongrating,store,diachi,ten,diem,bl,ten1,diem1,bl1,tongbl,tonghinh;
        ImageView hinh;
    }
    //phương thức để hiển thị ra khung nhìn
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        //ánh xạ các biến
        rowView = inflater.inflate(R.layout.customlvmain, null);
        holder.tongrating=(TextView) rowView.findViewById(R.id.TV);
        holder.store=(TextView) rowView.findViewById(R.id.TV1);
        holder.diachi=(TextView) rowView.findViewById(R.id.TV2);
        holder.ten=(TextView) rowView.findViewById(R.id.TV3);
        holder.diem=(TextView) rowView.findViewById(R.id.TV4);
        holder.bl=(TextView) rowView.findViewById(R.id.TV5);
        holder.ten1=(TextView) rowView.findViewById(R.id.TV6);
        holder.diem1=(TextView) rowView.findViewById(R.id.TV7);
        holder.bl1=(TextView) rowView.findViewById(R.id.TV8);
        holder.tongbl=(TextView) rowView.findViewById(R.id.TV9);
        holder.tonghinh=(TextView) rowView.findViewById(R.id.TV10);
        holder.hinh=(ImageView) rowView.findViewById(R.id.imageView);
        //truyền bữ liệu vào
        Itemlist itemlist=contactList.get(position);
        String a=itemlist.Sum_rating_custom;
        a=a.substring(0, 3);
        holder.tongrating.setText(a);
        holder.store.setText(itemlist.Name_store_custom);
        holder.diachi.setText(itemlist.Adress_custom);
        holder.tongbl.setText(itemlist.Sum_comment_custom);
        Bitmap bmp = BitmapFactory.decodeByteArray(itemlist.Hinh_custom, 0, itemlist.Hinh_custom.length);
        // Set the Bitmap data to the ImageView
        holder.hinh.setImageBitmap(bmp);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked ", Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}
