package com.example.fourseasoning;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database extends AppCompatActivity {
    EditText name, contact, live, soil, water, waterm, location, addinfo;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        live = findViewById(R.id.live);
        soil = findViewById(R.id.soil);
        water = findViewById(R.id.water);
        waterm = findViewById(R.id.waterm);
        location = findViewById(R.id.location);
        addinfo = findViewById(R.id.addinfo);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String liveTXT = live.getText().toString();
                String soilTXT = soil.getText().toString();
                String waterTXT = water.getText().toString();
                String watermTXT = waterm.getText().toString();
                String locationTXT = location.getText().toString();
                String addinfoTXT = addinfo.getText().toString();

                Boolean checkinsertdata = DB.insertUserData(nameTXT,
                        contactTXT,
                        liveTXT ,
                        soilTXT,
                        waterTXT,
                        watermTXT,
                        locationTXT,
                        addinfoTXT);

                if(checkinsertdata)
                    Toast.makeText(Database.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Database.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String liveTXT = live.getText().toString();
                String soilTXT = soil.getText().toString();
                String waterTXT = water.getText().toString();
                String watermTXT = waterm.getText().toString();
                String locationTXT = location.getText().toString();
                String addinfoTXT = addinfo.getText().toString();

                Boolean checkupdatedata = DB.updateUserData(
                        nameTXT,
                        contactTXT,
                        liveTXT,
                        soilTXT,
                        waterTXT,
                        watermTXT,
                        locationTXT,
                        addinfoTXT);
                if(checkupdatedata)
                    Toast.makeText(Database.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Database.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deleteData(nameTXT);
                if(checkudeletedata)
                    Toast.makeText(Database.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Database.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getData();
                if(res.getCount()==0){
                    Toast.makeText(Database.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Box number :"+res.getString(1)+"\n");
                    buffer.append("Months to full maturity :"+res.getString(2)+"\n\n");
                    buffer.append("Soil condition :"+res.getString(3)+"\n\n\n");
                    buffer.append("Water frequency :"+res.getString(4)+"\n\n\n\n");
                    buffer.append("Water method :"+res.getString(5)+"\n\n\n\n\n");
                    buffer.append("Location :"+res.getString(6)+"\n\n\n\n\n\n");
                    buffer.append("Additional info :"+res.getString(7)+"\n\n\n\n\n\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(Database.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }}