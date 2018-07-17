package com.nagarro.services;

import com.nagarro.constants.TaxConstants;
import com.nagarro.enums.ItemType;

public class ManufacturedTax implements TaxOnItem {
    @Override
    public double taxOnPerItem(double itemPrice, ItemType itemType) {

        return ((itemPrice * TaxConstants.MANUFACTURED_PERCENTAGE_TAX_12_5 / 100) + ((TaxConstants.MANUFACTURED_PERCENTAGE_TAX_VALUE_2 / 100) * (itemPrice + (TaxConstants.MANUFACTURED_PERCENTAGE_TAX_12_5 / 100) * itemPrice)));
    }
}
