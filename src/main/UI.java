package main;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font arial_20, arial_40;
    
    public UI(GamePanel gp) {
        this.gp = gp;
        arial_20 = new Font("Arial", Font.PLAIN, 20);
        arial_40 = new Font("Arial", Font.PLAIN, 40);
    }
    
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_20);
        g2.setColor(Color.BLACK);
        g2.drawString("Score: " + gp.getScore(), 10, 20);  // Position the score at the top left of the screen
        if (gp.getScore() >= 10 && gp.getScore() <= 14){
            String text = "Enemey level 2 has spawned!";
            int x = getXforCenteredText(text);
            int y = gp.screenHeight/2;
        
            g2.drawString(text, x, y); 
        }
        if (gp.getScore() >= 20 && gp.getScore() <= 25){
            String text = "You can eat enemy level 2 now!";
            int x = getXforCenteredText(text);
            int y = gp.screenHeight/2;
        
            g2.drawString(text, x, y); 
        }
        if (gp.getScore() >= 30 && gp.getScore() <= 35){
            String text = "Enemey level 3 has spawned!";
            int x = getXforCenteredText(text);
            int y = gp.screenHeight/2;
        
            g2.drawString(text, x, y); 
        }
        if (gp.getScore() >= 50 && gp.getScore() <= 54){
            String text = "You can eat enemy level 3 now!";
            int x = getXforCenteredText(text);
            int y = gp.screenHeight/2;
        
            g2.drawString(text, x, y); 
        }
        if (gp.getScore() >= 55 && gp.getScore() <= 60  ){
            g2.setColor(Color.RED);
            String text = "Enemy final level has spawned!";
            int x = getXforCenteredText(text);
            int y = gp.screenHeight/2;
        
            g2.drawString(text, x, y); 
        }
        if (gp.getScore() >= 0 && gp.getScore() <= 19){
            String text = "LEVEL 1";
            int x = getXforCenteredText(text);
            int y = 20;
        
            g2.drawString(text, x, y); 
        }
        if (gp.getScore() >= 20 && gp.getScore() <= 49){
            String text = "LEVEL 2";
            int x = getXforCenteredText(text);
            int y = 20;
        
            g2.drawString(text, x, y); 
        }
        if (gp.getScore() >= 50 && gp.getScore() <= 54){
            String text = "LEVEL 3";
            int x = getXforCenteredText(text);
            int y = 20;
        
            g2.drawString(text, x, y); 
        }
        if (gp.getScore() >= 55){
            g2.setColor(Color.RED);
            String text = "FINAL LEVEL";
            int x = getXforCenteredText(text);
            int y = 20;
        
            g2.drawString(text, x, y); 
        }
        if(gp.gameState == gp.playState) {
            
        }
        if(gp.gameState == gp.pauseState) {
            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);
            drawPauseScreen();
        }
        
        //GAME OVER STATE
        if(gp.gameState == gp.gameOverState) {
            drawGameOverScreen();
        }
        
    }
    public void drawPauseScreen() {
        
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        g2.drawString(text, x, y);  
    }
    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    
    public void drawGameOverScreen() {
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        
        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));
        
        //Shadow
        text = "Game Over";
        g2.setColor(Color.black);
        x = getXforCenteredText(text);
        y = gp.tileSize*4;
        g2.drawString(text,x,y);
        //main
        g2.setColor(Color.white);
        g2.drawString(text, x-4, y-4);
        
    }
}
