package com.samsung.android.eg.moveme;

import android.app.Activity;
import android.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.samsung.android.eg.moveme.Data.AlbumItem;
import com.samsung.android.eg.utils.ItemListAdapter;
import com.samsung.android.eg.utils.Ui;

public class ItemList extends ListFragment implements ItemInfo {
    @Override
    public void onAttach(Activity activity) {
    	super.onAttach(activity);

    	ui = Ui.getInstance();
    	
    	if (albumItems == null) setItems(Data.getData(getTag()));		
    	
    	setListAdapter(new ItemListAdapter<AlbumItem>(getActivity(), R.layout.list_item, albumItems));
    	
	    ui.registerFragment(this);
    }

	@Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
		ui.onItemSelected(pos, getTag());
    }

	public void setItems(AlbumItem[] items) {
		albumItems = items;
	}

	private Ui ui;
	private AlbumItem[] albumItems = null;
}