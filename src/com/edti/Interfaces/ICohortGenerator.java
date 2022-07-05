package com.edti.Interfaces;

import com.edti.Models.Cohort;

import java.util.Collection;
import java.util.HashMap;

public interface ICohortGenerator {
    Collection<Cohort> generate();

    void setExternalParams(HashMap<String, String> params);

    //UNIQUE!!!
    String generateSubjectCode();
    String generateCourseCode();
    String getSemester();
    String generateSubjectName();

    Collection<String> collectUserIds();

    String getFirstTwo();
    String getThird();
    String getFree();
    String getEight();
    String getNinth();
}
