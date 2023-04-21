package zelda.scenary;

import com.golden.gamedev.object.Sprite;

import zelda.Zelda;

public class Rock extends AbstractTile {
    
	public enum Kind {
        GREEN_PLAIN,
        GREEN_PLAIN_BORDER,
        GREEN_INDENTED,
        GREEN_SOUTH_EAST_CORNER,
        GREEN_SOUTH_WEST_CORNER,
        GREEN_NORTH_EAST_CORNER,
        GREEN_NORTH_WEST_CORNER,
        BUISSON,
        TRANS,
        EAU_VERT,
        ROCHE,
        BUISSON2,
        
    }
    
    private Kind kind;
    
    public Rock(Zelda game, Kind kind) {
        super(game, 2, 2, 42, 42);
        this.kind = kind;
        switch (this.kind) {
            case GREEN_NORTH_WEST_CORNER:
	            this.add("res/sprites/scenary/GREEN_NORTH_WEST_ROCK_1.GIF", -1);
	            this.add("res/sprites/scenary/GREEN_NORTH_WEST_ROCK_2.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_NORTH_WEST_ROCK_3.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_NORTH_WEST_ROCK_4.GIF", 1);
	            break;
	        case GREEN_INDENTED:
	            this.add("res/sprites/scenary/GREEN_INDENTED_ROCK_1.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_INDENTED_ROCK_2.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_INDENTED_ROCK_3.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_INDENTED_ROCK_4.GIF", 1);
	            break;
	        case GREEN_NORTH_EAST_CORNER:
	            this.add("res/sprites/scenary/GREEN_NORTH_EAST_ROCK_1.GIF", -1);
	            this.add("res/sprites/scenary/GREEN_NORTH_EAST_ROCK_2.GIF", -1);
	            this.add("res/sprites/scenary/GREEN_NORTH_EAST_ROCK_3.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_NORTH_EAST_ROCK_4.GIF", 1);
	            break;
	        case GREEN_SOUTH_EAST_CORNER:
	            this.add("res/sprites/scenary/GREEN_SOUTH_EAST_ROCK_1.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_SOUTH_EAST_ROCK_2.GIF", -1);
	            this.add("res/sprites/scenary/GREEN_SOUTH_EAST_ROCK_3.GIF", -1);
	            this.add("res/sprites/scenary/GREEN_SOUTH_EAST_ROCK_4.GIF", -1);
	            break;
	        case GREEN_PLAIN_BORDER:
	            this.add("res/sprites/scenary/GREEN_PLAIN_ROCK_1.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_PLAIN_ROCK_2.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_PLAIN_ROCK_3.GIF", -1);
	            this.add("res/sprites/scenary/GREEN_PLAIN_ROCK_4.GIF", -1);
	            break;
	        case GREEN_PLAIN:
	            this.add("res/sprites/scenary/GREEN_PLAIN_ROCK_1.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_PLAIN_ROCK_2.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_PLAIN_ROCK_3.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_PLAIN_ROCK_4.GIF", 1);
	            break;
	        case GREEN_SOUTH_WEST_CORNER:
	            this.add("res/sprites/scenary/GREEN_SOUTH_WEST_ROCK_1.GIF", -1);
	            this.add("res/sprites/scenary/GREEN_SOUTH_WEST_ROCK_2.GIF", 1);
	            this.add("res/sprites/scenary/GREEN_SOUTH_WEST_ROCK_3.GIF", -1);
	            this.add("res/sprites/scenary/GREEN_SOUTH_WEST_ROCK_4.GIF", -1);
	            break;
	        case BUISSON :
	        	this.add("res/sprites/scenary/GREEN_ROCK_7.GIF", 1) ;
	        	this.add("res/sprites/scenary/GREEN_ROCK_7.GIF", 1) ;
	        	this.add("res/sprites/scenary/GREEN_ROCK_7.GIF", -1) ;
	        	this.add("res/sprites/scenary/GREEN_ROCK_7.GIF", -1) ;
	        	break;
	        case TRANS :
	        	this.add("res/sprites/Dongeon/1/HD_transparent_rock.gif", 1);
	        	this.add("res/sprites/Dongeon/1/HD_transparent_rock.gif", 1);
	        	this.add("res/sprites/Dongeon/1/HD_transparent_rock.gif", 1);
	        	this.add("res/sprites/Dongeon/1/HD_transparent_rock.gif", 1);
	        	break;
	        case EAU_VERT :
	        	this.add("res/sprites/scenary/BGGCS.gif", 1) ;
	        	this.add("res/sprites/scenary/BGGCS.gif", 1) ;
	        	this.add("res/sprites/scenary/BGGCS.gif", 1) ;
	        	this.add("res/sprites/scenary/BGGCS.gif", 1) ;
	        	break;
	        case ROCHE :
	        	this.add("res/sprites/scenary/BGBR.gif", 1) ;
	        	this.add("res/sprites/scenary/BGBR.gif", 1) ;
	        	this.add("res/sprites/scenary/BGBR.gif", 1) ;
	        	this.add("res/sprites/scenary/BGBR.gif", 1) ;
	        	break;
	        case BUISSON2 :
	        	this.add("res/sprites/scenary/BGGSH.gif", 1) ;
	        	this.add("res/sprites/scenary/BGGSH.gif", 1) ;
	        	this.add("res/sprites/scenary/BGGSH.gif", -1) ;
	        	this.add("res/sprites/scenary/BGGSH.gif", -1) ;
	        	break;
        }
            
    }

}
