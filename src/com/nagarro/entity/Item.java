package com.nagarro.entity;

import com.nagarro.enums.ItemType;

/**
 * Item class for blue print of Item input
 */
public class Item {

    private String name;
    private double price;
    private int quantity;
    private ItemType type;

    /**
     * To wrap Item object to String
     *
     * @return String Object of Item
     */
    @Override
    public String toString() {
        return "Item{" +
                "Name = '" + name + '\'' +
                ", Price = " + price +
                ", Quantity = " + quantity +
                ", Item Type = " + type +
                '}';
    }

    /**
     * constructor of Item
     *
     * @param name
     * @param price
     * @param quantity
     * @param type
     */
    public Item(String name, double price, int quantity, ItemType type) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

}
