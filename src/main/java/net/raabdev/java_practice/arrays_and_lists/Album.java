package net.raabdev.java_practice.arrays_and_lists;

import java.util.ArrayList;

public class Album {
    private String name;

    public String getName() {
		return name;
	}

    private SongList songs;
    
	public ArrayList<Song> getSongs() {
		return songs.getSongs();
	}

 
	
	public Album(String name, Song song) {
		this.name = name;
		songs = new SongList();
		songs.add(song);
	}
	
	public void add(Song song) {
		songs.add(song);
	}
	
public class SongList {

	public SongList() {
		songs = new ArrayList<Song>();
	}

	private ArrayList<Song> songs;

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}
	
	public void add(Song song) {
		songs.add(song);
	}
	
}
	
	
}
