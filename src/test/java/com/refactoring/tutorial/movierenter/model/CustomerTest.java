package com.refactoring.tutorial.movierenter.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class CustomerTest {

    Movie regularMovie1 = new Movie("regularMovie1", 1);
    Movie regularMovie2 = new Movie("regularMovie2", 1);
    Movie regularMovie3 = new Movie("regularMovie3", 1);

    Movie newReleaseMovie1 = new Movie("New Release Movie1", 2);
    Movie newReleaseMovie2 = new Movie("New Release Movie2", 2);
    Movie newReleaseMovie3 = new Movie("New Release Movie3", 2);

    Movie childMovie1 = new Movie("Children Movie1", 0);
    Movie childMovie2 = new Movie("Children Movie2", 0);
    Movie childMovie3 = new Movie("Children Movie3", 0);

    @BeforeEach
    void setUp() {
    }

    @Test
    void getStatement__forRegularMovies() {

        Customer c = new Customer("testUser");
        c.addRentals(new Rental( regularMovie1, 5));
        c.addRentals(new Rental( regularMovie2, 6));
        c.addRentals(new Rental( regularMovie3, 7));
        // 2+2+2 + 3*1.5 + 4*1.5 + 5*1.5 = 24
        final String statement = c.getStatement();

        Assertions.assertTrue(statement.contains("Amount owned is 24.0"));
        Assertions.assertTrue(statement.contains("You earned 3 frequent renter points"));
    }

    @Test
    void getStatement__forNewReleaseMovies() {

        Customer c = new Customer("testUser");
        c.addRentals(new Rental( newReleaseMovie1, 10));
        c.addRentals(new Rental( newReleaseMovie2, 20));
        c.addRentals(new Rental( newReleaseMovie3, 30));
        // 10*3 + 20*3 + 30*3
        final String statement = c.getStatement();

        Assertions.assertTrue(statement.contains("Amount owned is 180.0"));
        Assertions.assertTrue(statement.contains("You earned 6 frequent renter points"));
    }

    @Test
    void getStatement__forChildrenMovies() {

        Customer c = new Customer("testUser");
        c.addRentals(new Rental( childMovie1, 5));
        c.addRentals(new Rental( childMovie2, 15));
        c.addRentals(new Rental( childMovie3, 18));
        // 1.5*3 + 2*1.5 + 12*1.5 + 15* 1.5
        final String statement = c.getStatement();


        Assertions.assertTrue(statement.contains("Amount owned is 48.0"));
        Assertions.assertTrue(statement.contains("You earned 3 frequent renter points"));
    }

    @Test
    void getStatement__forAllMovies() {

        Customer c = new Customer("testUser");
        c.addRentals(new Rental( newReleaseMovie3, 5)); // 5*3
        c.addRentals(new Rental( childMovie2, 15)); //1.5 + 12*1.5
        c.addRentals(new Rental( regularMovie1, 18)); //2 + 1.5*16
        // 5*3 + 1.5 + 12*1.5 + 2 + 1.5*16
        final String statement = c.getStatement();
        System.out.println(statement);
        Assertions.assertTrue(statement.contains("Amount owned is 60.5"));
        Assertions.assertTrue(statement.contains("You earned 4 frequent renter points"));
    }
}
