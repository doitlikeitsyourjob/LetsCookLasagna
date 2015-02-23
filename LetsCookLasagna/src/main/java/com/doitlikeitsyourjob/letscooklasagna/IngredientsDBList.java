package com.doitlikeitsyourjob.letscooklasagna;

/**
 * Created by ndRandall on 15/02/14.
 */

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class IngredientsDBList extends ListActivity {

    Cursor cursor;
    SQLiteDatabase dh;
    CustomCursorAdapter myCursorAdapter;
    ContentValues values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidContext.setContext(this);

        dh = DatabaseHelper.getInstance().getDb();
        values = new ContentValues();

        initialiseDBList();
        createListView();
        setupUIEvents();
        setupAdvert();

    }

    private void setupAdvert() {
        // Look up the AdView as a resource and load a request.
        AdView adView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .addTestDevice("3244EEFC41AB498C0365FD48218D1D96")  // My HTC One X test phone
                .build();
        adView.loadAd(adRequest);
    }

    private void initialiseDBList() {

        Cursor mCount = dh.rawQuery("select count(*) from tblList", null);
        mCount.moveToFirst();
        int count = mCount.getInt(0);
        mCount.close();


        if (count == 0) {
            //Delete All Data
            deleteData();

            // Inserting some data in SQLite to populate list view
            insertData(getString(R.string.listName1), getString(R.string.listDesc1));
            insertData(getString(R.string.listName2), getString(R.string.listDesc2));
            insertData(getString(R.string.listName3), getString(R.string.listDesc3));
            insertData(getString(R.string.listName4), getString(R.string.listDesc4));
            insertData(getString(R.string.listName5), getString(R.string.listDesc5));
            insertData(getString(R.string.listName6), getString(R.string.listDesc6));
            insertData(getString(R.string.listName7), getString(R.string.listDesc7));
            insertData(getString(R.string.listName8), getString(R.string.listDesc8));
            insertData(getString(R.string.listName9), getString(R.string.listDesc9));
            insertData(getString(R.string.listName10), getString(R.string.listDesc10));
            insertData(getString(R.string.listName11), getString(R.string.listDesc11));
            insertData(getString(R.string.listName12), getString(R.string.listDesc12));
            insertData(getString(R.string.listName13), getString(R.string.listDesc13));
            insertData(getString(R.string.listName14), getString(R.string.listDesc14));
            insertData(getString(R.string.listName15), getString(R.string.listDesc15));
            insertData(getString(R.string.listName16), getString(R.string.listDesc16));
            insertData(getString(R.string.listName17), getString(R.string.listDesc17));
            insertData(getString(R.string.listName18), getString(R.string.listDesc18));

        }
    }

    private void deleteData() {
        dh.delete(DatabaseHelper.TABLE_NAME, null, null);
    }

    private void insertData(String Name, String Description) {
        if (values != null) {
            values.clear();
        }
        values.put("name", Name);
        values.put("description", Description);
        dh.insert(DatabaseHelper.TABLE_NAME, null, values);
    }

    private void createListView() {
        setContentView(R.layout.main);

        cursor = dh.query(DatabaseHelper.TABLE_NAME, new String[]{"_id", "name", "selected"}, null, null, null, null, "_id asc");

        startManagingCursor(cursor);
        myCursorAdapter = new CustomCursorAdapter(this, cursor);
        this.getListView().setAdapter(myCursorAdapter);
    }

    public void clickHandler(View view) {

        if (view.getId() == R.id.checkbox) {
            cursor.requery(); /* to get the updated values from sqlite on changing the check of checkbox*/
        }
    }

    void setupUIEvents() {
        Button thebutton = (Button) findViewById(R.id.btnClear);
        thebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleButtonClearClick();
            }
        });
    }

    void handleButtonClearClick() {

        DatabaseHelper databasehelper = new DatabaseHelper();
        // get a cursor containing call ingredients

        databasehelper.clearCheckBox();

        //reload page
        Intent intent = new Intent(this, IngredientsDBList.class);
        startActivity(intent);
    }


}