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
}
