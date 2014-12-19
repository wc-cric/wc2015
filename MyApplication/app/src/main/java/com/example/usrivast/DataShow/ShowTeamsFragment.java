
package com.example.usrivast.DataShow;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ShowTeamsFragment extends Fragment {

    ListView groupAList;
    ListView groupBList;

	public static Fragment newInstance(Context context) {
		ShowTeamsFragment f = new ShowTeamsFragment();
		
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_show_teams, null);
        groupAList = (ListView)root.findViewById(R.id.groupAListView);
        groupBList = (ListView)root.findViewById(R.id.groupBListView);
        groupAList.setAdapter(new GroupAViewAdapter(getActivity().getApplicationContext()));
        groupBList.setAdapter(new GroupBViewAdapter(getActivity().getApplicationContext()));
		return root;
	}
	
}
