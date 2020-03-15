package com.refactoring.tutorial.movierenter.model;

import lombok.Getter;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    @Getter
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRentals(Rental rental) {
        this.rentals.add(rental);
    }

    public String getStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        StringBuffer sb = new StringBuffer();
        sb.append("Rental Record For " + getName() + "\n");
        while (rentals.hasMoreElements()) {
            double amount = 0;
            Rental each = (Rental) rentals.nextElement();

            //Determining amount for each line
            amount = getAmount(each);

            //add frequent renter points
            frequentRenterPoints++;
            //add bouns for two days new release rental
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getNoOfDaysRented() > 1) {
                frequentRenterPoints++;
            }
            sb.append("\t").append(each.getMovie().getMovieName()).append("\t");
            sb.append(amount + "\n");
            totalAmount += amount;
        }
        //Generate footer line for Message
        sb.append("Amount owned is ").append(totalAmount).append("\n");
        sb.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return sb.toString();
    }

    private double getAmount(Rental each) {
        double amount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (each.getNoOfDaysRented() > 2) {
                    amount += (each.getNoOfDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                amount += each.getNoOfDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                amount += 1.5;
                if (each.getNoOfDaysRented() > 3)
                    amount += (each.getNoOfDaysRented() - 3) * 1.5;
                break;
        }
        return amount;
    }
}
