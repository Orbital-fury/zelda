package zelda.scenary;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import zelda.Link;
import zelda.Zelda;
import zelda.enemies.Enemy;
import zelda.enemies.Enemy4D;
import zelda.enemies.EnemyGD;
import zelda.objects.Ruby;
import zelda.objects.Ruby.Kind;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;

public class Board {
    
    public final static int HEIGHT = 11;
    
    public final static int WIDTH = 16;
    
    private int x;
    
    private int y;
    
    private ArrayList<Ruby> rubies = new ArrayList<Ruby>();
    
    private AbstractTile[][] tiles;
    
    private Zelda game;
    
    private int size;
    
    private boolean display;
    
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    
    public Board(Zelda game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.tiles = new AbstractTile[WIDTH][HEIGHT];
        this.size = 0;
        display = true;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    
    
    
    public boolean moveTo(long elapsedTime, double x, double y, double speed) {
        boolean reached = false;
        for (int i = 0; i < Board.WIDTH; i++) {
            for (int j = 0; j < Board.HEIGHT; j++) {
                if (tiles[i][j] != null) {
                    reached &= tiles[i][j].moveTo(elapsedTime, x, y, speed);
                }
            }
        }
        return reached;        
    }
    
    public List<Sprite> getSprites() {
        List<Sprite> sprites = new ArrayList<Sprite>();
        for (int i = 0; i < Board.WIDTH; i++) {
            for (int j = 0; j < Board.HEIGHT; j++) {
                if (tiles[i][j] != null) {
                    sprites.addAll(tiles[i][j].getSprites());
                }
            }
        }
        return sprites;
    }
    
    public void add(AbstractTile tile) {
        int x = this.size % Board.WIDTH;
        int y = this.size/Board.WIDTH;
        tile.setLocation(x * 42, y * 42 + 126);
        tiles[x][y] = tile;
        this.size++;
        
   }
    
    public SpriteGroup getForeground() {
        SpriteGroup foreground = new SpriteGroup("FOREGROUND");
        for (int i = 0; i < Board.WIDTH; i++) {
            for (int j = 0; j < Board.HEIGHT; j++) {
                if (tiles[i][j] != null) {
                    SpriteGroup sg = tiles[i][j].getForeground(); 
                    Sprite sprites[] = sg.getSprites();
                    for (int k = 0; k < sg.getSize(); k++) {
                        foreground.add(sprites[k]);
                    }
                }
            }
        }
        return foreground;
    }
    
    public SpriteGroup getBackground() {
        SpriteGroup background = new SpriteGroup("BACKGROUND");
        for (int i = 0; i < Board.WIDTH; i++) {
            for (int j = 0; j < Board.HEIGHT; j++) {
                if (tiles[i][j] != null) {
                    SpriteGroup sg = tiles[i][j].getBackground();
                    Sprite sprites[] = sg.getSprites();
                    for (int k = 0; k < sg.getSize(); k++) {
                        background.add(sprites[k]);
                    }
                }
            }
        }
        return background;
    }
    
    public void update(long elapsedTime) {
        for (int i = 0; i < Board.WIDTH; i++) {
            for (int j = 0; j < Board.HEIGHT; j++) {
                if (tiles[i][j] != null) {
                    tiles[i][j].update(elapsedTime);
                }
            }
        }
        for (Ruby ruby : rubies) {
        	ruby.update();
        }
        for (Enemy enemy : enemies) {
        	enemy.update(elapsedTime);
        }
    }
    
    public void createRuby() {
    	Ruby ruby = new Ruby(Kind.BLUE, game);
    	ruby.setRuby();
    	rubies.add(ruby);
        ruby.setLocation(game.getLink().getX() + 50, game.getLink().getY());
    }

    public void render(Graphics2D g) {
        for (int i = 0; i < Board.WIDTH; i++) {
            for (int j = 0; j < Board.HEIGHT; j++) {
                if (tiles[i][j] != null) {
                    tiles[i][j].render(g);
                }
            }
        }
        for (Enemy enemy : enemies) {
        	enemy.render(g);
        }
        for (Ruby ruby : rubies) {
        	ruby.render(g);
        }
    }
    
    public void setEnemyOnBoard(String typeEnnemi, int x, int y) {
    	if (Integer.parseInt(typeEnnemi) < 20){
    		System.out.println(Integer.parseInt(typeEnnemi));
    		
    		Enemy4D enemy01 = new Enemy4D(game, typeEnnemi, x, y);
        	enemies.add(enemy01);
        	enemy01.setBoard(this);
    	}
    	else {
    		EnemyGD enemy02 = new EnemyGD(game, typeEnnemi, x, y);
        	enemies.add(enemy02);
        	enemy02.setBoard(this);
    	}
    }
}
