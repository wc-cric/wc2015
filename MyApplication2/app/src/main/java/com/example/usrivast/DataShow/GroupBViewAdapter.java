package com.example.usrivast.DataShow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.usrivast.DataGetters.TeamAdapter;
import com.example.usrivast.DataStorage.Team;
import com.example.usrivast.DataShow.R;

import java.util.ArrayList;

/**
 * Created by usrivast on 17/12/14.
 */
public class GroupBViewAdapter extends BaseAdapter {

    private ArrayList<Team> teams = new ArrayList<Team>();
    Context context;

    public GroupBViewAdapter(Context context)
    {
        this.context = context;
        ArrayList<Team> allteams = TeamAdapter.getInstance(context).getAllTeams();
        for(int i = 0; i < allteams.size(); i++)
        {
            Team team = allteams.get(i);
            if(team.getGroup().contains("B"))
            {
                teams.add(team);
            }
        }
    }

    @Override
    public int getCount() {
        return teams.size();
    }

    @Override
    public Object getItem(int position) {
        return teams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.teams, parent, false);
        TextView t = (TextView)row.findViewById(R.id.smallteamtextview);
        t.setText(teams.get(position).getTeamName());
        return row;
    }
}
