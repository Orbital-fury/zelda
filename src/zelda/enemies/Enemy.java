package zelda.enemies;

import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;

import zelda.Orientation;

public abstract class Enemy extends AnimatedSprite {
	private Timer figth;
	private Orientation orientation;
	public abstract void walk(Orientation direction); 
	public abstract void walkauto(); 

	
	
	
	
	public Enemy() {
		
	}
	
	

}
