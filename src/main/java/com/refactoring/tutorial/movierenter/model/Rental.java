package com.refactoring.tutorial.movierenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The rental class represents a customer renting a movie.
 */
@AllArgsConstructor
@Getter
public class Rental {
    private Movie movie;
    private int noOfDaysRented;

     double getCharge() {
        double amount = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (getNoOfDaysRented() > 2) {
                    amount += (getNoOfDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                amount += getNoOfDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                amount += 1.5;
                if (getNoOfDaysRented() > 3)
                    amount += (getNoOfDaysRented() - 3) * 1.5;
                break;
        }
        return amount;
    }

     int getFrequentRenterPoints() {
        //add bouns for two days new release rental
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getNoOfDaysRented() > 1) {
            return 2;
        }
        return 1;
    }
}
