package com.calories.counter.daily.tracker.Fragments.Weight;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.calories.counter.daily.tracker.MealDatabase.CaloriesDatabase;
import com.calories.counter.daily.tracker.R;

import java.lang.annotation.Target;

public class Weight extends Fragment {

    CaloriesDatabase caloriesDatabase;
    Context context;
    Button next_btn;
    RadioButton male_rdbtn, female_rdbtn;
    EditText name_et, weight_et, target_et;
    NumberPicker age_numberpicker, feet_numberpicker, inches_numberpicker;
    View view;
    String Name, Gender;
    int HeightFeet, HeightInches, Age;
    int CurrentWeight, TargetWeight;
    String HeightInCmvlu;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_weight, null, false);
        context = getContext();
        InitializationWidgets();
        caloriesDatabase = new CaloriesDatabase(context);
        genderfunction();
        Age();
        Height();
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name = name_et.getText().toString();
                weightfucntion();
                heightInCm();
                if(Name.length() == 0 ||Gender.length() == 0 || Age == 0 ||HeightInCmvlu.length() == 0 || CurrentWeight == 0 || TargetWeight == 0 )
                {
                    Toast.makeText(context, "Please Enter All Values", Toast.LENGTH_SHORT).show();
                }
                else {
                    caloriesDatabase.InsertWeightData(getContext(), Name, Gender, HeightInCmvlu, Age, CurrentWeight, TargetWeight);
                    ShowWeightData data = new ShowWeightData();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, data, "null")
                            .addToBackStack(null).commit();
                }
            }
        });
        return view;
    }
    private void InitializationWidgets() {
        next_btn = view.findViewById(R.id.next_btn);
        male_rdbtn = view.findViewById(R.id.male_rdbtn);
        female_rdbtn = view.findViewById(R.id.female_rdbtn);
        name_et = view.findViewById(R.id.name_et);
        weight_et = view.findViewById(R.id.weight_et);
        target_et = view.findViewById(R.id.targetWeight_et);
        age_numberpicker = view.findViewById(R.id.age_pickernumber);
        feet_numberpicker = view.findViewById(R.id.feet_numberpicker);
        inches_numberpicker = view.findViewById(R.id.inches_numberpicker);
    }
        //caloriesDatabase.InsertWeightData(context,);

    public void genderfunction() {

        male_rdbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (compoundButton.isChecked()) {
                    Gender = "Male";
                    female_rdbtn.setChecked(false);

                }
            }
        });
        female_rdbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (compoundButton.isChecked()) {
                    Gender = "Female";
                    male_rdbtn.setChecked(false);
                }

            }
        });





    }

    public void Age() {
        age_numberpicker.setMaxValue(90);
        age_numberpicker.setMinValue(1);
        age_numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                Age = numberPicker.getValue();
            }
        });
    }

    public void Height() {
        feet_numberpicker.setMinValue(1);
        feet_numberpicker.setMaxValue(10);
        feet_numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                HeightFeet = numberPicker.getValue();
            }
        });

        inches_numberpicker.setMinValue(1);
        inches_numberpicker.setMaxValue(12);
        inches_numberpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                HeightInches = numberPicker.getValue();
            }
        });
    }

    public void heightInCm() {

        HeightInCmvlu = String.valueOf(HeightFeet * 30.48 + HeightInches * 2.54);
        Toast.makeText(getContext(), ""+HeightInCmvlu, Toast.LENGTH_SHORT).show();
    }

    public void weightfucntion(){

        try
        {
            CurrentWeight= Integer.parseInt(weight_et.getText().toString());
            TargetWeight= Integer.parseInt(target_et.getText().toString());
        }
        catch (NumberFormatException e)
        {
            // handle the exception
            CurrentWeight=0;
            TargetWeight=0;
        }
    }
}