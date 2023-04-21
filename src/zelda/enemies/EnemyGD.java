package zelda.enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import zelda.scenary.Board;
import zelda.*;


import com.golden.gamedev.Game;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;

public class EnemyGD  extends Enemy{  
	
    static final double SPEED = 0.05;  
    
    private static final int ANIMATION_DELAY = 250;  
    
    private static final int FIGHT_TIMER = 300;
    
    
    public static final Orientation DEFAULT_ORIENTATION = Orientation.EAST;
    
    private Zelda game;
    
    
    private Orientation orientation;
    
   
    
    private Timer figth;
    
    //private static CollisionManager murmanager;
    //private static CollisionManager linkManager;
    
    private String numero;

    
    public EnemyGD(Zelda game,String numero, int x, int y, int life) {
    	super(life);
        this.game = game;
        this.orientation = (Orientation) EnemyGD.DEFAULT_ORIENTATION;
        this.getAnimationTimer().setDelay(EnemyGD.ANIMATION_DELAY);
        this.figth = new Timer(EnemyGD.FIGHT_TIMER);
        this.figth.setActive(false);
        //this.murmanager = new EnemyGDCollisionManager();
        //this.linkManager = new EnemyGDCollisionManager();
        this.numero = numero;
        this.initResources(x, y);
       
        
        
    }
    
    private void initResources(int x,int y) {
        BufferedImage[] sprites = new BufferedImage[4];
        // Marche Ouest
        sprites[0] = game.getImage("res/sprites/Ennemies/E"+this.numero+"WW1.gif");
        sprites[1] = game.getImage("res/sprites/Ennemies/E"+this.numero+"WW2.gif");
        // Marche Est
        sprites[2] = game.getImage("res/sprites/Ennemies/E"+this.numero+"WE1.gif");
        sprites[3] = game.getImage("res/sprites/Ennemies/E"+this.numero+"WE2.gif");
     
        
        this.setImages(sprites);
        this.setLocation(x, y);
        this.setAnimationFrame(0, 0);
    }
    
   public void setBoard(Board board) {
        SpriteGroup EnemyGD = game.getQuest().getGroup("ENEMYGD SPRITE GROUPE");//game.getQuest().getEnemySG(); 
        EnemyGD.add(this);
        //this.murmanager.setCollisionGroup(EnemyGD, board.getForeground());
        
        //SpriteGroup link = game.getLink().getSpriteGroup();
	    //this.linkManager.setCollisionGroup(EnemyGD, link);
   }
    
    public void update(long elapsedTime) {
        super.update(elapsedTime);
        this.walkauto();
        if (this.figth.action(elapsedTime)) {
            this.figth.setActive(false);
            if (this.orientation.equals(Orientation.WEST)) {
                this.setX(this.getX() + 22);
               
                    this.setAnimationFrame(0, 1);
               
            }
        }
       if (this.getLife() < 1) {
    	   this.moveX(1000);
       }
    }

    
    public void render(Graphics2D g) {
        super.render(g);
    }
    
   
    
    public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
    
    public void walk(Orientation direction) {
        if (!this.figth.isActive()) { 
            switch (direction) {
            case EAST:
             
                this.setAnimationFrame(2, 3);
                this.setAnimate(true);
                this.setHorizontalSpeed(EnemyGD.SPEED);
                this.setVerticalSpeed(0);
                this.orientation = Orientation.EAST;
                break;
            
            case WEST:
                this.setAnimationFrame(0, 1);
                this.setAnimate(true);
                this.setHorizontalSpeed(-EnemyGD.SPEED);
                this.setVerticalSpeed(0);
                this.orientation = Orientation.WEST;
                break;
            default:
                // do nothing
            
            	}
        }
    }
    
    public void fight() {
        if (!this.figth.isActive()) { 
            this.setSpeed(0, 0);
            this.figth.setActive(true);
            switch (this.orientation) {
           
            case EAST:
                this.setAnimationFrame(2, 3);
                this.setAnimate(true);
                break;
            case WEST:
                this.setX(this.getX() - 22);
                this.setAnimationFrame(0, 1);
                this.setAnimate(true);
                this.orientation = Orientation.WEST;
                break;
            default:
                // do nothing
            }
        }
    }
    
    /*
    private class EnemyGDCollisionManager extends AdvanceCollisionGroup {
        public EnemyGDCollisionManager() {
            this.pixelPerfectCollision = false;
        }
        
        public void collided(Sprite s1, Sprite s2) {
        	
        	
        	if (this.getCollisionSide() == Orientation.EAST.ordinal() ) {
        		
        		orientation = Orientation.WEST;
        		
        	} else if (this.getCollisionSide() == Orientation.WEST.ordinal() ) {
            		
            		orientation = Orientation.EAST;
            }
        }
    }
    */
   
    
    public void walkauto() {
    	if (this.getX()<0) {
        		this.walk(this.orientation.EAST); 
    	}
    	if (this.getX()>game.WIDTH) {
    			this.walk(this.orientation.WEST); 
    	}
    	this.walk(orientation);
    }


        
}
    

    
