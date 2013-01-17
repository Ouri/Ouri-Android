/*
package com.example.ouri;
	

import com.example.ouri.R;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.Facebook;
import com.example.ouri.SessionEvents.AuthListener;
import com.example.ouri.SessionEvents.LogoutListener;
import com.example.ouri.LoginButton;
import com.example.ouri.SessionStore;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;

public class Main extends Activity {
	public static final String APP_ID = "261067740686512";
	
	private Facebook mFacebook;
	private LoginButton mLoginButton;
	private Button testButton;
    private AsyncFacebookRunner mAsyncRunner;
    private final String awsAddress = "ec2-23-22-240-202.compute-1.amazonaws.com";
    private final String awsIPAddress = "54.235.197.14";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginButton = (LoginButton) findViewById(R.id.button1);
        testButton = (Button) findViewById(R.id.button2);
        
        mFacebook = new Facebook(APP_ID);
       	mAsyncRunner = new AsyncFacebookRunner(mFacebook);
       	SessionStore.restore(mFacebook, this);
        SessionEvents.addAuthListener(new SampleAuthListener());
        SessionEvents.addLogoutListener(new SampleLogoutListener());
        mLoginButton.init(this, mFacebook);
        
        testButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
        	
        });
    }

    public class SampleAuthListener implements AuthListener {

        public void onAuthSucceed() {
        }

        public void onAuthFail(String error) {
        }
    }

    public class SampleLogoutListener implements LogoutListener {
        public void onLogoutBegin() {
        }

        public void onLogoutFinish() {
        }
    }
    
}
*/