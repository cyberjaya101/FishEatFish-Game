package highscoredisplay;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    HighScoreManager highScoreManager = new HighScoreManager();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        highScoreManager.gameLoop(g); // Call the game loop to update and display high score
    }

    // Simulate score update (this would be called during gameplay)
    public void simulateScoreUpdate(int score) {
        highScoreManager.updateScore(score);
        repaint(); // Refresh the panel to show updated scores
    }
}