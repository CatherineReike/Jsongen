package com.edti;

import com.edti.Generators.CohortGenerator;
import com.edti.Generators.UserGenerator;
import com.edti.Interfaces.ICohortGenerator;
import com.edti.Interfaces.IUserGenerator;
import com.edti.Shared.ParamLoader;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        IUserGenerator test = new UserGenerator();
        test.generate().forEach((c) -> System.out.println(c.toString()));
    }
}
