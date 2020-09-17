package com.calories.counter.daily.tracker.Fragments.Weight;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.calories.counter.daily.tracker.MealDatabase.CaloriesDatabase;
import com.calories.counter.daily.tracker.R;


public class ShowWeightData extends Fragment {


    private CaloriesDatabase database;
    private SQLiteDatabase sqLiteDatabase;
    private String Name, Gender, Height;
    private int Age, CurrentWeight, TargetWeight;
    private TextView Nametxt, Gendertxt, Heighttxt, Agetxt, CurrentWtxt, TargetWeighttxt;
    private View view;

    public ShowWeightData() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show_weight_data, container, false);
        ValueInitialization();
        // Checking How Many Rows Database Have !
        database = new CaloriesDatabase(getContext());
        sqLiteDatabase = database.getWritableDatabase();
        Cursor cursor = database.GetWeightData(sqLiteDatabase);
        if (cursor.moveToFirst()) {
            do {
                Name = cursor.getString(1);
                Gender = cursor.getString(2);
                Height = cursor.getString(3);
                Age = cursor.getInt(4);
                CurrentWeight = cursor.getInt(5);
                TargetWeight = cursor.getInt(6);
                Nametxt.setText(String.valueOf(Name));
                Gendertxt.setText(String.valueOf(Gender));
                Heighttxt.setText(String.valueOf(Height));
                Agetxt.setText(String.valueOf(Age));
                CurrentWtxt.setText(String.valueOf(CurrentWeight));
                TargetWeighttxt.setText(String.valueOf(TargetWeight));
            } while (cursor.moveToNext());

        }


        return view;
    }

    public void ValueInitialization() {
        Nametxt = (TextView) view.findViewById(R.id.weight_plan_name);
        Gendertxt = (TextView) view.findViewById(R.id.weight_plan_gender);
        Agetxt = (TextView) view.findViewById(R.id.weight_plan_age);
        Heighttxt = (TextView) view.findViewById(R.id.weight_plan_height);
        CurrentWtxt = (TextView) view.findViewById(R.id.weight_plan_current_weight);
        TargetWeighttxt = (TextView) view.findViewById(R.id.weight_plan_target_weight);
    }
    public void UpdateDialog()
    {

    }


}