package com.samsung.android.eg.moveme;

import android.app.Activity;
import android.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.samsung.android.eg.moveme.Data.AlbumItem;
import com.samsung.android.eg.utils.ItemListAdapter;
import com.samsung.android.eg.utils.Ui;

public class ItemList extends ListFragment {
    @Override
    public void onAttach(Activity activity) {
    	super.onAttach(activity);

    	setListAdapter(new ItemListAdapter<AlbumItem>(activity, R.layout.list_item, Data.getData(getTag())));		
    }

	@Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
    	listener.onSelected(pos);
    }

    private Ui.SelectionListener listener;
}