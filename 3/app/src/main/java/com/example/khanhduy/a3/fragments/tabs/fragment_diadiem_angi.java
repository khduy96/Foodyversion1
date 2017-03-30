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

import com.example.khanhduy.a3.R;
import com.example.khanhduy.a3.fragments.tabs.data.SqlLiteDbHelper;
import com.example.khanhduy.a3.fragments.tabs.data.quanhuyen;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_diadiem_angi extends Fragment {
    //khai báo biến
    private ListView lv1;
    private Button huy;
    private Context mainactivity;
    private Button btn;
    SqlLiteDbHelper dbHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_diadiem, container, false);
        //anh xạ các biến
        btn=(Button)v.findViewById(R.id.btnheader);
        huy=(Button)v.findViewById(R.id.huy);
        lv1=(ListView) v.findViewById(R.id.lv3);
        //truyền dữ liệu từ database vào listview
        dbHelper = new SqlLiteDbHelper(mainactivity);
        dbHelper.openDataBase();
        List<quanhuyen> tinhthanh;
        tinhthanh = dbHelper.getquanhuyen();
        lv1.setAdapter(new CustomAdapter(mainactivity, tinhthanh));
        //sụ kiện button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainactivity, diadiem.class);
                startActivity(intent);
            }
        });
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((fragment_angi)getParentFragment()) .getActivity().onBackPressed();
            }
        });
        ((MainActivity)getActivity().getParent()).disable();
        return v;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof TabActivity_1){
            this.mainactivity = (TabActivity_1) context;
        }
    }
}
