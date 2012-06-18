package grc.disca.autopricing;

import android.app.Activity;
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
	}
	
	private void initControls(){
	    btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Log.i("MAIN", "Call WS");
				Webservice.callWebService();
				
			}
		});
	}
	
	
}