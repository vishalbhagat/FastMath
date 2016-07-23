package com.vishalbhagat.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;




public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


	protected void onStart() {
		super.onStart();
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent mainIntent = new Intent(MainActivity.this,SelectActivity.class);
					MainActivity.this.startActivity(mainIntent);
				// Finish the splash activity so it can't be returned to.
					MainActivity.this.finish();
				// Create an Intent that will start the main activity.
				
			}
		}, 1500);

	}
    
   
}
