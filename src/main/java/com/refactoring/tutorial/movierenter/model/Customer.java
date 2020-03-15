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


        Enumeration rentals = this.rentals.elements();
        StringBuffer sb = new StringBuffer();
        sb.append("Rental Record For " + getName() + "\n");
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            sb.append("\t").append(each.getMovie().getMovieName()).append("\t");
            sb.append(each.getCharge() + "\n");
        }
        //Generate footer line for Message
        sb.append("Amount owned is ").append(getTotalCharge()).append("\n");
        sb.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return sb.toString();
    }


    private Double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
