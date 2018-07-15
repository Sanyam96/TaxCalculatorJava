package com.nagarro.services;

import com.nagarro.enums.ItemType;

public interface TaxOnItem {
    public double taxOnPerItem(double itemPrice, ItemType itemType);
}
