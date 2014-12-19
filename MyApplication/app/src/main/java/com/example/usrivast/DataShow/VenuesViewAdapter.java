package com.example.usrivast.DataShow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.usrivast.DataGetters.VenueAdapter;
import com.example.usrivast.DataStorage.Venue;
import com.example.usrivast.DataShow.R;

import java.util.ArrayList;

/**
 * Created by usrivast on 18/12/14.
 */
public class VenuesViewAdapter extends BaseAdapter{

    private ArrayList<Venue> venues;
    Context context;

    public VenuesViewAdapter(Context context)
    {
        this.context = context;
        venues = VenueAdapter.getInstance(context).getVenues();
    }

    @Override
    public int getCount() {
        return venues.size();
    }

    @Override
    public Object getItem(int position) {
        return venues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.venue, parent, false);

        Button venueButton = (Button)row.findViewById(R.id.venue_button);
        Venue v = venues.get(position);
        venueButton.setText("\n" + v.getName() + " (" + v.getCountry() + ")\n\n" + v.getDescription() + "\n");
        venueButton.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        return row;
    }

}
