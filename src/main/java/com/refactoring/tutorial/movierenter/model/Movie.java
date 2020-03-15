package com.refactoring.tutorial.movierenter.model;

import lombok.Getter;


@Getter
public class Movie {
    public static final int CHILDREN = 0;
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 2;

    private String movieName;
    Price price;

    public Movie(String movieName, int priceCode) {
        this.movieName = movieName;
        this.setPriceCode(priceCode);
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREN:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    double getCharge(int noOfDaysRented) {
        return price.getCharge(noOfDaysRented);
    }


}
