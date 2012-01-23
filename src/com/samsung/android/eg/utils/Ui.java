package com.samsung.android.eg.utils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.samsung.android.eg.moveme.Album;
import com.samsung.android.eg.moveme.Data;
import com.samsung.android.eg.moveme.ItemInfo;
import com.samsung.android.eg.moveme.ItemList;
import com.samsung.android.eg.moveme.R;

public class Ui {
	public void setMode(int m) {
		mode = m;
		
		FragmentTransaction transaction = manager.beginTransaction();

		if (hasUsers == true) {
			Fragment fragment = (mode == 0 ? new Album() : new ItemList());
			((ItemInfo)fragment).setItems(Data.getUsers());
			transaction.replace(R.id.users, fragment, "users");
		}

		if (hasFaves == true) {
			Fragment fragment = (mode == 0 ? new Album() : new ItemList());
			((ItemInfo)fragment).setItems(Data.getFaves(0));
			transaction.replace(R.id.faves, fragment, "faves");
		}

		transaction.commit();
	}

	public void onItemSelected(int id, String tag) {
		if (tag.compareTo("faves") == 0) {
			//play(id);
			
			return;
		}

		FragmentTransaction transaction = manager.beginTransaction();

		int viewId = (hasFaves ? R.id.faves : R.id.users);
		Fragment fragment = (mode == 0 ? new Album() : new ItemList());

		((ItemInfo)fragment).setItems(Data.getFaves(id));

		transaction.replace(viewId, fragment, "faves");
		transaction.addToBackStack(null);
		transaction.commit();
	}

	public void registerFragment(Fragment fragment) {
		if (fragment.getTag().compareTo("users") == 0) {
			hasUsers = fragment.isInLayout();
		}
		else {
			hasFaves = fragment.isInLayout();
		}
	}
	
	public void setFragmentManager(FragmentManager fm) {
		manager = fm;
	}
	
	private Ui() { super(); };
	
	public static Ui getInstance() {
		if (ui == null) {
			ui = new Ui();
		}
		
		return ui;
	}
	
	public String[] getModes() {
		return modes;
	}
	
	private static Ui ui = null;

	private FragmentManager manager;
	
	private boolean hasUsers = false;
	private boolean hasFaves = false;
	
	private static final String[] modes = { "Album", "List" };
	private static int mode = 0;
}
