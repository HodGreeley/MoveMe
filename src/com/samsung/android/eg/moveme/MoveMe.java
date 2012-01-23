package com.samsung.android.eg.moveme;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.samsung.android.eg.utils.Ui;

public class MoveMe extends Activity {
	@Override
    public void onCreate(Bundle savedState) {
		super.onCreate(savedState);

		ui = Ui.getInstance();
        setContentView(R.layout.main);
        enableDropDown();
	}

    private void enableDropDown() {
		BaseAdapter menuSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ui.getModes());

		ActionBar.OnNavigationListener listener = new ActionBar.OnNavigationListener() {
			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) {
				ui.setMode(getFragmentManager(), itemPosition);
				
			    return true;
			}
		};
		
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setListNavigationCallbacks(menuSpinner, listener);
	}

	private Ui ui;
}
