package CSC372Mod4Portfolio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * CSC372 - Module 4 - Portfolio
 * Matthew Finney
 * A simple GUI application to manage a bank account balance, rewritten using JavaFX instead of Swing
 * With added simple menu bar functionality
 * https://github.com/matt-finney/CSC372
 */

public class Module2Redux extends Application 
{
     // Variable declarations
    private double balance;                  // current balance amount
    private Label balance_label;             // label for balance
    private TextField amount_field;          // user input field for deposit/withdraw amount
    private Button deposit_button;           // deposit button
    private Button withdraw_button;          // withdraw button

    // Panels
    private VBox panel;                      // main panel
    private HBox input_panel;                // panel for label + textfield
    private HBox button_panel;               // panel for buttons

    // Menu components
    private MenuBar menu_bar;                // top menu bar
    private Menu actions;                    // Actions menu
    private MenuItem exit_item;              // Exit menu item

    @Override
    public void start(Stage stage) 
    {
         // Set up the stage
        stage.setTitle("Bank Balance Application");
        stage.setWidth(400);
        stage.setHeight(250);

        // Create MenuBar and Menu
        menu_bar = new MenuBar();
        actions = new Menu("Actions");
        exit_item = new MenuItem("Exit");

        // Exit item action
        exit_item.setOnAction(e -> stage.close());

        // Add menu items to menu and menu to menubar
        actions.getItems().add(exit_item);
        menu_bar.getMenus().add(actions);

        // Create main panel
        panel = new VBox(10);
        panel.setPadding(new Insets(10));
        panel.setAlignment(Pos.TOP_LEFT);

        // Label for balance
        balance_label = new Label("Current Balance: $0.00");
        balance_label.setMaxWidth(Double.MAX_VALUE);
        panel.getChildren().add(balance_label);

        // Create input panel
        input_panel = new HBox(8);
        input_panel.setAlignment(Pos.CENTER_LEFT);
        Label amount_label = new Label("Enter Amount:");
        amount_field = new TextField();
        amount_field.setPrefColumnCount(16);
        input_panel.getChildren().addAll(amount_label, amount_field);
        panel.getChildren().add(input_panel);

        // Create buttons and add listeners
        deposit_button = new Button("Deposit");
        withdraw_button = new Button("Withdraw");

        deposit_button.setOnAction(e -> onDeposit());
        withdraw_button.setOnAction(e -> onWithdraw());

        // Create button panel
        button_panel = new HBox(10, deposit_button, withdraw_button);
        button_panel.setAlignment(Pos.CENTER);
        panel.getChildren().add(button_panel);

        // Root layout with menu at top and main panel in center
        BorderPane root = new BorderPane();
        root.setTop(menu_bar);
        root.setCenter(panel);

        stage.setScene(new Scene(root));
        stage.show();
    }

    // Deposit method
    private void onDeposit() 
    {
        Double amount = parseAmount();
        if (amount == null) return;
        balance += amount;
        updateUI();
    }

    // Withdraw method
    private void onWithdraw() 
    {
        Double amount = parseAmount();
        if (amount == null) return;
        if (amount > balance) 
        {
            showAlert(Alert.AlertType.WARNING, "Insufficient Funds", "You do not have enough balance to withdraw this amount.");
            return;
        }
        balance -= amount;
        updateUI();
    }

     // Parse and validate amount entered in the text field
    private Double parseAmount() 
    {
        String txt = amount_field.getText().trim();
        try 
        {
            double value = Double.parseDouble(txt);
            return value;
        } catch (NumberFormatException ex) 
        {
            showAlert(Alert.AlertType.ERROR, "Invalid input", "Please enter a valid number.");
            return null;
        }
    }

    // Update label with new balance and clear the input field
    private void updateUI() 
    {
        balance_label.setText(String.format("Current Balance: $%,.2f", balance));
        amount_field.clear();
    }

    // Display alert dialogs
    private void showAlert(Alert.AlertType type, String title, String content) 
    {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(content);
        a.showAndWait();
    }

    // Main method
    public static void main(String[] args) 
    {
        launch(args);
    }
}
