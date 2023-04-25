package com.mourishitz.protobuf;

import com.google.protobuf.Int32Value;
import com.mourishitz.models.Person;

public class PersonDemo {

    public static void main(String[] args) {

        Person sam = Person.newBuilder()
                .setName("Sam")
                .setAge(Int32Value.newBuilder().setValue(25).build())
                .build();

        System.out.println(sam.toString());
    }
}
