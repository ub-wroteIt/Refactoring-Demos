package com.refactoring.tutorial.movierenter.model;

public class RegularPrice extends  Price{

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
