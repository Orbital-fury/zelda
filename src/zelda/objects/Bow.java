package zelda.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.golden.gamedev.object.SpriteGroup;

import zelda.Zelda;


public class Bow extends ObjectZ {
	
	private Zelda game;
	
	
	public Bow(Zelda game) {
        super();
		this.game = game;
		this.initResources();
		this.setActive(true);
				
    }
	
	public void setBow() {
		SpriteGroup bowSG = game.getQuest().getBowSG();
        bowSG.add(this);
       
    }
	
	private void initResources() {
		BufferedImage sprite = game.getImage("res/sprites/Objects/OBOW.gif");
        this.setImage(sprite);
    }
	
	public void update() {
    }
	
	public void render(Graphics2D g) {
        super.render(g);
    }
	

}
