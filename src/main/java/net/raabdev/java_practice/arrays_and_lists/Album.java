package net.raabdev.java_practice.arrays_and_lists;

import java.util.ArrayList;

public class Album {
    private String name;

    public String getName() {
		return name;
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	private ArrayList<Song> songs; 
	
	public Album(String name, Song song) {
		this.name = name;
		songs = new ArrayList<Song>();
		songs.add(song);
	}
	
	public void add(Song song) {
		songs.add(song);
	}
	

}
