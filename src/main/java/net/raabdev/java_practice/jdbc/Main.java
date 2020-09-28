package net.raabdev.java_practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static final String DB_NAME = "testjava.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;
	public static final String TABLE_CONTACTS = "contacts";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_PHONE = "phone";
	public static final String COLUMN_EMAIL = "email";
	
	public static void main(String[] args) {
		try (	Connection conn = DriverManager.getConnection(CONNECTION_STRING); 
				Statement statement = conn.createStatement();
			){
				statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);	
				statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + " (" + 
						COLUMN_NAME + " TEXT, " +
						COLUMN_PHONE + " INTEGER,  " +
						COLUMN_EMAIL + " TEXT)");
				
	//			conn.setAutoCommit(false);
				insertContact(statement, "Jenny", 8675309, "jenny@smail.com");
				insertContact(statement, "Joe", 8989898, "joe@jdog.com");
				insertContact(statement, "John", 123, "johnjohn@smail.com");
				insertContact(statement, "Jack", 3456543, "jackie@aol.com");
				
				statement.execute("UPDATE contacts set phone = 1234567 where NAME = 'John'");
				statement.execute("DELETE FROM contacts where NAME = 'John'");

				//		statement.execute("SELECT * FROM contacts");
				//		ResultSet results = statement.getResultSet();

				ResultSet results = statement.executeQuery("SELECT * FROM contacts");

				while(results.next()) {

					System.out.println(results.getString("name") + " " +
								   results.getInt("phone") + " " +
								   results.getString("email")
								  );
				}
				
			
				results.close();
		
		} catch (SQLException e) {
				System.out.println("Something didn't work: " + e.getMessage());
				e.printStackTrace();
			}
	}	
	
	public static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
		statement.execute("INSERT INTO " + TABLE_CONTACTS + 
				" VALUES ('" + name + "', " + phone + ", '" + email + "')");
	}
}	
