package br.ufg.inf.muralufg.utils.db;

import android.database.sqlite.SQLiteDatabase;

class DBInfo {
    //DB Info
    private static final String DB_NAME = "MURALUFG.DB";
    private static final int DB_VERSION = 1;

    //Tables
    private static final String TABLE_NAME_NEWS = "news";
    private static final String TABLE_NAME_ACADEMITUNITS = "academicunits";

    //Columns
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_NEWS = "news";
    private static final String COLUMN_PHOTO = "photo";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_AUTHORBELONGS = "authorbelongs";
    private static final String COLUMN_DATETIME = "datetime";
    private static final String COLUMN_ISREADED = "isreaded";
    private static final String COLUMN_RELEVANCE = "relevance";
    private static final String COLUMN_URL = "url";
    private static final String COLUMN_UNITID = "unitid";
    private static final String COLUMN_UNIT = "unit";
    private static final String COLUMN_ISCHECKED = "ischecked";

    //Creates
    private static final String CREATE_TABLE_NEWS = "CREATE TABLE "
            + TABLE_NAME_NEWS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TITLE + " TEXT NOT NULL, "
            + COLUMN_NEWS + " TEXT NOT NULL, "
            + COLUMN_PHOTO + " TEXT, "
            + COLUMN_AUTHOR + " TEXT NOT NULL, "
            + COLUMN_AUTHORBELONGS + " INTEGER NOT NULL, "
            + COLUMN_DATETIME + " TEXT NOT NULL, "
            + COLUMN_ISREADED + " INTEGER NOT NULL, "
            + COLUMN_RELEVANCE + " INTEGER NOT NULL, "
            + COLUMN_URL + " TEXT NOT NULL);";

    private static final String CREATE_TABLE_ACADEMITUNITS = "CREATE TABLE "
            + TABLE_NAME_ACADEMITUNITS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_UNITID + " INTEGER NOT NULL, "
            + COLUMN_UNIT + " TEXT NOT NULL, "
            + COLUMN_ISCHECKED + " INTEGER NOT NULL);";

    //Deletes
    private static final String DELETE_TABLE_NEWS = "DROP TABLE IF EXISTS " + TABLE_NAME_NEWS;
    private static final String DELETE_TABLE_ACADEMITUNITS = "DROP TABLE IF EXISTS " + TABLE_NAME_ACADEMITUNITS;

    private DBInfo() {
    }

    //Get's
    public static String getDBName() {
        return DB_NAME;
    }

    public static int getDBVersion() {
        return DB_VERSION;
    }

    public static String getTableNameNews() {
        return TABLE_NAME_NEWS;
    }

    public static String getTableNameAcademicUnits() {
        return TABLE_NAME_ACADEMITUNITS;
    }

    public static String getColumnID() {
        return COLUMN_ID;
    }

    public static String getColumnTitle() {
        return COLUMN_TITLE;
    }

    public static String getColumnNews() {
        return COLUMN_NEWS;
    }

    public static String getColumnPhoto() {
        return COLUMN_PHOTO;
    }

    public static String getColumnAuthor() {
        return COLUMN_AUTHOR;
    }

    public static String getColumnAuthorbelongs() {
        return COLUMN_AUTHORBELONGS;
    }

    public static String getColumnDatetime() {
        return COLUMN_DATETIME;
    }

    public static String getColumnIsreaded() {
        return COLUMN_ISREADED;
    }

    public static String getColumnRelevance() {
        return COLUMN_RELEVANCE;
    }

    public static String getColumnURL() {
        return COLUMN_URL;
    }

    public static String getColumnUnitID() {
        return COLUMN_UNITID;
    }

    public static String getColumnUnit() {
        return COLUMN_UNIT;
    }

    public static String getColumnIsChecked() {
        return COLUMN_ISCHECKED;
    }

    public static void createDB(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NEWS);
        db.execSQL(CREATE_TABLE_ACADEMITUNITS);
    }

    public static void deleteDB(SQLiteDatabase db) {
        db.execSQL(DELETE_TABLE_NEWS);
        db.execSQL(DELETE_TABLE_ACADEMITUNITS);
    }

    public static void resetDB(SQLiteDatabase db) {
        deleteDB(db);
        createDB(db);
    }

    public static void resetNews(SQLiteDatabase db) {
        db.execSQL(DELETE_TABLE_NEWS);
        db.execSQL(CREATE_TABLE_NEWS);
    }

    public static void resetAcademicUnits(SQLiteDatabase db) {
        db.execSQL(DELETE_TABLE_ACADEMITUNITS);
        db.execSQL(CREATE_TABLE_ACADEMITUNITS);
    }

    public static void deleteNewsRow(SQLiteDatabase db, long id) {
        db.delete(TABLE_NAME_NEWS, COLUMN_ID + " = " + id, null);
    }

    public static void deleteAcademicUnitsRow(SQLiteDatabase db, long id) {
        db.delete(TABLE_NAME_ACADEMITUNITS, COLUMN_ID + " = " + id, null);
    }
}
