package com.lopparg.chechennumbers;




import android.content.Context;
import android.media.MediaPlayer;

public class Number {
	
	//Welche Sound soll abgespielt werden
	int sound_number;
	int sound[] = {R.raw.sound1, R.raw.sound2, R.raw.sound3};
	
	
	MediaPlayer md;  // Media Player um den Sound zu wiedergeben
	Context ctx;
	
	
	//Konstruktor um Number oObjekt zu erstellen
	public Number(Context ctx, int sound_number) {
		this.ctx = ctx;
		this.sound_number = sound_number;
		md = MediaPlayer.create(ctx, sound[sound_number]);
		
	}
	
	
	public int getSound() {
		return sound_number;
	}

	public void setSound(int sound_number) {
		this.sound_number = sound_number;
		md.reset();
		md = MediaPlayer.create(ctx, sound[sound_number]);
	}
	
	
	void playSound() {
		md.start();
	}
	
	void release() {
		md.release();
	}
	
	
	
	

}
