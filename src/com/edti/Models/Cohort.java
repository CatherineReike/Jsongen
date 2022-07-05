package com.edti.Models;

import java.util.List;

public class Cohort {
    private String targyKod;
    private String targyNev;
    private String kurzusKod;
    private String felev;

    private List<OEKurzusokFelhasznalokkalKurzusHallgatokAdat> oEKurzusokFelhasznalokkalKurzusHallgatokAdat;
    private List<OEKurzusokFelhasznalokkalKurzusOktatokAdat> oEKurzusokFelhasznalokkalKurzusOktatokAdat;

    public Cohort(String targyKod, String targyNev, String kurzusKod, String felev,
                  List<OEKurzusokFelhasznalokkalKurzusHallgatokAdat> oEKurzusokFelhasznalokkalKurzusHallgatokAdat,
                  List<OEKurzusokFelhasznalokkalKurzusOktatokAdat> oEKurzusokFelhasznalokkalKurzusOktatokAdat) {
        this.targyKod = targyKod;
        this.targyNev = targyNev;
        this.kurzusKod = kurzusKod;
        this.felev = felev;
        this.oEKurzusokFelhasznalokkalKurzusHallgatokAdat = oEKurzusokFelhasznalokkalKurzusHallgatokAdat;
        this.oEKurzusokFelhasznalokkalKurzusOktatokAdat = oEKurzusokFelhasznalokkalKurzusOktatokAdat;
    }

    public String getTargyKod() {
        return targyKod;
    }

    public void setTargyKod(String targyKod) {
        this.targyKod = targyKod;
    }

    public String getTargyNev() {
        return targyNev;
    }

    public void setTargyNev(String targyNev) {
        this.targyNev = targyNev;
    }

    public String getKurzusKod() {
        return kurzusKod;
    }

    public void setKurzusKod(String kurzusKod) {
        this.kurzusKod = kurzusKod;
    }

    public String getFelev() {
        return felev;
    }

    public void setFelev(String felev) {
        this.felev = felev;
    }

    public List<OEKurzusokFelhasznalokkalKurzusHallgatokAdat> getoEKurzusokFelhasznalokkalKurzusHallgatokAdat() {
        return oEKurzusokFelhasznalokkalKurzusHallgatokAdat;
    }

    public void setoEKurzusokFelhasznalokkalKurzusHallgatokAdat(List<OEKurzusokFelhasznalokkalKurzusHallgatokAdat> oEKurzusokFelhasznalokkalKurzusHallgatokAdat) {
        this.oEKurzusokFelhasznalokkalKurzusHallgatokAdat = oEKurzusokFelhasznalokkalKurzusHallgatokAdat;
    }

    public List<OEKurzusokFelhasznalokkalKurzusOktatokAdat> getoEKurzusokFelhasznalokkalKurzusOktatokAdat() {
        return oEKurzusokFelhasznalokkalKurzusOktatokAdat;
    }

    public void setoEKurzusokFelhasznalokkalKurzusOktatokAdat(List<OEKurzusokFelhasznalokkalKurzusOktatokAdat> oEKurzusokFelhasznalokkalKurzusOktatokAdat) {
        this.oEKurzusokFelhasznalokkalKurzusOktatokAdat = oEKurzusokFelhasznalokkalKurzusOktatokAdat;
    }

    @Override
    public String toString() {
        return "Cohort{" +
                "targyKod='" + targyKod + '\'' +
                ", targyNev='" + targyNev + '\'' +
                ", kurzusKod='" + kurzusKod + '\'' +
                ", felev='" + felev + '\'' +
                ", oEKurzusokFelhasznalokkalKurzusHallgatokAdat=" + oEKurzusokFelhasznalokkalKurzusHallgatokAdat +
                ", oEKurzusokFelhasznalokkalKurzusOktatokAdat=" + oEKurzusokFelhasznalokkalKurzusOktatokAdat +
                '}';
    }
}
