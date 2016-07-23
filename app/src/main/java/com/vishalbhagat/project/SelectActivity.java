package com.vishalbhagat.project;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SelectActivity extends Activity implements OnClickListener  {
Button begin;
Button med;
Button hard;
Button chal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);
		 ActionBar bar = getActionBar();
	        bar.setIcon(R.drawable.alarm);
	        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff8000")));
	        begin = (Button)findViewById(R.id.my_button1);
	        med =(Button)findViewById(R.id.my_button2);
	        hard = (Button)findViewById(R.id.my_button3);
	        chal = (Button)findViewById(R.id.my_button4);
	        begin.setOnClickListener(this);
	        med.setOnClickListener(this);
	        hard.setOnClickListener(this);
	        chal.setOnClickListener(this);
	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		Toast.makeText(getApplicationContext(), "id " + id, Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, GameActivity.class);
		if(id ==R.id.my_button1)
		{
			intent.putExtra("level", 1);
		}else if (id ==R.id.my_button2)
		{
			intent.putExtra("level", 2);
		}
		else if (id ==R.id.my_button3)
		{
			intent.putExtra("level", 3);
		}
		else if (id ==R.id.my_button4)
		{
			intent.putExtra("level", 4);
		}
		
	 startActivity(intent);
		
			
		
	}
}
