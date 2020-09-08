package com.calories.counter.daily.tracker.Fragments.MyPlans;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.calories.counter.daily.tracker.R;
import com.google.android.material.tabs.TabLayout;

public class MyPlan extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myplans, null, false);
        tabLayout = (TabLayout) view.findViewById(R.id.myplans_tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.myplans_viewpager);
        setupviewpager(viewPager);
        tabLayout.setupWithViewPager(viewPager);




        return view;
    }
    public void setupviewpager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addfragment(new PlanFragment(), "Plans");
        viewPagerAdapter.addfragment(new PersonalinfoFragment(), "Personal Info");
        viewPager.setAdapter(viewPagerAdapter);
    }
}