package tests;

import javax.swing.*;
import java.awt.*;

public class mod2example {
public static void main(String[] args) {
        // Create the main window (JFrame)
        JFrame frame = new JFrame("GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        // Create a label to display text
        JLabel label = new JLabel("Hello, World!");
        label.setFont(new Font("Arial", Font.BOLD, 18));

        // Add the label to the panel
        panel.add(label);

        // Add the panel to the frame
        frame.add(panel);

        // Make the window visible
        frame.setVisible(true);
    }
}
