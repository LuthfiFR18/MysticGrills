package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Order {
    private ObservableList<OrderedMenuItem> orderedItems = FXCollections.observableArrayList();

    public ObservableList<OrderedMenuItem> getOrderedItems() {
        return orderedItems;
    }

    public void addOrderedItem(Products product, int quantity) {
        OrderedMenuItem orderedItem = new OrderedMenuItem(product, quantity);
        orderedItems.add(orderedItem);
    }

    public void updateOrderedItem(Products product, int newQuantity) {
        // Find the ordered item and update its quantity
        orderedItems.stream()
                .filter(oi -> oi.getProduct().equals(product))
                .findFirst()
                .ifPresent(oi -> oi.setQuantity(newQuantity));
    }

    public void removeOrderedItem(Products product) {
        // Remove the ordered item
        orderedItems.removeIf(oi -> oi.getProduct().equals(product));
    }
}