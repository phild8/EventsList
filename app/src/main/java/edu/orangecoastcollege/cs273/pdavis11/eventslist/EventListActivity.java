package edu.orangecoastcollege.cs273.pdavis11.eventslist;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Events to the List activity
 */
public class EventListActivity extends ListActivity {

    /**
     * Loads a list of titles instead of setContentView
     * @param savedInstanceState loads any saved preferences
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Content has already been set for ListActivity
        // setContentView(R.layout.activity_event_list);

        // Define a built-in list adapter for this ListActivity:
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));

    }

    /**
     * sends an intent of titles and details to EventDetailsActivity.java
     * @param l the listView of titles
     * @param v the listView clicked
     * @param position where the click occurred in the list
     * @param id of the list
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        // Use the position in the list to look up in the titles array
        String title = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        // Create an intent to go to DetailsActivity with title and details sent
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("title", title); // K V
        detailsIntent.putExtra("details", details); // K V

        startActivity(detailsIntent);

    }

}
