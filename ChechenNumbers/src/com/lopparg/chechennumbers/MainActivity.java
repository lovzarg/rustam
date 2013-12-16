package com.lopparg.chechennumbers;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button button1;

	Button button2;
	Button button3;

	TextView enterTextView;

	int sound;
	Number num;
	int score = 0;
	Context ctx;

	Random ran = new Random();







	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);

		enterTextView = (TextView) findViewById(R.id.enterTextView);
		ctx  = this;
		num = new Number(ctx, 1);
		num.playSound();


		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(sound == 0){
					success();
				} else {
					playNextSound();
				}
			}
		});

		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(sound == 1){
					success();
				} else {
					playNextSound();
				}
			}
		});

		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(sound == 2){
					success();
				
				} else { playNextSound();}
			}
		});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void playNextSound() {

		sound = ran.nextInt(3);
		num.setSound(sound);
		num.playSound();
	}




	private void success() {
		score++;
		enterTextView.setText(Integer.toString(score));
		playNextSound();

	}
	
	


}
