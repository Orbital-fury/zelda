package zelda;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;

public class GameOverObject extends Sprite {
	
	private Zelda game;

    public GameOverObject(Zelda game) {
    	this.game = game;
    	BufferedImage sprite = game.getImage("res/sprites/TRIFORCE_TRIANGLE.gif");
        this.setImage(sprite);
        this.setActive(true);
    }
    
    public void update() {
    }
	
	public void render(Graphics2D g) {
        super.render(g);
    }
    
    
}