package com.calories.counter.daily.tracker.Fragments.Weight;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calories.counter.daily.tracker.R;

public class Weight  extends Fragment {

    TimePicker timepicker;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weight, null, false);

        timepicker = view.findViewById(R.id.weight_timerpickerforheight_id);
        timepicker.setIs24HourView(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timepicker.setHour(5);
            timepicker.setMinute(9);

        }


        return view;
    }
}