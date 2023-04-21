package zelda.scenary;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.imageio.ImageIO;

import zelda.Link;
import zelda.Orientation;
import zelda.Zelda;
import zelda.enemies.Enemy;
import zelda.objects.Bow;
import zelda.objects.CoeurOBJ;
import zelda.objects.Ruby;
import zelda.sounds.Sound;

import com.golden.gamedev.engine.BaseAudio;
import com.golden.gamedev.engine.BaseAudioRenderer;
import com.golden.gamedev.engine.BaseIO;
import com.golden.gamedev.engine.audio.WaveRenderer;
import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import com.golden.gamedev.util.*;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.*;

public class Quest extends PlayField {
    
    private Zelda game;
    
    private Board[][] boards;
    
    private QuestMenu menu;
    
    private SpriteGroup rubySG;
    private SpriteGroup coeurOBJSG;
    private  SpriteGroup enemySG;
    private  SpriteGroup enemy4D; 
    private  SpriteGroup linkSG;
    private  SpriteGroup bowSG;
    private SpriteGroup[][] boardSG;
    
    private Board currentBoard;
    private int currentBoardX;
    private int currentBoardY;
    
    public Quest(Zelda game) {
        super();
        this.game = game;
        this.boards = new Board[5][2];
        this.initRessources();
        currentBoardX = 2; // coordonnée X du board pour le spawn
        currentBoardY = 0; // coordonnée Y du board pour le spawn
        currentBoard = this.boards[currentBoardX][currentBoardY];
        this.boardSG = new SpriteGroup[5][2];
        this.rubySG = new SpriteGroup("RUBY SPRITE GROUPE");
        this.coeurOBJSG = new SpriteGroup("COEUR SPRITE GROUPE");
        this.enemySG = new SpriteGroup("ENEMYGD SPRITE GROUPE");
        this.enemy4D = new SpriteGroup("ENEMY4D SPRITE GROUPE");
        this.linkSG = new SpriteGroup("LINK SPRITE GROUPE");
        this.bowSG = new SpriteGroup("BOW SPRITE GROUPE");
        this.addGroup(enemy4D);
        this.addGroup(enemySG);
        this.addGroup(rubySG);
        this.addGroup(coeurOBJSG);
        this.addGroup(linkSG);
        this.addGroup(bowSG);
        this.addCollisionGroup(rubySG, linkSG, new RubyCollisionManager());
        this.addCollisionGroup(coeurOBJSG, linkSG, new CoeurCollisionManager());
        this.addCollisionGroup(bowSG, linkSG, new BowCollisionManager());
    }
    
