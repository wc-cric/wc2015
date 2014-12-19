package com.example.usrivast.DataShow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usrivast.DataGetters.FixtureAdapter;
import com.example.usrivast.DataGetters.VenueAdapter;
import com.example.usrivast.DataShow.R;
import com.example.usrivast.DataStorage.Fixture;
import com.example.usrivast.DataStorage.Venue;

import java.util.ArrayList;

/**
 * Created by usrivast on 18/12/14.
 */
public class FixturesViewAdapter extends BaseAdapter{


    private ArrayList<Fixture> fixtures = new ArrayList<Fixture>();
    Context context;

    public FixturesViewAdapter(Context context, String ...params)
    {
        this.context = context;

        if(params.length > 0)
        {
            ArrayList<Fixture> tempList = FixtureAdapter.getInstance(context).getFixtures();
            for(int i = 0; i < tempList.size();i++)
            {
                Fixture f = tempList.get(i);
                String t1 = f.getTeam1().getTeamName();
                String t2 = f.getTeam2().getTeamName();
                if(t1.contains(params[0]) || t2.contains(params[0]))
                {
                    fixtures.add(f);
                }
            }
        }
        else
        {
            fixtures = FixtureAdapter.getInstance(context).getFixtures();
        }
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

        Fixture fixture = fixtures.get(position);
        int k1 = context.getResources().getIdentifier("a1","drawable",context.getPackageName());
        ImageView i1 = (ImageView)row.findViewById(R.id.fixture_team1imageView);
        i1.setImageResource(k1);

        int k2 = context.getResources().getIdentifier("a2","drawable",context.getPackageName());
        ImageView i2 = (ImageView)row.findViewById(R.id.fixture_team2imageView);
        i2.setImageResource(k2);

        TextView smallText = (TextView)row.findViewById(R.id.fixture_smalltextview);

        smallText.setText(fixture.getTeam1().getTeamName()+ " vs " + fixture.getTeam2().getTeamName() +"\n" + "(" + fixture.getCategory() + ")");
        TextView largeText = (TextView)row.findViewById(R.id.fixture_largetextView);
        largeText.setText(fixture.getVenue().getName() + "\n" + fixture.getDate() + ", " + fixture.getTime());

        return row;
    }
}
