package com.example.usrivast.DataShow;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.usrivast.DataGetters.TeamAdapter;
import com.example.usrivast.DataStorage.Item;
import com.example.usrivast.DataStorage.SectionItem;
import com.example.usrivast.DataStorage.Team;
import com.example.usrivast.DataShow.R;

import java.util.ArrayList;

/**
 * Created by usrivast on 17/12/14.
 */
public class GroupAViewAdapter extends BaseAdapter {

    private ArrayList<Item> items = new ArrayList<Item>();
    Context context;

    public GroupAViewAdapter(Context context)
    {
        this.context = context;
        ArrayList<Team> allteams = TeamAdapter.getInstance(context).getAllTeams();
        items.add(new SectionItem("Pool A"));
        for(int i = 0; i < allteams.size(); i++)
        {
            Team team = allteams.get(i);
            if(team.getGroup().contains("A"))
            {
                items.add(team);
            }
        }
        items.add(new SectionItem("Pool B"));
        for(int i = 0; i < allteams.size(); i++)
        {
            Team team = allteams.get(i);
            if(team.getGroup().contains("B"))
            {
                items.add(team);
            }
        }
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



        final Item i = items.get(position);
        if (i != null) {
            if(i.isSection()){
                SectionItem si = (SectionItem)i;
                View row = layoutInflater.inflate(R.layout.team_section, parent, false);
                final TextView sectionView = (TextView) row.findViewById(R.id.team_section_textView);
                sectionView.setText(si.getTitle());
                return row;
            }else if(i.isTeam()){
                final Team ei = (Team)i;
                View row = layoutInflater.inflate(R.layout.teams, parent, false);
                row.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context, ShowTeamInfo.class);
                        i.putExtra("teamName", ei.getTeamName());
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(i);
                    }
                });
                TextView t = (TextView)row.findViewById(R.id.smallteamtextview);
                t.setText(ei.getTeamName());
                return row;
            }
        }

        return convertView;
    }
}