	private void createBoard() {
		
		Path dir = Paths.get("C:\\Users\\Simon\\Documents\\zelda\\res\\boards");
	
		try {
			DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
			{
				int i = 0;
				int j = 0;
				for (Path file : stream) {
					if (file.getFileName().toString().matches("^[BD]X[0-9]Y[0-9]\\.txt$")) {
						char z = file.getFileName().toString().charAt(0);
						i = Integer.parseInt(file.getFileName().toString().substring(2,3)) ;
		
						j = Integer.parseInt(file.getFileName().toString().substring(4,5)) ;
		
						
		
						if (Files.isRegularFile(file)) {
	
							switch (z) {
							case 'D':
								Image fond = ImageIO.read(new File("res/sprites/Dongeon/1/DG1BG.gif"));
								
								boards [i][j] = new DungeonBoard(this.game, i, j, fond);
								//processDungeonFile(d00, file);
								break;
							case 'B':
								boards [i][j] = new Board(this.game, i, j);
								//processDungeonFile(b00, file);
								break;
							}
		
							processBoardFile(boards[i][j], file);
						}
					}
				}
				this.add(boards[i][j]) ;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
    }
	
	private void processBoardFile(Board b00, Path file) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] terms = line.split(",");
				for (int i = 0; i < terms.length; i++) {
					if (terms[i].matches("^[FR][0-9]{1,3}$")) {
						char a = terms[i].charAt(0);
						int b = Integer.parseInt(terms[i].substring(1));
						switch (a) {
						case 'F':
							b00.add(new Floor(this.game, Zelda.mapFloor.get(b)));
							break;
						case 'R':
							b00.add(new Rock(this.game, Zelda.mapRock.get(b)));
							break;
						}
					}
				}
			}
			reader.close();
		}
	}

    private void initRessources() {
        this.menu = new QuestMenu(this.game);
        
        createBoard();       
        
    }
    
    public QuestMenu getMenu() {
    	return menu;
    }
    
    public void setEnvironnement() {
    	Board b = boards[2][0];
    	b.setEnemyOnBoard("01", 160, 450, 3);
        b.setEnemyOnBoard("01", 250, 300, 3);
        b.createRuby(200, 260);
        b.createRuby(450, 400);
        b.createCoeur(400,400);
        
        Board d = boards[4][1];
        d.createBow(306,198);
        
        boardSG[2][0] = b.getForeground();
    	this.addGroup(boardSG[2][0]);
    	this.addCollisionGroup(enemySG, this.boardSG[2][0], new EnemyGDCollisionManager());
    	this.addCollisionGroup(enemy4D, this.boardSG[2][0], new Enemy4DCollisionManager());
    	
    	//this.addCollisionGroup(linkSG, this.boardSG[0][0], new LinkCollisionManager());
    	//this.addCollisionGroup(linkSG, enemySG, new LinkCollisionManager());
    	//this.addCollisionGroup(linkSG, enemy4D, new LinkCollisionManager());
    	this.addCollisionGroup(enemySG, linkSG, new EnemyLinkCollisionManager());
    	this.addCollisionGroup(enemy4D, linkSG, new EnemyLinkCollisionManager());
    	
    	playSound(Sound.MUSIC);
    }
    
    
    public Board getCurrentBoard() {
        return this.boards[currentBoardX][currentBoardY];
    }
    
    public int getCurrentBoardX() {
        return this.currentBoardX;
    }
    
    public int getCurrentBoardY() {
        return this.currentBoardY;
    }
    
    public void setCurrentBoard(int x, int y) {
    	currentBoardX = x;
    	currentBoardY = y;
        currentBoard = this.boards[x][y];
    }
    
    public Board[][] getBoards() {
    	return boards;
    }
    
    public SpriteGroup getRubySG() {
    	return rubySG;
    }
    
    public SpriteGroup getCoeurOBJSG() {
    	return coeurOBJSG;
    }
    
    public SpriteGroup getBowSG() {
    	return bowSG;
    }
    
    public SpriteGroup getLinkSG() {
    	return linkSG;
    }
    
    public SpriteGroup getEnemySG() {
    	return enemySG;
    }
    public SpriteGroup getEnemy4D() {
    	return enemy4D;
    }
    
    public void add(Board board) {
        //this.addGroup(board.getBackground());
        //this.addGroup(board.getForground());
        this.boards[board.getX()][board.getY()] = board;
    }
        
    public void update(long elapsedTime) {
        super.update(elapsedTime);
        //this.boards[0][0].update(elapsedTime);
        this.getCurrentBoard().update(elapsedTime);
        this.menu.update(elapsedTime);
        
        this.checkCollisions();
        
        
        if (currentBoard == boards[3][0]) {
        	Link link = game.getLink();
        	double x = link.getX();
        	double y = link.getY();
        	
        	if (x > (168 - 21) && x < (168+21) && y > (378-21) && y < (378+21)) {
        		// TP link dans donjon
        		link.linkOnBoard(boards[4][1]);
        		this.setCurrentBoard(4, 1);
        		link.setLocation(200,350);
        	}
        }
        
        if (currentBoard == boards[4][1]) {
        	Link link = game.getLink();
        	double x = link.getX();
        	double y = link.getY();
        	
        	if (x > (296 - 21) && x < (296+21) && y > (340-21) && y < (340+21)) {
        		
        		// TP link dans donjon
        		link.linkOnBoard(boards[3][0]);
        		this.setCurrentBoard(3, 0);
        		link.setLocation(145,438);
        	}
        }
        //System.out.println(game.getLink().getX() + " ; " + game.getLink().getY());
    }
    
    public void render(Graphics2D g) {
        super.render(g);
        //this.boards[0][0].render(g);
        this.getCurrentBoard().render(g);
        this.menu.render(g);
    }
    
    public void playSound(Sound sound) {
    	// Charge le fichier son WAV en tant que tableau de bytes
    	String soundFile = sound.getImagePath();
        Path path = Paths.get(soundFile);
        // Initialise le renderer audio et charge le fichier son
        
        BaseAudioRenderer audioRenderer = new WaveRenderer();
        game.bsSound.setBaseRenderer(audioRenderer);
        try {
			audioRenderer.play(path.toUri().toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    protected class RubyCollisionManager extends BasicCollisionGroup {
		
		public RubyCollisionManager() {
            this.pixelPerfectCollision = false;
        }
        // s1 ruby ; s2 link
        public void collided(Sprite s1, Sprite s2) {
        	if (s1.isActive()) {
        		Ruby ruby = (Ruby) s1;
        		if (currentBoard.getRubies().contains(s1)) {
	        		if (ruby.getKind() == Ruby.Kind.BLUE) {
	        			menu.gainRuby(1);
	        		} else if (ruby.getKind() == Ruby.Kind.ORANGE) {
	        			menu.gainRuby(3);
	        		}
	        		System.out.println(menu.getNbrRuby());
	        		
	        		playSound(Sound.RUBY);
	        		
	                
	        		s1.moveX(1000);
	        		s1.setActive(false);
        		}
        	}
        }
    }
    
    protected class CoeurCollisionManager extends BasicCollisionGroup {
		
		public CoeurCollisionManager() {
            this.pixelPerfectCollision = false;
        }
        public void collided(Sprite s1, Sprite s2) {
        	Link link = (Link) s2;
        	if (s1.isActive()) {
        		CoeurOBJ coeur = (CoeurOBJ) s1;
        		if (currentBoard.getCoeurOBJ().contains(s1)) {
	        		link.setLife(link.getLife() + 1);
        			menu.setNbrCoeur(link.getLife());
        			menu.addCoeurDisplay();
        			
	        		playSound(Sound.HEART);
	        		
	                
	        		s1.moveX(1000);
	        		s1.setActive(false);
        		}
        	}
        }
    }
    
    protected class BowCollisionManager extends BasicCollisionGroup {
		
		public BowCollisionManager() {
            this.pixelPerfectCollision = false;
        }
        // s1 ruby ; s2 link
        public void collided(Sprite s1, Sprite s2) {
        	if (s1.isActive()) {
        		Bow bow = (Bow) s1;
        		if (currentBoard.getObjects().contains(s1)) {
	        		
	        		playSound(Sound.FANFARE); //////////////// A MODIFIER
	        		
	                
	        		s1.moveX(1000);
	        		menu.createBow();  //appel a creation dans queste menu
	        		s1.setActive(false);
        		}
        	}
        }
    }
    
    private class EnemyGDCollisionManager extends AdvanceCollisionGroup {
		public EnemyGDCollisionManager() {
			this.pixelPerfectCollision = false;
		}

		public void collided(Sprite s1, Sprite s2) {
			Enemy enemy = (Enemy) s1;

			if (this.getCollisionSide() == Orientation.EAST.ordinal()) {

				enemy.setOrientation(Orientation.WEST);

			} else if (this.getCollisionSide() == Orientation.WEST.ordinal()) {

				enemy.setOrientation(Orientation.EAST);
			}
		}
	}

	private class Enemy4DCollisionManager extends AdvanceCollisionGroup {

		public Enemy4DCollisionManager() {
			this.pixelPerfectCollision = false;
		}

		public void collided(Sprite s1, Sprite s2) {
			// System.out.println(this.collisionSide);
			// Enemy enemy = (Enemy) s1;
			this.revertPosition1();

		}

	}

	private class EnemyLinkCollisionManager extends AdvanceCollisionGroup {

		public EnemyLinkCollisionManager() {
			this.pixelPerfectCollision = false;
		}

		public void collided(Sprite s1, Sprite s2) {
			Enemy ennemy = (Enemy) s1;
			Link link = (Link) s2;
			if (s1.isActive() && game.getQuest().getCurrentBoard().getEnemies().contains(s1)) {
				if (link.getFight().isActive() && !ennemy.getHit().isActive()) { // Combat actif
					switch (link.getOrientation()) {
					case NORTH:
						if ((this.getCollisionSide() == 8)) {
							ennemy.setLife(ennemy.getLife() - 1);
							game.getQuest().playSound(Sound.HIT);
							this.revertPosition1();
							ennemy.getHit().setActive(true);
						}
						break;
					case SOUTH:
						System.out.println(collisionSide);
						if ((this.getCollisionSide() == 4)) {
							ennemy.setLife(ennemy.getLife() - 1);
							game.getQuest().playSound(Sound.HIT);
							this.revertPosition1();
							ennemy.getHit().setActive(true);
						}
						break;
					case WEST:
						if ((this.getCollisionSide() == 2)) {
							ennemy.setLife(ennemy.getLife() - 1);
							game.getQuest().playSound(Sound.HIT);
							this.revertPosition1();
							ennemy.getHit().setActive(true);
						}
						break;
					case EAST:
						if ((this.getCollisionSide() == 1)) {
							ennemy.setLife(ennemy.getLife() - 1);
							game.getQuest().playSound(Sound.HIT);
							this.revertPosition1();
							ennemy.getHit().setActive(true);
						}
						break;
					default:
						// do nothing
					}
				} else {
					
					this.revertPosition1();
				}
			}
		}

	}
}
