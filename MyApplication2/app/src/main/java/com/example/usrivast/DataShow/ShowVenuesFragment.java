
package com.example.usrivast.DataShow;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ShowVenuesFragment extends Fragment {

    ListView venuesList;
	public static Fragment newInstance(Context context) {
		ShowVenuesFragment f = new ShowVenuesFragment();
		
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_show_venues, null);
        venuesList = (ListView)root.findViewById(R.id.activity_show_venues_venueList);
        venuesList.setAdapter(new VenuesViewAdapter(getActivity().getApplicationContext()));
		return root;
	}
	
}
