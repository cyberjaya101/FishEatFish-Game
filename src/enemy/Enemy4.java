package enemy;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Enemy4 extends Enemy1 {

    public Enemy4(GamePanel gp) {
        super(gp);
        name = "Enemy4";
        level = 4;  // Set specific level for Enemy2
        speed = 10;  // Example: Faster speed for Enemy2
        maxLife = 1;
        life = maxLife;
        width = 23*4;  // Change size for Enemy2
        height = 11*4;

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
            level4ImageLeft = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy4left.png"));
            level4ImageRight = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy4right.png"));
            // Optionally, load other levels' images or handle separately
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCurrentImage() {
        // Change image based on direction and level for Enemy2
        currentImage = movingLeft ? level4ImageLeft : level4ImageRight;
    }
}
