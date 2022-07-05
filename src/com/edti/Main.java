package com.edti;

import com.edti.Generators.CohortGenerator;
import com.edti.Interfaces.ICohortGenerator;

public class Main {

    public static void main(String[] args) {
        ICohortGenerator test = new CohortGenerator();
        for (int i = 0; i < 20; i++) {
            System.out.println(test.generateSubjectCode());
        }

    }
}
