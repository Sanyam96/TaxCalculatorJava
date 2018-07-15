package com.nagarro;

import com.nagarro.services.TaxComputation;

public class Main {

    public static void main(String[] args) {
        calculateTax();
    }

    private static void calculateTax() {
        String yORn;
        do{
            TaxComputation taxComputation = new TaxComputation();
//            taxComputation.prepareItemAndComputeTax();
            System.out.println(taxComputation.prepareItemAndComputeTax().toString());

            System.out.println("Do you want to enter details of any other item (y/n): ");
            yORn = Utils.getScannerInstance().nextLine();

            if( yORn.equalsIgnoreCase("n")) {
                break;
            }
            else {
                while( !yORn.equalsIgnoreCase("y") && !yORn.equalsIgnoreCase("n")) {
                    System.out.println("Wrong input entered!!");
                    System.out.println("Please try (y/n)");
                    yORn = Utils.getScannerInstance().nextLine();
                }
            }
        }while( yORn.equalsIgnoreCase("y") );

        System.out.println();
    }

}
