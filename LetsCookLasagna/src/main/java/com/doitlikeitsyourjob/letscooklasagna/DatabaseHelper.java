package com.doitlikeitsyourjob.letscooklasagna;

/**
 * Created by ndRandall on 15/02/14.
 */

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper o_instance = null;
    public static final String DATABASE_NAME = "DBList";
    public static final int DATABASE_VERSION = 2;
    public SQLiteDatabase o_db = null;
    public static final String TABLE_NAME = "tblList";

    public DatabaseHelper() {
        super(AndroidContext.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
        o_db = getWritableDatabase();
    }

    public static DatabaseHelper getInstance() {
        if (o_instance == null) {
            o_instance = new DatabaseHelper();
        }
        return o_instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String[] creatStatments = new String[]{"create table "
                + TABLE_NAME
                + " (_id INTEGER PRIMARY KEY,name TEXT,description TEXT,selected INTEGER DEFAULT 0)"};

        for (String sStmt : creatStatments) {
            db.execSQL(sStmt);
        }

       /*
                final String[] creatStatments2 = new String[]{"create table "

                + " tblRecipe "
                + " (_id INTEGER PRIMARY KEY,name TEXT,description TEXT,selected INTEGER DEFAULT 0)"};

        for (String sStmt : creatStatments2) {
            db.execSQL(sStmt);
        }


        */


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);


    }

    public SQLiteDatabase getDb() {
        return o_db;
    }

    // open the database connection
    public void open() throws SQLException {
        // create or open a database for reading/writing
        o_db = o_instance.getWritableDatabase();
    } // end method open

    // close the database connection
    public void close() {
        if (o_db != null)
            o_db.close(); // close the database connection
    } // end method close

    // inserts a new contact in the database
    public void clearCheckBox() {

        ContentValues clearCheckBox = new ContentValues();
        clearCheckBox.put("selected", 0);

        //open(); // open the database
        o_db.update(TABLE_NAME, clearCheckBox, null, null);
        //close(); // close the database
    } // end method updateContact


}