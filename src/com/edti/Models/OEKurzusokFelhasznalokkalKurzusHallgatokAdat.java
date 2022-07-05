package com.edti.Models;

public class OEKurzusokFelhasznalokkalKurzusHallgatokAdat {
    private String neptunKod;

    public OEKurzusokFelhasznalokkalKurzusHallgatokAdat(String neptunKod) {
        this.neptunKod = neptunKod;
    }

    public String getNeptunKod() {
        return neptunKod;
    }

    public void setNeptunKod(String neptunKod) {
        this.neptunKod = neptunKod;
    }

    @Override
    public String toString() {
        return "OEKurzusokFelhasznalokkalKurzusHallgatokAdat{" +
                "neptunKod='" + neptunKod + '\'' +
                '}';
    }
}
