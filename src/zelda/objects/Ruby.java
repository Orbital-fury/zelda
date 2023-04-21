package zelda.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;

import zelda.Orientation;
import zelda.Zelda;
import zelda.scenary.Board;


public class Ruby extends Sprite {
	
	private Zelda game;
	
	//private RubyCollisionManager manager;
	private Kind kind;
	
	
	public enum Kind {
		BLUE("res/sprites/Objects/OBP.gif"),
        ORANGE("res/sprites/Objects/OYP.gif");
		
		private String imagePath;

        Kind(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getImagePath() {
            return imagePath;
        }
	}
	
	public Ruby(Kind kind, Zelda game) {
        super();
		this.game = game;
		this.initResources(kind);
		this.setActive(true);
		this.kind = kind;
		//this.manager = new RubyCollisionManager();		
    }
	
	public Kind getKind() {
		return kind;
	}
	
	public void setRuby() {
		SpriteGroup rubySG = game.getQuest().getRubySG();
        rubySG.add(this);
        //SpriteGroup link = game.getQuest().getLinkSG();
        //this.manager.setCollisionGroup(rubySG, link);
    }
	
	private void initResources(Kind kind) {
		BufferedImage sprite = game.getImage(kind.getImagePath());
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
