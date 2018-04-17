package cz.uhk.fim.kozakev1.dbs_and_location.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import cz.uhk.fim.kozakev1.dbs_and_location.model.Pub;

/**
 * Created by kozakev1 on 16.04.2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(PubTable.SQL_QUERY_CREATE);

        System.out.println("spustila se on create");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //TODO ulotiz si aktualni data
        sqLiteDatabase.execSQL(PubTable.SQL_QUERY_DELETE);
        onCreate(sqLiteDatabase);
        System.out.println("Spustila se in upgrade");
        //TODO naplnit novou db
    }

    public List<Pub> getAllPubs() {
        List<Pub> allPubs = new ArrayList<>();

        // ma nastartost operace s daty
        SQLiteDatabase database = getReadableDatabase();

        // vyberu vsechny polozky z PubTable
        Cursor cursor = database.rawQuery("SELECT * FROM " + PubTable.TABLE_NAME, null);

        // presunu se na dalsi radek
        while (cursor.moveToNext())  {
            String name = cursor.getString(cursor.getColumnIndex(PubTable.COLUMN_NAME)); // potrebuju najit kde se String nachazi
            double lat = cursor.getDouble(cursor.getColumnIndex(PubTable.COLUMN_LAT));
            double lng = cursor.getDouble(cursor.getColumnIndex(PubTable.COLUMN_LNG));

            Pub pub = new Pub(name, lat, lng);
            allPubs.add(pub);


        }

        return allPubs;
    }

    public boolean savePub(Pub pub) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PubTable.COLUMN_NAME, pub.getName());
        values.put(PubTable.COLUMN_LAT, pub.getLat());
        values.put(PubTable.COLUMN_LNG, pub.getLng());

        long id =  database.insert(PubTable.TABLE_NAME, null, values);

        return id > 0;

    }
}
