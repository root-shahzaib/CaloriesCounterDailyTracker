package com.calories.counter.daily.tracker.Fragments.Weight;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.calories.counter.daily.tracker.MealDatabase.CaloriesDatabase;
import com.calories.counter.daily.tracker.MealDatabase.ModelClasses.WeightModel;
import com.calories.counter.daily.tracker.R;


public class ShowWeightData extends Fragment {


    private CaloriesDatabase database;
    private SQLiteDatabase sqLiteDatabase;
    private String Name, Gender, Height;
    private int Age, CurrentWeight, TargetWeight;
    private TextView Nametxt, Gendertxt, Heighttxt, Agetxt, CurrentWtxt, TargetWeighttxt;
    TextView upertextvalu, belowtxtvalue;
    private View view;
    String et_Value;
    public ShowWeightData() {}
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
                Heighttxt.setText(String.valueOf(Height)+" cm");
                Agetxt.setText(String.valueOf(Age));
                CurrentWtxt.setText(String.valueOf(CurrentWeight)+" Kg");
                TargetWeighttxt.setText(String.valueOf(TargetWeight)+" Kg");
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
        Nametxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDialog(et_Value,WeightModel.WEIGHT_COLUMN_NAME);
                upertextvalu.setText("Your Name");
                belowtxtvalue.setText("Enter your name");
            }
        });
        Gendertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDialog(et_Value,WeightModel.WEIGHT_COLUMN_GENDER);
                upertextvalu.setText("Gender");
                belowtxtvalue.setText("Enter your gender male/female");
            }
        });
        Agetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDialog(et_Value,WeightModel.WEIGHT_COLUMN_AGE);
                upertextvalu.setText("Your Age");
                belowtxtvalue.setText("Enter your Age");
            }
        });
        Heighttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDialog(et_Value,WeightModel.WEIGHT_COLUMN_HEIGHT);
                upertextvalu.setText("Your Height");
                belowtxtvalue.setText("Enter your Height");
            }
        });
        CurrentWtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDialog(et_Value,WeightModel.WEIGHT_COLUMN_CURRENT_WEIGHT);
                upertextvalu.setText("Your Current weight");
                belowtxtvalue.setText("Enter your Current Weight");
            }
        });
        TargetWeighttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDialog(et_Value,WeightModel.WEIGHT_COLUMN_TARGET_WEIGHT);
                upertextvalu.setText("Your Target WEight");
                belowtxtvalue.setText("Enter your Target Weight");
            }
        });
    }
    public void UpdateDialog(final String Value, final String ColumnName) {
        final AlertDialog.Builder alertdialog = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.update_dialog_box_weight, null);
        final EditText editText = (EditText) view.findViewById(R.id.updatedialog_edittext);
        Button cancel = (Button) view.findViewById(R.id.updatedialog_cancelbtn);
        Button Save = (Button) view.findViewById(R.id.updatedialog_savebutton);
        upertextvalu = (TextView) view.findViewById(R.id.upertxtvalue);
        belowtxtvalue = (TextView) view.findViewById(R.id.belowtxtvalue);
        alertdialog.setView(view);
        final AlertDialog dialog = alertdialog.create();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_Value = editText.getText().toString();
                database.UpdateWeightData(getContext(),ColumnName, Value );
                dialog.dismiss();
                //Refreshing Fragment,
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(ShowWeightData.this).attach(ShowWeightData.this).commit();
            }
        });
        dialog.show();
    }



}