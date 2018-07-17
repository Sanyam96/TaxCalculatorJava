package com.nagarro.entity;

/**
 * Class to store Return output with Item Computation and with Tax Calculation
 */
public class ItemWithTax {

    private String name;
    private double price;
    private double salesTaxPerItem;
    private double finalPricePerItem;
    private double totalPrice;

    /**
     * Constructor
     *
     * @param name
     * @param price
     * @param salesTaxPerItem
     * @param finalPricePerItem
     * @param totalPrice
     */
    public ItemWithTax(String name, double price, double salesTaxPerItem, double finalPricePerItem, double totalPrice) {
        this.name = name;
        this.price = price;
        this.salesTaxPerItem = salesTaxPerItem;
        this.finalPricePerItem = finalPricePerItem;
        this.totalPrice = totalPrice;
    }

    /**
     * to wrap Item with tax into String
     *
     * @return Item with Tax String
     */
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
