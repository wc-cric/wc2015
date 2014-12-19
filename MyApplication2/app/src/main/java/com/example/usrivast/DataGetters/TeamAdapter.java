package com.example.usrivast.DataGetters;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usrivast.DataStorage.Team;

import java.util.ArrayList;


public class TeamAdapter {

    private static final String DATABASE_NAME = "worldcup2015";
    private static final String TABLE_NAME = "TEAM";
    private static final String UID = "_id";
    private static final String NAME = "_name";
    private static final String GROUP = "_group";
    private DataBaseHelper helper;
    private boolean databaseCreated = false;

    private ArrayList<Team> teams;

    private static TeamAdapter instance = null;
    protected TeamAdapter(Context context)
    {
        helper = DataBaseHelper.getInstance(context);
        teams = new ArrayList<Team>();
    }

    public ArrayList<Team> getAllTeams()
    {
        return teams;
    }

    public static TeamAdapter getInstance(Context context) {
        if(instance == null) {
            instance = new TeamAdapter(context);
        }
        return instance;
    }

    public void createTeamsFromDatabase()
    {
        if(databaseCreated)
            return;
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {UID, NAME, GROUP};
        Cursor cursor =  db.query(TABLE_NAME, columns, null,null,null,null,null);
        while(cursor.moveToNext())
        {
            int cid = cursor.getInt(0);
            String teamName = cursor.getString(1);
            String group = cursor.getString(2);
            Team team = new Team();
            team.set_id(cid);
            team.setTeamName(teamName);
            team.setGroup(group);
            teams.add(team);
        }
        databaseCreated = true;
    }


}
