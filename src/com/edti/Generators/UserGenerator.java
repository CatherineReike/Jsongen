package com.edti.Generators;


import com.edti.Interfaces.IUserGenerator;
import com.edti.Models.User;

import java.util.Collection;
import java.util.HashMap;

public class UserGenerator implements IUserGenerator {

    public static HashMap<Integer, String> Veznev;
    static {
        Veznev = new HashMap<>();
        Veznev.put(0, "Kovács");
        Veznev.put(1, "Nemes");
        Veznev.put(2, "Kis");
        Veznev.put(3, "Nagy");
        Veznev.put(4, "Tamási");
        Veznev.put(5, "Kelemen");
        Veznev.put(6, "Kelemen");
    }

    public static HashMap<Integer, String> Kernev;
    static {
        Veznev = new HashMap<>();
        Veznev.put(0, "Imre");
        Veznev.put(1, "János");
        Veznev.put(2, "Mátyás");
        Veznev.put(3, "Dóra");
        Veznev.put(4, "Anna");
        Veznev.put(5, "Ágnes");
        Veznev.put(6, "Béla");
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
        return null;
    }

    
}
