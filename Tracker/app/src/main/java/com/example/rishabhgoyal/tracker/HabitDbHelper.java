package com.example.rishabhgoyal.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rishabh Goyal on 12-02-2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;

    static final String NAME = "Tracker.db";

    public HabitDbHelper(Context context) {
        super(context, NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + Contract.Habit.TABLE_NAME + " (" +
                Contract.Habit.ID + " INTEGER PRIMARY KEY," +
                Contract.Habit.COLUMN_NAME+ " TEXT UNIQUE NOT NULL, " +
                Contract.Habit.COLUMN_HABIT + " TEXT NOT NULL, "  +
                Contract.Habit.COLUMN_FREQUENCY +"INTEGER NOT NULL,"+
                " );";
        sqLiteDatabase.execSQL(SQL_CREATE_HABIT_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.Habit.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    // Insert data in the table
    public boolean insertData(int id, String name, String location, String habit, int frquency) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contract.Habit.ID, id);
        contentValues.put(Contract.Habit.COLUMN_NAME, name);
        contentValues.put(Contract.Habit.COLUMN_HABIT, habit);
        contentValues.put(Contract.Habit.COLUMN_FREQUENCY,frquency);
        db.insert(Contract.Habit.TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }
    // Get data from the table
    public Cursor getData(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * from " + Contract.Habit.TABLE_NAME +
                " WHERE name=" + name, null);
        db.close();
        return result;
    }
    // Delete all table entries
    public int deleteAllEntries() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Contract.Habit.TABLE_NAME, null, null);
    }
    // Delete the database
    public boolean deleteDatabase(Context context) {
        return context.deleteDatabase(Contract.Habit.TABLE_NAME);
    }
    // Update data in the table
    public boolean updateData(int id, String name, String location, String habit, int frequnecy) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contract.Habit.ID, id);
        contentValues.put(Contract.Habit.COLUMN_NAME, name);
        contentValues.put(Contract.Habit.COLUMN_HABIT, habit);
        contentValues.put(Contract.Habit.COLUMN_FREQUENCY, frequnecy);
        db.update(Contract.Habit.TABLE_NAME, contentValues, " id = ? ",
                new String[]{Integer.toString(id)});
        db.close();
        return true;
    }



}
