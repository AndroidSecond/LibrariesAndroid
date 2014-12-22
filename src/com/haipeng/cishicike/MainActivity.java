package com.haipeng.cishicike;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.haipeng.cishicike.R;

public class MainActivity extends ActionBarActivity {

	ActionBar actionBar;
	ActionBarDrawerToggle drawerToggle;
	DrawerLayout drawerLayout;
	ListView drawerListView;
    DrawerAdapter drawerAdapter;
	List<String> mList = new ArrayList<String>();
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer_layout);
		actionBar = getSupportActionBar();
		View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.customer_main, new LinearLayout(this),false);
		actionBar.setCustomView(view);
		Drawable drawable =getResources().getDrawable(R.drawable.main_background); 
		actionBar.setBackgroundDrawable(drawable);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		drawerLayout = (DrawerLayout) findViewById(R.id.toggle_container);
		drawerListView = (ListView) findViewById(R.id.toggle_listView);
		
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.string_drawer_open);
		
        drawerLayout.setDrawerListener(drawerToggle);
        
        String[] drawers = getResources().getStringArray(R.array.string_array_drawer);
        for(String str:drawers)
        {
        	mList.add(str);
        }
        drawerAdapter = new DrawerAdapter(this, mList);
        drawerListView.setAdapter(drawerAdapter);
	}
      
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return false;
//	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
////		return super.onOptionsItemSelected(item);
//	}
}
