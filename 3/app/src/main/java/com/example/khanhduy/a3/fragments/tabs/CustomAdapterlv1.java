package com.example.khanhduy.a3.fragments.tabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khanhduy.a3.R;

public class CustomAdapterlv1 extends BaseAdapter{
    //khai báo biến
    String [] result;
    Context context;
    int [] imageId;
    //tham chiếu đến đối tượng lớp cha gần nhất
    private static LayoutInflater inflater=null;
    public CustomAdapterlv1(Context context1, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=context1;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //lấy size của list truyền vào
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
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
        TextView tv;
        ImageView img;
    }
    //phương thức để hiển thị khung nhìn
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.customv1, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        /*rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });*/
        return rowView;
    }
}