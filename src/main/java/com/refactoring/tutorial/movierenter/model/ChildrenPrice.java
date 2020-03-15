package com.refactoring.tutorial.movierenter.model;

public class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    double getCharge(int noOfDaysRented) {
        double result = 1.5;
        if (noOfDaysRented > 3)
            result += (noOfDaysRented - 3) * 1.5;
        return result;
    }
}
