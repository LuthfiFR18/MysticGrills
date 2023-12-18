package controller;

import database.Connect;
import javafx.stage.Stage;
import view.LoginView;
import view.RegisterView;

public class RegisterController {
    private RegisterView registerView;
    private Connect connect;

    public RegisterController(RegisterView registerView, Connect connect) {
        this.registerView = registerView;
        this.connect = connect;

        registerView.getRegisBtn().setOnAction(event -> register());
    }

    private void register() {
        // Get user input data
        String username = registerView.getUsernameTF().getText();
        String email = registerView.getEmailTF().getText();
        String password = registerView.getPasswordPF().getText();
        String confirm_password = registerView.getConfirmPassPF().getText();
        
        // Insert user into the database
        connect.insertUser(username, email, password, confirm_password);

        // Close the registration window
        Stage primaryStage = (Stage) registerView.getRegisBtn().getScene().getWindow();
        primaryStage.close();

        // Navigate to the login page
        LoginView loginView = new LoginView();
        Stage loginStage = new Stage();
        loginStage.setScene(loginView.getScene());
        loginStage.setTitle("Login");
        loginStage.show();
    }
}
