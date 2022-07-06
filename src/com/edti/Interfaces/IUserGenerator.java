package com.edti.Interfaces;

import com.edti.Models.User;

import java.util.Collection;
import java.util.HashMap;

public interface IUserGenerator {

    Collection<User> generateStudents();
    Collection<User> generateTeachers();

    void loadExternalParams(HashMap<String, String> params);

    //UNIQUE!!!
    String generateNeptuneId();
    String generateEmail(String s);
}
