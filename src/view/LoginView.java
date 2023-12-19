package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginView {
    private Scene scene;
    private BorderPane borderContainer;
    private GridPane gridContainer;
    private Label titleLbl, emailLbl, passwordLbl;
    private TextField emailTF;
    private PasswordField passwordPF;
    private Button loginBtn1;

    public LoginView() {
        initialize();
        addComponent();
        arrangeComponent();
    }
    

    private void initialize() {
        borderContainer = new BorderPane();
        gridContainer = new GridPane();
        titleLbl = new Label("Login");
        emailLbl = new Label("Email");
        passwordLbl = new Label("Password");
        emailTF = new TextField();
        passwordPF = new PasswordField();
        loginBtn1 = new Button("Login");
        scene = new Scene(borderContainer, 600, 300);
    }

    private void addComponent() {
        

        gridContainer.add(emailLbl, 0, 0);
        gridContainer.add(passwordLbl, 0, 2);
        gridContainer.add(emailTF, 1, 1);
        gridContainer.add(passwordPF, 1, 2);

        borderContainer.setTop(titleLbl);
        borderContainer.setCenter(gridContainer);
        borderContainer.setBottom(loginBtn1);
    }

    private void arrangeComponent() {
       
        BorderPane.setAlignment(titleLbl, Pos.CENTER);
        BorderPane.setAlignment(loginBtn1, Pos.CENTER);

        borderContainer.setPadding(new Insets(10));
        BorderPane.setMargin(titleLbl, new Insets(20));

        gridContainer.setAlignment(Pos.CENTER);
        gridContainer.setVgap(20);
        gridContainer.setVgap(20);

        emailTF.setMaxWidth(320);
        passwordPF.setMaxWidth(320);

        emailLbl.setMinWidth(100);
        passwordLbl.setMinWidth(100);

        titleLbl.setFont(new Font("Times New Roman", 16));
    }

    public Scene getScene() {
        return scene;
    }

    public TextField getEmailTF() {
        return emailTF;
    }

    public Button getLoginBtn1() {
        return loginBtn1;
    }

	public PasswordField getPasswordPF() {
        return passwordPF;
    }

    
}
