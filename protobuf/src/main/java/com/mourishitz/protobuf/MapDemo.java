package com.mourishitz.protobuf;

import com.mourishitz.models.BodyStyle;
import com.mourishitz.models.Car;
import com.mourishitz.models.Dealer;

public class MapDemo {

    public static void main(String[] args) {

        Car accord = Car.newBuilder()
            .setMake("Honda")
            .setModel("Accord")
            .setYear(2020)
            .build();

        Car civic = Car.newBuilder()
            .setMake("Honda")
            .setModel("Civic")
            .setYear(2017)
                .setBodyStyle(BodyStyle.SEDAN)
            .build();

        Dealer dealer = Dealer.newBuilder()
            .putModel(2017, civic)
            .putModel(2020, accord)
            .build();

        // The output of dealer is something like
        // 2017: {make: Honda, model: Civic, year: 2017}
        // 2020: {make: Honda, model: accord, year: 2020}

        System.out.println(
            dealer.getModelOrThrow(2017).getBodyStyle()
        );
    }
}
