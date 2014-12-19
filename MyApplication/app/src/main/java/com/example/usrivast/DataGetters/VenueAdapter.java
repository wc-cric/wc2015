package com.example.usrivast.DataGetters;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usrivast.DataStorage.Venue;

import java.util.ArrayList;

/**
 * Created by usrivast on 17/12/14.
 */
public class VenueAdapter {

    private DataBaseHelper helper;
    private static final String VENUE_TABLE_NAME = "Venue";
    private static final String VENUE_UID = "_id";
    private static final String VENUE_NAME = "_name";
    private static final String VENUE_DESCRIPTION = "_desc";
    private static final String VENUE_COUNTRY = "_country";

    private ArrayList<Venue> venues;
    private boolean databaseCreated = false;

    private static VenueAdapter instance = null;
    public VenueAdapter(Context context)
    {
        helper = DataBaseHelper.getInstance(context);
        venues = new ArrayList<Venue>();
    }

    public static VenueAdapter getInstance(Context context) {
        if(instance == null) {
            instance = new VenueAdapter(context);
        }
        return instance;
    }

    public ArrayList<Venue> getVenues()
    {
        return venues;
    }

    public void createVenuesFromDatabase()
    {
        if(databaseCreated)
            return;
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {VENUE_UID, VENUE_NAME, VENUE_DESCRIPTION, VENUE_COUNTRY};
        Cursor cursor =  db.query(VENUE_TABLE_NAME, columns, null,null,null,null,null);
        while(cursor.moveToNext())
        {
            int cid = cursor.getInt(0);
            String venueName = cursor.getString(1);
            String description = cursor.getString(2);
            String country = cursor.getString(3);
            Venue venue = new Venue();
            venue.set_id(cid);
            venue.setName(venueName);
            venue.setDescription(description);
            venue.setCountry(country);
            venues.add(venue);
        }
        databaseCreated = true;
    }

}
