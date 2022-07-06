package com.edti.Interfaces;

import com.edti.Models.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public interface IUserGenerator {

    Collection<User> generateUsers();

    void loadExternalParams(HashMap<String, String> params);

    //UNIQUE!!!
    String generateNeptuneId();
    String generateEmail(String s);
    HashMap<String, ArrayList<User>> GODgenerate() throws IOException;
}
