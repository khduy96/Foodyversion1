package com.example.khanhduy.a3.fragments.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.khanhduy.a3.R;
import com.example.khanhduy.a3.fragments.tabs.data.SqlLiteDbHelper;

import java.util.List;

public class diadiem extends AppCompatActivity {
    //khai báo biến
    SqlLiteDbHelper dbHelper;
    ListView lv;
    List<String> vietnam;
    //phương thức để hiển thị khung nhìn
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diadiem);
        //anh xạ các biến
        lv=(ListView)findViewById(R.id.lvtinhthanh);
        //khai báo biến
        dbHelper = new SqlLiteDbHelper(this);
        //mở database
        dbHelper.openDataBase();
        //lấy dữ liệu
        vietnam = dbHelper.gettinhthanh();
        //bỏ dữ liệu vào listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,vietnam);
        lv.setAdapter(adapter);
        //truyền dữ liệu sang activity gọi activity này
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=getIntent();
                intent.putExtra("thanhpho", vietnam.get(i));
                setResult(1, intent);
                finish();
            }
        });
    }
}
