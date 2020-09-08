package com.calories.counter.daily.tracker.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BreakfastHelperDatabase extends SQLiteOpenHelper
{


    public BreakfastHelperDatabase(@Nullable Context context) {
        super(context, BreakfastHelperModel.DATABASE_NAME, null, BreakfastHelperModel.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE = "CREATE TABLE "+BreakfastHelperModel.TABLE_NAME+
                "("+BreakfastHelperModel.ID+" INTEGER PRIMARY KEY, " +
                BreakfastHelperModel.NAME + " TEXT NOT NULL , " +
                BreakfastHelperModel.CALORIES + " TEXT NOT NULL , " +
                BreakfastHelperModel.MEASURE + " TEXT NOT NULL );";
        sqLiteDatabase.execSQL(CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP = " DROP TABLE IF EXISTS " + BreakfastHelperModel.TABLE_NAME;
        sqLiteDatabase.execSQL(DROP);
        onCreate(sqLiteDatabase);


    }

    public void InsertData(SQLiteDatabase database,String Name,String Calories,String Measure)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",Name);
        contentValues.put("Calories",Calories);
        contentValues.put("Measure",Measure);
        database.insert(BreakfastHelperModel.TABLE_NAME,null,contentValues);
    }
    public Cursor GetAllData(SQLiteDatabase database)
    {
        String GetData = "SELECT * FROM " +BreakfastHelperModel.TABLE_NAME;
        Cursor cursor = database.rawQuery(GetData,null);
        return  cursor;

    }
}
