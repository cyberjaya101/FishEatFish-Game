package enemy;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Enemy2 extends Enemy1 {

    public Enemy2(GamePanel gp) {
        super(gp);
        name = "Enemy2";
        level = 2;  // Set specific level for Enemy2
        speed = 6;  // Example: Faster speed for Enemy2
        maxLife = 1;
        life = maxLife;
        width = 23*2;  // Change size for Enemy2
        height = 11*2;

        getImage();  // Load images for Enemy2
        updateCurrentImage();  // Set initial image for Enemy2
    }

    @Override
    public void setAction() {
        // Enemy2 specific movement logic
        if (movingLeft) {
            x -= speed;
        } else {
            x += speed;
        }

        // Reset position if out of bounds
        if (x < -width - 500 || x > gp.screenWidth + 500) {
            resetPosition();
        }
    }

    @Override
    public void getImage() {
        try {
            level2ImageLeft = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy2left.png"));
            level2ImageRight = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy2right.png"));
            // Optionally, load other levels' images or handle separately
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCurrentImage() {
        // Change the image based on the direction
        switch (level) {
            case 1 -> currentImage = movingLeft ? level1ImageLeft : level1ImageRight;
            case 2 -> currentImage = movingLeft ? level2ImageLeft : level2ImageRight;
            case 3 -> currentImage = movingLeft ? level3ImageLeft : level3ImageRight;
            case 4 -> currentImage = movingLeft ? level4ImageLeft : level4ImageRight;
            case 5 -> currentImage = movingLeft ? level5ImageLeft : level5ImageRight;
            default -> throw new IllegalArgumentException("Invalid level: " + level);
        }
    }
    
    public void draw(Graphics2D g2) {
        if (currentImage != null) {
            g2.drawImage(currentImage, x, y, width, height, null);
        }
    }
}
