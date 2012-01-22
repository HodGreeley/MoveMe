package com.samsung.android.eg.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.samsung.android.eg.moveme.R;

public class ItemListAdapter<T> extends ArrayAdapter<T> {
	public ItemListAdapter(Context context, int layoutResourceId, T[] objects) {
		super(context, layoutResourceId, R.id.item_label, objects);
	}

	//@Override
	//public View getView(int position, View convertView, ViewGroup parent) {
	//	return null;	
	//}
}
