package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to exit using the x button on TL
        window.setResizable(false); //so that the window size can't be change
        window.setTitle("FishEatFish"); //the app name
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel); //it's like adding JPanel to this class, but we already add extra settings to our GamePanel Class
        
        window.pack(); //Causes this Window to be sized to fit the preferred size and layouts of it subcomponents (=GamePanel)
        
        window.setLocationRelativeTo(null); //the position when the app is opened, null will make it opened on the centre
        window.setVisible(true); // so we can see the window
        
        gamePanel.setupGame();
        gamePanel.startGameThread();

    }
}
