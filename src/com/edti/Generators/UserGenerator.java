package com.edti.Generators;


import com.edti.Interfaces.IUserGenerator;
import com.edti.Models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class UserGenerator implements IUserGenerator {

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
        Veznevs = new HashMap<>();
        Veznevs.put(0, "Imre");
        Veznevs.put(1, "János");
        Veznevs.put(2, "Mátyás");
        Veznevs.put(3, "Dóra");
        Veznevs.put(4, "Anna");
        Veznevs.put(5, "Zorka");
        Veznevs.put(6, "Béla");
    }



    @Override
    public Collection<User> generate() {

        return null;
    }

    @Override
    public void loadExternalParams(HashMap<String, String> params) {

    }

    @Override
    public String generateNeptuneId() {
        return null;
    }

    @Override
    public String generateEmail() {
        String Email = "";

        return Email;
    }

    public String generateNev(HashMap<Integer, String> params){
        String Nev ="";
        Random r = new Random();
        Nev = params.get(r.nextInt(7));
        return Nev;
    }

}
