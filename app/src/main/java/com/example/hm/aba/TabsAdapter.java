package com.example.hm.aba;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hm on 23/04/16.
 */
public class TabsAdapter extends FragmentStatePagerAdapter {
    public TabsAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int index){
        switch (index){
            case 0: return new HitungFragment();
            case 1: return new HargaRateFragment();
        }
        return new HitungFragment();
    }

    @Override
    public int getCount(){
        return 2;
    }
}
