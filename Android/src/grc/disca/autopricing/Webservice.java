package grc.disca.autopricing;

import grc.disca.autopricing.model.*;
import grc.disca.autopricing.model.Model.noClientFound;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.text.format.DateFormat;
import android.util.Log;

public class Webservice {
	DefaultHttpClient httpClient;
	HttpContext localContext;
	private String ret;

	HttpResponse response = null;
	HttpPost post = null;
	HttpGet get =null;
	HttpPut put = null;
	HttpDelete delete = null;
	String webserviceURL;

	// JSON Node names
	private static final String TAG_FIELDS = "fields";
	private static final String TAG_ID = "pk";

	private static final String TAG_TRACKS = "tracks";
	private static final String TAG_TRACKS_NAME = "name";
	private static final String TAG_TRACKS_AREA = "area";
	private static final String TAG_TRACKS_PRICE = "price";

	private static final String TAG_CLIENTS = "clients";
	private static final String TAG_CLIENTS_COMPANY = "company";
	private static final String TAG_CLIENTS_NAME = "name";

	private static final String TAG_INVOICES = "invoices";
	private static final String TAG_INVOICES_CLIENT = "client";
	private static final String TAG_INVOICES_DATE = "date";
	private static final String TAG_INVOICES_TOTAL = "total";

	private static final String TAG_MOBILES = "clients";
	private static final String TAG_MOBILES_NAME = "name";
	private static final String TAG_MOBILES_MAC = "mac";

	private static final String TAG_TESTS = "tests";
	private static final String TAG_TESTS_MOBILE = "mobile";
	private static final String TAG_TESTS_VEHICLE = "car";
	private static final String TAG_TESTS_PRICE = "price";
	private static final String TAG_TESTS_TRACK = "track";
	private static final String TAG_TESTS_MINUTES = "minutes";


	
	public static JSONObject getJSON(String url){

		//initialize
		InputStream is = null;
		String result = "";
		JSONObject jArray = null;

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(url);
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("WS ERROR", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("WS ERROR", "Error converting result "+e.toString());
		}

		//try parse the string to a JSON object
		try{
			jArray = new JSONObject(result);
		}catch(JSONException e){
			Log.e("WS ERROR", "Error parsing data "+ e.toString());
		}

		return jArray;
	}

	protected static void loadClients(String url,ArrayList<Client> clients){
		Log.i("WS", "Load Clients Service");

		//Get the data (see above)
		JSONObject json = getJSON(url);

		try{
			//Get the element that holds the tracks ( JSONArray )
			JSONArray  clientsArray = json.getJSONArray(TAG_CLIENTS);

			//Loop the Array
			for(int i=0;i < clientsArray.length();i++){	
				Client c = new Client();

				JSONObject clientObject = clientsArray.getJSONObject(i);
				//we should check that the client doesn't exist already
				c.setId(Integer.parseInt(clientObject.getString(TAG_ID)));

				JSONObject clientField = clientObject.getJSONObject(TAG_FIELDS);
				c.setName(clientField.getString(TAG_CLIENTS_NAME));
				c.setCompany(clientField.getString(TAG_CLIENTS_COMPANY));

				clients.add(c);

			}
		}catch(JSONException e)        {
			Log.e("WS ERROR", "Error parsing data "+e.toString());

		}
	}

