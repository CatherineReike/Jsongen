package com.edti;

import com.edti.Generators.CohortGenerator;
import com.edti.Interfaces.ICohortGenerator;

import java.util.HashSet;
import java.util.Random;

public class Main {
    static Random r = new Random();

    public static void main(String[] args) {
        HashSet<String> neptuns = new HashSet<>();

        String valami = "Andid";
        String betuk = "abcdefghijklmnopqrstuvwxyz";

        betuk = betuk.toUpperCase();

        for (int j = 0; j < 17000; j++)
        {
            String neptun ="";
            for (int i = 0; i < 6; i++)
            {
                if (r.nextInt(101)<70)
                {
                    neptun += betuk.charAt(r.nextInt(betuk.length()));
                }
                else
                {
                    neptun += r.nextInt(10);
                }
            }
            neptuns.add(neptun);
        }
        System.out.println(neptuns.size());
    }
}
