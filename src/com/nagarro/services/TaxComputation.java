package com.nagarro.services;

import com.nagarro.Utils;
import com.nagarro.constants.TaxConstants;
import com.nagarro.entity.Item;
import com.nagarro.entity.ItemWithTax;
import com.nagarro.enums.ItemType;

public class TaxComputation implements TaxOnItem {

    private Item prepareItem() {

        String name;
        double price;
        int quantity;
        int typeId;
        ItemType itemType = null;

        System.out.print("Enter Item name: ");
        name = Utils.getScannerInstance().nextLine();

        boolean itemTypeLoopFlag = true;
        while (itemTypeLoopFlag) {
            System.out.print("Enter Item type(1. raw, 2. manufactured, 3. imported): ");
            try {

                typeId = Utils.getScannerInstance().nextInt();
                switch (typeId) {
                    case 1:
                        itemType = ItemType.RAW;
                        break;
                    case 2:
                        itemType = ItemType.MANUFACTURED;
                        break;
                    case 3:
                        itemType = ItemType.IMPORTED;
//                        itemTypeLoopFlag = false;
                        break;
                    default:
                        System.out.println("Wrong input entered!");
                        System.out.println("Please try (1/2/3)");
                        continue;
                }

                itemTypeLoopFlag = false;
            } catch (Exception e) {
                System.out.println("MyException is : " + e);
                System.out.println("Wrong input entered!");
                System.out.println("Please try (1/2/3)");
                itemTypeLoopFlag = true;
            }
        }

        System.out.print("Enter Item price: ");
        price = Utils.getScannerInstance().nextDouble();

        System.out.print("Enter Item quantity: ");
        quantity = Utils.getScannerInstance().nextInt();

        Item item = new Item(name, price, quantity, itemType);

        System.out.println(item.toString());
        Utils.getScannerInstance().nextLine();

        return item;
    }

    public ItemWithTax prepareItemAndComputeTax() {
        Item item = this.prepareItem();
        return this.computeTax(item);
    }

    private ItemWithTax computeTax(Item item) {
        double salesTaxOnItem = taxOnPerItem(item.getPrice(), item.getType());
        ItemWithTax itemWithTax = new ItemWithTax(item.getName(), item.getPrice(), salesTaxOnItem, item.getPrice() + salesTaxOnItem, (item.getPrice() + salesTaxOnItem) * item.getQuantity());
        return itemWithTax;
    }

    @Override
    public double taxOnPerItem(double itemPrice, ItemType itemType) {

        if (itemType == ItemType.RAW) {
            return (itemPrice * TaxConstants.RAW_PERCENTAGE_TAX / 100);
        } else if (itemType == ItemType.MANUFACTURED) {
            return ((itemPrice * TaxConstants.MANUFACTURED_PERCENTAGE_TAX_12_5 / 100) + ((TaxConstants.MANUFACTURED_PERCENTAGE_TAX_VALUE_2 / 100) * (itemPrice + (TaxConstants.MANUFACTURED_PERCENTAGE_TAX_12_5 / 100) * itemPrice)));
        } else {
            double priceWithImportedTax = (TaxConstants.IMPORT_DUTY_PERCENAGE_TAX / 100) * itemPrice + itemPrice;

            if (priceWithImportedTax <= 100) {
                return TaxConstants.SURCHARGE_LESS_100_VALUE + priceWithImportedTax - itemPrice;
            } else if (priceWithImportedTax > 100 && priceWithImportedTax <= 200) {
                return TaxConstants.SURCHARGE_BETWEEN_100_200_VALUE + priceWithImportedTax - itemPrice;
            } else {
                return (((TaxConstants.SURCHARGE_MORE_200_PERCENTAGE_TAX / 100) * priceWithImportedTax + priceWithImportedTax) - itemPrice);
            }
        }
    }

}
