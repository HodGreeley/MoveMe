package com.samsung.android.eg.moveme;

public class Data {
	public final static class AlbumItem {
		private final int id;
		private final String label;
		
		public AlbumItem(int i, String l) {
			id = i;
			label = l;
		}
		
		public int getId() {
			return id;
		}
		
		public String getLabel() {
			return label;
		}
		
		@Override
		public String toString() {
			return label;
		}
	}
	
	public static AlbumItem[] getUsers() {
		return users;
	}
	
	public static AlbumItem[] getFaves(int id) {
		return faves[id];
	}
	
	private static AlbumItem[] users = {
		new AlbumItem(R.drawable.ic_launcher, "Hod"),
		new AlbumItem(R.drawable.ic_launcher, "Melbot"),
		new AlbumItem(R.drawable.ic_launcher, "Juan")
	};
	
	private static AlbumItem[][] faves = { 
		{ new AlbumItem(R.drawable.ic_launcher, "Test 1"), new AlbumItem(R.drawable.ic_launcher, "Test 2") },
		{ new AlbumItem(R.drawable.ic_launcher, "Test 1"), new AlbumItem(R.drawable.ic_launcher, "Test 2") },
		{ new AlbumItem(R.drawable.ic_launcher, "Test 1"), new AlbumItem(R.drawable.ic_launcher, "Test 2") },		
	};
}
