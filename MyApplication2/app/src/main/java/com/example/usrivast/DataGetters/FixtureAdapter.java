package com.example.usrivast.DataGetters;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usrivast.DataStorage.Fixture;
import com.example.usrivast.DataStorage.Team;
import com.example.usrivast.DataStorage.Venue;

import java.util.ArrayList;

/**
 * Created by usrivast on 17/12/14.
 */
public class FixtureAdapter {

    private DataBaseHelper helper;
    private static final String FIXTURE_TABLE_NAME = "FIXTURE";
    private static final String FIXTURE_UID = "_id";
    private static final String FIXTURE_TEAM1 = "_team1";
    private static final String FIXTURE_TEAM2 = "_team2";
    private static final String FIXTURE_VENUE = "_venue";
    private static final String FIXTURE_DATE = "_date";
    private static final String FIXTURE_TIME = "_time";
    private static final String FIXTURE_CATEGORY = "_category";
    private ArrayList<Fixture> fixtures;
    private  boolean databaseCreated = false;
    private static FixtureAdapter instance = null;
    protected FixtureAdapter(Context context)
    {
        helper = DataBaseHelper.getInstance(context);
        fixtures = new ArrayList<Fixture>();
    }

    public ArrayList<Fixture> getFixtures()
    {
        return  fixtures;
    }

    public static FixtureAdapter getInstance(Context context) {
        if(instance == null) {
            instance = new FixtureAdapter(context);
        }
        return instance;
    }

    public void createFixturesFromDatabase()
    {
        if(databaseCreated)
            return;
        SQLiteDatabase db = helper.getWritableDatabase();
        String[] columns = {FIXTURE_UID, FIXTURE_TEAM1, FIXTURE_TEAM2, FIXTURE_VENUE,
                 FIXTURE_DATE, FIXTURE_TIME, FIXTURE_CATEGORY};
        Cursor cursor =  db.query(FIXTURE_TABLE_NAME, columns, null,null,null,null,null);
        while(cursor.moveToNext())
        {
            int cid = cursor.getInt(0);
            String team1Name = cursor.getString(1);
            String team2Name = cursor.getString(2);
            String venueName = cursor.getString(3);
            String date = cursor.getString(4);
            String time = cursor.getString(5);
            String category = cursor.getString(6);
            Fixture fixture = new Fixture();
            fixture.set_id(cid);
            Team team1 = new Team();
            team1.setTeamName(team1Name);
            Team team2 = new Team();
            team2.setTeamName(team2Name);
            Venue v = new Venue();
            v.setName(venueName);
            fixture.setTeam1(team1);
            fixture.setTeam2(team2);
            fixture.setVenue(v);
            fixture.setDate(date);
            fixture.setTime(time);
            fixture.setCategory(category);
            fixtures.add(fixture);
        }
        databaseCreated = true;
    }
}
