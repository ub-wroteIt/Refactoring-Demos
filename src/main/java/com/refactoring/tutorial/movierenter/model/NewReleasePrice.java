package com.refactoring.tutorial.movierenter.model;

public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int noOfDaysRented) {
        return noOfDaysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int noOfDaysRented) {
        return (noOfDaysRented > 1) ? 2 : 1;
    }
}
