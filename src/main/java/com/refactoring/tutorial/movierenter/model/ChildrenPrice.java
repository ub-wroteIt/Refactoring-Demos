package com.refactoring.tutorial.movierenter.model;

public class ChildrenPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }
}
