package com.example.khanhduy.a3.fragments.tabs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khanhduy.a3.R;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class TabActivity_1 extends FragmentActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
    //khai báo biến
    private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String,TabInfo>();
    private PagerAdapter mPagerAdapter;
    Typeface face;
    private FragmentActivity mainactivity;
    //public Intent district = new Intent(TabActivity_1.this, diadiem.class);





    /**
     *
     * @author mwho
     * Maintains extrinsic info of a tab's construct
     */
    //biến kiểu Struct
    private class TabInfo {
        private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;
        TabInfo(String tag, Class<?> clazz, Bundle args) {
            this.tag = tag;
            this.clss = clazz;
            this.args = args;
        }

    }
    /**
     * A simple factory that returns dummy views to the Tabhost
     * @author mwho
     */

    class TabFactory implements TabHost.TabContentFactory {
        private final Context mContext;

        /**
         * @param context
         */
        public TabFactory(Context context) {
            mContext = context;
        }

        /** (non-Javadoc)
         * @see android.widget.TabHost.TabContentFactory#createTabContent(java.lang.String)
         */
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_activity_1);
                this.initialiseTabHost(savedInstanceState);
        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); //set the tab as per the saved state
        }
        for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++)
        {
            TextView textView = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(10);
        }
        TextView textView = (TextView) mTabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
        textView.setTextColor(Color.WHITE);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TabWidget tw = mTabHost.getTabWidget();
        View leftTabView = tw.getChildAt(0);

        leftTabView.setBackgroundResource(R.drawable.tab_bg_unselected);
        leftTabView.setPadding(0,0,0,0);
        leftTabView.setLayoutParams(new LinearLayout.LayoutParams(140,90));
        View rightTabView = tw.getChildAt(1);
        rightTabView.setBackgroundResource(R.drawable.tab_bg_selected);
        rightTabView.setPadding(0,0,0,0);
        rightTabView.setLayoutParams(new LinearLayout.LayoutParams(140,90));
        this.intialiseViewPager();
        ImageButton btnL=(ImageButton)findViewById(R.id.imageBtnL);
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabActivity_1.this, diadiem.class);
                startActivity(intent);
            }
        });

    }
    //tạo bottomSheet
    public void openBottomSheet (View v) {

        View view = getLayoutInflater ().inflate (R.layout.bottom_sheet, null);
        TextView txtBackup = (TextView)view.findViewById( R.id.txt_backup);
        TextView txtDetail = (TextView)view.findViewById( R.id.txt_detail);
        TextView txtOpen = (TextView)view.findViewById( R.id.txt_open);
        final TextView txtUninstall = (TextView)view.findViewById( R.id.txt_uninstall);

        final Dialog mBottomSheetDialog = new Dialog (TabActivity_1.this,
                R.style.MaterialDialogSheet);
        mBottomSheetDialog.setContentView (view);
        mBottomSheetDialog.setCancelable (true);
        mBottomSheetDialog.getWindow ().setLayout (LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow ().setGravity (Gravity.BOTTOM);
        mBottomSheetDialog.show ();


        txtBackup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(TabActivity_1.this,"Clicked Backup",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });

        txtDetail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(TabActivity_1.this,"Clicked Detail",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });

        txtOpen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(TabActivity_1.this,"Clicked Open",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });

        txtUninstall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(TabActivity_1.this,"Clicked Uninstall",Toast.LENGTH_SHORT).show();
                mBottomSheetDialog.dismiss();
            }
        });
    }
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("tab", mTabHost.getCurrentTabTag()); //save the tab selected
        super.onSaveInstanceState(outState);
    }
    /**
     * Initialise ViewPager
     */
    //thưc hiện chức năng hiển thị và viewpaper
    private void intialiseViewPager() {

        List<Fragment> fragments = new Vector<Fragment>();
        fragment_odau tab1 = (fragment_odau) Fragment.instantiate(this, fragment_odau.class.getName());
        fragment_angi tab2 = (fragment_angi) Fragment.instantiate(this, fragment_angi.class.getName());

        fragments.add(tab1);
        fragments.add(tab2);
        this.mPagerAdapter  = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        //
        this.mViewPager = (ViewPager)super.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.addOnPageChangeListener(this);
    }

    /**
     * Initialise the Tab Host
     */
    //tạo tab
    private void initialiseTabHost(Bundle args) {
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        TabInfo tabInfo = null;
        TabActivity_1.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator("Ở đâu"), ( tabInfo = new TabInfo("Tab2", fragment_odau.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        TabActivity_1.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab2").setIndicator("Ăn gì"), ( tabInfo = new TabInfo("Tab1", fragment_angi.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        // Default to first tab
        //this.onTabChanged("Tab1");
        //
        mTabHost.setOnTabChangedListener(this);
    }

    /**
     * Add Tab content to the Tabhost
     * @param activity
     * @param tabHost
     * @param tabSpec
     */
    //add tab
    private static void AddTab(TabActivity_1 activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo) {
        // Attach a Tab view factory to the spec
        tabSpec.setContent(activity.new TabFactory(activity));
        tabHost.addTab(tabSpec);
    }

    /** (non-Javadoc)
     * @see android.widget.TabHost.OnTabChangeListener#onTabChanged(java.lang.String)
     */
    //phuong thức đc gọi khi tap được chane
    @Override
    public void onTabChanged(String tabId) {
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
        for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++)
        {
            TextView textView = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            textView.setTextColor(Color.WHITE);
        }
        TextView textView = (TextView) mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab()).findViewById(android.R.id.title);
        textView.setTextColor(Color.BLACK);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        this.mTabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
    @Override
    //hàm onBackPressed back dung lại ở fragment_odau và fragment_angi
    public void onBackPressed()
    {
        if(!fragment_odau .handleBackPressed(getSupportFragmentManager())
                &&!fragment_angi .handleBackPressed(getSupportFragmentManager())){
            super.onBackPressed();
        }
    }

}
