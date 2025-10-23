package tests;

import javax.swing.*;
import java.awt.*;

public class mod3example 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // sets the layout manager
        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));

        frame.add(panel);
        frame.setVisible(true);
    }
}
