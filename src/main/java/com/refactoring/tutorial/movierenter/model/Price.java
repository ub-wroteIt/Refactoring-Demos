package com.refactoring.tutorial.movierenter.model;

import static com.refactoring.tutorial.movierenter.model.Movie.CHILDREN;
import static com.refactoring.tutorial.movierenter.model.Movie.NEW_RELEASE;
import static com.refactoring.tutorial.movierenter.model.Movie.REGULAR;

abstract class Price {
    abstract int getPriceCode();

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
}
