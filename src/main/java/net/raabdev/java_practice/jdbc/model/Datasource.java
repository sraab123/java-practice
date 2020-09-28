package net.raabdev.java_practice.jdbc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
	public static final String DB_NAME = "music.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

	public static final String TABLE_ARTISTS = "artists";
	public static final String COLUMN_ARTIST_ID = "_id";
	public static final String COLUMN_ARTIST_NAME = "name";
	public static final int INDEX_ARTIST_ID = 1;
	public static final int INDEX_ARTIST_NAME = 2;

	public static final String TABLE_ALBUMS = "albums";
	public static final String COLUMN_ALBUM_ID = "_id";
	public static final String COLUMN_ALBUM_NAME = "name";
	public static final String COLUMN_ALBUM_ARTIST = "artist";
	public static final int INDEX_ALBUM_ID = 1;
	public static final int INDEX_ALBUM_NAME = 2;
	public static final int INDEX_ALBUM_ARTIST = 3;

	public static final String TABLE_SONGS = "songs";
	public static final String COLUMN_SONG_ID = "_id";
	public static final String COLUMN_SONG_TRACK = "track";
	public static final String COLUMN_SONG_TITLE = "title";
	public static final String COLUMN_SONG_ALBUM = "album";
	public static final int INDEX_SONG_ID = 1;
	public static final int INDEX_SONG_TRACK = 2;
	public static final int INDEX_SONG_TITLE = 3;
	public static final int INDEX_SONG_ALBUM = 4;

	public static final int ORDER_BY_NONE = 1;
	public static final int ORDER_BY_ASC = 2;
	public static final int ORDER_BY_DESC = 3;

	private static final String QUERY_ARTIST_FOR_SONG_START = " SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME
			+ ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK + " "
			+ "FROM " + TABLE_SONGS + " " + "INNER JOIN " + TABLE_ALBUMS + " " + "ON " + TABLE_SONGS + "."
			+ COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID + " " + "INNER JOIN " + TABLE_ARTISTS
			+ " " + "ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID
			+ " " + "WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = '";

	public static final String QUERY_ARTIST_FOR_SONG_SORT = " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME
			+ ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";

	public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";

	public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " + TABLE_ARTIST_SONG_VIEW
			+ " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME
			+ " AS " + COLUMN_SONG_ALBUM + ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "."
			+ COLUMN_SONG_TITLE + " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "."
			+ COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTISTS + " ON "
			+ TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID + " ORDER BY "
			+ TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", "
			+ TABLE_SONGS + "." + COLUMN_SONG_TRACK;

	public static final String QUERY_VIEW_SONG_INFO = "SELECT " + COLUMN_ARTIST_NAME + ", " + COLUMN_SONG_ALBUM + ", "
			+ COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONG_TITLE + " = \"";

	public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + ", " + COLUMN_SONG_ALBUM
			+ ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONG_TITLE + " = ?";

	
	public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS + "(" + COLUMN_ARTIST_NAME + ") VALUES(?)";
	
	public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS + "(" + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES (?,?)";
	
	public static final String INSERT_SONG = "INSERT INTO " + TABLE_SONGS + "(" + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM + ") VALUES (?,?,?)";

	public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " + TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";
	
	public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " + TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_ARTIST + " = ? AND " + COLUMN_ALBUM_NAME + " = ?";
	
	
	
	private Connection conn;

	private PreparedStatement querySongInfoView;

	private PreparedStatement insertIntoArtists;
	
	private PreparedStatement insertIntoAlbums;
	
	private PreparedStatement insertIntoSongs;
	
	private PreparedStatement queryArtist;
	
	private PreparedStatement queryAlbum;
	
	public boolean open() {
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING);
			querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
			insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
			insertIntoAlbums = conn.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
			insertIntoSongs = conn.prepareStatement(INSERT_SONG);
			queryArtist = conn.prepareStatement(QUERY_ARTIST);
			queryAlbum = conn.prepareStatement(QUERY_ALBUM);
			return true;
		} catch (SQLException e) {
			System.out.println("Something didn't work: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public void close() {
		try {

			if (querySongInfoView != null) {
				querySongInfoView.close();
			}
			
			if (insertIntoArtists != null) {
				insertIntoArtists.close();
			}
			
			if (insertIntoAlbums != null) {
				insertIntoAlbums.close();
			}
		
			if (insertIntoSongs != null) {
				insertIntoSongs.close();
			}
			
			if (queryArtist != null) {
				queryArtist.close();
			}
			
			if (queryAlbum != null) {
				queryAlbum.close();
			}
		
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Something didn't work: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public List<Artist> queryArtists(int sortOrder) {

		StringBuilder sb = new StringBuilder("SELECT * ");
		sb.append(" FROM " + TABLE_ARTISTS);

		if (sortOrder != ORDER_BY_NONE) {
			sb.append(" ORDER BY ");
			sb.append(COLUMN_ARTIST_NAME);
			sb.append(" COLLATE NOCASE ");
			if (sortOrder == ORDER_BY_ASC) {
				sb.append("ASC");
			} else {
				sb.append("DESC");
			}

		}

		try (Statement statement = conn.createStatement(); ResultSet rs = statement.executeQuery(sb.toString());) {
			List<Artist> artists = new ArrayList<Artist>();
			while (rs.next()) {
				Artist a = new Artist();
				a.setId(rs.getInt(INDEX_ARTIST_ID));
				a.setName(rs.getString(INDEX_ARTIST_NAME));
				artists.add(a);
			}

			return artists;

		} catch (SQLException e) {
			System.out.println("Something didn't work: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public List<String> queryAlbumsforArtist(String artistName, int sortOrder) {
		StringBuilder sb = new StringBuilder("SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME);
		sb.append(" FROM " + TABLE_ALBUMS + " INNER JOIN " + TABLE_ARTISTS);
		sb.append(" ON  " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID);
		sb.append(" WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " =  '" + artistName + "'");

		if (sortOrder != ORDER_BY_NONE) {
			sb.append(" ORDER BY ");
			sb.append(TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME);
			sb.append(" COLLATE NOCASE ");
			if (sortOrder == ORDER_BY_ASC) {
				sb.append("ASC");
			} else {
				sb.append("DESC");
			}

		}

		System.out.println("SQL String is: " + sb.toString());

		try (Statement statement = conn.createStatement(); ResultSet rs = statement.executeQuery(sb.toString());) {
			List<String> artistNameList = new ArrayList<String>();
			while (rs.next()) {
				artistNameList.add(rs.getString(1));
			}

			return artistNameList;

		} catch (SQLException e) {
			System.out.println("Something didn't work: " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public List<SongArtist> queryArtistsForSong(String songName, int sortOrder) {
		StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
		sb.append(songName + "'");
		if (sortOrder != ORDER_BY_NONE) {
			sb.append(QUERY_ARTIST_FOR_SONG_SORT);
			if (sortOrder == ORDER_BY_ASC) {
				sb.append("ASC");
			} else {
				sb.append("DESC");
			}

		}

		System.out.println("SQL String is: " + sb.toString());

		try (Statement statement = conn.createStatement(); ResultSet rs = statement.executeQuery(sb.toString());) {
			List<SongArtist> songArtistList = new ArrayList<SongArtist>();
			while (rs.next()) {
				SongArtist sa = new SongArtist();
				sa.setArtistName(rs.getString(1));
				sa.setAlbumName(rs.getString(2));
				sa.setTrack(rs.getInt(3));
				songArtistList.add(sa);
			}

			return songArtistList;

		} catch (SQLException e) {
			System.out.println("Something didn't work: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public void querySongsMetadata() {
		String sql = "SELECT * FROM " + TABLE_SONGS;
		try (Statement statement = conn.createStatement(); ResultSet rs = statement.executeQuery(sql);) {
			ResultSetMetaData rsmd = rs.getMetaData();
			int numCols = rsmd.getColumnCount();
			for (int i = 1; i <= numCols; i++) {
				System.out.format("Column %d in table Songs is named %s\n", i, rsmd.getColumnName(i));
			}
		} catch (SQLException e) {
			System.out.println("Something didn't work: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public int getCount(String table) {
		String sql = "SELECT COUNT(*) AS count FROM " + table;
		try (Statement statement = conn.createStatement(); ResultSet results = statement.executeQuery(sql)) {

			int count = results.getInt("count");

			System.out.format("Count = %d\n", count);
			return count;
		} catch (SQLException e) {
			System.out.println("Query failed: " + e.getMessage());
			return -1;
		}
	}

	public boolean createViewForSongArtists() {

		try (Statement statement = conn.createStatement()) {

			statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
			return true;

		} catch (SQLException e) {
			System.out.println("Create View failed: " + e.getMessage());
			return false;
		}
	}

	public List<SongArtist> querySongInfoView(String title) {

		try {
			querySongInfoView.setString(1, title);
			ResultSet results = querySongInfoView.executeQuery();

			List<SongArtist> songArtists = new ArrayList<>();
			while (results.next()) {
				SongArtist songArtist = new SongArtist();
				songArtist.setArtistName(results.getString(1));
				songArtist.setAlbumName(results.getString(2));
				songArtist.setTrack(results.getInt(3));
				songArtists.add(songArtist);
			}

			return songArtists;

		} catch (SQLException e) {
			System.out.println("Query failed: " + e.getMessage());
			return null;
		}
	}
	
	private int insertArtist(String name) throws SQLException {
		queryArtist.setString(1,name);
		ResultSet rs = queryArtist.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		} else
			//insert the artist
			insertIntoArtists.setString(1, name);
			int rowsInserted = insertIntoArtists.executeUpdate();
			if(rowsInserted != 1) {
				throw new SQLException("Error inserting Artist 1");
			}
			
			ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
			if(generatedKeys.next()) {
				return generatedKeys.getInt(1);
			} else {
				throw new SQLException("Error getting the generated key _id for artist");
			}
	}

	private int insertAlbum(String name, int id) throws SQLException {
		queryAlbum.setString(1,name);
		queryAlbum.setInt(2, id);
		
		ResultSet rs = queryAlbum.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		} else
			//insert the album
			insertIntoAlbums.setString(2, name);
			insertIntoAlbums.setInt(1, id);
			int rowsInserted = insertIntoAlbums.executeUpdate();
			if(rowsInserted != 1) {
				throw new SQLException("Error inserting Album 1");
			}
			
			ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
			if(generatedKeys.next()) {
				return generatedKeys.getInt(1);
			} else {
				throw new SQLException("Error getting the generated key _id for album");
			}
	}

	public void insertSong(String title, String artist, String album, int track) {
	try {
		conn.setAutoCommit(false);
		int artistId = insertArtist(artist);
		int albumId = insertAlbum(album, artistId);
		insertIntoSongs.setString(2, title);
		insertIntoSongs.setInt(1, track);
		insertIntoSongs.setInt(3, albumId);
		int rowsInserted = insertIntoSongs.executeUpdate();
		if(rowsInserted == 1) {
			conn.commit();
		} else {
			throw new SQLException("Song Insert Failed");
		}			
	} catch (SQLException e) {
		System.out.println("Error inserting song: " + e.getMessage());
		try {
			System.out.println("Performing rollback");
			conn.rollback();
		} catch (SQLException e2) {
			System.out.println("Rollback failed: " + e2.getMessage());
			
		}
	} finally {
		try {
			System.out.println("Resetting autocommit behavior");
			conn.setAutoCommit(true);
		} catch (SQLException e3) {
			System.out.println("Error resetting autocommit: " + e3.getMessage());
		}
	}
	}

}
