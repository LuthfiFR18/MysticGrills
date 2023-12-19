package main;

import controller.LoginController;
import controller.MenuItemController;
import controller.RegisterController;
import database.Connect;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.LoginView;
import view.MenuItemView;
import view.RegisterView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Connect connect = Connect.getInstance();

        RegisterView registerView = new RegisterView();
        RegisterController registerController = new RegisterController(registerView, connect);
        
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView, connect);
        
        MenuItemView menuItemView = new MenuItemView(true);
        MenuItemController menuItemController = new MenuItemController(menuItemView, connect);

        primaryStage.setScene(menuItemView.getScene());
        
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
