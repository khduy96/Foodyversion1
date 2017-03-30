package com.example.khanhduy.a3.fragments.tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.example.khanhduy.a3.R;
import com.example.khanhduy.a3.fragments.tabs.data.SqlLiteDbHelper;

public class fragment_angi extends Fragment {
    SqlLiteDbHelper dbHelper;
    private GridView lv1;
    private Button bt1,bt2,bt3;
    private static int glaf=0,glaf1=0,glaf2=0,co=0;
    private Context mainactivity;
    GridView grid;
    private String[] web = {
            "Gần tôi",
            "Coupon",
            "Đặt chỗ ưu đãi",
            "Đặt giao hàng",
            "E-card",
            "Game & Fun",
            "Bình luận",
            "Blogs",
            "Top thành viên",
            "Video",
    } ;
    private int[] imageId = {
            R.drawable.ic_nearby,
            R.drawable.ic_ecoupon,
            R.drawable.ic_more_table,
            R.drawable.tn_ic_more_delivery,
            R.drawable.ic_ecard,
            R.drawable.ic_game,
            R.drawable.ic_icon_binhluanmoi,
            R.drawable.ic_icon_chuyende,
            R.drawable.ic_icon_topthanhvien,
            R.drawable.ic_video,
    };
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof TabActivity_1){
            this.mainactivity = (TabActivity_1) context;
        }
    }
    //phương thức để hiển thị khung nhìn
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment_angi, container, false);
        //ánh xạ các biến
        bt1 = (Button)v.findViewById(R.id.btn1);
        bt2 = (Button)v.findViewById(R.id.btn2);
        bt3 = (Button)v.findViewById(R.id.btn3);
        //sư kiên ẩn hiện các fragment khi các button được click
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt2.setBackgroundResource(R.drawable.btn_unselect);
                bt3.setBackgroundResource(R.drawable.btn_unselect);
                if(co==0){

                    ((MainActivity)getActivity().getParent()).disable();
                    bt1.setBackgroundResource(R.drawable.btn_select);
                    glaf=1;co=1;
                    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragments,new fragment_moinhat_angi());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else {
                    if(glaf==1){
                        onBackPressed();return;
                    }
                    if (glaf1==1||glaf2==1){
                        ((MainActivity)getActivity().getParent()).disable();
                        bt1.setBackgroundResource(R.drawable.btn_select);
                        glaf1=0;glaf2=0;
                        FragmentManager fm = getChildFragmentManager();
                        fm.popBackStack();
                        glaf=1;
                        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragments , new fragment_moinhat_angi());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return;
                    }
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt1.setBackgroundResource(R.drawable.btn_unselect);
                bt3.setBackgroundResource(R.drawable.btn_unselect);
                if(co==0){
                    ((MainActivity)getActivity().getParent()).disable();
                    bt2.setBackgroundResource(R.drawable.btn_select);
                    glaf1=1;co=1;
                    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragments,new fragment_danhmuc_angi());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else {
                    if(glaf1==1){
                        onBackPressed();return;
                    }
                    if (glaf==1||glaf2==1){
                        ((MainActivity)getActivity().getParent()).disable();
                        bt2.setBackgroundResource(R.drawable.btn_select);
                        glaf=0;glaf2=0;
                        FragmentManager fm = getChildFragmentManager();
                        fm.popBackStack();
                        glaf1=1;
                        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragments , new fragment_danhmuc_angi());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return;
                    }
                }
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt1.setBackgroundResource(R.drawable.btn_unselect);
                bt2.setBackgroundResource(R.drawable.btn_unselect);
                if(co==0){
                    ((MainActivity)getActivity().getParent()).disable();
                    bt3.setBackgroundResource(R.drawable.btn_select);
                    glaf2=1;co=1;
                    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragments, new fragment_diadiem_angi());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                else {
                    if(glaf2==1){
                        onBackPressed();return;
                    }
                    if (glaf==1||glaf1==1){
                        ((MainActivity)getActivity().getParent()).disable();
                        bt3.setBackgroundResource(R.drawable.btn_select);
                        glaf=0;glaf1=0;
                        FragmentManager fm = getChildFragmentManager();
                        fm.popBackStack();
                        glaf2=1;
                        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragments , new fragment_diadiem_angi());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return;
                    }
                }
            }
        });
        return v;
    }
    //đếm các fragment được mở ra từ fragment_angi
    public static boolean handleBackPressed(FragmentManager fm) {
        if(fm.getFragments() != null){
            for(Fragment frag : fm.getFragments()){
                if(frag != null && frag.isVisible() && frag instanceof fragment_angi){
                    if(((fragment_angi)frag).onBackPressed()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //thoát khỏi fragment
    private boolean onBackPressed() {
        glaf=0;glaf1=0;co=0;glaf2=0;
        ((MainActivity)getActivity().getParent()).enable();
        bt2.setBackgroundResource(R.drawable.btn_unselect);
        bt3.setBackgroundResource(R.drawable.btn_unselect);
        bt1.setBackgroundResource(R.drawable.btn_unselect);
        FragmentManager fm = getChildFragmentManager();
        if(handleBackPressed(fm)){
            return true;
        }
        else if(getUserVisibleHint() && fm.getBackStackEntryCount() > 0){
            fm.popBackStack();
            return true;
        }
        return false;
    }
}
