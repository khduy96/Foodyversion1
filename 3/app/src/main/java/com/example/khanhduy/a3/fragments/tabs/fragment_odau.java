package com.example.khanhduy.a3.fragments.tabs;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.khanhduy.a3.R;
import com.example.khanhduy.a3.fragments.tabs.data.Itemlist;
import com.example.khanhduy.a3.fragments.tabs.data.SqlLiteDbHelper;

import java.util.List;

public class fragment_odau extends Fragment implements fragment_danhmuc.Ondatadanhmuclistener{
    //khai báo biến
    SqlLiteDbHelper dbHelper;
    private ListView lv1;
    private Button bt1,bt2,bt3;
    private static int glaf=0,glaf1=0,glaf2=0,co=0;
    private Context mainactivity;
    private List<Itemlist> contactList,contactList1;
    private CustomAdapterlvmain adapter1;
    private GridView grid;
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
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment_odau, container, false);
        //ánh xạ các biến
        bt1 = (Button)v.findViewById(R.id.btn1);
        bt2 = (Button)v.findViewById(R.id.btn2);
        bt3 = (Button)v.findViewById(R.id.btn3);
        lv1=(ListView) v.findViewById(R.id.lvmain);
        View headerView = (View) inflater.inflate(R.layout.customheaderlvmain, lv1, false);
        //custom header
        CustomAdaptergv_header adapter = new CustomAdaptergv_header(mainactivity, web, imageId);
        grid=(GridView)headerView.findViewById(R.id.gridView1);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(mainactivity, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
        //đưa data vào list
        lv1.addHeaderView(headerView);
        dbHelper = new SqlLiteDbHelper(mainactivity);
        dbHelper.openDataBase();
        contactList = dbHelper.getAllItemlist();
        lv1.setAdapter(new CustomAdapterlvmain(mainactivity,contactList));
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
                    fragmentTransaction.replace(R.id.fragments,new fragment_moinhat());
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
                        fragmentTransaction.replace(R.id.fragments , new fragment_moinhat());
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
                    fragmentTransaction.replace(R.id.fragments,new fragment_danhmuc(),"c");
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
                        fragmentTransaction.replace(R.id.fragments , new fragment_danhmuc(),"c");
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
                    fragmentTransaction.replace(R.id.fragments, new fragment_diadiem());
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
                        fragmentTransaction.replace(R.id.fragments , new fragment_diadiem());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        return;
                    }
                }
            }
        });
        return v;
    }
    //đếm các fragment được mở ra từ fragment_odau
    public static boolean handleBackPressed(FragmentManager fm) {
        if(fm.getFragments() != null){
            for(Fragment frag : fm.getFragments()){
                if(frag != null && frag.isVisible() && frag instanceof fragment_odau){
                    if(((fragment_odau)frag).onBackPressed()){
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
    //lấy phương thức của hàm con
    @Override
    public void onDanhMucSelectionSet(String text, int tab, int selected) {
        FragmentManager fragmentManager = getChildFragmentManager();
        fragment_danhmuc someOtherNestFrag = (fragment_danhmuc) fragmentManager.findFragmentByTag("c");
        //Tag of your fragment which you should use when you add

        if(someOtherNestFrag != null) {
            bt2.setText(text);
            bt2.setTextColor(Color.RED);
            contactList1 = dbHelper.getdanhmuc(selected);
            lv1.setAdapter(new CustomAdapterlvmain(mainactivity,contactList1));
        }
        else Log.d("null","null");

    }
}
