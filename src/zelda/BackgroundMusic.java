package zelda;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BackgroundMusic extends Thread {
	
	public void run() {
		AudioInputStream audioInputStream;
		try {
			System.out.println("Je suis là");
			audioInputStream = AudioSystem.getAudioInputStream(new File ("res/sounds/son_jeu.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}