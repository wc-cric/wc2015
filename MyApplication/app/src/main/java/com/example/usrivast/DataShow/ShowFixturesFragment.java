package com.example.usrivast.DataShow;

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
public class ShowFixturesFragment extends Fragment {

    ListView fixturesList;

    public static Fragment newInstance(Context context) {
        ShowFixturesFragment f = new ShowFixturesFragment();

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_show_fixtures, null);
        fixturesList = (ListView)root.findViewById(R.id.activity_show_fixtures_listView);
        fixturesList.setAdapter(new FixturesViewAdapter(getActivity().getApplicationContext()));
        return root;
    }

}
