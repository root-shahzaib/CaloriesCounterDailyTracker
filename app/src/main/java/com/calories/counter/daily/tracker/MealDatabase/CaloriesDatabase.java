package com.calories.counter.daily.tracker.MealDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.calories.counter.daily.tracker.MealDatabase.ModelClasses.BreakfastModel;
import com.calories.counter.daily.tracker.MealDatabase.ModelClasses.WeightModel;

public class CaloriesDatabase extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "caloriesdatabase";
    public static final int DATABASE_VERSION = 1;
    public CaloriesDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(WeightModel.CREATE_WEIGHT);
        sqLiteDatabase.execSQL(BreakfastModel.CREATE_BREAKFAST);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(WeightModel.DROP_WEIGHT);
        sqLiteDatabase.execSQL(BreakfastModel.DROP_BREAKFAST);
        onCreate(sqLiteDatabase);
    }
    // All About Weight functionality ;
    public void InsertWeightData(Context context, String Name, String Gender, String Height, int Age, int CurrentWeight, int TargetWeight) {
        ContentValues WeightContentValues = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        WeightContentValues.put("PERSON_NAME", Name);
        WeightContentValues.put("GENDER", Gender);
        WeightContentValues.put("HEIGHT", Height);
        WeightContentValues.put("AGE", Age);
        WeightContentValues.put("CURRENT_WEIGHT", CurrentWeight);
        WeightContentValues.put("TARGET_WEIGHT", TargetWeight);
        long newRowId = db.insert(WeightModel.WEIGHT_TABLE_NAME, null, WeightContentValues);
        if (newRowId == -1) {
            Toast.makeText(context, "Data is not Inserted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
        }


    }
    public Cursor GetWeightData(SQLiteDatabase database) {
        String GetWeightData = "SELECT * FROM " + WeightModel.WEIGHT_TABLE_NAME;
        Cursor cursor = database.rawQuery(GetWeightData, null);

        return cursor;

    }
    public int getProfilesCount(SQLiteDatabase database) {
        String GetWeightData = "SELECT * FROM " + WeightModel.WEIGHT_TABLE_NAME;
        Cursor cursor = database.rawQuery(GetWeightData, null);
        int count = cursor.getCount();
        return count;
    }
    public void UpdateWeightData(Context context, String ColumnName, String ColumnValue) {
        ContentValues WeightContentValues = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        WeightContentValues.put(ColumnName, ColumnValue);
        long newRowId = db.update(WeightModel.WEIGHT_TABLE_NAME, WeightContentValues,
                WeightModel.WEIGHT_COLUMN_ID + " = 1", null);
        if (newRowId == -1) {
            Toast.makeText(context, "Data is not updated", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Data updated Successfully", Toast.LENGTH_SHORT).show();
        }
    }
       /*  MEAL ACTIVITY */

    // All About Breakfast functionality
    public void InsertBreakfast(Context context, String Name, String Gender, String Height, int Age, int CurrentWeight, int TargetWeight) {
        ContentValues WeightContentValues = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        WeightContentValues.put("PERSON_NAME", Name);
        WeightContentValues.put("GENDER", Gender);
        WeightContentValues.put("HEIGHT", Height);
        WeightContentValues.put("AGE", Age);
        WeightContentValues.put("CURRENT_WEIGHT", CurrentWeight);
        WeightContentValues.put("TARGET_WEIGHT", TargetWeight);
        long newRowId = db.insert(WeightModel.WEIGHT_TABLE_NAME, null, WeightContentValues);
        if (newRowId == -1) {
            Toast.makeText(context, "Data is not Inserted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
        }


    }





}
