package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MenuItemView {
    private Scene scene;
    private BorderPane borderContainer;
    private GridPane gridContainer;
    private Button viewMenuBtn;

    private Label menuItemLabel;
    private ListView<String> menuItemsListView;
    private Label quantityLabel;
    private Spinner<Integer> quantitySpinner;
    private Button addToOrderBtn;

    public MenuItemView() {
        borderContainer = new BorderPane();
        gridContainer = new GridPane();

        menuItemLabel = new Label("Menu Item");
        menuItemsListView = new ListView<>();
        quantityLabel = new Label("Quantity");
        quantitySpinner = new Spinner<>(1, Integer.MAX_VALUE, 1);
        addToOrderBtn = new Button("Add to Order");

        initialize();
        addComponents();
        arrangeComponents();
    }

    private void initialize() {
    	
    	viewMenuBtn = new Button("View Menu");
    	
        scene = new Scene(borderContainer, 600, 400);
    }

    private void addComponents() {
        borderContainer.setTop(menuItemLabel);
        borderContainer.setCenter(gridContainer);
        borderContainer.setBottom(addToOrderBtn);
        borderContainer.setCenter(viewMenuBtn);

        gridContainer.add(menuItemLabel, 0, 0);
        gridContainer.add(menuItemsListView, 1, 0);
        gridContainer.add(quantityLabel, 0, 1);
        gridContainer.add(quantitySpinner, 1, 1);
        gridContainer.add(viewMenuBtn, 1, 4);
    }

    private void arrangeComponents() {
        BorderPane.setAlignment(menuItemLabel, Pos.CENTER);
        BorderPane.setAlignment(addToOrderBtn, Pos.CENTER);

        borderContainer.setPadding(new Insets(10));

        gridContainer.setAlignment(Pos.CENTER);
        gridContainer.setVgap(20);

        quantitySpinner.setMaxWidth(80);

        menuItemLabel.setMinWidth(100);
        quantityLabel.setMinWidth(100);
    }
    
    

    public Scene getScene() {
        return scene;
    }

    // add event handlers for the button or other functionalities as needed
    
    public void setAddToOrderAction(Runnable action) {
        addToOrderBtn.setOnAction(event -> action.run());
    }

    // Other methods for setting menu items in the ListView, etc., as needed
}
