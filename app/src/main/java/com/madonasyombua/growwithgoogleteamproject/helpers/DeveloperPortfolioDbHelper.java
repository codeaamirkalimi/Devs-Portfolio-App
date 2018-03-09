package com.madonasyombua.growwithgoogleteamproject.helpers;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.madonasyombua.growwithgoogleteamproject.data.DeveloperPortfolioContract.*;

public class DeveloperPortfolioDbHelper extends SQLiteOpenHelper {

    // Database name
    public static final String DATABASE_NAME = "developerPortfolio.db";

    // Database version
    public static final int DATABASE_VERSION = 1;

    public DeveloperPortfolioDbHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // SQL statement for creating Users table
        final String SQL_CREATE_TABLE_USER = "CREATE TABLE " +
                UserEntry.TABLE_USER + "(" +
                UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                UserEntry.COLUMN_FIRSTNAME + " TEXT NOT NULL," +
                UserEntry.COLUMN_LASTNAME + " TEXT NOT NULL," +
                UserEntry.COLUMN_EMAIL + " VARCHAR(320)," +
                UserEntry.COLUMN_CREATED + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        // SQL statement for creating Feeds table
        final String SQL_CREATE_TABLE_FEED = "CREATE TABLE " +
                FeedEntry.TABLE_FEED + "(" +
                FeedEntry.COLUMN_DESCRIPTION + " VARCHAR(1024)," +
                FeedEntry.COLUMN_USER + " INTEGER NOT NULL," +
                FeedEntry.COLUMN_CREATED + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        // Execute the SQL commands to create the tables
        db.execSQL(SQL_CREATE_TABLE_USER);
        db.execSQL(SQL_CREATE_TABLE_FEED);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + FeedEntry.TABLE_FEED);

        // Create new db
        onCreate(db);

    }
}
