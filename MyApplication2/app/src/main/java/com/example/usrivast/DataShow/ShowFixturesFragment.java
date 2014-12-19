package com.example.usrivast.DataShow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by usrivast on 19/12/14.
 */
@SuppressLint("ValidFragment")
public class ShowFixturesFragment extends Fragment {

    ListView fixturesList;

    String team = "";
    public static Fragment newInstance(Context context, String ...params) {
        ShowFixturesFragment f; new ShowFixturesFragment("");
        if(params.length > 0)
        {
            f= new ShowFixturesFragment(params[0]);
        }
        else
        {
            f= new ShowFixturesFragment("");
        }
        return f;
    }

    @SuppressLint("ValidFragment")
    public ShowFixturesFragment(String t)
    {
        team = t;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_show_fixtures, null);
        fixturesList = (ListView)root.findViewById(R.id.activity_show_fixtures_listView);
        fixturesList.setAdapter(new FixturesViewAdapter(getActivity().getApplicationContext(), team));
        return root;
    }

}
