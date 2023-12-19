package controller;

import database.Connect;
import javafx.stage.Stage;
import view.LoginView;
import view.MenuItemView;
import view.RegisterView;

//LoginController.java
public class LoginController {
 private final LoginView loginView;
 private final Connect connect;

 public LoginController(LoginView loginView, Connect connect) {
	 System.out.println("LoginController initialized");
     this.loginView = loginView;
     this.connect = connect;
     loginView.getLoginBtn1().setOnAction(event -> handleLogin());
 }


	
	  private void handleLogin() { 
		  String email = loginView.getEmailTF().getText();
		  String password = loginView.getPasswordPF().getText();
		  System.out.println("Login button clicked");
	  
	  if (connect.validateUser(email, password)) { 
		  openMenuItemView();
		  } 
	  	else{
	  System.out.println("Invalid login credentials"); }
	  
	  }
	 

 private void openMenuItemView() {
	 Stage loginStage = (Stage) loginView.getScene().getWindow();
     loginStage.close();
	 
     MenuItemView menuItemView = new MenuItemView(true);
     Stage menuItemStage = new Stage();
     menuItemStage.setScene(menuItemView.getScene());
     menuItemStage.setTitle("Menu Items");
     menuItemStage.show();

     
 }
 
 public void switchToRegisterView() { 
	 RegisterView registerView = new RegisterView(); 
	 Stage registerStage = new Stage();
	 registerStage.setScene(registerView.getScene());
	 registerStage.setTitle("Registration"); registerStage.show();
		  
		  Stage loginStage = (Stage) loginView.getScene().getWindow();
		  loginStage.close(); }
}

    
	
	 
	 

