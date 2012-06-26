package grc.disca.autopricing;

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
	

	
	protected static void loadTracks(String url){
		Log.i("WS", "Init web service");
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
	
		//Get the data (see above)
		JSONObject json = getJSON(url);
			
		try{
			//Get the element that holds the tracks ( JSONArray )
			JSONArray  earthquakes = json.getJSONArray("tracks");
	
		      	//Loop the Array
		        for(int i=0;i < earthquakes.length();i++){						
	
		        	HashMap<String, String> map = new HashMap<String, String>();
		        	JSONObject e = earthquakes.getJSONObject(i);
	
		        	map.put("id",  String.valueOf(i));
		        	map.put("name", "Earthquake name:" + e.getString("eqid"));
		        	map.put("magnitude", "Magnitude: " +  e.getString("magnitude"));
		        	mylist.add(map);
			}
		       }catch(JSONException e)        {
		       	 Log.e("log_tag", "Error parsing data "+e.toString());
		       }
	}
}

	/*
	 * 
	 * 
	 * 		HttpParams myParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(myParams, 10000);
		HttpConnectionParams.setSoTimeout(myParams, 10000);
		httpClient = new DefaultHttpClient(myParams);
		localContext = new BasicHttpContext();
		webserviceURL = serviceName;

	}
	
	//Use this method to do a HttpPost\WebInvoke on a Web Service
	public String webInvoke(String methodName, Map<String, Object> params) {
		JSONObject jsonObject = new JSONObject();
		for (Map.Entry<String, Object> param : params.entrySet()){
			try {
				jsonObject.put(param.getKey(), param.getValue());
			}
			catch (JSONException e) {
				Log.e("WEBSERVICE", "JSONException : "+e);
			}
		}
		return webInvoke(methodName, jsonObject.toString(), "application/json");
	}
	
	//POST
	private String webInvoke(String methodName, String data, String contentType) {
		ret = null;
		httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY,
		CookiePolicy.RFC_2109);
		httpPost = new HttpPost(webServiceUrl + methodName);
		response = null;
		StringEntity tmp = null;
		//httpPost.setHeader("User-Agent", "SET YOUR USER AGENT STRING HERE");
	
		if (contentType != null) {
			httpPost.setHeader("Content-Type", contentType);
			} 
		else {
			httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		}
		
		try {
			tmp = new StringEntity(data,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			Log.e("Groshie", "HttpUtils : UnsupportedEncodingException : "+e);
		}
		
		httpPost.setEntity(tmp);
		Log.d("Groshie", webServiceUrl + "?" + data);
		try {
		response = httpClient.execute(httpPost,localContext);
		if (response != null) {
		ret = EntityUtils.toString(response.getEntity());
		}
		} catch (Exception e) {
	 * */
