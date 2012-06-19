package grc.disca.autopricing;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class TestingSQLiteHelper extends SQLiteOpenHelper {
	
	String createTracks = "CREATE TABLE testing_track (" +
								"id integer NOT NULL PRIMARY KEY, " +
								"name varchar(100) NOT NULL, " +
								"price real NOT NULL);";
	String dropTracks = "DROP TABLE IF EXISTS  testing_track;";

	
	String createClients = "CREATE TABLE testing_client (" +
							"id integer NOT NULL PRIMARY KEY," +
							"name varchar(20) NOT NULL," +
							"company varchar(20) NOT NULL);";
	String dropClients = "DROP TABLE IF EXISTS  testing_client;";

							
	String createVehicles = "CREATE TABLE testing_vehicle (" +
							"id integer NOT NULL PRIMARY KEY," +
							"name varchar(50) NOT NULL," +
							"color varchar(50) NOT NULL," +
							"frame varchar(20) NOT NULL," +
							"client_id integer NOT NULL REFERENCES testing_client (id));";
	String dropVehicles = "DROP TABLE IF EXISTS  testing_client;";

	
	String createTests = "CREATE TABLE testing_test (" +
						"id integer NOT NULL PRIMARY KEY," +
						"mobile_id integer NOT NULL REFERENCES testing_mobile (id)," +
						"car_id integer NOT NULL REFERENCES testing_vehicle (id)," +
						"track_id integer NOT NULL REFERENCES testing_track (id)," +
						"minutes integer NOT NULL," +
						"price real NOT NULL," +
						"invoice_id integer NOT NULL REFERENCES testing_invoice (invoiceID));";
	String dropTests = "DROP TABLE IF EXISTS  testing_test;";

	
	 public TestingSQLiteHelper(Context contexto, String nombre, CursorFactory factory, int version) {
		 super(contexto, nombre, factory, version);
	}

	public void onCreate(SQLiteDatabase db) {
		createDB(db);
	}

	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		dropDB(db);
		createDB(db);
	}
	
	private void createDB(SQLiteDatabase db){
		db.execSQL(createTracks);
		db.execSQL(createClients);		
		db.execSQL(createVehicles);
		db.execSQL(createTests);
	}
	private void dropDB(SQLiteDatabase db){
		db.execSQL(dropTracks);
		db.execSQL(dropClients);		
		db.execSQL(dropVehicles);
		db.execSQL(dropTests);
	}

}
