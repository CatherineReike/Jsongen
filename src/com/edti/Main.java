package com.edti;

import com.edti.Generators.UserGenerator;
import com.edti.Interfaces.IUserGenerator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        IUserGenerator test = new UserGenerator();

        test.GODgenerate();
    }
}
