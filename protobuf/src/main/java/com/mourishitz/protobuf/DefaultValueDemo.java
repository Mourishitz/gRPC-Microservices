package com.mourishitz.protobuf;

import com.mourishitz.models.Person;

public class DefaultValueDemo {

    public static void main(String[] args) {

        Person person = Person.newBuilder().build();

        // This line should throw a NullPointerException
        // since we never declared a city to the Model.
        System.out.println(
                // The ouput is "City: ". The getCity() method returns blank
                // It didn't throw because in proto *there is no null*
                "City" + person.getAddress().getCity()
        );

        // To validate it as a 'not null' we have this methods
        // returning booleans for the existence (or not) of a value
        System.out.println(
                "Has Address: " + person.hasAddress()
        );
    }
}
