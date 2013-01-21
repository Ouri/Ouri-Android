package com.example.ouri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

public class MakeNetworkMessage {

    private final String awsIPAddress = "http://54.235.197.14:3000/";
	public MakeNetworkMessage() {
	}
	
	public void sendSignOn(String json) {
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("type", "ouri"));
			params.add(new BasicNameValuePair("email", "test2"));
			params.add(new BasicNameValuePair("pw", "test3"));
			String parameters = new String();
			parameters = "{" + "\"method\" : " + "\"sign/in/\", " +
					"\"params\" : \"" + getQuery(params) + "\"}";
			new ProcessTaskPost().execute(parameters, null, null);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendSchools() {
		String parameters = new String();
		parameters = "{" + "\"method\" : " + "\"schools/\", " +
				"\"params\" : \"\"}";
		new ProcessTaskGet().execute(parameters, null, null);
	}
	
	private String jsonParser(String json, String target) {
		try {	
			JSONObject jObj = new JSONObject(json);
			return jObj.getString(target);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No key";
		}
		
		
	}
	private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException
	{
	    StringBuilder result = new StringBuilder();
	    boolean first = true;

	    for (NameValuePair pair : params)
	    {
	        if (first)
	            first = false;
	        else
	            result.append("&");

	        result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
	        result.append("=");
	        result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
	    }

	    return result.toString();
	}
	public String sendGet(String method, String params){
		URL url = null;
		HttpURLConnection httpURLCon;
		try {
			url = new URL(awsIPAddress + method);
			httpURLCon = (HttpURLConnection) url.openConnection();
			httpURLCon.setDefaultUseCaches(false);
			httpURLCon.setDoInput(true);
			httpURLCon.setDoOutput(false);
			httpURLCon.setRequestProperty("content-type",  "application/x-www-form-urlencoded");		
			httpURLCon.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
			httpURLCon.setRequestMethod("GET");
			httpURLCon.connect();
			
			InputStream is = httpURLCon.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));		
			
			String result = new String("");
			String buffer = new String("");
			while ( (buffer = br.readLine()) != null) {
				result += buffer;
			}
			br.close();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}	
	}
	public String sendPost(String method, String params){
		URL url = null;
		HttpURLConnection httpURLCon;
		try {
			url = new URL(awsIPAddress + method);
			httpURLCon = (HttpURLConnection) url.openConnection();
			httpURLCon.setDefaultUseCaches(false);
			httpURLCon.setDoInput(true);
			httpURLCon.setDoOutput(true);
			httpURLCon.setRequestProperty("content-type",  "application/x-www-form-urlencoded");		
			httpURLCon.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
			httpURLCon.setRequestMethod("POST");
			
			OutputStream os = httpURLCon.getOutputStream();
			BufferedWriter writer = new BufferedWriter(
			        new OutputStreamWriter(os, "UTF-8"));
			writer.write(params);
			writer.close();
			os.flush();
			os.close();
			
			InputStream is = httpURLCon.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String result = new String("");
			String buffer = new String("");
			while ( (buffer = br.readLine()) != null) {
				result += buffer;
			}
			br.close();
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}		
	}
	
	private class ProcessTaskGet extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub			
			return sendGet(jsonParser(params[0], "method"), jsonParser(params[0], "params"));
		}
		protected void onPostExecute(String result){
			System.out.println(result);
		}
	}
	
	
	private class ProcessTaskPost extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			return sendPost(jsonParser(params[0], "method"), jsonParser(params[0], "params"));
		}
		protected void onPostExecute(String result){
			System.out.println(result);
		}
	}
}
