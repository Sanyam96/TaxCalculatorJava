package com.nagarro.services;

import com.nagarro.enums.ItemType;

/**
 * interface to define tax base on Item Type and their Item Price
 */
public interface TaxOnItem {

    /**
     *
     * @param itemPrice
     * @param itemType
     * @return
     */
    double taxOnPerItem(double itemPrice, ItemType itemType);
}
