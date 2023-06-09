package zelda.scenary;

import java.awt.Graphics2D;

import zelda.GameOverObject;
import zelda.Zelda;
import zelda.sounds.Sound;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;

public class QuestMenu {
    
    private SpriteGroup sprites;
    private SpriteGroup rubiesGroup;
    private SpriteGroup coeur;
    private SpriteGroup bow;
    
    private Zelda game;
    
    private int nbrRuby;
    private int nbrCoeur;
    
    public QuestMenu(Zelda game) {
        this.game = game;
        this.sprites = new SpriteGroup("menu");
        this.rubiesGroup = new SpriteGroup("");
        
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/B_CASE.GIF"), 330, 30));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/A_CASE.GIF"), 400, 30));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/LIFE.GIF"), 500, 30));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/BOMB.GIF"), 230, 79));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/X.GIF"), 250, 80));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/KEY.GIF"), 230, 60));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/X.GIF"), 250, 60));
        this.sprites.add(new Sprite(this.game.getImage("res/sprites/PIECE.GIF"), 230, 30));
        
        this.rubiesGroup.add(new Sprite(this.game.getImage("res/sprites/0.GIF"), 300, 30));
        this.rubiesGroup.add(new Sprite(this.game.getImage("res/sprites/0.GIF"), 280, 30));
        this.rubiesGroup.add(new Sprite(this.game.getImage("res/sprites/0.GIF"), 260, 30));
        int nbrRuby = 0;
        
        this.coeur = new SpriteGroup("vie");
        this.coeur.add(new Sprite(this.game.getImage("res/sprites/Objects/OHC.GIF"), 500, 90));
        this.coeur.add(new Sprite(this.game.getImage("res/sprites/Objects/OHC.GIF"), 525, 90));
        this.coeur.add(new Sprite(this.game.getImage("res/sprites/Objects/OHC.GIF"), 550, 90));
        this.coeur.add(new Sprite(this.game.getImage("res/sprites/Objects/OHC.GIF"), 500, 60));
        this.coeur.add(new Sprite(this.game.getImage("res/sprites/Objects/OHC.GIF"), 525, 60));
        this.coeur.add(new Sprite(this.game.getImage("res/sprites/Objects/OHC.GIF"), 550, 60));
        this.nbrCoeur = 6;
        
        this.bow = new SpriteGroup("bow");
    }
    
    public void move(long elapsedTime, boolean flag) {
        Sprite[] s = this.sprites.getSprites();
        for (int i = 0; i < this.sprites.getSize(); i++) {
            if (flag) 
                s[i].moveTo(elapsedTime, s[i].getX(), s[i].getY() + 300, 1);
            else 
                s[i].moveTo(elapsedTime, s[i].getX(), s[i].getY() - 300, 1);
        }
        
    }
    
    public int getNbrRuby() {
    	return this.nbrRuby;
    }
    public int getNbrCoeur() {
    	return this.nbrCoeur;
    } 	
    
    public void setNbrCoeur(int coeur) {
    	 this.nbrCoeur = coeur;
    } 	
    
    public String afficheNum(int n) {
    	return "res/sprites/" + n + ".GIF";
    }
   
    
    public void rubyDisplay() {
    	int centaine = nbrRuby / 100;
    	int dizaine = (nbrRuby % 100) / 10;
    	int unite = nbrRuby % 10;
    	
    	this.rubiesGroup.getSprites()[0].setImage(this.game.getImage(afficheNum(unite)));
    	this.rubiesGroup.getSprites()[1].setImage(this.game.getImage(afficheNum(dizaine)));
    	this.rubiesGroup.getSprites()[2].setImage(this.game.getImage(afficheNum(centaine)));
    }
    
	public void RemoveCoeurDisplay() {

		if (this.nbrCoeur >= 1) {
			System.out.println(this.nbrCoeur);
			game.getQuest().playSound(Sound.HURT);
			this.coeur.getSprites()[this.nbrCoeur].setImage(this.game.getImage("res/sprites/Objects/OBH.GIF"));
		} else {
			System.out.println(this.nbrCoeur);
			game.getQuest().playSound(Sound.HURT);
			this.coeur.getSprites()[this.nbrCoeur].setImage(this.game.getImage("res/sprites/Objects/OBH.GIF"));
			game.getQuest().playSound(Sound.DIE);
			game.bsMusic.stopAll();
			game.bsSound.stopAll();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			game.finish();

		}
	}
	
	public void addCoeurDisplay() {
		
		if (this.nbrCoeur < 6) {
			System.out.println(this.nbrCoeur);
			this.coeur.getSprites()[this.nbrCoeur - 1].setImage(this.game.getImage("res/sprites/Objects/OHC.GIF"));
		} else {

		}
		
	}
    
	  public void createBow() {
		  this.bow.add(new Sprite(this.game.getImage("res/sprites/Objects/OBOW.gif"), 344, 53));
	    }
    
    public void gainRuby(int incr) {
    	this.nbrRuby = Math.min(this.nbrRuby + incr, 999);
    	if (nbrRuby <= 999) {
    		this.rubyDisplay();
    	}
    }
    
    public void update(long elapsedTime) {
        this.sprites.update(elapsedTime);
        this.coeur.update(elapsedTime);
    }
    
    public void render(Graphics2D g) {
        this.sprites.render(g);
        this.rubiesGroup.render(g);
        this.coeur.render(g);
        this.bow.render(g);
    }
}
