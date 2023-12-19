package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Order;
import model.OrderedMenuItem;
import model.Products;
import view.OrderView;

public class OrderedItemController {
    private OrderView orderedItemView;
    private ObservableList<OrderedMenuItem> orderedItems = FXCollections.observableArrayList();

    public OrderedItemController(OrderView view) {
        this.orderedItemView = view;
        orderedItemView.getTable().setItems(orderedItems);
    }

    public void updateView(Order order) {
        orderedItems.clear();
        orderedItems.addAll(order.getOrderedItems());
    }

    // Add methods to handle updating ordered items (increase, reduce, remove)
}