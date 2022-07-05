package com.edti.Generators;


import com.edti.Interfaces.IUserGenerator;
import com.edti.Models.User;

import java.util.Collection;
import java.util.HashMap;

public class UserGenerator implements IUserGenerator {

    @Override
    public Collection<User> generate() {
        return null;
    }

    @Override
    public void loadExternalParams(HashMap<String, String> params) {

    }

    @Override
    public String generateNeptuneId() {
        return null;
    }

    @Override
    public String generateEmail() {
        return null;
    }
}
