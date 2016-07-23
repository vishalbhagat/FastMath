package com.vishalbhagat.project;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class EndActivity extends Activity implements OnClickListener {
Button tryagain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end);
		ActionBar bar = getActionBar();
        bar.setIcon(R.drawable.alarm);
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff8000")));
		tryagain =  (Button) findViewById(R.id.tryagain);
		tryagain.setOnClickListener(this);
	}

	

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, SelectActivity.class);
		 startActivity(intent);
		 finish();
		
	}
}
