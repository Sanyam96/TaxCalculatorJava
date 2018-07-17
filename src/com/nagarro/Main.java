package com.nagarro;

import com.nagarro.services.TaxComputation;

/**
 * Entry Point for this project
 * Main class having main function of Tax Calculator
 */
public class Main {

    /**
     * main function
     *
     * @param args
     */
    public static void main(String[] args) {
        calculateTax();
    }

    /**
     * to calculate tax
     */
    private static void calculateTax() {
        String yORn;
        //  loop to continue with program or no (y/n)
        do {
            TaxComputation taxComputation = new TaxComputation();
            System.out.println(taxComputation.prepareItemAndComputeTax().toString());   // print output with computed tax

            System.out.println("Do you want to enter details of any other item (y/n): ");
            yORn = Utils.getScannerInstance().nextLine();   // input y or n

            if (yORn.equalsIgnoreCase("n")) {
                break;
            } else {
                while (!yORn.equalsIgnoreCase("y") && !yORn.equalsIgnoreCase("n")) {
                    System.out.println("Wrong input entered!!");
                    System.out.println("Please try (y/n)");
                    yORn = Utils.getScannerInstance().nextLine();
                }
            }
        } while (yORn.equalsIgnoreCase("y"));

    }

}
