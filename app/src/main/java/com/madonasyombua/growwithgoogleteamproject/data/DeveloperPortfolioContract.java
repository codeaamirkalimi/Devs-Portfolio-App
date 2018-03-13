package com.madonasyombua.growwithgoogleteamproject.data;


import android.provider.BaseColumns;

public class DeveloperPortfolioContract {

    // TODO: add Users table
    public class UserEntry implements BaseColumns {

        public static final String TABLE_USER           = "users";
        public static final String COLUMN_FIRSTNAME     = "firstName";
        public static final String COLUMN_LASTNAME      = "lastName";
        public static final String COLUMN_EMAIL         = "email";
        public static final String COLUMN_CREATED       = "created";


    }

    // TODO: add Feeds table
    public class FeedEntry implements BaseColumns {

        public static final String TABLE_FEED           = "feeds";
        public static final String COLUMN_DESCRIPTION   = "description";
        public static final String COLUMN_USER          = "user";
        public static final String COLUMN_CREATED       = "created";

    }

    // TODO: add more tables as needed here
}
