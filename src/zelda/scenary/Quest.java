package zelda.scenary;

import java.awt.Graphics2D;
import java.util.HashMap;

import zelda.Zelda;
import zelda.enemies.Enemy;

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.SpriteGroup;

public class Quest extends PlayField {
    
    private Zelda game;
    
    private Board[][] boards;
    
    private QuestMenu menu;
    
    private SpriteGroup rubySG = new SpriteGroup("RUBY SPRITE GROUPE");
    
    private static HashMap<Integer, Floor.Color> mapFloor;
    private static HashMap<Integer, Rock.Kind> mapRock;
    
    private Board currentBoard;
    private int currentBoardX;
    private int currentBoardY;
    
    public static void createHashMap() {
    	mapFloor.put(null, null);
    }
    
    public Quest(Zelda game) {
        super();
        this.game = game;
        this.boards = new Board[2][1];
        this.initRessources();
        currentBoardX = 0;
        currentBoardY = 0;
        currentBoard = this.boards[currentBoardX][currentBoardY];
    }

    private void initRessources() {
        this.menu = new QuestMenu(this.game);
        
        
        // Board (0, 0)
        Board b00 = new Board(this.game, 0, 0);
        
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
            
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
            
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_WEST_CORNER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));//b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED)); ////////
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_NORTH_EAST_CORNER));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));

        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Floor(this.game, Floor.Color.SAND));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        

        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b00.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        this.add(b00);
        
     // Board (0, 0)
        Board b01 = new Board(this.game, 1, 0);
        
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
            
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
            
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_EAST_CORNER));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_SOUTH_WEST_CORNER));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN_BORDER));
        
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED)); ////////
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_NORTH_EAST_CORNER));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));

        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Floor(this.game, Floor.Color.SAND));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_INDENTED));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        

        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        b01.add(new Rock(this.game, Rock.Kind.GREEN_PLAIN));
        
        this.add(b01);
        
        
        
        //////////
        
        b00.setEnemyOnBoard("01", 160, 450);
        b00.setEnemyOnBoard("20", 160, 300);
        
    }
    
    public QuestMenu getMenu() {
    	return menu;
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
    }
    
    public void render(Graphics2D g) {
        super.render(g);
        //this.boards[0][0].render(g);
        this.getCurrentBoard().render(g);
        this.menu.render(g);
    }
}
