package com.samsung.android.eg.moveme;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.samsung.android.eg.moveme.Data.AlbumItem;
import com.samsung.android.eg.utils.ItemListAdapter;
import com.samsung.android.eg.utils.Ui;

public class ItemList extends ListFragment {
	public ItemList(Context context, AlbumItem[] items) {
    	setListAdapter(new ItemListAdapter<AlbumItem>(context, R.layout.list_item, items));		
    	listener = (Ui.SelectionListener)context;
	}

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
    	listener.onSelected(pos);
    }

    private Ui.SelectionListener listener;
}