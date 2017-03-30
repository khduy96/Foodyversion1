package com.example.khanhduy.a3.fragments.tabs;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.khanhduy.a3.R;
import com.example.khanhduy.a3.fragments.tabs.data.SqlLiteDbHelper;
import com.example.khanhduy.a3.fragments.tabs.data.quanhuyen;

import java.util.List;

public class fragment_diadiem extends Fragment {
    //khai báo biến
    private ListView lv1;
    private Button huy;
    private Context mainactivity;
    private Button btn;
    private TextView TT;
    private TabActivity_1 tinh;
    SqlLiteDbHelper dbHelper;
    String mywebsite;
    //phương thức để hiển thị ra khung nhìn
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_diadiem, container, false);
        //ánh xạ các biến
        btn=(Button)v.findViewById(R.id.btnheader);
        TT=(TextView)v.findViewById(R.id.textheader);
        huy=(Button)v.findViewById(R.id.huy);
        lv1=(ListView) v.findViewById(R.id.lv3);
        //sự kiện button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diadiem = new Intent(mainactivity, diadiem.class);
                startActivityForResult(diadiem, 1);
            }
        });
        //truyền dữ liệu từ database vào listview
        dbHelper = new SqlLiteDbHelper(mainactivity);
        dbHelper.openDataBase();
        List<quanhuyen> tinhthanh;
        tinhthanh = dbHelper.getquanhuyen();
        lv1.setAdapter(new CustomAdapter(mainactivity, tinhthanh));
        //sự kiện button
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((fragment_odau)getParentFragment()) .getActivity().onBackPressed();
            }
        });
        ((MainActivity)getActivity().getParent()).disable();
        return v;
    }
    //nhận biến từ activity
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            mywebsite = data.getStringExtra("thanhpho");
            TT.setText(mywebsite );
        }
    }
    //mainactivity có phương thúc của cha
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof TabActivity_1){
            this.mainactivity = (TabActivity_1) context;
        }
    }
}
