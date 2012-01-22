package com.samsung.android.eg.moveme;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.samsung.android.eg.utils.Ui;

public class MoveMe extends Activity implements Ui.SelectionListener {
	@Override
    public void onCreate(Bundle savedState) {
		super.onCreate(savedState);
        setContentView(R.layout.main);
        
        initFragments();
        enableDropDown();
	}

	private void initFragments() {
		manager = getFragmentManager();

		album = (Album)manager.findFragmentById(R.id.user_album);
		album.setItems(Data.getUsers());

		itemList = new ItemList(this, Data.getUsers());
	}
	
    private void enableDropDown() {
		BaseAdapter menuSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, new String[] { "Album", "List" });

		ActionBar.OnNavigationListener listener = new ActionBar.OnNavigationListener() {
			
			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) {
				Fragment fragment = (itemPosition == 0 ? album : itemList);
			    FragmentTransaction transaction = manager.beginTransaction();
			    transaction.replace(R.id.user_album, fragment);
			    transaction.commit();
			    
			    return true;
			}
		};
		
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setListNavigationCallbacks(menuSpinner, listener);
	}

	@Override
	public void onSelected(int position) {
	}
	
	private FragmentManager manager;
	private Album album;
	private ItemList itemList;
}
