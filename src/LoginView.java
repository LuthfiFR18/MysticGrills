
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginView {
	Scene scene;
	BorderPane borderContainer;
	GridPane gridContainer;
	FlowPane flowContainer;
	
	Label titleLbl, emailLbl, passwordLbl;
	TextField emailTF;
	PasswordField passwordPF;
	
	Button loginBtn;
	
	public void initialize() {
		
		borderContainer = new BorderPane();
		gridContainer = new GridPane();
		flowContainer = new FlowPane();
		
		
		emailLbl = new Label("Email");
		passwordLbl = new Label("Password");


		emailTF = new TextField();
		
		passwordPF = new PasswordField();

		
		loginBtn = new Button("Login");
		
		scene = new Scene(borderContainer, 600, 400);
		
		 
	}
	
	public void addComponent(){
		borderContainer.setTop(titleLbl);
		borderContainer.setCenter(gridContainer);
		borderContainer.setBottom(loginBtn);
		
	
		gridContainer.add(emailLbl, 0, 0);
		gridContainer.add(passwordLbl, 0, 2);
	
		

		gridContainer.add(emailTF, 1, 1);
		gridContainer.add(passwordPF, 1, 2);

	}
	
	public void arrangeComponent() {
		BorderPane.setAlignment(titleLbl, Pos.CENTER);
		BorderPane.setAlignment(loginBtn, Pos.CENTER);
		
		borderContainer.setPadding(new Insets(10));
		BorderPane.setMargin(titleLbl, new Insets(20));
		
		gridContainer.setAlignment(Pos.CENTER);
		gridContainer.setVgap(20);
		gridContainer.setVgap(20);
		
		flowContainer.setHgap(20);
		
		emailTF.setMaxWidth(320);
		passwordPF.setMaxWidth(320);
		

		emailLbl.setMinWidth(100);
		passwordLbl.setMinWidth(100);
		
		titleLbl.setFont(new Font("Times New Roman", 16));
		
	}
	
}
