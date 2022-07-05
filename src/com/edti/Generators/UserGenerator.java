package com.edti.Generators;


import com.edti.Interfaces.IUserGenerator;
import com.edti.Models.Cohort;
import com.edti.Models.User;
import com.edti.Shared.ParamLoader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class UserGenerator implements IUserGenerator {
    Random r = new Random();

    public static HashMap<Integer, String> Veznevs;
    static {
        Veznevs = new HashMap<>();
        Veznevs.put(0, "Kovács");
        Veznevs.put(1, "Nemes");
        Veznevs.put(2, "Selmeci");
        Veznevs.put(3, "Nagy");
        Veznevs.put(4, "Tamási");
        Veznevs.put(5, "Kelemen");
        Veznevs.put(6, "Vágner");
    }

    public static HashMap<Integer, String> Kernevs;
    static {
        Kernevs = new HashMap<>();
        Kernevs.put(0, "Imre");
        Kernevs.put(1, "János");
        Kernevs.put(2, "Mátyás");
        Kernevs.put(3, "Dóra");
        Kernevs.put(4, "Anna");
        Kernevs.put(5, "Zorka");
        Kernevs.put(6, "Béla");
    }

    private int numberOfUsers;

    @Override
    public Collection<User> generate() {
        loadExternalParams(ParamLoader.getParams("data.txt"));
        Set<User> creativeUserSet = new HashSet<>();
        int i =0;
        while(i != numberOfUsers)
        {
            String kN = generateKerNev();
            String vN = generateVezNev();
            String nyeptun = generateNeptuneId();
            User currentUser = new User(r.nextInt(10000000), nyeptun, vN, kN, String.format("%s %s", vN, kN), generateEmail(nyeptun));
            if (!creativeUserSet.contains(currentUser)) {
                creativeUserSet.add(currentUser);
                i++;
            }
        }

        return creativeUserSet;
    }

    @Override
    public void loadExternalParams(HashMap<String, String> params) {
        this.numberOfUsers = Integer.parseInt(params.get("numberOfCourse"));
    }


    @Override
    public String generateNeptuneId() {

        String betuk = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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

        return neptun;
    }

    @Override
    public String generateEmail(String nyeptun) {
        return String.format("%s@mail.com", nyeptun);
    }

    public String generateVezNev(){
        String Nev ="";
        Random r = new Random();
        Nev = Veznevs.get(r.nextInt(Veznevs.size()));
        return Nev;
    }
    public String generateKerNev(){
        String Nev ="";
        Random r = new Random();
        Nev = Kernevs.get(r.nextInt(Kernevs.size()));

        System.out.println(Nev.hashCode());
        return Nev;


    }


}
