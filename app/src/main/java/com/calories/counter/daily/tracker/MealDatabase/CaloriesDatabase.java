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

public class CaloriesDatabase extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "caloriesdatabase";
    public static final int DATABASE_VERSION = 1;
    String CREATE_BREAKFAST = "CREATE TABLE "+ BreakfastModel.BREAKFAST_TABLE_NAME+
            "("+ BreakfastModel.BREAKFAST_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            BreakfastModel.BREAKFAST_COLUMN_NAME + " TEXT NOT NULL , " +
            BreakfastModel.BREAKFAST_COLUMN_CALORIES + " TEXT NOT NULL , " +
            BreakfastModel.BREAKFAST_COLUMN_MEASURE + " TEXT  NOT NULL );";

    String CREATE_WEIGHT = "CREATE TABLE "+ WeightModel.WEIGHT_TABLE_NAME + "("+
            WeightModel.WEIGHT_COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
            WeightModel.WEIGHT_COLUMN_NAME + " TEXT NOT NULL,"+
            WeightModel.WEIGHT_COLUMN_GENDER + " TEXT NOT NULL, "+
            WeightModel.WEIGHT_COLUMN_HEIGHT + " TEXT NOT NULL, "+
            WeightModel.WEIGHT_COLUMN_AGE + " INTEGER NOT NULL, " +
            WeightModel.WEIGHT_COLUMN_CURRENT_WEIGHT + " INTEGER NOT NULL, " +
            WeightModel.WEIGHT_COLUMN_TARGET_WEIGHT + " INTEGER NOT NULL );";




    public CaloriesDatabase(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_WEIGHT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP = " DROP TABLE IF EXISTS " + WeightModel.WEIGHT_TABLE_NAME;
        sqLiteDatabase.execSQL(DROP);

        onCreate(sqLiteDatabase);


    }

    public void InsertWeightData(Context context,String Name,String Gender,String Height,int Age,int CurrentWeight,int TargetWeight)
    {
        ContentValues WeightContentValues = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        WeightContentValues.put("PERSON_NAME",Name);
        WeightContentValues.put("GENDER",Gender);
        WeightContentValues.put("HEIGHT",Height);
        WeightContentValues.put("AGE",Age);
        WeightContentValues.put("CURRENT_WEIGHT",CurrentWeight);
        WeightContentValues.put("TARGET_WEIGHT",TargetWeight);
        long newRowId = db.insert(WeightModel.WEIGHT_TABLE_NAME,null,WeightContentValues);
        if(newRowId == -1)
        {
            Toast.makeText(context,"Data is not Inserted",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(context, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
        }


    }
    public Cursor GetWeightData(SQLiteDatabase database)
    {
        String GetWeightData = "SELECT * FROM " + WeightModel.WEIGHT_TABLE_NAME;
        Cursor cursor = database.rawQuery(GetWeightData,null);

        return  cursor;

    }
    public int getProfilesCount(SQLiteDatabase database) {
        String GetWeightData = "SELECT * FROM " + WeightModel.WEIGHT_TABLE_NAME;
        Cursor cursor = database.rawQuery(GetWeightData, null);
        int count = cursor.getCount();
        return count;
    }
    public void UpdateWeightData()
    {

    }
}
