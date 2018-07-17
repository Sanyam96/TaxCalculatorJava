package com.nagarro.services;

import com.nagarro.Utils;
import com.nagarro.constants.TaxConstants;
import com.nagarro.entity.Item;
import com.nagarro.entity.ItemWithTax;
import com.nagarro.enums.ItemType;

/**
 * Class for tax computation
 */
public class TaxComputation implements TaxOnItem {

    /**
     * function to prepare Item
     * @return Item Object
     * after taking input operations
     */
    private Item prepareItem() {

        String name;
        double price;
        int quantity;
        int typeId;
        ItemType itemType = null;

        System.out.print("Enter Item name: ");
        name = Utils.getScannerInstance().nextLine();   // input name String

        boolean itemTypeLoopFlag = true;
        // loop to take input for Item Type, if wrong input entered, loop
        while (itemTypeLoopFlag) {
            System.out.print("Enter Item type(1. raw, 2. manufactured, 3. imported): ");
            try {
                typeId = Utils.getScannerInstance().nextInt();  // input type ID
                switch (typeId) {
                    case 1:
                        itemType = ItemType.RAW;
                        break;
                    case 2:
                        itemType = ItemType.MANUFACTURED;
                        break;
                    case 3:
                        itemType = ItemType.IMPORTED;
                        break;
                    default:
                        System.out.println("Wrong input entered!");
                        System.out.println("Please try (1/2/3)");
                        continue;
                }
                itemTypeLoopFlag = false;
            } catch (Exception e) {
                System.out.println("MyException is : " + e + "\nWrong input entered!" + "\nPlease try (1/2/3)");
                itemTypeLoopFlag = true;
                Utils.getScannerInstance().nextLine();
            }
        }

        System.out.print("Enter Item price: ");
        price = Utils.getScannerInstance().nextDouble();    // input Item Price

        System.out.print("Enter Item quantity: ");
        quantity = Utils.getScannerInstance().nextInt();    // input Item quantity

        Item item = new Item(name, price, quantity, itemType);  // Item object with passing all input params to constructor

        System.out.println(item.toString());    // print Item object as string
        Utils.getScannerInstance().nextLine();

        return item;
    }

    /**
     * transform Item to Item with Tax
     * @return computed item with tax
     */
    public ItemWithTax prepareItemAndComputeTax() {
        Item item = this.prepareItem();
        return this.computeTax(item);
    }

    /**
     * Item with Tax object preparation
     * @param item
     * @return Item with Tax
     */
    private ItemWithTax computeTax(Item item) {
        double salesTaxOnItem = taxOnPerItem(item.getPrice(), item.getType());
        ItemWithTax itemWithTax = new ItemWithTax(item.getName(), item.getPrice(), salesTaxOnItem, item.getPrice() + salesTaxOnItem, (item.getPrice() + salesTaxOnItem) * item.getQuantity());
        return itemWithTax;
    }

    /**
     * Main business logic to calculate tax according to Item Type
     * @param itemPrice
     * @param itemType
     * @return tax on per item
     */
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
