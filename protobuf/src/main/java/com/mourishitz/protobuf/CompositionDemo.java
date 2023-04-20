package com.mourishitz.protobuf;

import com.mourishitz.models.Address;
import com.mourishitz.models.Car;
import com.mourishitz.models.Person;

import java.util.ArrayList;
import java.util.List;

public class CompositionDemo {

    public static void main(String[] args) {

        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("Main Street")
                .setCity("Atlanta")
                .build();

        Car accord = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        Car civic = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(2017)
                .build();

        List<Car> cars = new ArrayList<>();
        cars.add(accord);
        cars.add(civic);

        Person sam = Person.newBuilder()
                .setName("Sam")
                .setAge(25)
                // .addCar(accord)  We can use addCar instead of setCar
                // .addCar(civic)  because of One to Many relation
                .addAllCar(cars) // Or use addAllCar with an ArrayList of Car's
                .setAddress(address)
                .build();

        System.out.println(
                sam
        );
    }
}
