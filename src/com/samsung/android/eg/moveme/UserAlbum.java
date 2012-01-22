package com.samsung.android.eg.moveme;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.Toast;

public class UserAlbum extends Fragment {
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.useralbum, container, false);
		
		Gallery album = (Gallery) view.findViewById(R.id.user_album);
	    album.setAdapter(new ImageAdapter(this));
	    
	    album.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView parent, View v, int position, long id) {
	        }
	    });
	    
        return view;
	}
}
