package grc.disca.autopricing;

import grc.disca.autopricing.model.Track;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

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
	private static final String TAG_TRACKS_FIELDS = "fields";
	private static final String TAG_TRACKS_NAME = "name";
	private static final String TAG_TRACKS_AREA = "area";
	private static final String TAG_TRACKS_PRICE = "price";

	
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
				Log.e("log_tag", "Error in http connection "+e.toString());
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
				Log.e("log_tag", "Error converting result "+e.toString());
			}

			//try parse the string to a JSON object
			try{
		        	jArray = new JSONObject(result);
			}catch(JSONException e){
				Log.e("log_tag", "Error parsing data "+ e.toString());
			}

			return jArray;
		}
	

	
	protected static void loadTracks(String url,ArrayList<Track> tracks){
		Log.i("WS", "Init web service");
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
	
		//Get the data (see above)
		JSONObject json = getJSON(url);
			
		try{
			//Get the element that holds the tracks ( JSONArray )
			JSONArray  tracksArray = json.getJSONArray("tracks");
	
		      	//Loop the Array
		        for(int i=0;i < tracksArray.length();i++){	
		        	Track t = new Track();
	
		        	HashMap<String, String> map = new HashMap<String, String>();
		        	JSONObject trackObject = tracksArray.getJSONObject(i);
		        	JSONObject trackField = trackObject.getJSONObject(TAG_TRACKS_FIELDS);
		        	t.setName(trackField.getString(TAG_TRACKS_NAME));
		        	t.setPrice(Float.valueOf(trackField.getString(TAG_TRACKS_PRICE)));
		        	
		        	tracks.add(t);
		        	
			}
		       }catch(JSONException e)        {
		       	 Log.e("log_tag", "Error parsing data "+e.toString());
		       }
	}
}

	