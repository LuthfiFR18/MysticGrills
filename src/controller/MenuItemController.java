package controller;

import database.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Order;
import model.Products;
import view.MenuItemView;

public class MenuItemController {
	private MenuItemView menuitemView;
	private ObservableList<Products> products = FXCollections.observableArrayList();
	private boolean isAdmin;

	private Order currentOrder = new Order();
	
	public MenuItemController(MenuItemView view, Connect connect) {
		this.menuitemView = view;
		this.isAdmin = isAdmin;
		
		loadTableData(); 
		setupTableSelectionListener(); 
		setButtonListener();
	}
	
	private void setButtonListener() {
		menuitemView.getAddButton().setOnAction(e -> handleInsert());
		menuitemView.getDeleteButton().setOnAction(e -> handleDelete());
		menuitemView.getUpdateButton().setOnAction(e -> handleUpdate());
		menuitemView.getAddToOrderButton().setOnAction(e -> handleAddToOrder());
	}
	
	private void setupTableSelectionListener() {
		menuitemView.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
			    menuitemView.getIdInput().setText(String.valueOf(newSelection.getProductID()));
			    menuitemView.getNameInput().setText(newSelection.getProductName());
			    menuitemView.getPriceInput().setText(String.valueOf(newSelection.getProductPrice()));

			} else {
			    
			    menuitemView.getIdInput().clear();
			    menuitemView.getNameInput().clear();
			    menuitemView.getPriceInput().clear();

			}
		});
	}

	void loadTableData() {
		products.clear();
		products.addAll(Products.loadProducts());
		menuitemView.getTable().setItems(products);
	}
	
	void handleInsert() {
		String name = menuitemView.getNameInput().getText();
		int price = Integer.parseInt(menuitemView.getPriceInput().getText());
		for (Products product : products) {
			if (name.equals(product.getProductName())) {
				System.out.println("Name is not unique");
				return;
			}
		}
		Products.insertProduct(name, price);
		loadTableData();
	}
	
	void handleDelete() {
		int id = Integer.valueOf(menuitemView.getIdInput().getText());
		Products.deleteProduct(id);
		loadTableData();
	}

	void handleUpdate() {
		int id = Integer.valueOf(menuitemView.getIdInput().getText());
		String name = menuitemView.getNameInput().getText();
		int price = Integer.parseInt(menuitemView.getPriceInput().getText());
		Products.updateProduct(id, name, price);
		loadTableData();
	}
	
	private void handleAddToOrder() {
        Products selectedProduct = menuitemView.getTable().getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            try {
                int quantity = Integer.parseInt(menuitemView.getInputqty().getText());
                if (quantity > 0) {
                    currentOrder.addOrderedItem(selectedProduct, quantity);
                    // You may want to update your OrderedItemView here
                    // You need to implement a method in OrderedItemController to update its view
                    // something like orderedItemController.updateView(currentOrder);
                } else {
                    System.out.println("Quantity must be greater than 0.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid quantity format.");
            }
        } else {
            System.out.println("Please select a menu item.");
        }
    }
}
