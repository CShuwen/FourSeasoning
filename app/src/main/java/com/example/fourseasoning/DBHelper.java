package com.example.fourseasoning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;
public class DBHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "Userdetails";
    private static final String PLANT_NAME = "name";
    private static final String PLANT_BOX = "box";
    private static final String PLANT_LIVE= "live";
    private static final String PLANT_SOIL= "soil";
    private static final String PLANT_WATER = "water";
    private static final String PLANT_WATERM= "waterm";
    private static final String PLANT_LOCATION= "location";
    private static final String PLANT_ADDINFO= "addinfo";

    String name, contact, live, soil, water, waterm, location, addinfo;
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + PLANT_NAME + " TEXT, " + PLANT_BOX + " INT, " + PLANT_LIVE + " INT, " + PLANT_SOIL + " TEXT, " + PLANT_WATER + " TEXT, " + PLANT_WATERM+ " TEXT, " + PLANT_LOCATION  + " TEXT, " + PLANT_ADDINFO + " TEXT);";
        DB.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(String name, String contact, String live, String soil, String water,
                                  String waterm, String location, String addinfo)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLANT_NAME, name);
        contentValues.put(PLANT_BOX, contact);
        contentValues.put(PLANT_LIVE, live);
        contentValues.put(PLANT_SOIL, soil);
        contentValues.put(PLANT_WATER, water);
        contentValues.put(PLANT_WATERM, waterm);
        contentValues.put(PLANT_LOCATION, location);
        contentValues.put(PLANT_ADDINFO, addinfo);
        long result=DB.insert(TABLE_NAME, null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public Boolean updateuserdata(String name, String box, String live, String soil, String water,
                                  String waterm, String location, String addinfo) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PLANT_NAME, name);
        contentValues.put(PLANT_BOX, box);
        contentValues.put(PLANT_LIVE, live);
        contentValues.put(PLANT_SOIL, soil);
        contentValues.put(PLANT_WATER, water);
        contentValues.put(PLANT_WATERM, waterm);
        contentValues.put(PLANT_LOCATION, location);
        contentValues.put(PLANT_ADDINFO, addinfo);

        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}


    public Boolean deletedata (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }



    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;

    }
}