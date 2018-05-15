package com.connercaspar.taskmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public ViewPageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TabFragmentIncomplete.getInstance(position);
            case 1:
                return TabFragmentComplete.getInstance(position);
            case 2:
                return TabFragmentAll.getInstance(position);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Incomplete Tasks";
            case 1:
                return "Completed Tasks";
            case 2:
                return "All Tasks";
            default:
                return null;
        }
    }
}
