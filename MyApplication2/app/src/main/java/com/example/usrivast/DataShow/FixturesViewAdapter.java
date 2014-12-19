package com.example.usrivast.DataShow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.usrivast.DataGetters.FixtureAdapter;
import com.example.usrivast.DataShow.R;
import com.example.usrivast.DataStorage.Fixture;

import java.util.ArrayList;

/**
 * Created by usrivast on 18/12/14.
 */
public class FixturesViewAdapter extends BaseAdapter{


    private ArrayList<Fixture> fixtures = new ArrayList<Fixture>();
    Context context;

    public FixturesViewAdapter(Context context)
    {
        this.context = context;
        fixtures = FixtureAdapter.getInstance(context).getFixtures();
    }

    @Override
    public int getCount() {
        return fixtures.size();
    }

    @Override
    public Object getItem(int position) {
        return fixtures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.fixture, parent, false);
        Button fixtureButton = (Button)row.findViewById(R.id.fixture_button);
        Fixture fixture = fixtures.get(position);
        String s =  "\n" + fixture.getCategory() + "\n" +
                    fixture.getTeam1().getTeamName() + " vs " + fixture.getTeam2().getTeamName() + "\n" +
                    "in " + fixture.getVenue().getName() + " on " + fixture.getDate() + " at " + fixture.getTime() + "\n";
        fixtureButton.setText(s);
        return row;
    }
}
