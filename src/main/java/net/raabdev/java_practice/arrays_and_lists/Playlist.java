package net.raabdev.java_practice.arrays_and_lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {

	private static LinkedList<Song> playlist = new LinkedList<Song>();
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		boolean exit = false;
		boolean forward = true;
		//String name;
		ArrayList<Album> albums = new ArrayList<>();

		//create the songs
		Song s1 = new Song("Teen Spirit", 4);
		Song s2 = new Song("Lithium", 6);
		Song s3 = new Song("Come As you are", 2);
		
		Song s4 = new Song("Beat It", 3);
		Song s5 = new Song("Thriller", 8);
		Song s6 = new Song("Billie Jean", 4);
		
		Song s7 = new Song("Help", 5);
		Song s8 = new Song("Eight Days", 7);
		Song s9 = new Song("Lady Madonna", 2);
		
		//build the albumns
		Album a1 = new Album("Nirvana", s1);
		a1.add(s2);
		a1.add(s3);
		
		Album a2 = new Album("MJ", s4);
		a2.add(s5);
		a2.add(s6);
		
		Album a3 = new Album("Beatles", s7);
		a3.add(s8);
		a3.add(s9);

		//add to ArrayList
		albums.add(a1);
		albums.add(a2);
		albums.add(a3);
		
//		for(Album album:albums) {
//			System.out.println("**" + album.getName() + "**");
//			for(Song song: album.getSongs()) {
//				System.out.println(song.getName());
//			}
//		}
		
		//Create Playlist
		playlist.add(albums.get(0).getSongs().get(1));
		playlist.add(albums.get(1).getSongs().get(1));
		playlist.add(albums.get(2).getSongs().get(1));
		playlist.add(albums.get(0).getSongs().get(0));
		playlist.add(albums.get(1).getSongs().get(0));
		playlist.add(albums.get(2).getSongs().get(0));

		ListIterator<Song> it = playlist.listIterator();
		
		//On startup we play the first song
	    System.out.println("Now playing " + it.next().getName() + "\n");
		
		while (!exit) {
			
			optionMenu();
			if (scanner.hasNextInt()) {
				
				switch (scanner.nextInt()) {
				
				case 1:
					//quitting the program
					exit = true;
					break;
					
				case 2:	
					//go to next song in playlist
					if(!forward) {
						it.next();
						forward = true;
					}
					if(it.hasNext()) {
						System.out.println("Now playing " + it.next().getName()  + "\n");
					} else {
						System.out.println("Already on Last Song"  + "\n");
					}
					break;
				case 3:
					//go back a song
					if(forward) {
						it.previous();
						forward = false;
					}
					if(it.hasPrevious()) {
						System.out.println("Now playing " + it.previous().getName()  + "\n");
					} else {
						System.out.println("Already on First Song"  + "\n");
					}
					break;
					
				case 4:
					//start over the current song
					if(forward) {
						System.out.println("Starting over song " + playlist.get(it.previousIndex()).getName()  + "\n");
					} else {
						System.out.println("Starting over song " + playlist.get(it.nextIndex()).getName()  + "\n");
					}
					it.nextIndex();
					
					break;
					
				case 5:
					//list all songs
					System.out.println("Current Songs in the playlist: ");
					for(Song song:playlist) {
						System.out.println(song.getName());
					}
					break;
				}
				scanner.nextLine();
				System.out.println();
			}
			
		}
	}
	
	private static void optionMenu() {
		System.out.println("Playlist Menu: ");
		System.out.println("1: Quit ");
		System.out.println("2: Skip Forward");
		System.out.println("3: Skip Backward");
		System.out.println("4: Replay Current Song");
		System.out.println("5: Show All Songs");
	}

}


