package CSC372Mod3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/*
 * CSC372 - Module 3
 * Matthew Finney
 * A JavaFX application that demonstrates a menu button with selectable items
 * https://github.com/matt-finney/CSC372
 */

public class Module3 extends Application 
{
    private final TextArea text_area = new TextArea();

  @Override
    public void start(Stage stage) 
    {
        stage.setTitle("CSC327 Module 3");

        // root layout
        BorderPane root = new BorderPane();
        text_area.setEditable(false);
        text_area.setWrapText(true);
        text_area.setPromptText("log will appear here...");
        // Apply padding to the text area so the MenuBar stays flush with the top
        BorderPane.setMargin(text_area, new Insets(0, 20, 20, 20));
        root.setCenter(text_area);

        // menu bars
        MenuBar menu_bar = new MenuBar();
        Menu actions = new Menu("Actions");

        // menu items
        MenuItem show_date = new MenuItem("Show Date/Time");
        MenuItem save_text = new MenuItem("Save Text to File");
        MenuItem random_green = new MenuItem("Random Green Background");
        MenuItem exit = new MenuItem("Exit");

        // add items to menu and menu to menu bar
        actions.getItems().addAll(show_date, save_text, random_green, new SeparatorMenuItem(), exit);
        menu_bar.getMenus().add(actions);
        root.setTop(menu_bar);

        // menu item actions
        show_date.setOnAction(e -> 
        {
            // get current date and time and display in text area
            String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US));
            text_area.appendText("Current Date/Time: " + now + "\n");
        });

        save_text.setOnAction(e -> 
        {
            // saves the current text area content to log.txt
            String content = text_area.getText();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) 
            {
                writer.write(content);
                text_area.appendText("Text saved to log.txt\n");
            } 
            catch (IOException ex) 
            {
                text_area.appendText("Error saving file: " + ex.getMessage() + "\n");
            }
        });

        random_green.setOnAction(e -> 
        {
            // change background to a random shade of green
            int green_value = (int)(Math.random() * 256);
            Color random_green_color = Color.rgb(0, green_value, 0);
            root.setBackground(new Background(new BackgroundFill(random_green_color, null, Insets.EMPTY)));
            text_area.appendText(String.format("Background color changed to RGB(0, %d, 0)\n", green_value));
        });

        // exits the application
        exit.setOnAction(e -> Platform.exit());

        // scene setup
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        Application.launch(args);
    }
}
