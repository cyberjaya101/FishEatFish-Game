package main;

import Entity.Entity;
import Entity.Fish1;
import Tile.TileManager;
import enemy.Enemy1;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GamePanel extends JPanel implements Runnable{
    
    //Screen Settings
    final int originalTileSize = 16; //16x16 tiles
    final int scale = 4;
    
    public final int tileSize = originalTileSize * scale; //48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    
    // FPS
    int fps = 60;
    
    //System
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    Sound sound = new Sound();
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    
    
    // ENTITY
    public Enemy1 enemy1 = new Enemy1(this);
    public Fish1 fish1 = new Fish1(this,keyH);
    public Entity enemy[] = new Entity[900];
    ArrayList<Entity> entityList = new ArrayList<>();
    
    public int score = 0;
    
    // GAME STATE
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    private GamePanel gamePanel;
    public final int gameOverState = 6;
    
    
    public GamePanel(){ //constructor of this game panel
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //set the size of this class (JPanel)
        this.setBackground(Color.white);
        this.setDoubleBuffered(true); // if ture, all the drawing will be done in an offscreen painting buffer, in short it will improves rendering
        this.addKeyListener(keyH);
        this.setFocusable(true); //with this, this GamePanel can be "fpcused" to receive key input.
        
        setupGame();
    }
    
    public void setupGame() {
    
        playMusic(0);
        
        aSetter.setEnemy();
        aSetter.setEnemy2();
        aSetter.setEnemy3();
        
        gameState = playState;
    }
    
    public void spawnLevel2Enemies() {
    if (getScore() >= 10 && !aSetter.isLevel2EnemiesSpawned()) {
            
            aSetter.setEnemy4();
            aSetter.setEnemy5();
            aSetter.setEnemy6();
            aSetter.setEnemy7();
            aSetter.setLevel2EnemiesSpawned(true);
        }
}
    public void spawnLevel3Enemies() {
    if (getScore() >= 30 && !aSetter.isLevel3EnemiesSpawned()) {
           
            aSetter.setEnemy8();
            aSetter.setEnemy9();
            aSetter.setEnemy10();
            aSetter.setEnemy11();
            aSetter.setLevel3EnemiesSpawned(true);  
        }
}
    public void spawnLevel4Enemies() {
    if (getScore() >= 55 && !aSetter.isLevel4EnemiesSpawned()) {
           
            aSetter.setEnemy12();
            aSetter.setEnemy13();
            aSetter.setEnemy14();
            aSetter.setLevel4EnemiesSpawned(true);  
        }
}
    
    public void startGameThread(){
        
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() { //game loop which will be the core of our game
        
        double drawInterval = 1000000000 / fps; //o.0166666666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;
        long timer = 0;
        int drawCount = 0;
        long currentTime;
        long lastTime = System.nanoTime();
        
        while (gameThread != null) {
            //we use nano cuz it's more precised
           // long currentTime = System.nanoTime();                   //1,000,000,000 nanoseconds = 1 seconds
           // long currentTime2 = System.currentTimeMillis();         //1,000 milliseconds = 1 seconds
            
            //1. UPDATE: update information such as character positions
            update();
            
            
            //2. DRAW: draw the screen with the update information
            repaint();
            
            
            
            try {
                currentTime = System.nanoTime();
                timer += (currentTime - lastTime);
                lastTime = currentTime;
                
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;                  //we do this because the thread.sleep use millis
                
                
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                
                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
                drawCount++;
                
                if (timer >= 1000000000) {
                    System.out.println("FPS: " +drawCount);
                    drawCount = 0;
                    timer = 0;
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    public void update() {
        
        spawnLevel2Enemies();
        spawnLevel3Enemies();
        spawnLevel4Enemies();
        
        if(gameState == playState) {
            fish1.update();
            Enemy1.handleEnemies(enemy, screenWidth, screenHeight);
        }
        if(gameState == pauseState) {
            //nothing
        }
}



    public void addEntity(Entity entity) {
        entityList.add(entity);
    }
    private void drawEntities(Graphics2D g2) {
        for (Entity entity : entityList) {
            entity.draw(g2);
        }
    }
    
    public int getScore() {
        return score;
    }

    public void increaseScore(int points) {
        score += points;
        
    }

    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g; //we change graphics g to graphics 2D, Graphics 2D has more funcation.
        
        //TILE
        tileM.draw(g2); //this is like layer, so we put the tile draw before player
        
        //PLAYER
        fish1.draw(g2);
        
        //ENEMY
        for(int i = 0; i < enemy.length; i++) {
            if(enemy[i] != null) {
                enemy[i].draw(g2);
//                entityList.add(enemy[i]);
            }
        }
        
//        // Draw Entities
//        for(int i = 0; i < entityList.size(); i++) {
//            entityList.get(i).draw(g2);
//        }
//        //Empty Entities
//        for(int i = 0; i < entityList.size(); i++) {
//            entityList.remove(i);
//        }

        //UI
        ui.draw(g2);
        
        
        g2.dispose();
        
        
    }
    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic(int i){
        sound.setFile(i);
        sound.stop();
    }
    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }
}
