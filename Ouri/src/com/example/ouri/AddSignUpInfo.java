package com.example.ouri;	

import com.example.ouri.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class AddSignUpInfo extends Activity {
	
	private ImageButton nextstep;
	private Context a;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_info);   
        a = this;
        
        nextstep = (ImageButton) findViewById(R.id.btn_nextStep);
        
        nextstep.setOnClickListener (new OnClickListener() {			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MakeNetworkMessage m = new MakeNetworkMessage();
				//m.getTest();
				//m.sendSignOn("test");
				m.sendSchools();
			}
		});
    }   
    
}
