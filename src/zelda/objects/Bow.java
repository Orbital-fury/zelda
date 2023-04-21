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
		//this.manager = new RubyCollisionManager();		
    }
	
	public void setBow() {
		SpriteGroup bowSG = game.getQuest().getBowSG();
        bowSG.add(this);
        //SpriteGroup link = game.getQuest().getLinkSG();
        //this.manager.setCollisionGroup(rubySG, link);
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
	
	/*
	protected class RubyCollisionManager extends BasicCollisionGroup {
		
		public boolean colliding = false;
		
		public RubyCollisionManager() {
            this.pixelPerfectCollision = false;
        }
        
        public void collided(Sprite s1, Sprite s2) {
        	if (!colliding) {
        		game.getQuest().getMenu().gainRuby(1);
        		System.out.println(game.getQuest().getMenu().getNbrRuby());
        		colliding = true;
        	}
        	s1.setActive(false);
        }
    }
    */

}
