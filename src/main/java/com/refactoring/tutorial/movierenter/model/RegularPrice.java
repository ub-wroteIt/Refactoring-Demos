package com.refactoring.tutorial.movierenter.model;

public class RegularPrice extends  Price{

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
    @Override
    double getCharge(int noOfDaysRented){
        double result = 2;
        if (noOfDaysRented > 2) {
            result += (noOfDaysRented - 2) * 1.5;
        }
        return result;
    }
}
