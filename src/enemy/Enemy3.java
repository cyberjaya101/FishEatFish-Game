package enemy;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Enemy3 extends Enemy1 {

    public Enemy3(GamePanel gp) {
        super(gp);
        name = "Enemy3";
        level = 3;  // Set specific level for Enemy2
        speed = 8;  // Example: Faster speed for Enemy2
        maxLife = 1;
        life = maxLife;
        width = (int) (32*1.5);  // Change size for Enemy2
        height = (int) (25*1.5);

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
            level3ImageLeft = ImageIO.read(getClass().getResourceAsStream("/Enemy/Fish3left.png"));
            level3ImageRight = ImageIO.read(getClass().getResourceAsStream("/Enemy/Fish3right.png"));
            // Optionally, load other levels' images or handle separately
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCurrentImage() {
        // Change image based on direction and level for Enemy2
        currentImage = movingLeft ? level3ImageLeft : level3ImageRight;
    }
}
