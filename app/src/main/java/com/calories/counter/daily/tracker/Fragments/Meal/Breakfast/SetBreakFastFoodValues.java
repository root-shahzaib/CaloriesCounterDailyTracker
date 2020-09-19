package com.calories.counter.daily.tracker.Fragments.Meal.Breakfast;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calories.counter.daily.tracker.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SetBreakFastFoodValues#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetBreakFastFoodValues extends Fragment {


    public SetBreakFastFoodValues() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_set_break_fast_food_values, container, false);
    }
}