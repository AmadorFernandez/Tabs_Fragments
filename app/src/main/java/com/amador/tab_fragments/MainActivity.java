package com.amador.tab_fragments;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ViewPager.PageTransformer {

    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private AdapterPager adapter;
    private CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator);


        //Se debe inicializar el tab layout y el pager
        tabLayout = (TabLayout)findViewById(R.id.tab);
        tabLayout.setBackgroundColor(Color.DKGRAY);
        tabLayout.setTabTextColors(ColorStateList.valueOf(Color.MAGENTA));
        // tabLayout.addTab(tabLayout.newTab().setText("Tab1"));

        String[] array = getResources().getStringArray(R.array.tabs);
        TabLayout.Tab[] tabs = new TabLayout.Tab[array.length];

        for(int i = 0; i < array.length; i++){

            tabs[i] = tabLayout.newTab();
            tabLayout.addTab(tabs[i]);

        }

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        adapter = new AdapterPager(getSupportFragmentManager(), tabLayout.getTabCount(),
                getResources().getStringArray(R.array.tabs));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        for(int i = 0; i < tabs.length; i++){

            tabLayout.getTabAt(i).setIcon(R.drawable.ic_action_name);
        }




/*

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
                tab.setIcon(R.drawable.ic_action_name);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

               // tabLayout.getTabAt(position).select();
                tabLayout.setScrollPosition(position, 0f, true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

*/

    }

    @Override
    public void transformPage(View page, float position) {


    }
}