package com.calories.counter.daily.tracker.MealDatabase.ModelClasses;

import android.provider.BaseColumns;

public class WeightModel {
    // Weight Model
    public static final String WEIGHT_TABLE_NAME = "weighttable";
    public static final String WEIGHT_COLUMN_ID = "ID";
    public static final String WEIGHT_COLUMN_NAME = "PERSON_NAME";
    public static final String WEIGHT_COLUMN_GENDER = "GENDER";
    public static final String WEIGHT_COLUMN_HEIGHT = "HEIGHT";
    public static final String WEIGHT_COLUMN_AGE = "AGE";
    public static final String WEIGHT_COLUMN_CURRENT_WEIGHT = "CURRENT_WEIGHT";
    public static final String WEIGHT_COLUMN_TARGET_WEIGHT = "TARGET_WEIGHT";
    public static final  String CREATE_WEIGHT = "CREATE TABLE " + WEIGHT_TABLE_NAME + "(" +
            WEIGHT_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            WEIGHT_COLUMN_NAME + " TEXT NOT NULL," +
            WEIGHT_COLUMN_GENDER + " TEXT NOT NULL, " +
            WEIGHT_COLUMN_HEIGHT + " TEXT NOT NULL, " +
            WEIGHT_COLUMN_AGE + " INTEGER NOT NULL, " +
            WEIGHT_COLUMN_CURRENT_WEIGHT + " INTEGER NOT NULL, " +
            WEIGHT_COLUMN_TARGET_WEIGHT + " INTEGER NOT NULL );";

   public static final String DROP_WEIGHT = " DROP TABLE IF EXISTS " +WEIGHT_TABLE_NAME;

}
