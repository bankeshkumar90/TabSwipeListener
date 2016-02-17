package com.cafe;

 
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) { 
        switch (index) {
        case 0:
            return new Incomefragment();
        case 1: 
            return new Deductionsfragment();
        case 2:
            return new Taxespaidfragment();
         
          
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
    
    
     
}