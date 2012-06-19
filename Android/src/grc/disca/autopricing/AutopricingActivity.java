package grc.disca.autopricing;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class AutopricingActivity extends Activity {
	
	private Button btn;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initControls();
		initDB();
	}
	
	private void initControls(){
	    btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Log.i("MAIN", "Call WS");
				Webservice.callWebService("http://www.colorines.org/tracks.json");
				
			}
		});
	}
	
	private void initDB(){
		TestingSQLiteHelper testdb = new TestingSQLiteHelper(this, "DB_testing", null, 1);
		SQLiteDatabase db = testdb.getWritableDatabase();
        if(db != null){
            //Aquí deberemos insertar los datos de la BD

            //Cerramos la base de datos
            db.close();
        }	
	}
	
}