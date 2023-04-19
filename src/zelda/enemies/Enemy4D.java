package zelda.enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import zelda.*;
import zelda.scenary.Board;

import com.golden.gamedev.Game;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;

public class Enemy4D extends Enemy {

	private static final double SPEED = 0.05;

	private static final int ANIMATION_DELAY = 250;

	private static final int FIGHT_TIMER = 300;

	public static final Orientation DEFAULT_ORIENTATION = Orientation.WEST;

	private Zelda game;

	private Orientation orientation;

	private int life;

	private Timer figth;

	private CollisionManager manager;

	private String numero;
	

	Timer test = new Timer(500);

	public Enemy4D(Zelda game, String numero, int x, int y) {
		this.game = game;
		this.orientation = (Orientation) Enemy4D.DEFAULT_ORIENTATION;
		this.getAnimationTimer().setDelay(Enemy4D.ANIMATION_DELAY);
		this.figth = new Timer(Enemy4D.FIGHT_TIMER);
		this.figth.setActive(false);
		this.manager = new EnemyCollisionManager();

		this.numero = numero;
		this.initResources(x, y);
	}

	private void initResources(int x, int y) {
		BufferedImage[] sprites = new BufferedImage[8];
		// Walk north
		sprites[0] = game.getImage("res/sprites/Ennemies/E" + this.numero + "WN1.gif");
		sprites[1] = game.getImage("res/sprites/Ennemies/E" + numero + "WN1.gif");
		// Walk south
		sprites[2] = game.getImage("res/sprites/Ennemies/E" + numero + "WS1.gif");
		sprites[3] = game.getImage("res/sprites/Ennemies/E" + numero + "WS1.gif");
		// Walk east
		sprites[4] = game.getImage("res/sprites/Ennemies/E" + numero + "WE1.gif");
		sprites[5] = game.getImage("res/sprites/Ennemies/E" + numero + "WE1.gif");
		// Walk west
		sprites[6] = game.getImage("res/sprites/Ennemies/E" + numero + "WW1.gif");
		sprites[7] = game.getImage("res/sprites/Ennemies/E" + numero + "WW1.gif");

		this.setImages(sprites);
		this.setLocation(x, y);
		this.setAnimationFrame(0, 0);
	}

	public void setBoard(Board board) {
		SpriteGroup Enemy4D = new SpriteGroup("ENEMY4D SPRITE GROUPE");
		Enemy4D.add(this);
		this.manager.setCollisionGroup(Enemy4D, board.getForeground());
	}

	public void update(long elapsedTime) {

		super.update(elapsedTime);
		this.walkauto();
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
		
		int random = ((int) (Math.random() * 4)) + 1;
		
		if (test.action(elapsedTime)) {
			
			System.out.println(test);
			System.out.println(random);
			
			if (random == 1) {
				orientation = Orientation.SOUTH;
				this.walkauto();
			} else if (random == 2) {
				orientation = Orientation.WEST;
				this.walkauto();
			} else if (random == 3) {
				orientation = Orientation.EAST;
				this.walkauto();
			} else if (random == 4) {
				orientation = Orientation.NORTH;
				this.walkauto();
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
				this.setVerticalSpeed(-Enemy4D.SPEED);
				this.setHorizontalSpeed(0);
				this.orientation = Orientation.NORTH;
				break;

			case SOUTH:
				this.setAnimationFrame(2, 3);
				this.setAnimate(true);
				this.setVerticalSpeed(Enemy4D.SPEED);
				this.setHorizontalSpeed(0);
				this.orientation = Orientation.SOUTH;
				break;

			case EAST:
				this.setAnimationFrame(4, 5);
				this.setAnimate(true);
				this.setHorizontalSpeed(Enemy4D.SPEED);
				this.setVerticalSpeed(0);
				this.orientation = Orientation.EAST;
				break;

			case WEST:
				this.setAnimationFrame(6, 7);
				this.setAnimate(true);
				this.setHorizontalSpeed(-Enemy4D.SPEED);
				this.setVerticalSpeed(0);
				this.orientation = Orientation.WEST;
				break;
			default:
				// do nothing
			}
		}
	}

	private class EnemyCollisionManager extends AdvanceCollisionGroup {
		public EnemyCollisionManager() {
			this.pixelPerfectCollision = false;
		}

		public void collided(Sprite s1, Sprite s2) {
			
			

			if (this.getCollisionSide() == Orientation.EAST.ordinal()) {

				if (orientation != Orientation.NORTH) {
					orientation = Orientation.NORTH;
				} else {
					orientation = Orientation.WEST;
				}
			}

			if (this.getCollisionSide() == Orientation.WEST.ordinal()) {

				if (orientation != Orientation.SOUTH) {
					orientation = Orientation.SOUTH;
				} else {
					orientation = Orientation.EAST;
				}
			}

			if (this.getCollisionSide() == Orientation.NORTH.ordinal()) {
				if (orientation != Orientation.WEST) {
					orientation = Orientation.WEST;
				} else {
					orientation = Orientation.SOUTH;
				}
			}

			if ((this.getCollisionSide() == Orientation.SOUTH.ordinal()))
				if (orientation != Orientation.EAST) {
					orientation = Orientation.EAST;
				} else {
					orientation = Orientation.NORTH;
				}
		}

	}

	public void walkauto() {

		if (this.getX() < 0) {
			this.walk(this.orientation.EAST);
		}
		if (this.getX() > game.WIDTH) {
			this.walk(this.orientation.WEST);
		}
		if (this.getY() > game.HEIGHT) {
			this.walk(this.orientation.SOUTH);
		}
		if (this.getY() < game.HEIGHT_MENU) {
			this.walk(this.orientation.NORTH);
		}
		this.walk(orientation);
	}
}
