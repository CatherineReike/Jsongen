package com.edti.Generators;

import com.edti.Interfaces.ICohortGenerator;
import com.edti.Models.Cohort;

import java.util.*;

public class CohortGenerator implements ICohortGenerator {
    private final String[][] karIntezet = {{"A", "G"}, {"A", "M"},
            {"B", "A"}, {"B", "S"}, {"B", "T"}, {"B", "V"},
            {"K", "A"}, {"K", "H"}, {"K", "E"}, {"K", "M"}, {"K", "V"},
            {"N", "B"}, {"N", "I"}, {"N", "M"}, {"N", "N"},
            {"R", "M"}, {"R", "K"}, {"R", "T"}, {"R", "D"},
            {"T", "M"}};
    private final String[] targyKod= {"D", "G", "P", "T", "K", "F", "A", "N", "S",
            "E", "O", "M", "I", "Z", "V", "W", "Z"};
    private final String[] kepzes = {"F", "B", "D", "O", "M", "S", "T", "E"};
    private final String[] munkarend = {"N", "L", "E", "T"};



    @Override
    public Collection<Cohort> generate() {


        return null;
    }

    @Override
    public void loadExternalParams(HashMap<String, String> params) {

    }

    @Override
    public String generateSubjectCode() {
        return String.format("%s%s%s%s%sE", getFirstTwo(), getThird(), getFree(), getEight(), getNinth());
    }

    @Override
    public String generateCourseCode() {
        return null;
    }

    @Override
    public String getSemester() {
        return null;
    }

    @Override
    public String generateSubjectName() {
        return null;
    }

    @Override
    public Collection<String> collectUserIds() {
        return null;
    }

    @Override
    public String getFirstTwo() {
        String first, second;
        Random rndFirst = new Random();
        int index = rndFirst.nextInt(20);
        String[] kar = karIntezet[index];
        first = kar[0];
        second = kar[1];
        return String.format("%s%s", first, second);
    }

    @Override
    public String getThird() {
        Random rnd = new Random();
        return targyKod[rnd.nextInt(targyKod.length-1)];
    }

    @Override
    public String getFree() {
        String chars = "ABCDEFGHIJKLMOPQRSTVWXYZ";
        StringBuilder free = new StringBuilder();
        Random rnd = new Random();
        while (free.length() < 3) {
            int index = (int) (rnd.nextFloat() * chars.length());
            free.append(chars.charAt(index));
        }
        return free.toString();
    }

    @Override
    public String getEight() {
        Random rnd = new Random();
        return kepzes[rnd.nextInt(kepzes.length-1)];
    }

    @Override
    public String getNinth() {
        Random rnd = new Random();
        return munkarend[rnd.nextInt(munkarend.length-1)];
    }


}
