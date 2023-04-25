package com.mourishitz.protobuf;

import com.mourishitz.models.Credentials;
import com.mourishitz.models.EmailCredentials;
import com.mourishitz.models.PhoneOTP;

public class OneOfDemo {

    public static void main(String[] args) {

        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("gabrielmorishita@hotmail.com")
                .setPassword("password1234")
                .build();

        PhoneOTP phoneCredentials = PhoneOTP.newBuilder()
                .setNumber(12341234)
                .setCode(123)
                .build();

        Credentials credentials = Credentials.newBuilder()
//                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneCredentials)
                .build();

        login(credentials);
    }

    private static void login(Credentials credentials) {

        switch (credentials.getModeCase()){
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
                break;
            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
                break;
            case MODE_NOT_SET:
                System.out.println("Mode was not set");
        }
    }

}
