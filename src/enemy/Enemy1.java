package enemy;

import Entity.Entity;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Enemy1 extends Entity {
    public BufferedImage level1ImageLeft, level1ImageRight;
    public BufferedImage level2ImageLeft, level2ImageRight;
    public BufferedImage level3ImageLeft, level3ImageRight;
    public BufferedImage level4ImageLeft, level4ImageRight;
    public BufferedImage level5ImageLeft, level5ImageRight;
    public BufferedImage currentImage;
    
    public Rectangle solidArea = new Rectangle(0,0,23,11);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public int width;
    public int height;
    public boolean movingLeft;
    public int level; // Add the level variable
    public Random random;

    public Enemy1(GamePanel gp) {
        super(gp);
        random = new Random();

        name = "Enemy1";
        level = 1; // Default level
        speed = 4; // You can vary this based on enemy level
        maxLife = 1;
        life = maxLife;

        // Set default size for level 1 enemy
        width = 23;
        height = 11;
        

        getImage();  // Load images
        updateCurrentImage();  // Update image based on direction
    } 

    @Override
    public void setAction() {
        
        // Move based on direction
        if (movingLeft) {
            x -= speed;
        } else {
            x += speed;
        }

        // Reset position if out of screen bounds
        if (x < -width -500|| x > gp.screenWidth+500) {
            resetPosition();
        }
    }
    
    public static void handleEnemies(Entity[] enemies, int screenWidth, int screenHeight) {
        for (int i = 0; i < enemies.length; i++) {
            Entity e = enemies[i];
            if (e != null) {
                e.update();  // Update the enemy
                }
        }
    }


    public void resetPosition() {
        // Reset position to spawn again randomly
        if (random.nextBoolean()) {
            x = gp.screenWidth; // Spawn on the right
            movingLeft = true;
            System.out.println("Spawning from the right.");
        } else {
            x = -width; // Spawn on the left
            movingLeft = false;
            System.out.println("Spawning from the left.");
        }

        y = 30 + random.nextInt(gp.screenHeight - height -30); // Random vertical position
        updateCurrentImage();
    }
    public void getImage() {
        try {
            level1ImageLeft = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy1left.png"));
            level1ImageRight = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy1right.png"));
            level2ImageLeft = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy2left.png"));
            level2ImageRight = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy2right.png"));
            level3ImageLeft = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy3left.png"));
            level3ImageRight = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy3right.png"));
            level4ImageLeft = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy4left.png"));
            level4ImageRight = ImageIO.read(getClass().getResourceAsStream("/Enemy/Enemy4right.png"));
            level5ImageLeft = ImageIO.read(getClass().getResourceAsStream("/Enemy/Immortalleft.png"));
            level5ImageRight = ImageIO.read(getClass().getResourceAsStream("/Enemy/Immortalright.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
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
    
    @Override
    public void draw(Graphics2D g2) {
        if (currentImage != null) {
            g2.drawImage(currentImage, x, y, width, height, null);
        }
    }


}