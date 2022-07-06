package com.edti.Models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("net.hexar.json2pojo")
public class OEKurzusokFelhasznalokkalKurzusOktatokAdat {
    @SerializedName("NeptunKod")
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
