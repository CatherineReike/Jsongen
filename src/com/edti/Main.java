package com.edti;

import com.edti.Generators.CohortGenerator;
import com.edti.Generators.UserGenerator;
import com.edti.Interfaces.ICohortGenerator;
import com.edti.Interfaces.IUserGenerator;
import com.edti.Models.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        IUserGenerator userGenerator = new UserGenerator();
        ICohortGenerator cohortGenerator = new CohortGenerator();

        HashMap<String, ArrayList<User>> users = new HashMap<>(userGenerator.GODgenerate());

        cohortGenerator.writeToFile(users);
    }
}
