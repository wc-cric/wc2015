package com.example.usrivast.DataShow;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TeamInfoViewPagerAdapter extends FragmentPagerAdapter {
	private Context _context;

    private final int count = 3;
    private String teamName ="";

	public TeamInfoViewPagerAdapter(Context context, FragmentManager fm, String ...params) {
		super(fm);	
		_context=context;
		if(params.length > 0)
        {
            teamName = params[0];
        }
		}
	@Override
	public Fragment getItem(int position) {
		Fragment f = new Fragment();
		switch(position){
		case 0:
			f= ShowFixturesFragment.newInstance(_context, teamName);
			break;
		case 1:
			f= ShowFixturesFragment.newInstance(_context, teamName);
			break;
        case 2:
            f= ShowFixturesFragment.newInstance(_context, teamName);
            break;
		}
		return f;
	}
	@Override
	public int getCount() {
		return count;
	}

}
