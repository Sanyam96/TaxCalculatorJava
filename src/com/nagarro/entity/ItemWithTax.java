package com.nagarro.entity;

import com.nagarro.enums.ItemType;

public class ItemWithTax{

    private String name;
    private double price;
    private double salesTaxPerItem;
    private double finalPrice;


    public ItemWithTax(String name, double price, double salesTaxPerItem, double finalPrice) {
        this.name = name;
        this.price = price;
        this.salesTaxPerItem = salesTaxPerItem;
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "Item Details With Tax{" +
                "name = '" + name + '\'' +
                ", price = " + price +
                ", sales Tax Per Item = " + salesTaxPerItem +
                ", final Price=" + finalPrice +
                '}';

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

    public double getSalesTaxPerItem() {
        return salesTaxPerItem;
    }

    public void setSalesTaxPerItem(double salesTaxPerItem) {
        this.salesTaxPerItem = salesTaxPerItem;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

}
