package controller;

import database.Connect;
import javafx.stage.Stage;
import view.MenuItemView;

public class MenuItemController {
    private final MenuItemView menuItemView;

    public MenuItemController(MenuItemView menuItemView) {
        this.menuItemView = menuItemView;
        initialize();
    }

    private void initialize() {
    	menuItemView.setAddToOrderAction(() -> {
    	    
    	    System.out.println("Add to Order button clicked!");
    	});
    }
}
