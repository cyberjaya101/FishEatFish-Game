package highscoredisplay;

// Main class to run the game
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("High Score Display");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        // Simulate score updates
        gamePanel.simulateScoreUpdate(10); // Example score update
        gamePanel.simulateScoreUpdate(20); // Example score update
        gamePanel.simulateScoreUpdate(15); // Example score update
        gamePanel.simulateScoreUpdate(25); // New high score
    }
}