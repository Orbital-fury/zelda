package zelda.enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import zelda.*;
import zelda.Orientation;
import zelda.objects.Blade;
import zelda.objects.Shield;
import zelda.scenary.Board;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;

public class Enemy extends AnimatedSprite {

    
    private static final double SPEED = 0.2;  
    
    private static final int ANIMATION_DELAY = 100;  
    
    private static final int FIGHT_TIMER = 300;
    
    public static final Orientation DEFAULT_ORIENTATION = Orientation.NORTH;
    
    private Game game;
    
    private Orientation orientation;
    
    private int life;
    
    private Timer figth;
    
    private CollisionManager manager;
    
    private String numero;
    
    public Enemy(Game game, String numero, int x, int y) {
        this.game = game;
        this.orientation = Enemy.DEFAULT_ORIENTATION;
        this.getAnimationTimer().setDelay(Enemy.ANIMATION_DELAY);
        this.figth = new Timer(Enemy.FIGHT_TIMER);
        this.figth.setActive(false);
        this.manager = new EnemyCollisionManager();
        
        this.numero = "01";//numero;
        this.initResources(x, y);
    }
    
    private void initResources(int x, int y) {
        BufferedImage[] sprites = new BufferedImage[8];
        // Walk north
        sprites[0] = game.getImage("res/sprites/Ennemies/E"+this.numero+"WN1.gif");
        sprites[1] = game.getImage("res/sprites/Ennemies/E"+numero+"WN1.gif");
        // Walk south
        sprites[2] = game.getImage("res/sprites/Ennemies/E"+numero+"WS1.gif");
        sprites[3] = game.getImage("res/sprites/Ennemies/E"+numero+"WS1.gif");
        // Walk east
        sprites[4] = game.getImage("res/sprites/Ennemies/E"+numero+"WE1.gif");
        sprites[5] = game.getImage("res/sprites/Ennemies/E"+numero+"WE1.gif");
        // Walk west
        sprites[6] = game.getImage("res/sprites/Ennemies/E"+numero+"WW1.gif");
        sprites[7] = game.getImage("res/sprites/Ennemies/E"+numero+"WW1.gif");
        
        this.setImages(sprites);
        this.setLocation(x, y);
        this.setAnimationFrame(0, 0);
    }
    
    public void setBoard(Board board) {
        SpriteGroup enemy = new SpriteGroup("ENEMY SPRITE GROUPE");
        enemy.add(this);
        this.manager.setCollisionGroup(enemy, board.getForeground());
    }
    
    public void update(long elapsedTime) {
        super.update(elapsedTime);
        if (this.figth.action(elapsedTime)) {
            this.figth.setActive(false);
            if (this.orientation.equals(Orientation.WEST)) {
                this.setX(this.getX() + 22);
                this.setAnimationFrame(6, 16);
            } else if (this.orientation.equals(Orientation.NORTH)) {
                this.setY(this.getY() + 22);
                this.setAnimationFrame(0, 0);
            }
        }
        if (this.manager != null) 
            this.manager.checkCollision();
    }

    
    public void render(Graphics2D g) {
        super.render(g);
    }

    
    public void walk(Orientation direction) {
        if (!this.figth.isActive()) { 
            switch (direction) {
            case NORTH:
                this.setAnimationFrame(0, 1);
                this.setAnimate(true);
                this.setVerticalSpeed(-Enemy.SPEED);
                this.setHorizontalSpeed(0);
                this.orientation = Orientation.NORTH;
                break;
            case SOUTH:
                this.setAnimationFrame(2, 3);
                this.setAnimate(true);
                this.setVerticalSpeed(Enemy.SPEED);
                this.setHorizontalSpeed(0);
                this.orientation = Orientation.SOUTH;
                break;
            case EAST:
                this.setAnimationFrame(4, 5);
                this.setAnimate(true);
                this.setHorizontalSpeed(Enemy.SPEED);
                this.setVerticalSpeed(0);
                this.orientation = Orientation.EAST;
                break;
            case WEST:
                this.setAnimationFrame(6, 7);
                this.setAnimate(true);
                this.setHorizontalSpeed(-Enemy.SPEED);
                this.setVerticalSpeed(0);
                this.orientation = Orientation.WEST;
                break;
            default:
                // do nothing
            }
        }
    }
    /*
    public void fight() {
        if (!this.figth.isActive()) { 
            this.setSpeed(0, 0);
            this.figth.setActive(true);
            switch (this.orientation) {
            case NORTH:
                this.setY(this.getY() - 22);
                this.setAnimationFrame(14, 16);
                this.setAnimate(true);
                break;
            case SOUTH:
                switch(this.shield) {
                case SMALL:
                    this.setAnimationFrame(17, 19);
                    break;
                case MAGICAL:
                    this.setAnimationFrame(20, 22);
                    break;
                default:
                    // do nothing
                }
                this.setAnimate(true);
                break;
            case EAST:
                switch(this.shield) {
                case SMALL:
                    this.setAnimationFrame(23, 25);
                    break;
                case MAGICAL:
                    this.setAnimationFrame(26, 28);
                    break;
                default:
                    // do nothing
                }
                this.setAnimate(true);
                break;
            case WEST:
                this.setX(this.getX() - 22);
                switch(this.shield) {
                case SMALL:
                    this.setAnimationFrame(29, 31);
                    break;
                case MAGICAL:
                    this.setAnimationFrame(32, 34);
                    break;
                default:
                    // do nothing
                }
                this.setAnimate(true);
                this.orientation = Orientation.WEST;
                break;
            default:
                // do nothing
            }
        }
    }
    */
    private class EnemyCollisionManager extends AdvanceCollisionGroup {
        public EnemyCollisionManager() {
            this.pixelPerfectCollision = false;
        }
        
        public void collided(Sprite s1, Sprite s2) {
            this.revertPosition1();
        }
    }
     
}
    

