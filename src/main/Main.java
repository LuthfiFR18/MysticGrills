package main;

import controller.RegisterController;
import database.Connect;
import javafx.application.Application;
import javafx.stage.Stage;
import view.RegisterView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Connect connect = Connect.getInstance();

        RegisterView registerView = new RegisterView();
        RegisterController registerController = new RegisterController(registerView, connect);

        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(registerView.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
