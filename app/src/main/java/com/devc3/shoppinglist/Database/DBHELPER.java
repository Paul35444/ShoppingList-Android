package com.devc3.shoppinglist.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Paul on 7/11/2017.
 */

public class DBHELPER extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "wishListApp.db"; //Name of DB
    public static final int DATABASE_VERSION = 1; //Version that must be updated anytime the structure is changed

    public static final String WISHLIST_TABLE_NAME = "wishlist"; //Name of table
    public static final String WISHLIST_COLUMN_ID = BaseColumns._ID; // A special id number for row of values
    public static final String WISHLIST_COLUMN_NAME = "name"; // custom columns
    public static final String WISHLIST_COLUMN_GIFT = "gift";
    public static final String WISHLIST_COLUMN_SPECIFICS = "specifics";
    public static final String WISHLIST_COLUMN_STORE = "store";
    public static final String WISHLIST_COLUMN_URL = "URL";
    public static final String WISHLIST_COLUMN_STATUS = "status";//Might cause problems with SQLite storing as integers 0,1

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + WISHLIST_TABLE_NAME + " (" +
                    WISHLIST_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    WISHLIST_COLUMN_NAME + " TEXT NOT NULL," +
                    WISHLIST_COLUMN_GIFT + " TEXT NOT NULL)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + WISHLIST_TABLE_NAME;

    private static final String SQL_SELECT_ALL_ENTRIES = "SELECT  * FROM " + WISHLIST_TABLE_NAME;

    public static String GETTER_SQL_ALL_ENTRIES()
    {
        return SQL_SELECT_ALL_ENTRIES;
    }

    public DBHELPER(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}