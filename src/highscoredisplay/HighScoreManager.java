package highscoredisplay;

import javax.swing.*;
import java.awt.*;

public class HighScoreManager {
    private int highScore = 0; // Store the highest score
    private int currentScore = 0; // Store the current score
    private boolean newHighScore = false; // Flag for new high score

    // Method to update the current score
    public void updateScore(int score) {
        currentScore = score;
        if (currentScore > highScore) {
            highScore = currentScore; // Update high score
            newHighScore = true; // Set flag for new high score
        }
    }

    // Method to display the high score
    public void displayHighScore(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("High Score: " + highScore, 10, 30); // Display high score

        if (newHighScore) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("New High Score! Congratulations!", 50, 100); // Congratulatory message
            newHighScore = false; // Reset flag
        }
    }

    // Method to reset the game
    public void resetGame() {
        currentScore = 0; // Reset current score
    }

    // Example of how to use the HighScoreManager in a game loop
    public void gameLoop(Graphics g) {
        // Simulate gameplay and score update
        updateScore(currentScore); // Update score based on gameplay
        displayHighScore(g); // Display high score on the screen
    }
}