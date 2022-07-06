package com.edti.Interfaces;

import com.edti.Models.Cohort;
import com.edti.Models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface ICohortGenerator {
    Collection<Cohort> generate(HashMap<String, ArrayList<User>> users);

    void setExternalParams(HashMap<String, String> params);

    //UNIQUE!!!
    String generateSubjectCode();
    String generateCourseCode();
    String getSemester();
    String generateSubjectName();

    void collectUserIds(HashMap<String, ArrayList<User>> users);

    String getFirstTwo();
    String getThird();
    String getFree();
    String getEight();
    String getNinth();
}
