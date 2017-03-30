package com.example.khanhduy.a3.fragments.tabs;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;

import com.example.khanhduy.a3.R;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    TabHost TabHostWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign id to Tabhost.
        TabHostWindow = (TabHost)findViewById(android.R.id.tabhost);

        //Creating tab menu.
        TabSpec TabMenu1 = TabHostWindow.newTabSpec("First tab");
        TabSpec TabMenu2 = TabHostWindow.newTabSpec("Second Tab");
        TabSpec TabMenu3 = TabHostWindow.newTabSpec("Third Tab");
        TabSpec TabMenu4 = TabHostWindow.newTabSpec("Four Tab");
        TabSpec TabMenu5 = TabHostWindow.newTabSpec("Five Tab");


        //Setting up tab 1 name.
        TabMenu1.setIndicator("",getResources().getDrawable(R.drawable.home_select));
        //Set tab 1 activity to tab 1 menu.
        TabMenu1.setContent(new Intent(this,TabActivity_1.class));

        //Setting up tab 2 name.
        TabMenu2.setIndicator("",getResources().getDrawable(R.drawable.home_select));
        //Set tab 3 activity to tab 1 menu.
        TabMenu2.setContent(new Intent(this,TabActivity_2.class));

        //Setting up tab 2 name.
        TabMenu3.setIndicator("",getResources().getDrawable(R.drawable.home_select));
        //Set tab 4 activity to tab 4 menu.
        TabMenu3.setContent(new Intent(this,TabActivity_2.class));


        TabMenu4.setIndicator("",getResources().getDrawable(R.drawable.home_select));
        //Set tab 4 activity to tab 4 menu.
        TabMenu4.setContent(new Intent(this,TabActivity_2.class));

        TabMenu5.setIndicator("",getResources().getDrawable(R.drawable.home_select));
        //Set tab 3 activity to tab 5 menu.
        TabMenu5.setContent(new Intent(this,TabActivity_2.class));
        //Adding tab1, tab2, tab3,tab4, tab5  to tabhost view.

        TabHostWindow.addTab(TabMenu1);
        TabHostWindow.addTab(TabMenu2);
        TabHostWindow.addTab(TabMenu3);
        TabHostWindow.addTab(TabMenu4);
        TabHostWindow.addTab(TabMenu5);



    }
    //ẩn tabhost
    public void disable(){
        TabWidget tabWidgetloz=(TabWidget)findViewById(android.R.id.tabs);
        tabWidgetloz.setVisibility(View.GONE);
    }
    //hiện tabhost
    public void enable(){
        TabWidget tabWidgetloz=(TabWidget)findViewById(android.R.id.tabs);
        tabWidgetloz.setVisibility(View.VISIBLE);
    }
}