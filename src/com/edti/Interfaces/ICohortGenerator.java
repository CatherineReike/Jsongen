package com.edti.Interfaces;

import com.edti.Models.Cohort;

import java.util.Collection;
import java.util.HashMap;

public interface ICohortGenerator {
    Collection<Cohort> generate();

    void loadExternalParams(HashMap<String, String> params);

    //UNIQUE!!!
    String generateSubjectCode();
    String generateCourseCode();
    String generateSemester();
    String generateSubjectName();

    Collection<String> collectUserIds();
}
