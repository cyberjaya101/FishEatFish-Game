package Tile;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {
    
    GamePanel gp;
    public Tile[] tile;
//    public int mapTileNum[][];
    
    public TileManager(GamePanel gp) {
        this.gp = gp;
        
        tile = new Tile[1];
        
        getTileImage();
    }
    
    public void getTileImage() {
        
        try {
            
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/background.png"));
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {
        
//        g2.drawImage(tile[0].image, 0, 0, 1024, 768, null);
        g2.drawImage(tile[0].image, 0, 0, gp.screenWidth, gp.screenHeight, null);
    }
}
