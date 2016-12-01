package com.amador.tab_fragments;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by usuario on 30/11/16.
 */
public class AdapterPager extends FragmentStatePagerAdapter {


    private int conTab;
    private String[] titles;


    public AdapterPager(FragmentManager fm, int conTab, String[] titles){

        super(fm);
        this.conTab = conTab;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {

        CustomFragment customFragment = null;
        Bundle bundle = new Bundle();

        switch (position){

            case 0:
                bundle.putString(CustomFragment.KEY_REG_TEXT,"Tab 1");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 1:
                bundle.putString(CustomFragment.KEY_REG_TEXT,"Tab 2");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 2:
                bundle.putString(CustomFragment.KEY_REG_TEXT,"Tab 3");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 3:
                bundle.putString(CustomFragment.KEY_REG_TEXT,"Tab 4");
                customFragment = CustomFragment.newInstance(bundle);
                break;
            case 4:
                bundle.putString(CustomFragment.KEY_REG_TEXT,"Tab 5");
                customFragment = CustomFragment.newInstance(bundle);
                break;
        }

        return customFragment;
    }

    @Override
    public int getCount() {

        return conTab;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.titles[position];
    }


}
