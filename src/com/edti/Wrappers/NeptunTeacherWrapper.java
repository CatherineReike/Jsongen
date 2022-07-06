package com.edti.Wrappers;

import com.edti.Models.User;

import java.util.ArrayList;
import java.util.List;

public class NeptunTeacherWrapper {
    private List<User> OE_AlkalmazottakAdat;

    public List<User> getOE_AlkalmazottakAdat() {
        return OE_AlkalmazottakAdat;
    }

    public void setOE_AlkalmazottakAdat(List<User> OE_AlkalmazottakAdat) {
        this.OE_AlkalmazottakAdat = OE_AlkalmazottakAdat;
    }

    public NeptunTeacherWrapper() {
        this.OE_AlkalmazottakAdat = new ArrayList<>();
    }
}
