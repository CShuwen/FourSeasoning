package com.example.fourseasoning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    //Constant fields
    private static final String DATABASE_NAME = "FourSeasoning.db";
    private static final int DATABASE_VER = 1;

    /*
    private static final String TABLE_NAME = "Userdetails";
    private static final String PLANT_NAME = "name";
    private static final String PLANT_BOX = "box";
    private static final String PLANT_LIVE= "live";
    private static final String PLANT_SOIL= "soil";
    private static final String PLANT_WATER = "water";
    private static final String PLANT_WATERM= "waterm";
    private static final String PLANT_LOCATION= "location"; //change to lighting
    private static final String PLANT_ADDINFO= "addinfo";
     */

    private static final String COLUMN_ID ="_id";
    private static final String TABLE_NAME = "my_plants";
    private static final String COLUMN_PLANT_NAME = "plant_name";
    private static final String COLUMN_BOX = "plant_box";
    private static final String COLUMN_MONTHS_TO_FULL = "plants_months";
    private static final String COLUMN_SOIL= "plant_soil";
    private static final String COLUMN_WATER_FREQUENCY= "plant_water_frequency";
    private static final String COLUMN_WATER_METHOD = "plant_water_method";
    private static final String COLUMN_LIGHT= "plant_light";
    private static final String COLUMN_ADDITIONAL_INFO = "plant_additional_info";

    public DatabaseHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VER);
        this.context = context;
    }

    //TABLE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_PLANT_NAME + " TEXT, " +
                        COLUMN_BOX + " TEXT, " +
                        COLUMN_MONTHS_TO_FULL + " TEXT, " +
                        COLUMN_SOIL + " TEXT, " +
                        COLUMN_WATER_FREQUENCY + " TEXT, " +
                        COLUMN_WATER_METHOD + " TEXT, " +
                        COLUMN_LIGHT + " TEXT, " +
                        COLUMN_ADDITIONAL_INFO + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //CREATE
    void addPlant(String plantName,
                  String box,
                  String monthsToFull,
                  String soilCondition,
                  String waterFrequency,
                  String waterMethod,
                  String lightingCondition,
                  String additionalInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        if(db == null){
            Log.d("db checker", "null data");
        }

        else{
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_PLANT_NAME,plantName);
            cv.put(COLUMN_BOX,box);
            cv.put(COLUMN_MONTHS_TO_FULL,monthsToFull);
            cv.put(COLUMN_SOIL, soilCondition);
            cv.put(COLUMN_WATER_FREQUENCY, waterFrequency);
            cv.put(COLUMN_WATER_METHOD, waterMethod);
            cv.put(COLUMN_LIGHT,lightingCondition);
            cv.put(COLUMN_ADDITIONAL_INFO,additionalInfo);

            long result = db.insert(TABLE_NAME,null,cv);
            if(result == -1){
                Toast.makeText(context,"Error. Failed to add plant.", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(context, "New plant added successfully.", Toast.LENGTH_SHORT).show();
            }
        }

    }

    //READ
    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    //UPDATE ALL
    void updateData(String plantId,
                    String plantName,
                    String box,
                    String monthsToFull,
                    String soilCondition,
                    String waterFrequency,
                    String waterMethod,
                    String lightingCondition,
                    String additionalInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PLANT_NAME,plantName);
        cv.put(COLUMN_BOX,box);
        cv.put(COLUMN_MONTHS_TO_FULL, monthsToFull);
        cv.put(COLUMN_SOIL, soilCondition);
        cv.put(COLUMN_WATER_FREQUENCY, waterFrequency);
        cv.put(COLUMN_WATER_METHOD, waterMethod);
        cv.put(COLUMN_LIGHT, lightingCondition);
        cv.put(COLUMN_ADDITIONAL_INFO, additionalInfo);

        long result = db.update(TABLE_NAME,cv,"_id=?", new String[]{plantId});
        if(result == -1){
            Toast.makeText(context, "Failed to update.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Successfully updated plant", Toast.LENGTH_SHORT).show();
        }
    }

    //DELETE ONE ROW
    void deleteOneRow(String plantId){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME,"_id=?", new String[]{plantId});
        if(result == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        }
    }

    //DELETE ALL
    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
}
