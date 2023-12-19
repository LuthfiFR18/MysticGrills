package view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.OrderedMenuItem;
import model.Products;

public class OrderView {
    private TableView<OrderedMenuItem> table;
    private Stage stage;

    public OrderView(ObservableList<OrderedMenuItem> orderedItems) {
        table = createOrderTable();
        table.getItems().addAll(orderedItems);

        VBox root = new VBox(new Label("Ordered Items"), table);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 400, 400);
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Ordered Items");
    }

    private TableView<OrderedMenuItem> createOrderTable() {
        TableView<OrderedMenuItem> table = new TableView<>();

        TableColumn<OrderedMenuItem, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduct().getProductName()));

        TableColumn<OrderedMenuItem, Number> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()));

        table.getColumns().addAll(nameColumn, quantityColumn);

        return table;
    }
    
    public TableView<OrderedMenuItem> getTable() {
        return table;
    }

    public Stage getStage() {
        return stage;
    }

    public void show() {
        stage.show();
    }
}