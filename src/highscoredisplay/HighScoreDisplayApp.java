import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScoreDisplayApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("High Score Display");
        GamePanel gamePanel = new GamePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(gamePanel);
        frame.setVisible(true);

        // Simulate score updates every second
        Timer timer = new Timer(1000, new ActionListener() {
            private int score = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                score += 10; // Increment score
                gamePanel.simulateScoreUpdate(score); // Update the score in the game panel
            }
        });
        timer.start();
    }
}