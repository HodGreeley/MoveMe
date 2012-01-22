package com.samsung.android.eg.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.samsung.android.eg.moveme.R;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	private Integer[] mImageIds;
	private int mItemBackground;
	
	public ImageAdapter(Context c, Integer[] imageIds) {
		mContext = c;
		mImageIds = imageIds;
		
        TypedArray attr = mContext.obtainStyledAttributes(R.styleable.Album);
        mItemBackground = attr.getResourceId(
                R.styleable.Album_android_galleryItemBackground, 0);
        attr.recycle();
	}
	
	@Override
	public int getCount() {
        return mImageIds.length;
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
		return null;
	}

}
