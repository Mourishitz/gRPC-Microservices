package com.mourishitz.protobuf;

import com.mourishitz.models.Person;

public class PersonDemo {

    public static void main(String[] args) {

        Person sam = Person.newBuilder()
                .setName("Sam")
                .setAge(10)
                .build();

        System.out.println(sam.toString());
    }
}
