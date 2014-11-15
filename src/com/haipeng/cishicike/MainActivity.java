package com.haipeng.cishicike;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import com.haipeng.cishicike.R;

public class MainActivity extends ActionBarActivity {

	ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionBar = getSupportActionBar();
		actionBar.setDisplayShowCustomEnabled(true);
		View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.customer_main, new LinearLayout(this),false);
		actionBar.setCustomView(view);
		Drawable drawable =getResources().getDrawable(R.drawable.main_background); 
		actionBar.setBackgroundDrawable(drawable);

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
