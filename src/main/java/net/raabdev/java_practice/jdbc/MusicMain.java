package net.raabdev.java_practice.jdbc;

import java.util.List;
import java.util.Scanner;

import net.raabdev.java_practice.jdbc.model.Artist;
import net.raabdev.java_practice.jdbc.model.Datasource;
import net.raabdev.java_practice.jdbc.model.SongArtist;

public class MusicMain {

	public static void main(String[] args) {
		Datasource ds = new Datasource();
		if(!ds.open()) {
			System.out.println("Can't Open Datasource");
			return;
		}
		
		List<Artist> artists = ds.queryArtists(Datasource.ORDER_BY_DESC);
		
		if(artists == null) {
			System.out.println("No artists to display");
			return;
		}
		
		for (Artist artist: artists) {
			System.out.println("Artist id: " + artist.getId() + ", Artist Name: " + artist.getName());
		}
		
		List<String> albums = ds.queryAlbumsforArtist("Pink Floyd", Datasource.ORDER_BY_DESC);

		for (String albumName: albums) {
			System.out.println(albumName);
		}
		
		List<SongArtist> lsa = ds.queryArtistsForSong("Heartbreaker", Datasource.ORDER_BY_DESC);
		
		for(SongArtist sa: lsa) {
			System.out.println( "Artist: " + sa.getArtistName() + ", Album: " + sa.getAlbumName() + ", Track:" + sa.getTrack());
			
		}
		ds.querySongsMetadata();
			
        int count = ds.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        ds.createViewForSongArtists();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String title = scanner.nextLine();

        lsa = ds.querySongInfoView(title);
        
        if(lsa.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : lsa) {
            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
                " Album name = " + artist.getAlbumName() +
                " Track number = " + artist.getTrack());
        }


        ds.insertSong("Touch of Grey", "Grateful Dead", "In The Dark", 1);
		
		
		ds.close();
		

	}

}
