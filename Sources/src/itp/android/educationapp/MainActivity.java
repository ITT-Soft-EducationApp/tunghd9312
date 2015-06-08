package itp.android.educationapp;

import itp.android.educationapp.adapter.NavDrawerListAdapter;
import itp.android.educationapp.fragment.CaidatFragment;
import itp.android.educationapp.fragment.DanhSachTruongFragment;
import itp.android.educationapp.fragment.NhungDieuCanBietFragment;
import itp.android.educationapp.fragment.TinTuyenSinhFragment;
import itp.android.educationapp.fragment.TraCuuDiemThiFragment;
import itp.android.educationapp.fragment.TuVanFragment;
import itp.android.educationapp.model.NavDrawer;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawer> navDrawerItems;
	private NavDrawerListAdapter adapter;
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		View footer = getLayoutInflater().inflate(R.layout.drawer_list_footer, null);

		mTitle = mDrawerTitle = getTitle();

		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
		mDrawerList.addFooterView(footer);
		addLeftMenuItem();
		// Recycle the typed array
		navMenuIcons.recycle();

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		actionBar = getSupportActionBar();
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.tranlucent_bg_a));
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, // nav menu toggle icon
				R.string.tuychon, // nav drawer open - description for
									// accessibility
				R.string.tuychon // nav drawer close - description for
									// accessibility
		) {
			public void onDrawerClosed(View view) {
				 actionBar.setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				 actionBar.setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}

	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	void hideKeyboard(){
		View v = getCurrentFocus();
		if (v != null) {
			InputMethodManager inputManager = (InputMethodManager) getApplication()
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			inputManager.hideSoftInputFromWindow(v.getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}

	/***
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		hideKeyboard();
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new TinTuyenSinhFragment();
			break;
		case 1:
			fragment = new DanhSachTruongFragment();
			break;
		case 2:
			fragment = new TraCuuDiemThiFragment();
			break;
		case 3:
			fragment = new NhungDieuCanBietFragment();
			break;
		case 4:
			fragment = new TuVanFragment();
			break;
		case 5:
			fragment = new CaidatFragment();
			break;

		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		 actionBar.setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	void addLeftMenuItem() {
		navDrawerItems = new ArrayList<NavDrawer>();
		String nhungdieucanbiet = getResources().getString(
				R.string.nhungdieucanbiet);
		String khac = getResources().getString(R.string.khac);

		// Tin Tuyen sinh <= need a Title here
		String tintuyensinh = getResources().getString(R.string.tuyensinh);
		navDrawerItems.add(new NavDrawer(navMenuTitles[0], navMenuIcons
				.getResourceId(0, -1), true, tintuyensinh));
		// Danh sach truong DHCD
		navDrawerItems.add(new NavDrawer(navMenuTitles[1], navMenuIcons
				.getResourceId(1, -1), false));
		// Tra Cuu diem thi
		navDrawerItems.add(new NavDrawer(navMenuTitles[2], navMenuIcons
				.getResourceId(2, -1), false));
		// Nhung dieu can biet <= need a Title here
		// navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons
		// .getResourceId(3, -1), true, nhungdieucanbiet));
		navDrawerItems.add(new NavDrawer(navMenuTitles[3], navMenuIcons
				.getResourceId(3, -1), true, nhungdieucanbiet));

		// Tu van <= need a Title here
		navDrawerItems.add(new NavDrawer(navMenuTitles[4], navMenuIcons
				.getResourceId(4, -1), true, khac));
		navDrawerItems.add(new NavDrawer(navMenuTitles[5], navMenuIcons
				.getResourceId(5, -1), false));
	}
}