package com.example.realestate.utils;

import java.util.Random;

public class GenerateRandomName {

    final String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final Random rand= new Random();

    public String RandomNames() {
        int i = 10;
        String uid="";
        while (i-- > 0) {
            uid+=alpha.charAt(rand.nextInt(26));
        }
        return uid;
    }

}
