package com.example.rishabhgoyal.tracker;

import android.provider.BaseColumns;

/**
 * Created by Rishabh Goyal on 12-02-2017.
 */

public class Contract {
/**Contract for the App*/
    public static final class Habit implements BaseColumns {

        public static final String ID = "id";
        public static final String TABLE_NAME = "habit";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_HABIT = "habit";
    }
}
