package com.edti;

import com.edti.Generators.CohortGenerator;
import com.edti.Generators.UserGenerator;
import com.edti.Interfaces.ICohortGenerator;
import com.edti.Interfaces.IGlobalSerialize;
import com.edti.Interfaces.IUserGenerator;
import com.edti.Models.User;
import com.edti.Shared.GlobalSerialize;
import com.edti.Shared.ParamLoader;
import com.edti.Wrappers.NeptunStudentWrapper;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IUserGenerator test = new UserGenerator();
        List<User> users = new ArrayList<>(test.generate());
        NeptunStudentWrapper wrapper = new NeptunStudentWrapper();
        wrapper.setOE_AktivJogviszonyosHallgatokAdat(users);
        IGlobalSerialize<NeptunStudentWrapper> serializer = new GlobalSerialize<>();
        serializer.serialize(wrapper);

        
    }
}
