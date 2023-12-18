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

public class RegisterView {
    private Scene scene;
    private BorderPane borderContainer;
    private GridPane gridContainer;

    private Label titleLbl, usernameLbl, emailLbl, passwordLbl, confirmPassLbl;
    private TextField usernameTF, emailTF;
    private PasswordField passwordPF, confirmPassPF;
    private Button regisBtn;
    

    public RegisterView() {
        borderContainer = new BorderPane();
        gridContainer = new GridPane();
        

        titleLbl = new Label("Register Here!");
        usernameLbl = new Label("Username");
        emailLbl = new Label("Email");
        passwordLbl = new Label("Password");
        confirmPassLbl = new Label("Confirm Password");

        usernameTF = new TextField();
        emailTF = new TextField();
        passwordPF = new PasswordField();
        confirmPassPF = new PasswordField();

        regisBtn = new Button("Register");

        initialize();
        addComponents();
        arrangeComponents();
    }

    private void initialize() {
        scene = new Scene(borderContainer, 600, 300);
        confirmPassPF = new PasswordField();
    }

    private void addComponents() {
        borderContainer.setTop(titleLbl);
        borderContainer.setCenter(gridContainer);
        borderContainer.setBottom(regisBtn);

        gridContainer.add(usernameLbl, 0, 0);
        gridContainer.add(emailLbl, 0, 1);
        gridContainer.add(passwordLbl, 0, 2);
        gridContainer.add(confirmPassLbl, 0, 3);

        gridContainer.add(usernameTF, 1, 0);
        gridContainer.add(emailTF, 1, 1);
        gridContainer.add(passwordPF, 1, 2);
        gridContainer.add(confirmPassPF, 1, 3);
    }

    private void arrangeComponents() {
        BorderPane.setAlignment(titleLbl, Pos.CENTER);
        BorderPane.setAlignment(regisBtn, Pos.CENTER);

        borderContainer.setPadding(new Insets(10));
        BorderPane.setMargin(titleLbl, new Insets(20));

        gridContainer.setAlignment(Pos.CENTER);
        gridContainer.setVgap(20);

        usernameTF.setMaxWidth(320);
        emailTF.setMaxWidth(320);
        passwordPF.setMaxWidth(320);
        confirmPassPF.setMaxWidth(320);

        usernameLbl.setMinWidth(100);
        emailLbl.setMinWidth(100);
        passwordLbl.setMinWidth(100);
        confirmPassLbl.setMinWidth(100);

        titleLbl.setFont(new Font("Times New Roman", 16));
    }

    public Scene getScene() {
        return scene;
    }

    public TextField getUsernameTF() {
        return usernameTF;
    }

    public TextField getEmailTF() {
        return emailTF;
    }

    public PasswordField getPasswordPF() {
        return passwordPF;
    }

    public PasswordField getConfirmPassPF() {
        return confirmPassPF;
    }

    public Button getRegisBtn() {
        return regisBtn;
    }
}

