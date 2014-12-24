package com.haipeng.cishicike;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.haipeng.cishicike.R;

public class MainActivity extends ActionBarActivity {

	ActionBar actionBar;
	ActionBarDrawerToggle drawerToggle;
	DrawerLayout drawerLayout;
	ListView drawerListView;
	DrawerAdapter drawerAdapter;
	List<String> mList = new ArrayList<String>();
	protected TextView mTitleView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer_layout);
		actionBar = getSupportActionBar();
		// View view =
		// LayoutInflater.from(MainActivity.this).inflate(R.layout.customer_main,
		// new LinearLayout(this),false);
		// actionBar.setCustomView(view);

		// Drawable drawable
		// =getResources().getDrawable(R.drawable.main_background);
		// actionBar.setBackgroundDrawable(drawable);
		// actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.actionbar_background));
		drawerLayout = (DrawerLayout) findViewById(R.id.toggle_container);
		drawerListView = (ListView) findViewById(R.id.toggle_listView);

		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
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
		drawerAdapter = new DrawerAdapter(this, mList);
		drawerListView.setAdapter(drawerAdapter);
		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		LayoutInflater inflator = getLayoutInflater();
		View titleView = inflator.inflate(R.layout.customer_main, null);
		if (titleView != null) {
			mTitleView = (TextView) titleView.findViewById(R.id.headerTitle);

			actionBar.setDisplayShowCustomEnabled(true);
			actionBar.setDisplayShowTitleEnabled(false);
			actionBar.setLogo(getResources().getDrawable(R.drawable.ic_wfa));
			actionBar.setCustomView(titleView);
			//
		}

	}

	// @Override
	// public boolean onKeyDown(int keyCode, KeyEvent e) {
	// if (keyCode == KeyEvent.KEYCODE_MENU) {
	// if (drawerLayout.isDrawerOpen(drawerListView))
	// drawerLayout.closeDrawer(drawerListView);
	// else
	// drawerLayout.openDrawer(drawerListView);
	// return true;
	// }
	// if (keyCode == KeyEvent.KEYCODE_BACK && e.getRepeatCount() == 0) {
	// if (drawerLayout.isDrawerOpen(drawerListView))
	// drawerLayout.closeDrawer(drawerListView);
	//
	// return true;
	// }
	// return super.onKeyDown(keyCode, e);
	// }

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return false;
	// }

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
