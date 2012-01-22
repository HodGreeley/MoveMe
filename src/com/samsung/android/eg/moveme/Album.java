package com.samsung.android.eg.moveme;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;

import com.samsung.android.eg.utils.ImageAdapter;
import com.samsung.android.eg.utils.Ui;

public class Album extends Fragment {
    @Override
    public void onAttach(Activity activity) {
            super.onAttach(activity);
            
            listener = (Ui.SelectionListener)activity;
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View view = inflater.inflate(R.layout.album, container, false);

		gallery = (Gallery)view.findViewById(R.id.gallery);
	    
	    gallery.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	listener.onSelected(position);
	        }
	    });

        return view;
	}

	public void setItems(Data.AlbumItem[] items) {
	    gallery.setAdapter(new ImageAdapter(getActivity(), items));
	}

	private Ui.SelectionListener listener;
	private Gallery gallery;
}
