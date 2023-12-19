package view;

import controller.MenuItemController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Products;

public class MenuItemView extends VBox{
	private TableView<Products> table;
	private Button addBtn = new Button("Add");
	private Button deleteBtn = new Button("Delete");
	private Button updateBtn = new Button("Update");
	private Button addToOrderBtn = new Button("Add to Order");
	
	private TextField InputId = new TextField();
	private TextField Inputname = new TextField();
	private TextField Inputprice = new TextField();
	private TextField Inputqty = new TextField();

	
	public MenuItemView(boolean isAdmin) {


		table = createProductTable();
			
		 GridPane forms = createProductForm(table, isAdmin);
	        VBox.setMargin(forms, new Insets(20));
	        
	        HBox buttons = new HBox(addToOrderBtn);
	        buttons.setSpacing(10);

	        this.getChildren().addAll(table, forms, buttons);
	        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	        Scene scene = new Scene(this, 1200, 800);
	        new Stage().setScene(scene);
	}
	
	private TableView<Products> createProductTable() {
		TableView<Products> table = new TableView<>();
		TableColumn<Products, String> idColumn = new TableColumn<>("Product ID");
		idColumn.setCellValueFactory(new PropertyValueFactory<>("ProductID"));

		TableColumn<Products, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("ProductName"));

		TableColumn<Products, Number> priceColumn = new TableColumn<>("Price");
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("ProductPrice"));

		
		table.getColumns().add(idColumn);
		table.getColumns().add(nameColumn);
		table.getColumns().add(priceColumn);

		return table;
	}
	
	private GridPane createProductForm(TableView<Products> table, boolean isAdmin) {
        GridPane forms = new GridPane();
        forms.setVgap(20);
        forms.setHgap(10);

        forms.add(new Label("Product ID:"), 0, 0);
        InputId.setDisable(true);
        forms.add(InputId, 1, 1);
        forms.add(new Label("Product Name:"), 0, 1);
        forms.add(Inputname, 1, 1);
        forms.add(new Label("Product Price:"), 0, 2);
        forms.add(Inputprice, 1, 2);
        forms.add(addBtn, 0, 4);
        forms.add(deleteBtn, 1, 4);
        forms.add(updateBtn, 2, 4);

        // Make the admin buttons invisible for non-admin users
        addBtn.setVisible(isAdmin);
        deleteBtn.setVisible(isAdmin);
        updateBtn.setVisible(isAdmin);

        return forms;
    }

	public TableView<Products> getTable() {
		return table;
	}

	public Button getAddButton() {
		return addBtn;
	}

	public Button getDeleteButton() {
		return deleteBtn;
	}

	public Button getUpdateButton() {
		return updateBtn;
	}
	
	public Button getAddToOrderButton() {
	        return addToOrderBtn;
	}

	public TextField getIdInput() {
		return InputId;
	}

	public TextField getNameInput() {
		return Inputname;
	}

	public TextField getPriceInput() {
		return Inputprice;
	}

	public TextField getInputqty() {
		return Inputqty;
	}

	
	

	
}
