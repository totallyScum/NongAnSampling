package com.chen.nongansampling.adapter;

import android.os.Parcelable;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class BusinessArchivesFragmentAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> tab_title_list;//存放标签页标题
    private ArrayList<Fragment> fragment_list;//存放ViewPager下的Fragment
    public BusinessArchivesFragmentAdapter(FragmentManager fm) {
        super(fm);
        this.tab_title_list = tab_title_list;
        this.fragment_list = fragment_list;
    }
    public BusinessArchivesFragmentAdapter(FragmentManager fm, ArrayList<String> tab_title_list, ArrayList<Fragment> fragment_list) {
        super(fm);
        this.tab_title_list = tab_title_list;
        this.fragment_list = fragment_list;
    }
    @Override
    public Fragment getItem(int position) {
        return fragment_list.get(position);
    }

    @Override
    public int getCount() {
        return fragment_list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab_title_list.get(position);
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Parcelable saveState() {
   //     return super.saveState();

        return null;
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        //super.restoreState(state, loader);
    }
}
