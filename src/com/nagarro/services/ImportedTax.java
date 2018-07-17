package com.nagarro.services;

import com.nagarro.constants.TaxConstants;
import com.nagarro.enums.ItemType;

public class ImportedTax implements TaxOnItem {

    @Override
    public double taxOnPerItem(double itemPrice, ItemType itemType) {
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
