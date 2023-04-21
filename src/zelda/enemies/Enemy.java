package zelda.enemies;

import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;

import zelda.Link;
import zelda.Orientation;
import zelda.scenary.Board;

public abstract class Enemy extends AnimatedSprite {
	private Timer figth;
	protected Timer hit;
	protected static final int HIT_TIMER = 1000;
	private Orientation orientation;
	private int life;
	public abstract void walk(Orientation direction); 
	public abstract void walkauto(); 

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	 public void setLife(int life) {
		 this.life = life;
	 }
	 public int getLife() {
		 return this.life;
	 }
	
	
	
	
	public Enemy(int life) {
		this.life = life;
		this.hit = new Timer(Enemy.HIT_TIMER);
		this.hit.setActive(false);
	}
	
	public Timer getHit() {
		return this.hit;
	}
	
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		if (this.hit.action(elapsedTime)) {
			this.hit.setActive(false);
		}
		
	}
	
	

}
