package com.example.khanhduy.a3.fragments.tabs;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.khanhduy.a3.R;

public class CustomAdaptergv_header extends BaseAdapter{
    //khai báo biến
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;
    //tham chiếu đến đối tượng lớp cha gần nhất
    public CustomAdaptergv_header(Context c,String[] web,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }
    //lấy size của list truyền vào
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    //phương thức để hiển thị khung nhìn
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.custom_gv_headre, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_item_label);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_item_image);
            textView.setText(web[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}