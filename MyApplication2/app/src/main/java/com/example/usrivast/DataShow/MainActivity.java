package com.example.usrivast.DataShow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.usrivast.DataGetters.DataBaseHelper;
import com.example.usrivast.DataGetters.FixtureAdapter;
import com.example.usrivast.DataGetters.TeamAdapter;
import com.example.usrivast.DataGetters.VenueAdapter;

import java.io.IOException;


public class MainActivity extends FragmentActivity {
    private ViewPager _mViewPager;
    private ViewPagerAdapter _adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadDataFromDatabase(getApplicationContext());

        setUpView();
        setTab();
    }

    private void loadDataFromDatabase(Context context)
    {
        try {
            DataBaseHelper.getInstance(context).createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TeamAdapter.getInstance(context).createTeamsFromDatabase();
        VenueAdapter.getInstance(context).createVenuesFromDatabase();
        FixtureAdapter.getInstance(context).createFixturesFromDatabase();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpView(){
        _mViewPager = (ViewPager) findViewById(R.id.viewPager);
        _adapter = new ViewPagerAdapter(getApplicationContext(),getSupportFragmentManager());
        _mViewPager.setAdapter(_adapter);
        _mViewPager.setCurrentItem(0);
    }
    private void setTab(){
        _mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrollStateChanged(int position) {}
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {}
            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                switch(position){
                    case 0:
                        findViewById(R.id.first_tab).setVisibility(View.VISIBLE);
                        findViewById(R.id.second_tab).setVisibility(View.INVISIBLE);
                        findViewById(R.id.third_tab).setVisibility(View.INVISIBLE);
                        break;

                    case 1:
                        findViewById(R.id.first_tab).setVisibility(View.INVISIBLE);
                        findViewById(R.id.second_tab).setVisibility(View.VISIBLE);
                        findViewById(R.id.third_tab).setVisibility(View.INVISIBLE);
                        break;

                    case 2:
                        findViewById(R.id.first_tab).setVisibility(View.INVISIBLE);
                        findViewById(R.id.second_tab).setVisibility(View.INVISIBLE);
                        findViewById(R.id.third_tab).setVisibility(View.VISIBLE);
                        break;
                }
            }

        });

    }
}
