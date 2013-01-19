package com.example.ouri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class MakeNetworkMessage {

    private final String awsIPAddress = "http://54.235.197.14:3000/schools/";
    private Context thisContext;
	public MakeNetworkMessage(Context a) {
		thisContext = a;
	}
	public void test () {
		new ProcessTask().execute(null, null, null);
	}
	private class ProcessTask extends AsyncTask<Void, Void, Void> {
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			URL url = null;
			HttpURLConnection httpURLCon;
			try {
				url = new URL(awsIPAddress);
				httpURLCon = (HttpURLConnection) url.openConnection();
				httpURLCon.setDefaultUseCaches(false);
				httpURLCon.setDoInput(true);
				httpURLCon.setDoOutput(false);
				httpURLCon.setRequestProperty("content-type",  "application/x-www-form-urlencoded");		
				httpURLCon.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
		//		httpURLCon.setRequestProperty("Access","[star]/[star]");
				httpURLCon.setRequestMethod("GET");
				httpURLCon.connect();
				
				InputStream is = httpURLCon.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				
				char[] buff = new char[512];
				
				int len = -1;
				
				while( (len = br.read(buff)) != -1) {
					Toast toast = Toast.makeText(thisContext, new String(buff, 0, len), Toast.LENGTH_SHORT);
					toast.show();
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return null;
		}
	}
	private class ProcessTaskPost extends AsyncTask<Void, Void, Void> {
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			URL url = null;
			HttpURLConnection httpURLCon;
			try {
				url = new URL(awsIPAddress);
				httpURLCon = (HttpURLConnection) url.openConnection();
				httpURLCon.setDefaultUseCaches(false);
				httpURLCon.setDoInput(true);
				httpURLCon.setDoOutput(true);
				httpURLCon.setRequestProperty("content-type",  "application/x-www-form-urlencoded");		
				httpURLCon.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
				httpURLCon.setRequestMethod("POST");
				httpURLCon.connect();
				
				InputStream is = httpURLCon.getErrorStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				
				char[] buff = new char[512];
				
				int len = -1;
				
				while( (len = br.read(buff)) != -1) {
					Toast toast = Toast.makeText(thisContext, new String(buff, 0, len), Toast.LENGTH_SHORT);
					toast.show();
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return null;
		}
	}
}
