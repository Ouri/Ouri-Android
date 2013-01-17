package com.example.ouri;
	
import com.example.ouri.SessionEvents.AuthListener;
import com.example.ouri.SessionEvents.LogoutListener;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.Facebook;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.app.Activity;
import android.content.Intent;

public class Ouri extends Activity {
	public static final String APP_ID = "261067740686512";
	
	private Facebook mFacebook;
	private LoginButton mLoginButton;
	private AsyncFacebookRunner mAsyncRunner;
    private final String awsAddress = "ec2-23-22-240-202.compute-1.amazonaws.com";
    private final String awsIPAddress = "54.235.197.14";
    private ImageButton mSignUp;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        
        mLoginButton = (LoginButton) findViewById(R.id.fbLogin);
        mSignUp = (ImageButton) findViewById(R.id.btn_signUp);
        
        mFacebook = new Facebook(APP_ID);
       	mAsyncRunner = new AsyncFacebookRunner(mFacebook);
       	SessionStore.restore(mFacebook, this);
        SessionEvents.addAuthListener(new SampleAuthListener());
        SessionEvents.addLogoutListener(new SampleLogoutListener());
        mLoginButton.init(this, mFacebook);
        /*
        testButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}        	
        });*/
        
        mSignUp.setOnClickListener (new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(Ouri.this, AddSignUpInfo.class);  
                startActivity(intent);  
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
