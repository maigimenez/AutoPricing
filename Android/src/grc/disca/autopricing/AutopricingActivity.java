package grc.disca.autopricing;

import java.util.ArrayList;

import grc.disca.autopricing.model.*;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class AutopricingActivity extends Activity {
	
	private Button btn;
	private static final String BASE_URL = "http://localhost:8000/api";
	private static final String CLIENTS_URL = "clients";
	private static final String INVOICES_URL = "invoices";
	private static final String MOBILES_URL = "mobiles";
	private static final String TESTS_URL = "tests";
	private static final String TRACKS_URL = "tracks";
	private static final String VEHICLESS_URL = "vehicles";

	private Model model;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initModel();
		initControls();
		initDB();
	}
	
	private void initModel(){
		model = new Model();
	}

	private void initControls(){
	    btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Log.i(AutopricingActivity.class.getName(), "Call WS");
				//Webservice.callWebService(url);
				
			}
		});
	}
	
	private void initDB(){
		Log.i("MAIN", "Init DB");
		TestingSQLiteHelper testdb = new TestingSQLiteHelper(this, "DB_testing", null, 1);
		SQLiteDatabase db = testdb.getWritableDatabase();
        if(db != null){
        	//Webservice.getJSON(url);
            //Aquí deberemos insertar los datos de la BD
        	
        	Webservice.loadClients(BASE_URL+CLIENTS_URL,model.getClients());
    		Log.i("MAIN", "Clients loaded:" + model.getClients().size() + " clients readed" );

        	Webservice.loadInvoices(BASE_URL+INVOICES_URL,model);
    		Log.i("MAIN", "Invoices loaded:" + model.getInvoices().size() + " invoices readed" );

        	Webservice.loadMobiles(BASE_URL+MOBILES_URL,model.getMobiles());
    		Log.i("MAIN", "Mobiles loaded:" + model.getMobiles().size() + " mobiles readed" );

        	/*Webservice.loadTests(BASE_URL+TESTS_URL,model);
    		Log.i("MAIN", "Tests loaded:" + model.getTests().size() + " tests readed" );*/

        	Webservice.loadTracks(BASE_URL+TRACKS_URL,model.getTracks());
    		Log.i("MAIN", "Tracks loaded:" + model.getTracks().size() + " tracks readed" );

        	//Webservice.loadVehicles(BASE_URL+VEHICLESS_URL,model);
    		//Log.i("MAIN", "Vehicles loaded:" + model.getVehicles().size() + " vehicles readed" );


            //Cerramos la base de datos
            db.close();
        }	
	}
	
}