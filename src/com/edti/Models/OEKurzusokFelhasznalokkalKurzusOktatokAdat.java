package com.edti.Models;

public class OEKurzusokFelhasznalokkalKurzusOktatokAdat {
    private String neptunKod;

    public OEKurzusokFelhasznalokkalKurzusOktatokAdat(String neptunKod) {
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
        return "OEKurzusokFelhasznalokkalKurzusOktatokAdat{" +
                "neptunKod='" + neptunKod + '\'' +
                '}';
    }
}