	protected static void loadInvoices(String url,Model model){
		Log.i("WS", "Load Invoices Service");

		ArrayList<Invoice> invoices = model.getInvoices();

		//Get the data (see above)
		JSONObject json = getJSON(url);

		try{
			//Get the element that holds the tracks ( JSONArray )
			JSONArray  invoicesArray = json.getJSONArray(TAG_INVOICES);

			//Loop the Array
			//We should check if the data already exists
			for(int i=0;i < invoicesArray.length();i++){	
				Invoice in = new Invoice();
			
				JSONObject invoiceObject = invoicesArray.getJSONObject(i);
				//we should check that the client doesn't exist already
				in.setId(Integer.parseInt(invoiceObject.getString(TAG_ID)));

				JSONObject invoicetField = invoiceObject.getJSONObject(TAG_FIELDS);
				try {
					String client = invoicetField.getString(TAG_INVOICES_CLIENT);
					Client c = model.getClient(client);
					in.setClient(c);

				} catch (noClientFound e) {
					Log.e("WS ERROR", "Error client not found "+e.toString());
				}
				try {
					in.setDate(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(invoicetField.getString(TAG_INVOICES_DATE)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				//Pending
				//in.setTests(tests)
				
				in.setTotal(Float.valueOf(invoicetField.getString(TAG_INVOICES_TOTAL)));
				
				invoices.add(in);
			}
			model.setInvoices(invoices);
		}catch(JSONException e)        {
			Log.e("log_tag", "Error parsing data "+e.toString());

		}
	}

	protected static void loadMobiles(String url,ArrayList<Mobile> mobiles){
		Log.i("WS", "Load Mobiles Service");

		//Get the data (see above)
		JSONObject json = getJSON(url);

		try{
			//Get the element that holds the tracks ( JSONArray )
			JSONArray  mobilesArray = json.getJSONArray(TAG_MOBILES);

			//Loop the Array
			for(int i=0;i < mobilesArray.length();i++){	
				Mobile m = new Mobile();

				JSONObject mobileObject = mobilesArray.getJSONObject(i);
				
				//we should check that the client doesn't exist already
				m.setId(Integer.parseInt(mobileObject.getString(TAG_ID)));
				
				JSONObject mobileField = mobileObject.getJSONObject(TAG_FIELDS);
				m.setName(mobileField.getString(TAG_MOBILES_NAME));
				m.setMac(mobileField.getString(TAG_MOBILES_MAC));

				mobiles.add(m);

			}
		}catch(JSONException e)        {
			Log.e("WS ERROR", "Error parsing data "+e.toString());

		}
	}
	
	protected static void loadTests(String url,Model model){
		Log.i("WS", "Load Tests Service");
		
		ArrayList<Test> tests = model.getTests();

		//Get the data (see above)
		JSONObject json = getJSON(url);

		try{
			//Get the element that holds the tracks ( JSONArray )
			JSONArray  testsArray = json.getJSONArray(TAG_TESTS);

			//Loop the Array
			for(int i=0;i <  testsArray.length();i++){	
				Test t = new Test();

				JSONObject testObject =  testsArray.getJSONObject(i);
				
				//we should check that the client doesn't exist already
				t.setId(Integer.parseInt(testObject.getString(TAG_ID)));
				
				JSONObject testField = testObject.getJSONObject(TAG_FIELDS);
				t.setMinutes(Integer.parseInt(testField.getString(TAG_TESTS_MINUTES)));
				t.setPrice(Float.parseFloat(testField.getString(TAG_TESTS_PRICE)));
				//t.setMobile(mobile);
				//t.setTrack(track);
				//t.setVehicle(vehicle);
				
				tests.add(t);

			}
		}catch(JSONException e)        {
			Log.e("WS ERROR", "Error parsing data "+e.toString());

		}
	}
	
	protected static void loadTracks(String url,ArrayList<Track> tracks){
		Log.i("WS", "Load Tracks Service");

		//Get the data (see above)
		JSONObject json = getJSON("http://www.colorines.org/tracks.json");

		try{
			//Get the element that holds the tracks ( JSONArray )
			JSONArray  tracksArray = json.getJSONArray(TAG_TRACKS);

			//Loop the Array
			for(int i=0;i < tracksArray.length();i++){	
				Track t = new Track();

				JSONObject trackObject = tracksArray.getJSONObject(i);
				t.setId(Integer.parseInt(trackObject.getString(TAG_ID)));
				JSONObject trackField = trackObject.getJSONObject(TAG_FIELDS);
				t.setName(trackField.getString(TAG_TRACKS_NAME));
				t.setPrice(Float.valueOf(trackField.getString(TAG_TRACKS_PRICE)));
				//t.setArea(trackField.getString(TAG_TRACKS_AREA));
				tracks.add(t);

			}
		}catch(JSONException e)        {
			Log.e("log_tag", "Error parsing data "+e.toString());
		}
	}



}

