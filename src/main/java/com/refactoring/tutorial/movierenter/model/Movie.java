package com.refactoring.tutorial.movierenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
public class Movie {
    public static final int CHILDREN = 0;
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 2;

    private String movieName;
    private Price price;

    public Movie(String movieName, int priceCode) {
        this.movieName = movieName;
        this.setPriceCode(priceCode);
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode){
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

    double getCharge(int noOfDaysRented){
        return price.getCharge(noOfDaysRented);
    }


    int getFrequentRenterPoints(int noOfDaysRented) {
        //add bouns for two days new release rental
        if (price.getPriceCode() == NEW_RELEASE && noOfDaysRented > 1) {
            return 2;
        }
        return 1;
    }
}
