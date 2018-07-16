package com.nagarro.entity;

public class ItemWithTax {

    private String name;
    private double price;
    private double salesTaxPerItem;
    private double finalPricePerItem;
    private double totalPrice;


    public ItemWithTax(String name, double price, double salesTaxPerItem, double finalPricePerItem, double totalPrice) {
        this.name = name;
        this.price = price;
        this.salesTaxPerItem = salesTaxPerItem;
        this.finalPricePerItem = finalPricePerItem;
        this.totalPrice = totalPrice;
    }


    public ItemWithTax(String name, double price, double salesTaxPerItem, double finalPrice) {
        this.name = name;
        this.price = price;
        this.salesTaxPerItem = salesTaxPerItem;
        this.finalPricePerItem = finalPrice;
    }

    @Override
    public String toString() {
        return "Item_Details_With_Tax{" +
                "Name = '" + name + '\'' +
                ", Item Price = " + price +
                ", Sales Tax Per Item = " + salesTaxPerItem +
                ", Final Price Per Item = " + finalPricePerItem +
                ", Total Price = " + totalPrice +
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

    public double getFinalPricePerItem() {
        return finalPricePerItem;
    }

    public void setFinalPricePerItem(double finalPricePerItem) {
        this.finalPricePerItem = finalPricePerItem;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
