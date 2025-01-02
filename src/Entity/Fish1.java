package Entity;

import enemy.Enemy1;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;
import java.awt.Image;
import java.awt.Rectangle;

public class Fish1 extends Entity {
    
    KeyHandler keyH;
    public boolean[] scoreSoundPlayed = new boolean[900];
    
    public Fish1(GamePanel gp, KeyHandler keyH){
        
        super(gp);
        this.keyH = keyH;
        Enemy1 enemy1 = new Enemy1(gp);
        
        Rectangle solidArea = new Rectangle(16, 16);
        solidArea.x = 48;
        solidArea.y = 20;
        int solidAreaDefaultX = solidArea.x;
        int solidAreaDefaultY = solidArea.y;
        
        attackArea.width = 48; //change the attack area here
        attackArea.height = 20;
        
        setDefaultValues();
        getPlayerImage();
        
    }
    public void setDefaultValues() {
        
        x=100;
        y=100;
        speed=4;
        direction = "right";
        
        //player status
        maxLife = 1;
        life = maxLife;
    }
    public void getPlayerImage(){
        try {
            
            left = ImageIO.read(getClass().getResourceAsStream("/Fish/Fish4Left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/Fish/Fish4Right.png"));
           
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        
        if(attacking = true) {
            attacking();
        }
        
        if(keyH.upPressed == true) {
            if (y - speed >= 30) { // Check top boundary
            y -= speed;
        }
        }
        if(keyH.leftPressed == true) {
            direction = "left";
             if (x - speed >= -5) { // Check left boundary
            x -= speed;
        }
        }
        if(keyH.downPressed == true) {
            if (y + speed + gp.tileSize <= gp.screenHeight +45) { // Check bottom boundary
            y += speed;
        }
        }
        if(keyH.rightPressed == true) {
            direction = "right";
            if (x + speed + gp.tileSize <= gp.screenWidth+20) { // Check right boundary
            x += speed;
        }
        }
       
       collisionOn = false;
       
       
       //CHECK ENEMY COLLISION
//       int enemyIndex = gp.collisionChecker.checkEntity(this, gp.enemy);
//       boolean playerIndex = gp.collisionChecker.checkPlayer(this);
//       touchingEnemy(enemyIndex);
//       contactEnemy(enemyIndex);
//       playerEnemy(playerIndex);
       if(life <= 0) {
           gp.playSE(2);
           gp.gameState = gp.gameOverState;
       }
       levelUp();
    }
    public void levelUp() {
        int currentScore = gp.getScore();
            if ((currentScore == 20 || currentScore == 50) && !scoreSoundPlayed[currentScore]) {
                gp.playSE(3); // Play the sound
                scoreSoundPlayed[currentScore] = true; // Mark this score as played
}
    }
    
    public void touchingEnemy(int i) {
      
        if (i != 999) {
            System.out.println("Touching!");
            attacking = true;
        }
    }
    public void contactEnemy(int i) {
        
        if (i != 999) {
            gp.stopMusic(1);
            life -= 1;
            System.out.println(life);
        }
    }
    public void playerEnemy(boolean x) {
        
        if (x == true) {
            gp.stopMusic(1);
            life -= 1;
            System.out.println(life);
        }
    }
    
    public void attacking() {
        int solidAreaWidth = solidArea.width;
        int solidAreaHeight = solidArea.height;
        
        //attack area become solid area
        solidArea.width = attackArea.width;
        solidArea.height = attackArea.height;
        
        //check monster collision with the update size
        int enemyIndex = gp.collisionChecker.checkEntity(this, gp.enemy);
        int hit2Index = gp.collisionChecker.checkEntity2(this, gp.enemy);
        int hit3Index = gp.collisionChecker.checkEntity3(this, gp.enemy);
        int hit4Index = gp.collisionChecker.checkEntity4(this, gp.enemy);
        if (gp.getScore() <= 19 ) {
            damagePlayer(hit2Index);
        }
        if (gp.getScore() <= 49 ) {
            damagePlayer(hit3Index);
        }
        if (gp.getScore() <= 9999 ) {
            damagePlayer(hit4Index);
        }
        damageEnemy(enemyIndex);
        
        
    }
    public void damageEnemy (int i) {
        if(i != 999) {
            
            System.out.println("HIT!");
            gp.increaseScore(1);
            gp.enemy[i].life -= 1;
            gp.playSE(1);
            
            if (gp.enemy[i].life <= 0) {
            gp.enemy[i] = null; // Remove the enemy
            // Respawn the enemy using AssetSetter
            if (i == 0) {
                gp.aSetter.setEnemy(); // Respawn enemy 0 (Enemy1)
            } else if (i == 1) {
                gp.aSetter.setEnemy2(); // Respawn enemy 1 (Enemy1)
            } else if (i == 2) {
                gp.aSetter.setEnemy3(); // Respawn enemy 2 (Enemy1)
            } else if (i == 3) {
                gp.aSetter.setEnemy4(); // Respawn enemy 3 (Enemy2)
            } else if (i == 4) {
                gp.aSetter.setEnemy5(); // Respawn enemy 4 (Enemy2)
            } else if (i == 5) {
                gp.aSetter.setEnemy6(); // Respawn enemy 5 (Enemy2)
            }
        }
        }
    }
    public void damagePlayer (int i) {
        if(i != 999) {
            
            System.out.println("HIT!");
            life -=1;
            gp.increaseScore(1);
            gp.enemy[i].life -= 1;
            gp.playSE(2);
            
//            if (gp.enemy[i].life <= 0) {
//            gp.enemy[i] = null; // Remove the enemy
//            // Respawn the enemy using AssetSetter
//            if (i == 0) {
//                gp.aSetter.setEnemy(); // Respawn enemy 0 (Enemy1)
//            } else if (i == 1) {
//                gp.aSetter.setEnemy2(); // Respawn enemy 1 (Enemy1)
//            } else if (i == 2) {
//                gp.aSetter.setEnemy3(); // Respawn enemy 2 (Enemy1)
//            } else if (i == 3) {
//                gp.aSetter.setEnemy4(); // Respawn enemy 3 (Enemy2)
//            } else if (i == 4) {
//                gp.aSetter.setEnemy5(); // Respawn enemy 4 (Enemy2)
//            } else if (i == 5) {
//                gp.aSetter.setEnemy6(); // Respawn enemy 5 (Enemy2)
//            }
//        }
        }
    }
    
    
    public void draw(Graphics2D g2){   
          BufferedImage image = null;
          
        switch (direction) {
            case "left": 
                image = left;
                break;
            case "right": 
                image = right;
                break;
            default:
                break;
            }

        if (image != null) {
            if (gp.getScore() >=20){
                attackArea.width = (int) (48*1.5);
                attackArea.height = (int) (20*1.5);
            }
            if (gp.getScore() >=50){
                attackArea.width = (int) (48*1.8);
                attackArea.height = (int) (20*1.8);
            }
//            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
            g2.drawImage(image, x, y, attackArea.width, attackArea.height, null);
            
            }
    }

          
}
