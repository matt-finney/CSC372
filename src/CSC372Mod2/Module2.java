package CSC372Mod2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * CSC372 - Module 2
 * Matthew Finney
 * A simple GUI application to manage a bank account balance
 * https://github.com/matt-finney/CSC372
 */

public class Module2 extends JFrame implements ActionListener 
{
    private double balance;             // holds account balance
    private JLabel balance_label;       // displays balance
    private JTextField amount_field;    // user input field
    private JButton deposit_button;
    private JButton withdraw_button;

    public Module2() 
    {
        // Set up the frame
        setTitle("Bank Balance Application");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 5, 5));

        // Balance label
        balance_label = new JLabel("Current Balance: $0.00", SwingConstants.CENTER);
        panel.add(balance_label);

        // Text field for amount input
        JPanel input_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        input_panel.add(new JLabel("Enter Amount:"));
        amount_field = new JTextField(16);
        input_panel.add(amount_field);
        panel.add(input_panel);

        // Buttons
        deposit_button = new JButton("Deposit");
        withdraw_button = new JButton("Withdraw");

        // Add listeners
        deposit_button.addActionListener(this);
        withdraw_button.addActionListener(this);

        // Sub-panel for buttons
        JPanel button_panel = new JPanel();
        button_panel.add(deposit_button);
        button_panel.add(withdraw_button);
        panel.add(button_panel);

        // Add panel to frame
        add(panel);
        setVisible(true);
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            double amount = Double.parseDouble(amount_field.getText());
            if (e.getSource() == deposit_button) 
            {
                balance += amount;
            } else if (e.getSource() == withdraw_button) 
            {
                if (amount > balance) 
                {
                    JOptionPane.showMessageDialog(this, "Insufficient funds!");
                    return;
                }
                balance -= amount;
            }
            balance_label.setText(String.format("Current Balance: $%,.2f", balance));
            amount_field.setText("");
        } catch (NumberFormatException ex) 
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    public static void main(String[] args) 
    {
        // Run the GUI
        SwingUtilities.invokeLater(Module2::new);
    }
}

