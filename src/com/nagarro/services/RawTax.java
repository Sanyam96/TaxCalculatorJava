package com.nagarro.services;

import com.nagarro.constants.TaxConstants;
import com.nagarro.enums.ItemType;

public class RawTax implements TaxOnItem {

    @Override
    public double taxOnPerItem(double itemPrice, ItemType itemType) {
        return (itemPrice * TaxConstants.RAW_PERCENTAGE_TAX / 100);
    }
}
