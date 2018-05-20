package com.example.fabio.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AttractionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);
    }

    public void openMap(View view){
        // Create a new intent
        Intent intent = new Intent(this, MapActivity.class);
        /*intent.putExtra("name", attractions.get(i).getName());
        intent.putExtra("description", attractions.get(i).getDescription());
        intent.putExtra("address", attractions.get(i).getAddress());*/

        // Start the new activity
        startActivity(intent);
    }
}
