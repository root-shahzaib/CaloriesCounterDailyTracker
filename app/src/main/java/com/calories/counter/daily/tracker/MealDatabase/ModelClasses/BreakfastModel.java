package com.calories.counter.daily.tracker.MealDatabase.ModelClasses;

public class BreakfastModel {
     // Breakfast Table
    public static final String BREAKFAST_TABLE_NAME = "breakfast.caloriesdatabase.db";
    public static final String BREAKFAST_ROW_ID = "ID";
    public static final String BREAKFAST_COLUMN_NAME = "NAME";
    public static final String BREAKFAST_COLUMN_CALORIES = "CALORIES";
    public static final String BREAKFAST_COLUMN_MEASURE = "MEASURE";
    public static final String BREAKFAST_COLUMN_IMAGE = "IMAGE";

   public static final String CREATE_BREAKFAST= "CREATE TABLE "+ BREAKFAST_TABLE_NAME + "("+
            BREAKFAST_ROW_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
            BREAKFAST_COLUMN_NAME + " TEXT NOT NULL,"+
            BREAKFAST_COLUMN_CALORIES + " TEXT NOT NULL, "+
            BREAKFAST_COLUMN_MEASURE + " TEXT NOT NULL, "+
            BREAKFAST_COLUMN_IMAGE + " INTEGER NOT NULL );";

    public static final String DROP_BREAKFAST = " DROP TABLE IF EXISTS " +BREAKFAST_TABLE_NAME;



}
