package com.example.khanhduy.a3.fragments.tabs;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.khanhduy.a3.R;

public class fragment_danhmuc extends Fragment {
    //khai báo biến
    private ListView lv1;
    private Button huy;
    private Context mainactivity;
    private static String [] a1 = {"Sang trọng","Buffet","Nhà hàng","Ăn vặt/Vỉa hè","Ăn chay","Cafe/Desert","Quán ăn","Bar/Pub","Quán nhậu","Beer club","Tiêm bánh","Tiệc tận nơi","shop Online","Giao cơm văn phòng","Khu ẩm thực"};
    private static int [] prgmImages={R.drawable.home_ic_filter_latest_act,R.drawable.home_ic_filter_most_near,
            R.drawable.home_ic_filter_top_of_week,R.drawable.home_ic_filter_tourist,
            R.drawable.home_ic_filter_ecard,R.drawable.home_ic_filter_most_reservation,
            R.drawable.home_ic_filter_bankcard,R.drawable.home_ic_delivery,
            R.drawable.home_ic_filter_latest_act,R.drawable.home_ic_filter_most_near,
            R.drawable.home_ic_filter_top_of_week,R.drawable.home_ic_filter_tourist,
            R.drawable.home_ic_filter_ecard,R.drawable.home_ic_filter_most_reservation,
            R.drawable.home_ic_filter_bankcard};
    Ondatadanhmuclistener mylistener;
    //làm cho hàm onAttachToParentFragment thành phương thức
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onAttachToParentFragment(getParentFragment());
    }

    //bắt lỗi truyền vào
    public void onAttachToParentFragment(Fragment fragment)
    {
        try
        {
            mylistener = (Ondatadanhmuclistener)fragment;

        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(
                    fragment.toString() + " must implement OnPlayerSelectionSetListener");
        }
    }
    //khai báo interface
    public interface Ondatadanhmuclistener
    {
        public void onDanhMucSelectionSet(String text, int tab, int selected);
    }
    //hiển thị ra khung nhìn
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_danhmuc, container, false);
        //ánh xạ các biến
        lv1=(ListView) v.findViewById(R.id.lv2);
        huy=(Button)v.findViewById(R.id.huy);
        //truyền data vào list
        lv1.setAdapter(new CustomAdapterlv2(mainactivity, a1 ,prgmImages));
        //sự kiện click itemlistview
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mylistener.onDanhMucSelectionSet(a1[i],1,i);
                ((fragment_odau)getParentFragment()) .getActivity().onBackPressed();
            }
        });
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof TabActivity_1){
            this.mainactivity = (TabActivity_1) context;
        }
    }

}
