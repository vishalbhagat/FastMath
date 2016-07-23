package com.vishalbhagat.project;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class GameActivity extends Activity implements OnClickListener {
	private final String tag = "fastmath";
	private int time ;
	private int bigPrime = 1982451653;
	Button start;
	Button ok;
	long millisUntilFinished;
	private float answercalculated;
	private float youranswer;
	private String equation;
	private int totalScore;
	TextView score;
	EquationGenerator eqgen;
	EditText answer;

	
TextView  timerTextView;
TextView  equationtext;
MyCountDownTimer countTimer;
DecimalFormat df;
Bundle bundle;
int level;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bundle = getIntent().getExtras(); 
		if (bundle != null) {
		    level = bundle.getInt("level");
		}
		if(level==1 || level == 2)
		{
			this.time = 40;
			df = new DecimalFormat("######.##");
		}else if (level==3)
		{
			this.time = 40;
			df = new DecimalFormat("######.###");
		}
		else if(level==4)
		{
			this.time = 40;
			df = new DecimalFormat("######.####");
		}else if(level == 5)
		{
			this.time = 40;
			df = new DecimalFormat("######.####");
		}
		eqgen = new EquationGenerator(level);
		totalScore = 0;
		setContentView(R.layout.activity_game);

		timerTextView = (TextView) findViewById(R.id.timer);
		start = (Button) findViewById(R.id.start);
		ok =(Button) findViewById(R.id.ok);
		start.setOnClickListener(this);
		ok.setOnClickListener(this);
		ok.setEnabled(false);
		answer = (EditText) findViewById(R.id.answer);
		answer.setText("");
		score = (TextView) findViewById(R.id.score);
		score.setText("Score :" + Integer.toString(totalScore));
		timerTextView.setText("Timer :" +time+ " seconds");
		equationtext  = (TextView) findViewById(R.id.equation);
		equationtext.setText(".........");
		df.setRoundingMode(RoundingMode.DOWN);
		ActionBar bar = getActionBar();
	    bar.setIcon(R.drawable.alarm);
	    bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff8000")));
	    bar.setDisplayHomeAsUpEnabled(true);

	    countTimer = new MyCountDownTimer(time*1000,1000);
	 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	 public class MyCountDownTimer extends CountDownTimer {
		 long millisUntilFinished;
		  public MyCountDownTimer(long startTime, long interval) {
		   super(startTime, interval);
		  }

		  @Override
		  public void onFinish() {
		    timerTextView.setText("Time's up!");
		    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
			startActivity(intent);
		  }

		  @Override
		  public void onTick(long millisUntilFinished) {
			  this.millisUntilFinished =  millisUntilFinished;
			  Log.d(tag, "millisUntilFinished : "+millisUntilFinished/1000);
			  if(millisUntilFinished / 1000 <4)
			  {
				  timerTextView.setTextColor(Color.RED);
			  } 
			  timerTextView.setText("Timer :" + millisUntilFinished / 1000 +" seconds");
		  }

		
		  public long getTime()
		  {
			  return millisUntilFinished;
		  }
		  
		 }


	@Override
	public void onClick(View v) {
		
		if(v.getId()==R.id.start)
		{	start.setEnabled(false);
			ok.setEnabled(true);
			
			countTimer.start();
			equation  = eqgen.getEquation();
			equationtext.setText(equation);
			
	        
		}
		else if(v.getId()==R.id.ok)
		{ 	
			this.answercalculated = Float.parseFloat(df.format(eqgen.getAnswer()));
			Log.d(tag, "answercalculated : "+answercalculated);
			try{ 
					this.youranswer = Float.parseFloat(answer.getText().toString());
					
			}catch(NumberFormatException ex){
				this.youranswer = bigPrime;
		}	
			if( Float.compare(this.answercalculated, this.youranswer) == 0)
				{ 
						start.setEnabled(true);
						ok.setEnabled(false);
						
						totalScore = totalScore + (int)(countTimer.getTime()/1000);
						score.setText("Score :" + Integer.toString(totalScore));
						answer.setText("");
						equationtext.setText(".........");
						eqgen = new EquationGenerator(level);
						countTimer.cancel();
						
					}
			else
			{

			}
			
		}
		
	}



	 @Override
	protected void onDestroy() {
		countTimer.cancel();
		finish();
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {
		countTimer.cancel();
		finish();
		super.onBackPressed();
	}

	@Override
	  public void onResume() {
		
	    super.onResume();

	  }

	  @Override
	  public void onPause() {

	    finish();
	    super.onPause();
	  }



}
