package com.edti.Generators;

import com.edti.Interfaces.ICohortGenerator;
import com.edti.Interfaces.IGlobalSerialize;
import com.edti.Models.Cohort;
import com.edti.Models.OEKurzusokFelhasznalokkalKurzusHallgatokAdat;
import com.edti.Models.OEKurzusokFelhasznalokkalKurzusOktatokAdat;
import com.edti.Models.User;
import com.edti.Shared.GlobalSerialize;
import com.edti.Shared.ParamLoader;
import com.edti.Wrappers.NeptunCourseWrapper;
import com.edti.Wrappers.NeptunStudentWrapper;


import java.io.IOException;
import java.util.*;


public class CohortGenerator implements ICohortGenerator {

    private String semester;
    private int numberOfCourses;
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
    private final String[] targynevek = {"Elektronika", "Pszihologia", "Építészet", "Automatika", "Villamos energetika",
                "Felhő technológiák", "Szoftver fejlesztés", "Festészet", "Villamos gépek", "Statika", "Nemes Peti alapfokon",
    "Nemes Peti haladóknak", "Varázslástan alapfokon", "Bájitaltan II.", "Sötét varázslatok kivédése", "Gyógynövénytan",
            "Átváltoztatástan", "Mágiatörténet IV.", "Legendás állatok és megfigyelésük"};

    private final List<OEKurzusokFelhasznalokkalKurzusHallgatokAdat> students = new ArrayList<>();
    private final List<OEKurzusokFelhasznalokkalKurzusOktatokAdat> teachers = new ArrayList<>();

    NeptunCourseWrapper neptunCourseWrapper = new NeptunCourseWrapper();



    public void writeToFile(HashMap<String, ArrayList<User>> users) throws IOException {
        generate(users);
        IGlobalSerialize<NeptunCourseWrapper> serializer = new GlobalSerialize<>();

        serializer.serialize(neptunCourseWrapper, "OE_Get_KurzusokFelhasznalokkalAdatok");
    }

    @Override
    public Collection<Cohort> generate(HashMap<String, ArrayList<User>> users) {
        collectUserIds(users);
        setExternalParams(ParamLoader.getParams("data.txt"));
        Set<Cohort> cohortSet = new HashSet<>();
        int i = 0;
        Random rnd = new Random();
        while (i != this.numberOfCourses) {
            List<OEKurzusokFelhasznalokkalKurzusHallgatokAdat> studentsToAdd = new ArrayList<>();
            List<OEKurzusokFelhasznalokkalKurzusOktatokAdat> teachersToAdd = new ArrayList<>();
            int numberOfStudents = rnd.nextInt(15);
            int numberOfTeachers = rnd.nextInt(3);

            int j = 0;
            int index;
            while (j < numberOfStudents) {
                index = rnd.nextInt(students.size());
                if (!studentsToAdd.contains(students.get(index))) {
                    studentsToAdd.add(students.get(index));
                    j++;
                }
            }

            j = 0;
            while (j < numberOfTeachers) {
                index = rnd.nextInt(teachers.size());
                if (!teachersToAdd.contains(teachers.get(index))) {
                    teachersToAdd.add(teachers.get(index));
                    j++;
                }
            }

            Cohort testCohort = new Cohort(generateSubjectCode(), generateSubjectName(), generateCourseCode(),
                    getSemester(), new ArrayList<>(studentsToAdd), new ArrayList<>(teachersToAdd));
            if (!cohortSet.contains(testCohort)) {
                cohortSet.add(testCohort);
                i++;
            }
        }
        neptunCourseWrapper.getOE_KurzusokFelhasznalokkalAdat().addAll(cohortSet);
        return cohortSet;
    }

    @Override
    public void collectUserIds(HashMap<String, ArrayList<User>> users) {
        users.get("student").forEach((s) -> students.add(new OEKurzusokFelhasznalokkalKurzusHallgatokAdat(s.getNeptunKod())));
        users.get("teacher").forEach((t) -> teachers.add(new OEKurzusokFelhasznalokkalKurzusOktatokAdat(t.getNeptunKod())));
    }

    @Override
    public void setExternalParams(HashMap<String, String> params) {
        this.semester = params.get("semester");
        this.numberOfCourses = Integer.parseInt(params.get("numberOfCourse"));
    }

    @Override
    public String generateSubjectCode() {
        return String.format("%s%s%s%s%sE", getFirstTwo(), getThird(), getFree(), getEight(), getNinth());
    }

    @Override
    public String generateCourseCode() {
        String chars = "ABCDEFGHIJKLMOPQRSTVWXYZ0123456789";
        StringBuilder courseCode = new StringBuilder();
        Random rnd = new Random();
        while (courseCode.length() < 3) {
            int index = (int) (rnd.nextFloat() * chars.length());
            courseCode.append(chars.charAt(index));
        }
        return courseCode.toString();
    }

    @Override
    public String getSemester() {
        return this.semester;
    }

    @Override
    public String generateSubjectName() {
        Random rnd = new Random();
        return targynevek[rnd.nextInt(targynevek.length-1)];
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
