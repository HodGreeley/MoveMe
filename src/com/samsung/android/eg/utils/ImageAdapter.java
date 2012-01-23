package com.samsung.android.eg.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.samsung.android.eg.moveme.Data.AlbumItem;
import com.samsung.android.eg.moveme.R;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private AlbumItem[] albumItems;
	private int itemBackground;
	
	public ImageAdapter(Context c, AlbumItem[] items) {
		context = c;
		albumItems = items;
		
        TypedArray attr = context.obtainStyledAttributes(R.styleable.Album);
        itemBackground = attr.getResourceId(R.styleable.Album_android_galleryItemBackground, 0);
        attr.recycle();
	}
	
	@Override
	public int getCount() {
        return albumItems.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);

        imageView.setImageResource(albumItems[position].getId());
        imageView.setLayoutParams(new Gallery.LayoutParams(300, 200));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(itemBackground);

        return imageView;
	}
}
