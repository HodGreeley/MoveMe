package com.samsung.android.eg.moveme;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;

import com.samsung.android.eg.moveme.Data.AlbumItem;
import com.samsung.android.eg.utils.ImageAdapter;
import com.samsung.android.eg.utils.Ui;

public class Album extends Fragment implements ItemInfo {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
    	ui = Ui.getInstance();
    	
		View view = inflater.inflate(R.layout.album, container, false);

		gallery = (Gallery)view.findViewById(R.id.gallery);
	    
		if (albumItems == null) setItems(Data.getData(getTag()));

	    gallery.setAdapter(new ImageAdapter(getActivity(), albumItems));
		
	    gallery.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	    		ui.onItemSelected(position, getTag());
	        }
	    });
	    
	    ui.registerFragment(this);

        return view;
	}

	public void setItems(AlbumItem[] items) {
		albumItems = items;
	}

	private Ui ui;
	private Gallery gallery;
	private AlbumItem[] albumItems = null;
}
