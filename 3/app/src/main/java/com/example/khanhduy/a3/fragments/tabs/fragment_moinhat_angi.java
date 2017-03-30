package com.example.khanhduy.a3.fragments.tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.khanhduy.a3.R;


public class fragment_moinhat_angi extends Fragment {
    //khai báo biến
    private ListView lv1;
    private Button huy;
    private Context mainactivity;
    private static String [] a1 = {"Mới nhất","Gần tôi","Phổ biến","Du khách","Ưu dãi E-card","Đặt chỗ","Ư đãi thẻ","Đặt giao hàng"};
    private static int [] prgmImages={R.drawable.home_ic_filter_latest_act,R.drawable.home_ic_filter_most_near,
            R.drawable.home_ic_filter_top_of_week,R.drawable.home_ic_filter_tourist,
            R.drawable.home_ic_filter_ecard,R.drawable.home_ic_filter_most_reservation,
            R.drawable.home_ic_filter_bankcard,R.drawable.home_ic_delivery};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment_moinhat, container, false);
        //ánh xạ các biến
        lv1=(ListView) v.findViewById(R.id.lv1);
        huy=(Button)v.findViewById(R.id.huy);
        //truyền data cho lixtview
        lv1.setAdapter(new CustomAdapterlv1(mainactivity, a1 ,prgmImages));
        //sự kiện button
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
