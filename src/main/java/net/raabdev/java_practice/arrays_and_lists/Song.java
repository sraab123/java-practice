package net.raabdev.java_practice.arrays_and_lists;

public class Song {

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	private int duration;
	
	public Song(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}
	
	

}
