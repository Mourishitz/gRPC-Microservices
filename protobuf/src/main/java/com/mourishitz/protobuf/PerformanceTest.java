package com.mourishitz.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mourishitz.json.JPerson;
import com.mourishitz.models.Person;

public class PerformanceTest {

    public static void main(String[] args) {

        JPerson person = new JPerson();
        person.setName("sam");
        person.setAge(10);

        ObjectMapper mapper = new ObjectMapper();

        Runnable json = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(person);
                JPerson person1 = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(10)
                .build();

        Runnable proto = () -> {
            try {
                byte[] bytes = sam.toByteArray();
                Person sam1 = Person.parseFrom(bytes);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        for (int i = 0; i < 5; i++) {
            runPerformanceTest(json, "JSON");
            runPerformanceTest(proto, "PROTO");
        }

    }

    private static void runPerformanceTest(Runnable runnable, String method){
        long time1 = System.currentTimeMillis();

        for (int i = 0; i < 10_000_000; i++) {
            runnable.run();
        }

        long time2 = System.currentTimeMillis();

        System.out.println(
               method + " : " + (time2 - time1) + " ms"
        );
    }
}
