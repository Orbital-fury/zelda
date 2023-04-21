package zelda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import zelda.objects.Ruby;
import zelda.objects.Ruby.Kind;
import zelda.scenary.Floor;
import zelda.scenary.Quest;
import zelda.scenary.Rock;


import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;

public class Zelda extends Game {
    
    private Link link;
   
    private Quest quest;
    
    private boolean menu;
    
    public static HashMap <Integer, Floor.Color> mapFloor = new HashMap <> () ;

	public static HashMap <Integer, Rock.Kind> mapRock = new HashMap <> () ;
    
    public static final int WIDTH = 672;
    public static final int HEIGHT = 588;
    public static final int HEIGHT_MENU = 126;
    
    public Zelda() {
        
    }
    
    public Link getLink() {
    	return link;
    }
    
    public void initResources() {
    	createMap();
        this.quest = new Quest(this);
        this.link = new Link(this);
        this.link.setBoard(this.quest.getCurrentBoard());
        this.menu = false;
        this.quest.setEnvironnement();
        
    }
    
    public static void createMap() {
		mapFloor.put(3, Floor.Color.SAND) ;
		mapFloor.put(30, Floor.Color.TROU_NOIR) ;
		mapFloor.put(7, Floor.Color.ESCALIER) ;
		mapFloor.put(8, Floor.Color.ESCALIER_D);
		mapFloor.put(9, Floor.Color.TRANS);		
		mapFloor.put(133, Floor.Color.PONT);
		
		mapRock.put(8, Rock.Kind.BUISSON) ;
		mapRock.put(9, Rock.Kind.TRANS) ;
		
		mapRock.put(44, Rock.Kind.GREEN_NORTH_WEST_CORNER) ;
		mapRock.put(93, Rock.Kind.EAU_VERT) ;
		
		
		
		mapRock.put(30, Rock.Kind.EAU_VERT) ;
		mapRock.put(67, Rock.Kind.EAU_VERT) ;
		
		
		
		
		mapRock.put(2, Rock.Kind.ROCHE) ;
		mapRock.put(27, Rock.Kind.BUISSON2) ;
		
		mapRock.put(46, Rock.Kind.GREEN_NORTH_EAST_CORNER) ;
		mapRock.put(45, Rock.Kind.GREEN_INDENTED) ;
		mapRock.put(63, Rock.Kind.GREEN_PLAIN) ;
		mapRock.put(631, Rock.Kind.GREEN_PLAIN_BORDER) ;
		mapRock.put(62, Rock.Kind.GREEN_SOUTH_WEST_CORNER) ;
		mapRock.put(64, Rock.Kind.GREEN_SOUTH_EAST_CORNER);
	}
        
    public void update(long elapsedTime) {
        if (this.keyPressed(KeyEvent.VK_ALT)) {
            this.link.fight();
        } else if (this.keyDown(KeyEvent.VK_LEFT)) {
            this.link.walk(Orientation.WEST);
        } else if (this.keyDown(KeyEvent.VK_RIGHT)) {
            this.link.walk(Orientation.EAST);
        } else if (this.keyDown(KeyEvent.VK_UP)) {
            this.link.walk(Orientation.NORTH);
        } else if (this.keyDown(KeyEvent.VK_DOWN)) {
            this.link.walk(Orientation.SOUTH);
        } else if (keyPressed(KeyEvent.VK_A)) {
        	quest.getCurrentBoard().createRuby((int) this.link.getX() + 50, (int) this.link.getY());
            
        } else if (keyPressed(KeyEvent.VK_ESCAPE)) {
            finish();
        } else {
            this.link.setSpeed(0, 0);
        }
        
        this.quest.update(elapsedTime);
        this.link.update(elapsedTime);
        this.checkBorder();
    }
    
    public void checkBorder() {
    	int x = this.quest.getCurrentBoardX();
		int y = this.quest.getCurrentBoardY();
    	if (link.getX() > (WIDTH - link.getWidth())) {
    		
    		if (x < this.quest.getBoards().length - 1) {
    			this.quest.setCurrentBoard(x + 1, y);
    			this.link.linkOnBoard(this.quest.getCurrentBoard());
    			this.link.setLocation(0, this.link.getY());
    		}
    	} else if (link.getX() < 0) {
    		if (x > 0) {
    			this.quest.setCurrentBoard(x - 1, y);
    			this.link.linkOnBoard(this.quest.getCurrentBoard());
    			this.link.setLocation((WIDTH - link.getWidth()), this.link.getY());
    		}
    	} else if (link.getY() > (HEIGHT - link.getHeight())) {
    		if (y > 0) {
    			this.quest.setCurrentBoard(x, y - 1);
    			this.link.linkOnBoard(this.quest.getCurrentBoard());
    			this.link.setLocation(this.link.getX(), HEIGHT_MENU);
    		}
    	} else if (link.getY() < HEIGHT_MENU) {
    		if (y < this.quest.getBoards()[0].length - 1) {
    			this.quest.setCurrentBoard(x, y + 1);
    			this.link.linkOnBoard(this.quest.getCurrentBoard());
    			this.link.setLocation(this.link.getX(), HEIGHT - link.getHeight());
    		}
    	}
    }

    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.quest.render(g);
        this.link.render(g);
        
    }
    
    public Quest getQuest() {
    	return quest;
    }
    
    public static void main(String[] args) {
        GameLoader game = new GameLoader();
        game.setup(new Zelda(), new Dimension(WIDTH,HEIGHT), false);
        game.start();
    }
    
}
