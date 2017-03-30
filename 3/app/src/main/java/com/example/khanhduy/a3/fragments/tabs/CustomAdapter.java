package com.example.khanhduy.a3.fragments.tabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khanhduy.a3.R;
import com.example.khanhduy.a3.fragments.tabs.data.SqlLiteDbHelper;
import com.example.khanhduy.a3.fragments.tabs.data.quanhuyen;

import java.util.List;

public class CustomAdapter extends BaseAdapter{
    //khai báo biến
    private List<quanhuyen> result;
    private Context context;
    SqlLiteDbHelper dbHelper;
    private static LayoutInflater inflater=null;
    //tham chiếu đến đối tượng lớp cha gần nhất
    public CustomAdapter(Context context1, List<quanhuyen> prgmNameList) {
        // TODO Auto-generated constructor stub
        this.result=prgmNameList;
        this.context=context1;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //lấy size của list truyền vào
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.size();
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
    //tạo kiểu cấu trúc
    public class Holder
    {
        TextView tv;
        Button bnt;
        ListView lv_lv1;
    }
    //set chiều cao cho listview con
    public static void justifyListViewHeightBasedOnChildren (ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }
    //phương thức để hiển thị khung nhìn
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        //khai báo biến
        View rowView;
        //ánh xạ các biến
        rowView = inflater.inflate(R.layout.customlv3, parent, false);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.bnt=(Button) rowView.findViewById(R.id.lv_r_bnt);
        holder.lv_lv1=(ListView) rowView.findViewById(R.id.lv_lv1);
        holder.tv.setText(result.get(position).name);
        //lấy dữ liệu từ database  và ruyền nó vào listview
        dbHelper = new SqlLiteDbHelper(context);
        dbHelper.openDataBase();
        List<String> tinhthanh;
        tinhthanh = dbHelper.getphuongxa(result.get(position).id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,tinhthanh);
        holder.lv_lv1.setAdapter(adapter);
        String so=Integer.toString(tinhthanh.size());
        holder.bnt.setText(so+" phường/xã");
        //



        ///
        holder.lv_lv1.setVisibility(View.GONE );

        justifyListViewHeightBasedOnChildren(holder.lv_lv1);
        holder.bnt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.lv_lv1.setVisibility(holder.lv_lv1.isShown() ? View.GONE : View.VISIBLE);
            }
        });
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = result.get(position).name;
                Toast.makeText(context, "You Clicked "+data, Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}