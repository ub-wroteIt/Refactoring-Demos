package com.refactoring.tutorial.movierenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Movie {
    public static final int CHILDREN = 0;
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 2;

    private String movieName;
    private int priceCode;

    double getCharge(int noOfDaysRented) {
       double result = 0;
       switch (getPriceCode()) {
           case REGULAR:
               result += 2;
               if (noOfDaysRented > 2) {
                   result += (noOfDaysRented - 2) * 1.5;
               }
               break;
           case NEW_RELEASE:
               result += noOfDaysRented * 3;
               break;
           case CHILDREN:
               result += 1.5;
               if (noOfDaysRented > 3)
                   result += (noOfDaysRented - 3) * 1.5;
               break;
       }
       return result;
   }

    int getFrequentRenterPoints(int noOfDaysRented) {
        //add bouns for two days new release rental
        if (getPriceCode() == NEW_RELEASE && noOfDaysRented > 1) {
            return 2;
        }
        return 1;
    }
}
