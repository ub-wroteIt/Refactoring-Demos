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
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();

            sb.append("\t").append(each.getMovie().getMovieName()).append("\t");
            sb.append(each.getCharge() + "\n");
            totalAmount += each.getCharge();
        }
        //Generate footer line for Message
        sb.append("Amount owned is ").append(totalAmount).append("\n");
        sb.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return sb.toString();
    }



    private double getAmount(Rental rental){
        return rental.getCharge();
    }

}
