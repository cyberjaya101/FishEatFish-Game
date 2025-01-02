package main;

import enemy.Enemy1;
import enemy.Enemy2;
import enemy.Enemy3;
import enemy.Enemy4;
import java.util.Random;

public class AssetSetter {
    

    Random random = new Random();
    
    GamePanel gp; 
    
    public boolean level2EnemiesSpawned = false;
    public boolean level3EnemiesSpawned = false;
    public boolean level4EnemiesSpawned = false;
    
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public boolean isLevel2EnemiesSpawned() {
        return level2EnemiesSpawned;
    }
    
    public void setLevel2EnemiesSpawned(boolean level2EnemiesSpawned) {
        this.level2EnemiesSpawned = level2EnemiesSpawned;
    }
    public boolean isLevel3EnemiesSpawned() {
        return level3EnemiesSpawned;
    }
    
    public void setLevel3EnemiesSpawned(boolean level3EnemiesSpawned) {
        this.level3EnemiesSpawned = level3EnemiesSpawned;
    }
    public boolean isLevel4EnemiesSpawned() {
        return level4EnemiesSpawned;
    }
    
    public void setLevel4EnemiesSpawned(boolean level4EnemiesSpawned) {
        this.level4EnemiesSpawned = level4EnemiesSpawned;
    }
    
    public int[] setSpawn() {                      // this x and y is only the random for first spawn, 
        int y = 30 + random.nextInt(gp.screenHeight - 30);  //the next x and y will use the one one the Enemy1 Class
        int x = random.nextInt(2);
    
        // Spawn enemy from either left or right side
        if (x == 0) {
            x = -50;  // Start from left off-screen
        } else {
            x = gp.screenWidth + 50;  // Start from right off-screen
        }
        int[] position = {x, y};
        return position;
    }
    
    
    //LEVEL 1
    public void setEnemy() {
    int[] spawnPosition = setSpawn();
    
    // Initialize the enemy at the random position
    gp.enemy[0] = new Enemy1(gp);
    gp.enemy[0].x = spawnPosition[0];  // Set x to the calculated spawn position
    gp.enemy[0].y = spawnPosition[1];  // Set y to the random spawn position
    }
    public void setEnemy2() {
    int[] spawnPosition = setSpawn();
    
    // Initialize the enemy at the random position
    gp.enemy[1] = new Enemy1(gp);
    gp.enemy[1].x = spawnPosition[0];  // Set x to the calculated spawn position
    gp.enemy[1].y = spawnPosition[1];  // Set y to the random spawn position
    }
    public void setEnemy3() {
    int[] spawnPosition = setSpawn();
    
    // Initialize the enemy at the random position
    gp.enemy[2] = new Enemy1(gp);
    gp.enemy[2].x = spawnPosition[0];  // Set x to the calculated spawn position
    gp.enemy[2].y = spawnPosition[1];  // Set y to the random spawn position
    }
    
    // LEVEL 2
    public void setEnemy4() {

            int[] spawnPosition = setSpawn();
            gp.enemy[3] = new Enemy2(gp);
            gp.enemy[3].x = spawnPosition[0];
            gp.enemy[3].y = spawnPosition[1];
            gp.enemy[3].solidArea.setBounds(0, 0, 23*2, 11*2);
    }
     public void setEnemy5() {

            int[] spawnPosition = setSpawn();
            gp.enemy[4] = new Enemy2(gp);
            gp.enemy[4].x = spawnPosition[0];
            gp.enemy[4].y = spawnPosition[1];
            gp.enemy[4].solidArea.setBounds(0, 0, 23*2, 11*2);
    }
    public void setEnemy6() {
            int[] spawnPosition = setSpawn();
            gp.enemy[5] = new Enemy2(gp);
            gp.enemy[5].x = spawnPosition[0];
            gp.enemy[5].y = spawnPosition[1];
            gp.enemy[5].solidArea.setBounds(0, 0, 23*2, 11*2);
    }
    public void setEnemy7() {
            int[] spawnPosition = setSpawn();
            gp.enemy[6] = new Enemy2(gp);
            gp.enemy[6].x = spawnPosition[0];
            gp.enemy[6].y = spawnPosition[1];
            gp.enemy[6].solidArea.setBounds(0, 0, 23*2, 11*2);
    }
    public void setEnemy8() {
            int[] spawnPosition = setSpawn();
            gp.enemy[7] = new Enemy3(gp);
            gp.enemy[7].x = spawnPosition[0];
            gp.enemy[7].y = spawnPosition[1];
            gp.enemy[7].solidArea.setBounds(0, 0, (int) (32*1.5), (int) (25*1.5));
    }
    public void setEnemy9() {
            int[] spawnPosition = setSpawn();
            gp.enemy[8] = new Enemy3(gp);
            gp.enemy[8].x = spawnPosition[0];
            gp.enemy[8].y = spawnPosition[1];
            gp.enemy[8].solidArea.setBounds(0, 0, (int) (32*1.5), (int) (25*1.5));
    }
    public void setEnemy10() {
            int[] spawnPosition = setSpawn();
            gp.enemy[9] = new Enemy3(gp);
            gp.enemy[9].x = spawnPosition[0];
            gp.enemy[9].y = spawnPosition[1];
            gp.enemy[9].solidArea.setBounds(0, 0, (int) (32*1.5), (int) (25*1.5));
    }
    public void setEnemy11() {
            int[] spawnPosition = setSpawn();
            gp.enemy[10] = new Enemy3(gp);
            gp.enemy[10].x = spawnPosition[0];
            gp.enemy[10].y = spawnPosition[1];
            gp.enemy[10].solidArea.setBounds(0, 0, (int) (32*1.5), (int) (25*1.5));
    }
    public void setEnemy12() {
            int[] spawnPosition = setSpawn();
            gp.enemy[11] = new Enemy4(gp);
            gp.enemy[11].x = spawnPosition[0];
            gp.enemy[11].y = spawnPosition[1];
            gp.enemy[11].solidArea.setBounds(0, 0, 23*4, 11*4);
    }
    public void setEnemy13() {
            int[] spawnPosition = setSpawn();
            gp.enemy[12] = new Enemy4(gp);
            gp.enemy[12].x = spawnPosition[0];
            gp.enemy[12].y = spawnPosition[1];
            gp.enemy[12].solidArea.setBounds(0, 0, 23*4, 11*4);
    }
    public void setEnemy14() {
            int[] spawnPosition = setSpawn();
            gp.enemy[13] = new Enemy4(gp);
            gp.enemy[13].x = spawnPosition[0];
            gp.enemy[13].y = spawnPosition[1];
            gp.enemy[13].solidArea.setBounds(0, 0, 23*4, 11*4);
    }
    }
