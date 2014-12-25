package com.haipeng.cishicike;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

public class BaseActivity extends ActionBarActivity {
	ActionBar actionBar;
	ActionBarDrawerToggle drawerToggle;
	DrawerLayout drawerLayout;
	ListView drawerListView;
	DrawerAdapter drawerAdapter;
	List<String> mList = new ArrayList<String>();
	FrameLayout frameLayout;
	LayoutInflater inflator = getLayoutInflater();
	protected TextView mTitleView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer_layout);
	}

	public void init(Activity activity, int layoutID) {
		actionBar = getSupportActionBar();
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.actionbar_background));
		drawerLayout = (DrawerLayout) findViewById(R.id.toggle_container);
		drawerListView = (ListView) findViewById(R.id.toggle_listView);

		frameLayout = (FrameLayout) findViewById(R.id.toggle_frameLayout);

		// Toggle视图
		drawerToggle = new ActionBarDrawerToggle(activity, drawerLayout,
				R.drawable.ic_drawer, R.string.string_drawer_open) {

			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerClosed(drawerView);
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerOpened(drawerView);
				invalidateOptionsMenu();
			}

		};
		drawerLayout.setDrawerListener(drawerToggle);

		String[] drawers = getResources().getStringArray(
				R.array.string_array_drawer);
		for (String str : drawers) {
			mList.add(str);
		}
		drawerAdapter = new DrawerAdapter(activity, mList);
		drawerListView.setAdapter(drawerAdapter);
		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// ActionBar的视图View
		View titleView = inflator.inflate(R.layout.customer_main, null);
		if (titleView != null) {
			mTitleView = (TextView) titleView.findViewById(R.id.headerTitle);

			actionBar.setDisplayShowCustomEnabled(true);
			actionBar.setDisplayShowTitleEnabled(false);
			actionBar.setLogo(getResources().getDrawable(R.drawable.ic_wfa));
			actionBar.setCustomView(titleView);
		}

		// FrameLayout的视图
		View view = inflator.inflate(layoutID, null);
		frameLayout.addView(view);
		//
	}
	

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		if (null == drawerToggle) {
			return false;
		}
		return drawerToggle.onOptionsItemSelected(item);
	}
}

