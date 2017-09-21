package com.example.pdavis11.eventslist;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {
    /**
     * Loads ImageView, EventTitleTextView, and EventDetailsTextView
     *
     * @param savedInstanceState Loads any saved instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        // Get the data out of the intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String details = intent.getStringExtra("details");

        ImageView eventImageView = (ImageView) findViewById(R.id.eventImageView);

        // Create references to the text views
        TextView titleTextView = (TextView) findViewById(R.id.eventTitleTextView);
        TextView detailsTitleView = (TextView) findViewById(R.id.eventDetailsTextView);

        // Set the text of the the text views
        titleTextView.setText(title);
        detailsTitleView.setText(details);

        // Use the asset manager to retrieve a file (image)
        AssetManager am = this.getAssets();
        String imageFileName = title.replace(" ", "") + ".jpeg";
        // Use AssetManager to open a stream to the file name.
        try{
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(image);
        } catch (IOException e){
            Log.e("OC Music Events", "Error loading image:" + imageFileName);
        }

    }

    /**
     * Returns to user to eventsList
     *
     * @param v reads button click
     */
    protected void goBackToList(View v)
    {
        // Terminates the current activity (terminates the details activity)
        finish();
    }
}
