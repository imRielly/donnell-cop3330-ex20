/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Rielly Donnell
 */

package oop.example;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 Exercise 20 - Multistate Sales Tax Calculator
 More complex programs may have decisions nested in other decisions, so that when one decision is made, additional decisions must be made.

 Create a tax calculator that handles multiple states and multiple counties within each state. The program prompts the user for the order amount and the state where the order will be shipped.

 Wisconsin residents must be changed 5% sales tax with an additional county-level charge.
 For Wisconsin residents, prompt for the county of residence.
 For Eau Claire county residents, add an additional 0.005 tax.
 For Dunn county residents, add an additional 0.004 tax.
 Illinois residents must be charged 8% sales tax with no additional county-level charge.
 All other states are not charged tax.
 The program then displays the tax and the total for Wisconsin and Illinois residents
 but just the total for everyone else.

 Example Output
 What is the order amount? 10
 What state do you live in? Wisconsin
 What county do you live in? Dane
 The tax is $0.50.
 The total is $10.50.

 Constraints
 Ensure that all money is rounded up to the nearest cent.
 Use a single output statement at the end of the program to display the program results.

 Challenges
 Add support for your state and county.
 Allow the user to enter a state abbreviation and county name in upper, lower, or mixed case.
 Allow the user to also enter the state’s full name in upper, lower, or mixed case.
 Implement the program using data structures to avoid nested if statements.
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        //System.out.println(money.format(amt));

        System.out.print("What is the order total? ");
        double order = in.nextDouble();
        in.nextLine();

        System.out.print("What is the state? ");
        String state = in.nextLine();
        state = state.toUpperCase();

        boolean isWI = state.equals("WI") || state.toUpperCase().equals("WISCONSIN");
        boolean isIL = state.equals("IL") || state.toUpperCase().equals("ILLINOIS");
        String output;

        double taxRate = 0.000;

        if (isWI) {
            taxRate = 0.050;
            System.out.print("What county do you live in? ");
            String county = in.nextLine();
            county = county.toUpperCase();
            if (county.equals("EAU CLAIRE")) {
                taxRate = +0.005;
            } else if (county.equals("DUNN")) {
                taxRate = +0.004;
            }
        }

        if (isIL) {
            taxRate = 0.08;
        }
        if (isIL || isWI){
            double tax = order * taxRate;
            double total = order + tax;
            output = String.format("The tax is %s.\n" +
                    "The total is %s.", money.format(tax), money.format(total));
        }
        else {
            output = String.format("The total is %s.", money.format(order));
        }

        System.out.println(output);
    }
}
