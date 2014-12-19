package com.example.usrivast.DataStorage;

/**
 * Created by usrivast on 17/12/14.
 */
public class Team implements Item{

    private int _id;
    private String teamName;
    private String group;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean isSection() {
        return false;
    }

    @Override
    public boolean isTeam() {
        return true;
    }
}
