
package zelda.scenary;

import com.golden.gamedev.object.Sprite;

import zelda.Zelda;

public class Floor extends AbstractTile {
    
	public enum Color {
		GREEN,
		TROU_NOIR,
		SAND,
		ESCALIER,
		ESCALIER_D,
		TRANS,
		PONT,
	}
    private Color color;
    
    public Floor(Zelda game, Color color) {
		super(game, 1, 1, 42, 42);
		this.color = color;

		switch(color) {
		case SAND:
			this.add(new Sprite(this.game.getImage("res/sprites/scenary/BGGF.gif")), -1);
			break;
		case GREEN:     	
			break;
		case TROU_NOIR:
			this.add(new Sprite(this.game.getImage("res/sprites/scenary/OUTSIDE_DOOR.GIF")), -1) ;
			break;
		case ESCALIER :
			this.add(new Sprite(this.game.getImage("res/sprites/scenary/BGGDS.gif")), -1);
			break;
		case ESCALIER_D :
			this.add(new Sprite(this.game.getImage("res/sprites/scenary/BGGDS.gif")), -1);
			break;
		case TRANS :
			this.add(new Sprite(this.game.getImage("res/sprites/Dongeon/1/HD_transparent_floor.gif")), -1);
			break;
		case PONT :
			this.add(new Sprite(this.game.getImage("res/sprites/scenary/BGBB.gif")), -1);
			break;

		}
	}
}
