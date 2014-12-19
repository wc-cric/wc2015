package com.example.usrivast.DataShow;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
	private Context _context;

    private final int count = 3;
	
	public ViewPagerAdapter(Context context, FragmentManager fm) {
		super(fm);	
		_context=context;
		
		}
	@Override
	public Fragment getItem(int position) {
		Fragment f = new Fragment();
		switch(position){
		case 0:
			f= ShowTeamsFragment.newInstance(_context);
			break;
		case 1:
			f= ShowVenuesFragment.newInstance(_context);
			break;
        case 2:
            f= ShowFixturesFragment.newInstance(_context);
            break;
		}
		return f;
	}
	@Override
	public int getCount() {
		return count;
	}

}
