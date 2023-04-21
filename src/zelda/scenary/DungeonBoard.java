package zelda.scenary;

import java.awt.Graphics2D;
import java.awt.Image;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;

import zelda.Zelda;

public class DungeonBoard extends Board {
    
    private Image backgroundImage;

    public DungeonBoard(Zelda game, int x, int y, Image backgroundImage) {
        super(game, x, y);
        this.backgroundImage = backgroundImage;
    }
    
    public void add(AbstractTile tile) {
    	
        int x = this.size % Board.WIDTH;
        int y = this.size/Board.WIDTH;
        tile.setLocation(x * 42, y * 42 + 126);
        tiles()[x][y] = tile;
        this.size++;
   }

	private AbstractTile[][] tiles() {
		return tiles;
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

	public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    public void render(Graphics2D g) {
        // Dessiner l'image d'arrière-plan
        g.drawImage(backgroundImage, getX(), 126, null);

        // Dessiner les tuiles par-dessus l'image d'arrière-plan
        super.render(g);
    }
}