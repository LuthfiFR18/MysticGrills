package controller;

import database.Connect;
import javafx.stage.Stage;
import view.LoginView;
import view.MenuItemView;

public class LoginController {
    private final LoginView loginView;
    private final Connect connect;

    public LoginController(LoginView loginView, Connect connect) {
        this.loginView = loginView;
        this.connect = connect;
        initialize();
    }

    private void initialize() {
        // Set up event handlers
        loginView.getLoginBtn().setOnAction(event -> {
            // Get user input data
            String email = loginView.getEmailTF().getText();
            String password = loginView.getPasswordPF().getText();

            // Validate the user (replace this with your validation logic)
            if (connect.validateUser(email, password)) {
                // If valid, open the MenuItemView
                openMenuItemView();
            } else {
                // Show an error message or handle invalid login
                System.out.println("Invalid login credentials");
            }
        });
    }

    private void openMenuItemView() {
        MenuItemView menuItemView = new MenuItemView();
        Stage menuItemStage = new Stage();
        menuItemStage.setScene(menuItemView.getScene());
        menuItemStage.setTitle("Menu Items");
        menuItemStage.show();

        // Close the LoginView stage
        Stage loginStage = (Stage) loginView.getScene().getWindow();
        loginStage.close();
    }
}
