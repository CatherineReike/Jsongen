package com.edti.Wrappers;

import com.edti.Models.Cohort;

import java.util.ArrayList;
import java.util.List;

public class NeptunCourseWrapper {
    private List<Cohort> OE_KurzusokFelhasznalokkalAdat;

    public List<Cohort> getOE_KurzusokFelhasznalokkalAdat() {
        return OE_KurzusokFelhasznalokkalAdat;
    }

    public void setOE_KurzusokFelhasznalokkalAdat(List<Cohort> OE_KurzusokFelhasznalokkalAdat) {
        this.OE_KurzusokFelhasznalokkalAdat = OE_KurzusokFelhasznalokkalAdat;
    }

    public NeptunCourseWrapper() {
        this.OE_KurzusokFelhasznalokkalAdat = new ArrayList<>();
    }
}
