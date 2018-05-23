package com.example.fabio.tourguideapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AttractionActivity extends AppCompatActivity {
    private String name ="";
    private String description ="";
    private String address ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        TextView tvName = findViewById(R.id.attraction_name);
        TextView tvDescription = findViewById(R.id.attraction_description);
        TextView tvAddress = findViewById(R.id.attraction_address);
        ImageView img_photo = findViewById(R.id.attraction_photo);

        name = getIntent().getStringExtra("name");
        description = getIntent().getStringExtra("description");
        address = getIntent().getStringExtra("address");
        tvName.setText(name);
        tvDescription.setText(description);
        tvAddress.setText(address);
        img_photo.setImageResource(getIntent().getIntExtra("photo" , 0));
    }

    public void openMap(View view){
        // Create a new intent
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("description", description);
        intent.putExtra("address", address);

        // Start the new activity
        startActivity(intent);
    }
}
