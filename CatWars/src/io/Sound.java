package io;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip clip;
	
	public Sound() {
		
	}
	
	public void setSound(URL soundURL, int type) {
		
		try {

			AudioInputStream sound = AudioSystem.getAudioInputStream(soundURL);
			clip = AudioSystem.getClip();
			clip.open(sound);
			
			clip.setFramePosition(0);
			clip.start();
			
			if (type == 1) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();

				while (clip.isRunning()) {
					Thread.sleep(100);
					
				}
			}
			clip.start();	
		
	}
		catch(Exception e) {
			System.out.println("No sound");
		}
		
	}
	
	
//	
//	public void play(int type) {
//		clip.setFramePosition(0);
//		clip.start();
//		
//		if (type == 1) {
//			clip.loop(Clip.LOOP_CONTINUOUSLY);
//			clip.start();
//
//			while (clip.isRunning()) {
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//		}
//		
//		
//	}


}
