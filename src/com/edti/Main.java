package com.edti;

import com.edti.Generators.UserGenerator;
import com.edti.Interfaces.IUserGenerator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IUserGenerator test = new UserGenerator();
        //List<User> users = new ArrayList<>(test.generateUsers());
        //NeptunStudentWrapper wrapper = new NeptunStudentWrapper();
        //wrapper.setOE_AktivJogviszonyosHallgatokAdat(users);


        //ez itten a User Generatorban történjen meg
        test.GODgenerate();
    }
}
