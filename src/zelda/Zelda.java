package zelda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import zelda.objects.Ruby;
import zelda.objects.Ruby.Kind;
import zelda.scenary.Quest;
import zelda.scenary.Rock;


import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;

public class Zelda extends Game {
    
    private Link link;
   
    private Quest quest;
    
    private boolean menu;
    
    private static final int WIDTH = 672;
    private static final int HEIGHT = 588;
    private static final int HEIGHT_MENU = 126;
    
    public Zelda() {
        
    }
    
    public Link getLink() {
    	return link;
    }
    
    public void initResources() {
    	//Quest.createHashMap();
        this.quest = new Quest(this);
        this.link = new Link(this);
        this.link.setBoard(this.quest.getCurrentBoard());
        this.menu = false;
        
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
        } else if (this.keyDown(KeyEvent.VK_A)) {
        	this.quest.getCurrentBoard().createRuby();
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
    	if (link.getX() > (WIDTH - link.getWidth())) {
    		int x = this.quest.getCurrentBoardX();
    		int y = this.quest.getCurrentBoardY();
    		if (x < this.quest.getBoards().length - 1) {
    			this.quest.setCurrentBoard(x + 1, y);
    			this.link.setBoard(this.quest.getCurrentBoard());
    			this.link.setLocation(0, this.link.getY());
    		}
    	} else if (link.getX() < 0) {
    		int x = this.quest.getCurrentBoardX();
    		int y = this.quest.getCurrentBoardY();
    		if (x > 0) {
    			this.quest.setCurrentBoard(x - 1, y);
    			this.link.setBoard(this.quest.getCurrentBoard());
    			this.link.setLocation((WIDTH - link.getWidth()), this.link.getY());
    		}
    	} else if (link.getY() > (HEIGHT - link.getHeight())) {
    		int x = this.quest.getCurrentBoardX();
    		int y = this.quest.getCurrentBoardY();
    		if (y < this.quest.getBoards()[0].length - 1) {
    			this.quest.setCurrentBoard(x, y + 1);
    			this.link.setBoard(this.quest.getCurrentBoard());
    			this.link.setLocation(this.link.getX(), HEIGHT_MENU);
    		}
    	} else if (link.getY() < HEIGHT_MENU) {
    		int x = this.quest.getCurrentBoardX();
    		int y = this.quest.getCurrentBoardY();
    		if (y > HEIGHT_MENU) {
    			this.quest.setCurrentBoard(x, y - 1);
    			this.link.setBoard(this.quest.getCurrentBoard());
    			this.link.setLocation(this.link.getY(), HEIGHT - link.getHeight());
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
