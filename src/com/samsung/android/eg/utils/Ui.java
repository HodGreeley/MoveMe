package com.samsung.android.eg.utils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.samsung.android.eg.moveme.Album;
import com.samsung.android.eg.moveme.ItemList;

public class Ui {
	public void setMode(FragmentManager manager, int mode) {
		FragmentTransaction transaction = manager.beginTransaction();
		
		if (mode == 0) {
			if (userFragment != null) {
				userFragment = changeFragment(transaction, userFragment, userContainerId, new Album(), "users");
			}
			
			if (favesFragment != null) {
				favesFragment = changeFragment(transaction, favesFragment, favesContainerId, new Album(), "faves");
			}
		}
		else {
			if (userFragment != null) {
				userFragment = changeFragment(transaction, userFragment, userContainerId, new ItemList(), "users");
			}
			
			if (favesFragment != null) {
				favesFragment = changeFragment(transaction, favesFragment, favesContainerId, new ItemList(), "faves");
			}			
		}

		transaction.commit();
	}

	private Fragment changeFragment(FragmentTransaction transaction, Fragment current, int viewId, Fragment next, String tag) {
		transaction.remove(current).add(viewId, next, tag);
	
		return next;
	}
	
	public void setUserFragment(Fragment fragment, int id) {
		userFragment = fragment;
		userContainerId = id;
	}
	
	public void setFavesFragment(Fragment fragment, int id) {
		favesFragment = fragment;
		favesContainerId = id;
	}
	
	private Ui() {};
	
	public static Ui getInstance() {
		if (ui == null) {
			ui = new Ui();
		}
		
		return ui;
	}
	
	public interface SelectionListener {
		public void onSelected(int position);
	}
	
	public String[] getModes() {
		return modes;
	}
	
	private Fragment userFragment = null;
	private int userContainerId;
	
	private Fragment favesFragment = null;
	private int favesContainerId;
	
	private static Ui ui = null;
	private static final String[] modes = { "Album", "List" };
}
