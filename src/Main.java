import javafx.application.Application;
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

public class Main extends Application{
	
	Scene scene;
	BorderPane borderContainer;
	GridPane gridContainer;
	FlowPane flowContainer;
	
	Label titleLbl, usernameLbl, emailLbl, passwordLbl, confirmPassLbl;
	TextField usernameTF, emailTF;
	PasswordField passwordPF, confirmPassPF;
	
	Button regisBtn;
	
	public void initialize() {
		
		borderContainer = new BorderPane();
		gridContainer = new GridPane();
		flowContainer = new FlowPane();
		
//		Label label = new Label("hello");
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
		
		scene = new Scene(borderContainer, 600, 300);
	}
	
	
	public void addComponent(){
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
	
	public void arrangeComponent() {
		BorderPane.setAlignment(titleLbl, Pos.CENTER);
		BorderPane.setAlignment(regisBtn, Pos.CENTER);
		
		borderContainer.setPadding(new Insets(10));
		BorderPane.setMargin(titleLbl, new Insets(20));
		
		gridContainer.setAlignment(Pos.CENTER);
		gridContainer.setVgap(20);
		gridContainer.setVgap(20);
		
		flowContainer.setHgap(20);
		
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		initialize();
		addComponent();
		arrangeComponent();
		arg0.setTitle("Registration Form");
		arg0.setScene(scene);
		arg0.setResizable(false);
		arg0.show();
	}

}
