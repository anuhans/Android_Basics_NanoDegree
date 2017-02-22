package com.example.rishabhgoyal.inventory;

import android.provider.BaseColumns;

/**
 * Created by Rishabh Goyal on 18-02-2017.
 */

public class Contract {

    public static final class InventoryEntry implements BaseColumns {

        public static final String COLUMN_ID = "id";
        public static final String TABLE_NAME = "inventory";
        public static final String COLUMN_PRODUCT_NAME = "name";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_IMAGE="image";
        public static final String COLUMN_PRICE = "price";
    }
}
