package com.refactoring.tutorial.movierenter.model;

abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int noOfDaysRented);

    int getFrequentRenterPoints(int noOfDaysRented) {
        //add bouns for two days new release rental
        return 1;
    }
}
