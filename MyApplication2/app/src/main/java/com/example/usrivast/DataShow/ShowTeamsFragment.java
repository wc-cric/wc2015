
package com.example.usrivast.DataShow;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ShowTeamsFragment extends Fragment {

    ListView teamList;

	public static Fragment newInstance(Context context) {
		ShowTeamsFragment f = new ShowTeamsFragment();
		
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_show_teams, null);
        teamList = (ListView)root.findViewById(R.id.teamListView);
        teamList.setAdapter(new GroupAViewAdapter(getActivity().getApplicationContext()));
		return root;
	}
	
}
