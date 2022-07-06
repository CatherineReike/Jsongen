package com.edti.Wrappers;

import com.edti.Models.User;

import java.util.ArrayList;
import java.util.List;

public class NeptunStudentWrapper {
    private List<User> OE_AktivJogviszonyosHallgatokAdat;

    public List<User> getOE_AktivJogviszonyosHallgatokAdat() {
        return OE_AktivJogviszonyosHallgatokAdat;
    }

    public void setOE_AktivJogviszonyosHallgatokAdat(List<User> OE_AktivJogviszonyosHallgatokAdat) {
        this.OE_AktivJogviszonyosHallgatokAdat = OE_AktivJogviszonyosHallgatokAdat;
    }

    public NeptunStudentWrapper() {
        this.OE_AktivJogviszonyosHallgatokAdat = new ArrayList<>();
    }
}
